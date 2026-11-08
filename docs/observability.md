# Observability

What the Running Coach App reports about its own operation, so that a bad run can be explained without reproducing it.

[`docs/analytics.md`](analytics.md) is about how the product is used. This page is about how it behaves: whether the coach spoke when it was due to, and what happened when it did not.

## The Unit Of Work

The product serves no requests. It has no network permission, no routes, and nothing calls it. The unit of work an `SLI` is measured over is therefore a **spoken line**: one line that falls due during a session and is either spoken or dropped.

Everything the assignment's request language asks for maps onto that unit:

| Request language | What it is here |
| --- | --- |
| Request identifier | `line_id`, random per line, unique within a session |
| Route | `line_kind`, one of `stats`, `effort`, or `answer` |
| Failure label | `outcome`, one of `spoken`, `dropped_busy`, or `dropped_unavailable` |

The page uses the product's own words below. It is written this way rather than borrowing request language it cannot honour.

## The Signals

The three signal types are the metric, the log, and the trace.

The product emits a **metric** for every `SLI` on this page, as the aggregate computed from the points below.

The product writes a **structured log line** for every spoken line, because [`SLI-01`](#sli-01)'s per-line point is read from it. One line, one log record, carrying the labels in the table above and the measured value. The sink that writes it is in the product today and the record's shape is fixed by [`FR-014`](functional-requirements/fr/FR-014.md); the call that emits one during a session is not, and [issue #175](https://github.com/Running-Coach-App/running-coach-app/issues/175) carries it into `SPRINT-07`.

The product emits no **trace**. A trace spans work that crosses a boundary, and nothing here crosses one: a session runs inside a single foreground service on one phone.

The team defines no alert this week. An alert is a rule over a signal rather than a signal of its own, and there is nothing yet to route one to.

## The SLIs

An `SLI` is a quality signal the product emits and the pipeline records: what is measured, in which unit, over which window, and by which query. It is not the target. The target stays in the quality requirement's `Response Measure`.

Two are defined. `SLI-01` is the one the diagnosability test reads, through the sink the product ships; a real session does not yet produce its points, which is [issue #175](https://github.com/Running-Coach-App/running-coach-app/issues/175). `SLI-02` is planned, because neither the record nor the sink it needs exists yet.

### SLI-01

Spoken line latency.

**Status:** Active

**Definition:** The delay between a line falling due and the speech for it starting, measured per spoken line. Every point carries `line_id`, which identifies the line, `line_kind`, which says whether it was a stats line, an effort cue, or an answer, `outcome`, which is `spoken` when the speech started and `dropped_busy` or `dropped_unavailable` when it did not, and `session_id`, so one session's points can be read in order. A dropped line records the delay up to the moment it was abandoned, so a failure still produces a point rather than a gap.

**Unit:** Milliseconds.

**Window:** Five minutes, reported as a P95. A point appears in the log as soon as the line is resolved, within one second of the speech starting or being abandoned.

**Source:** The structured log line the `coach app` container writes for every spoken line, from the speech scheduler in `CoachService`. One log record per line, written on the device.

**Query:** The aggregate the chart runs, and the per-line query the diagnosability test reads, are both written against the exported log file loaded as a `lines` table.

```sql
-- The SLI: P95 latency over five minutes, failures kept as their own series.
SELECT date_trunc('minute', occurred_at) AS minute,
       outcome,
       quantile_cont(0.95) WITHIN GROUP (ORDER BY latency_ms) AS p95_ms
FROM lines
WHERE occurred_at >= now() - INTERVAL 5 MINUTE
GROUP BY minute, outcome
ORDER BY minute;
```

```sql
-- The per-line point the test reads back for one failed line.
SELECT occurred_at, line_id, line_kind, outcome, latency_ms, session_id
FROM lines
WHERE line_id = $line_id;
```

### SLI-02

Coaching continuity through a lost location fix.

**Status:** Planned

**Definition:** The share of lost-fix intervals during which the coach kept speaking, measured per interval. A point carries `session_id`, the interval's duration, and whether any line was spoken inside it. This is the signal [`QR-04`](quality-requirements/qr/QR-04.md) needs: it promises the product keeps speaking the stats it still has when the fix is lost, and nothing records today whether it did.

**Unit:** Ratio, intervals with speech over intervals.

**Window:** Per session, reported across the last 30 days.

**Source:** Planned. It needs the lost-fix intervals from [`location_fix_lost`](analytics.md#the-events) and [`location_fix_regained`](analytics.md#the-events) joined to the spoken lines in between, and the join does not exist yet.

**Query:** Planned, once the source exists.

## The Pipeline

There is no observability backend and no query endpoint. The product has no `INTERNET` permission, and [`DEC-028`](decisions.md#dec-028) keeps a runner's data on the device, so nothing is shipped off the phone on its own.

The structured log lines are written to a file in the app's private storage, one JSON object per line, alongside the event file [`docs/analytics.md`](analytics.md) describes. The team reads an exported file by loading it as the `lines` table the queries above are written against.

Retention is the last 7 days or the last 50 sessions, whichever is reached first. The log is per line rather than per session, so it grows faster than the event file and is kept for less time.

Because there is no backend, there is no organization, no credential, and no dashboard, and no chart address to keep private. The week's report declares that deviation and the course confirmation behind it.
