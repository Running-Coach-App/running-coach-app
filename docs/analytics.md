# Analytics

What the Running Coach App records about its own use, what that record is read for, and how each number is computed.

The product runs entirely on the phone and holds no network permission. [`DEC-028`](decisions.md#dec-028) keeps a runner's data on the device and prefers a file export over a server. Everything on this page is built that way: events are recorded on the phone, and a runner exports them as a file when they choose to. Nothing is sent anywhere on its own.

## The Value And The Metrics

### The Metric Tree

- [Weekly completed coached sessions](#weekly-completed-coached-sessions) — the focus metric, expressing [`VP-01`](research/value-proposition.md#vp-01)
  - **L1 (counter-metric):** [Early-stopped session rate](#early-stopped-session-rate)
  - **L1:** [Session completion rate](#session-completion-rate)
    - **L2:** [Spoken line delivery rate](#spoken-line-delivery-rate)
    - **L2:** [Location fix availability](#location-fix-availability)

### Why This Focus Metric

[`VP-01`](research/value-proposition.md#vp-01) promises an in-run voice coach that answers spoken questions about the current run. A runner gets that value only by running a whole session with the coach talking to them. Counting the sessions that actually happened, end to end, is therefore the closest number to the promise.

- **It expresses value.** A completed coached session is the runner having had the thing the product exists to give: a run they were talked through without looking at the phone. A started-and-abandoned session is not.
- **It represents the vision and strategy.** The vision's goal is a runner who hears what to do and how the run is going while running. This metric counts exactly the runs where that happened.
- **It is a leading indicator.** It moves within a week of a change to the coach's behaviour, long before anything slower like whether somebody keeps using the app for a season.
- **It is actionable.** The team changes it through the things it controls: what the coach says, when it says it, and whether it keeps speaking when a stat goes missing. Each of those is an input metric below.
- **It is understandable.** "How many runs did the coach talk somebody through this week" needs no explanation to the `Customer`, and he used almost those words at the kickoff.
- **It is measurable.** Every part of it comes from events the product already has reason to record: a session starting, the coach speaking, and the session stopping. No new sensor and no new permission.
- **It is not a vanity metric.** It can go down. A release that makes the coach annoying lowers it, because runners stop early, and that is the point of watching it.

Rejected as a vanity metric: total app opens, because opening the app says nothing about whether a run happened or whether the coach was any use, and it rises when the product is confusing enough to need a second look.

The focus metric depends on the input metrics below it, and it has no value yet. Nobody outside the team has completed a session with the product: the `Customer` had no installable build until [`v0.3.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.3.0), and [`TOS-02`](threshold-of-success.md#tos-02) is recorded as missed for that reason. Until real runners produce traffic, the only events the product has are the team's own, which carry `source = smoke` or `source = usability-test` and are excluded or labelled accordingly. Test traffic is not presented as the metric's value.

### Weekly completed coached sessions

**Definition:** The count of completed coached sessions in a calendar week. A session counts when it has a `session_started` event, a `session_stopped` event, and at least one `stats_spoken` event between them, so a session the coach never spoke in does not count.

**Source:** [`session_started`](#the-events), [`stats_spoken`](#the-events), and [`session_stopped`](#the-events).

**Query:** This is the one metric computed by running its query rather than by hand.

```sql
SELECT date_trunc('week', started_at) AS week, count(*) AS completed_sessions
FROM (
  SELECT session_id, min(occurred_at) FILTER (WHERE event = 'session_started') AS started_at
  FROM events
  WHERE source = 'app'
  GROUP BY session_id
  HAVING count(*) FILTER (WHERE event = 'session_started') = 1
     AND count(*) FILTER (WHERE event = 'session_stopped') = 1
     AND count(*) FILTER (WHERE event = 'stats_spoken') >= 1
)
GROUP BY week
ORDER BY week;
```

### Early-stopped session rate

**Definition:** The share of started sessions stopped before the first stats line falls due. The numerator is sessions whose `session_stopped` is less than 180 seconds after their `session_started`; the denominator is all started sessions. The 180 seconds is the cadence [`DEC-013`](decisions.md#dec-013) fixed.

This is the counter-metric. The cheapest way to raise the focus metric is to get more sessions started, and this is the number that shows when those extra sessions are ones runners abandon.

**Source:** [`session_started`](#the-events) and [`session_stopped`](#the-events).

**Query:**

```sql
SELECT round(100.0 * count(*) FILTER (WHERE duration_s < 180) / nullif(count(*), 0), 1) AS early_stopped_pct
FROM (
  SELECT session_id,
         max(occurred_at) FILTER (WHERE event = 'session_stopped')
   - min(occurred_at) FILTER (WHERE event = 'session_started') AS duration_s
  FROM events
  WHERE source = 'app'
  GROUP BY session_id
  HAVING count(*) FILTER (WHERE event = 'session_stopped') = 1
);
```

### Session completion rate

**Definition:** The share of started sessions that reach a stop. The numerator is sessions with a `session_stopped` event; the denominator is sessions with a `session_started` event. A session with no stop was killed by the phone, by the battery, or by the runner closing the app.

**Source:** [`session_started`](#the-events) and [`session_stopped`](#the-events).

**Query:**

```sql
SELECT round(100.0 * count(*) FILTER (WHERE stopped) / nullif(count(*), 0), 1) AS completion_pct
FROM (
  SELECT session_id, bool_or(event = 'session_stopped') AS stopped
  FROM events
  WHERE source = 'app'
  GROUP BY session_id
);
```

### Spoken line delivery rate

**Definition:** The share of spoken lines that were due and were actually spoken. The numerator is `stats_spoken` and `effort_cue_spoken` events; the denominator is those plus `spoken_line_dropped` events, which the product records when a line fell due and could not be spoken.

**Source:** [`stats_spoken`](#the-events), [`effort_cue_spoken`](#the-events), and [`spoken_line_dropped`](#the-events).

**Query:**

```sql
SELECT round(100.0 * count(*) FILTER (WHERE event IN ('stats_spoken', 'effort_cue_spoken'))
             / nullif(count(*), 0), 1) AS delivery_pct
FROM events
WHERE source = 'app'
  AND event IN ('stats_spoken', 'effort_cue_spoken', 'spoken_line_dropped');
```

### Location fix availability

**Definition:** The share of session time with a location fix. The numerator is session seconds not inside a lost-fix interval; the denominator is total session seconds. A lost-fix interval runs from a `location_fix_lost` event to the next `location_fix_regained` event in the same session, or to that session's stop.

This is what [`QR-04`](quality-requirements/qr/QR-04.md) promises the product survives, and the number that says how often it has to.

**Source:** [`location_fix_lost`](#the-events), [`location_fix_regained`](#the-events), [`session_started`](#the-events), and [`session_stopped`](#the-events).

**Query:**

```sql
SELECT round(100.0 * (1 - sum(lost_s) / nullif(sum(total_s), 0)), 1) AS fix_available_pct
FROM session_spans;  -- lost_s from each fix-lost interval, total_s from start to stop
```

## The Events

Every event name is `object_action` in snake case, so the object comes first and the past-tense action second, as in `session_started`.

Every event carries `session_id` (uuid, required), `occurred_at` (timestamp, required), and `source` (enum, required). `session_id` is generated at random when a session starts; it is not derived from anything about the runner and cannot be reversed to them. `source` is one of `app`, `usability-test`, or `smoke`. `smoke` marks traffic the team generated to check that recording works, and every metric above excludes it. `usability-test` marks the team's own usability sessions and is not excluded, because the Week 7 work needs to see them.

No event carries a name, an email address, a phone number, an address, free text, or anything a runner typed or said. The question events record that a question was asked and which stat it was about, never its words.

| Event | Fires when | Fields | Collected at |
| --- | --- | --- | --- |
| `session_started` | The runner starts a session, from the screen or a headset control | `session_id` (uuid, required), `occurred_at` (timestamp, required), `source` (enum, required), `kind` (enum `interval` or `steady`, required) | `coach app`, on the runner's phone |
| `stats_spoken` | The coach produces a stats line for the session to speak | `session_id`, `occurred_at`, `source`, `elapsed_s` (integer, required), `stats_present` (integer 0 to 3, required) | `coach app`, on the runner's phone |
| `effort_cue_spoken` | The coach produces an effort cue for the session to speak | `session_id`, `occurred_at`, `source`, `effort` (enum `push` or `ease`, required) | `coach app`, on the runner's phone |
| `spoken_line_dropped` | A line falls due and cannot be spoken, because the previous line is still playing or the speech engine is unavailable | `session_id`, `occurred_at`, `source`, `line_kind` (enum `stats`, `effort`, `answer`, required), `reason` (enum, required) | `coach app`, on the runner's phone |
| `question_asked` | The recogniser returns a result for a spoken question | `session_id`, `occurred_at`, `source`, `topic` (enum `time`, `pace`, `distance`, `off_topic`, required) | `coach app`, on the runner's phone |
| `question_answered` | The coach finishes speaking an answer to a question | `session_id`, `occurred_at`, `source`, `topic` (enum, required), `answered` (boolean, required) | `coach app`, on the runner's phone |
| `location_fix_lost` | The product stops receiving a location fix during a session | `session_id`, `occurred_at`, `source` | `coach app`, on the runner's phone |
| `location_fix_regained` | A location fix returns after being lost | `session_id`, `occurred_at`, `source`, `lost_s` (integer, required) | `coach app`, on the runner's phone |
| `session_stopped` | The session ends, from the screen, a headset control, or the product stopping itself | `session_id`, `occurred_at`, `source`, `duration_s` (integer, required), `distance_m` (integer, required), `reason` (enum `runner` or `system`, required) | `coach app`, on the runner's phone |
| `session_summary_spoken` | The coach finishes speaking the after-run summary | `session_id`, `occurred_at`, `source`, `had_distance` (boolean, required) | `coach app`, on the runner's phone |

The table covers the core task end to end: a session starts, the coach speaks stats and effort cues, a question is asked and answered, a lost fix is survived, the session stops, and the summary is spoken.

Every event above is recorded today except `spoken_line_dropped`, which needs the per-line outcome [`FR-014`](functional-requirements/fr/FR-014.md) specifies. Until [issue #175](https://github.com/Running-Coach-App/running-coach-app/issues/175) lands, [the spoken line delivery rate](#spoken-line-delivery-rate) has no value. The table says so rather than implying the event exists.

## The Pipeline

The `coach app` container records every event itself. There is no collector, no network call, and no backend: the product has no `INTERNET` permission, and [`DEC-028`](decisions.md#dec-028) keeps a runner's data on the device.

Events are appended to a JSON Lines file in the app's private storage, one object per line, in the order they happened. A runner exports that file when they choose to, which is the file export [`DEC-028`](decisions.md#dec-028) asked for. The team reads an exported file by loading it as the `events` table the queries above are written against.

Retention is the last 90 days or the last 500 sessions, whichever is reached first, which covers the longest window any metric on this page defines. Older lines are dropped from the front of the file.

Because there is no backend, there is no environment scope, no client credential, and no dashboard. The `Collected at` column names the build the events come from instead. The week's report declares that deviation and the course confirmation behind it.
