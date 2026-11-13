# UT-01: Run A Coached Session Without Being Shown How

- **Status:** Planned
- **Design sprint:** [SPRINT-07](../../project-plan.md#sprint-07)
- **Run sprint:** [SPRINT-08](../../project-plan.md#sprint-08)

A runner who has never seen the product starts a coached session, hears it through, and ends it without taking the phone out of a pocket and without being shown how.

This test exists because the product's whole promise is that a runner does not have to look at it. Every claim the team has made about that so far has been made by the team, on the team's own phone, by the people who wrote it. `UT-01` is the first time somebody who did not is asked to do it.

## Research questions

1. Does a first-time runner work out how to start a coached session without being told, and does the product's own on-screen note carry enough for them to do it?
2. At which point does a first-time runner take the phone back out of the pocket, and what are they looking for when they do?
3. Does a first-time runner recognise, from what they hear alone, that the session is running and then that it has ended?

## The Requirement

[`QR-09`](../../quality-requirements/qr/QR-09.md), whose [`QRT-01`](../../quality-requirements/qr/QR-09.md#qrt-01) names `UT-01` in its `**Runs at:**`. `QR-09` reads one measure this test records — whether the main task was completed `Unaided` — and the other measures below are reported as results rather than as verdicts.

[`QR-03`](../../quality-requirements/qr/QR-03.md) is the neighbouring requirement and is deliberately not the one this test settles. `QR-03` asks whether a session is *reachable* without the screen, which is a property of the controls. `QR-09` asks whether a stranger *works out how*, which is a property of what the product teaches them in the first minute. The same session supplies evidence for both; only `QR-09` has its test here.

## Participant Profile

- **Role and task:** somebody who goes running, or walks briskly for exercise, at least occasionally, and who has their phone with them when they do. That is the person [the product vision](../../product-vision.md) is for: a beginner to intermediate runner, not an athlete.
- **Familiarity:** has used at least one phone app during exercise — a music player, a step counter, or a run tracker. A participant who has never taken a phone out on a run is outside the profile, because the test could not tell their confusion about this product from their confusion about the idea.
- **Device:** the team's Android phone, with the participant's own headphones or the team's, and a pocket or a jacket the phone fits in. The participant's own phone is not used: the build is a debug build and the session has to be instrumented.
- **Relation to the target user:** a person who would plausibly install this app for their own running. Not a teammate, not the `Customer`, not an instructor, and not course staff.

### Recruitment target

Three completed sessions is the minimum this test is designed for, and **five is the design target**. Every counted participant is 18 or older and matches the profile above.

The team recruits from the people around it who run but are not on it: classmates outside team 4, and runners at the university's sports facilities. A classmate who is not a teammate may be recruited when they match the profile. The team asks in person and through the course's own channels, and it records nothing about a person who declines.

Participant codes are `P-01`, `P-02`, and so on, assigned in the order the sessions are arranged, and never reused. A session that is withdrawn, refused the recording, or technically broken does not count, its code is retired, and a replacement is recruited under the next free code. A dry run with a teammate is not a session and gets no code.

## The Tasks

The same three usability test tasks, in this fixed order, for every participant. The main task is first. No task names a control, a label, a screen, or a number of steps, and the facilitator reads each scenario verbatim.

### Main task: be coached through a short run with the phone away

> You are about to go out for a short run, and you want this app to coach you out loud while it is in your pocket. The phone is in your hand with the app open. Go when you are ready, and finish the session when you have had enough.

- **Start point:** the phone unlocked, the app open on the screen it opens on, in the participant's hand, outdoors at the point the facilitator shows them.
- **End state:** a session was started, the participant heard the coach speak at least once while running, and the session was ended — with the phone staying in the pocket from the moment the participant chose to put it there.
- **Time limit:** 12 minutes, which allows for working out how to start, about five minutes of running, and ending it.
- **Success criterion:** `Unaided` when the participant reaches the end state with no help; `Assisted` when a hint is needed and the observer records it; `Failed` when the end state is not reached within 12 minutes.

### Secondary task 1: find out what the coach said on that run

> You have finished the run. You want to see what the coach told you while you were out, and how far you went.

- **Start point:** immediately after the main task, phone in hand, wherever the main task left it.
- **End state:** the participant has the record of the run they just did in front of them, with what the coach said during it.
- **Time limit:** 3 minutes.
- **Success criterion:** as above, against this end state.

### Secondary task 2: make the coach speak more slowly

> On your next run, you would like the coach to speak more slowly than it just did.

- **Start point:** immediately after secondary task 1.
- **End state:** the coach's speaking speed is set slower than it was, and the participant says what they expect that to change.
- **Time limit:** 3 minutes.
- **Success criterion:** as above, against this end state.

### The help rule

**Help is anything that moves the participant forward that they did not work out themselves.** It includes naming or pointing at any control, reading the screen's own text aloud to them, telling them what to press or say, confirming a guess before they act on it, and answering "am I doing this right?" with anything but a redirection to the scenario.

It does not include reading the scenario again verbatim, saying "whatever you would normally do", saying "keep thinking aloud", or any part of the consent, the recording check, or the surveys.

The facilitator answers questions about the scenario and never about the interface. When a participant is stuck and asks directly, the facilitator waits ten seconds, then gives the smallest hint that unblocks them and says the word "hint" aloud so the recording marks it. The task is `Assisted` from the first hint, and the observer writes down what the hint was.

### Why asking the coach a question aloud is not a task

The product's spoken-question flow is the one part of the main flow this test leaves alone, and that is a decision rather than an oversight. The question input is still a typed box: the three interface changes the `Customer` asked for in Week 5 — among them replacing the typed Ask with a microphone control — are recorded as [`DEC-024`](../../decisions.md#dec-024) to [`DEC-026`](../../decisions.md#dec-026) and are not built. Asking a participant to ask a question aloud would measure a gap the team already knows about and has already agreed to close, at the cost of the thing it does not know. It becomes a task in the next test, once [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) lands.

## Protocol

Every session runs in this order, with no step dropped and none reordered:

1. The welcome, and what the session is: the product is being tested, not the participant.
2. The consent and the recording check, per [`consent.md`](consent.md). No recording consent, no session.
3. The pre-test, from [`surveys.md`](surveys.md).
4. The think-aloud instruction.
5. The main task's scenario, read verbatim, then observation in silence.
6. The SEQ for the main task.
7. Secondary task 1, read verbatim, then observation, then its SEQ.
8. Secondary task 2, read verbatim, then observation, then its SEQ.
9. The SUS, all ten items, after all three tasks.
10. The open-ended post-test.
11. The debrief, and the chance to withdraw anything.

Two team members run every session, and the same facilitator runs all the counted ones. The facilitator does not solve a task. The observer records the help given, the time on each task, the friction, and the quotes. The full facilitation script is in [`sessions/README.md`](sessions/README.md).

**The stop rule.** The facilitator stops a session when the participant asks to stop, when the participant appears unwell or unsafe on the run, or when the team sees a critical or security-sensitive problem. The stop and its reason go into the session note and the results. A session stopped before its data is complete does not count as completed, and its code is retired.

## Measures

Four measures are recorded in every session, and the results report all four:

| Measure | How it is recorded | Scope |
| --- | --- | --- |
| Completion and assistance | `Unaided`, `Assisted`, or `Failed`, by the observer against the criterion written above | Each of the three tasks |
| Time on task | The observer's stopwatch, from the end of the scenario reading to the end state or the time limit | Each of the three tasks |
| SEQ | The one standard question, 1 to 7, asked immediately after each task | Each of the three tasks |
| SUS | The ten standard items, 1 to 5, after all three tasks, scored `2.5 × (20 + sum(odd) - sum(even))` | The whole session |

[`QR-09`](../../quality-requirements/qr/QR-09.md) reads the first of these, on the main task only. The other three, and the main task's own time and SEQ, are reported in [`results.md`](results.md) as results.

The qualitative evidence is the think-aloud, the observation notes, the friction points, and the quotes. The quantitative evidence is the table above together with the test's instrumentation below, where it covers the task.

## Instrumentation

### What the test has to observe

For the main task, the observer's stopwatch and eyes cannot see inside the phone, and three of the things the test wants to know are inside it: whether a session really started when the participant believed it did, when the coach actually spoke, and whether the phone had a location fix while the participant was waiting to hear a distance. The instrumentation exists to answer those, and to let the observer's timings be checked against the product's own record rather than trusted.

### The Week 6 events it reuses

The test adds no event. [The events table](../../analytics.md#the-events) already carries what the main task needs, and during a session each of these is emitted with `source = usability-test`:

| Event | What the test reads it for |
| --- | --- |
| `session_started` | That a session began, when, and which kind the participant started |
| `stats_spoken`, `effort_cue_spoken` | That the coach spoke, when, and how much of the stats it had to speak with |
| `location_fix_lost`, `location_fix_regained` | Whether the phone could supply a distance at all during the run |
| `session_stopped` | That the session ended, when, by the runner or by the system, and the duration and distance it ended with |
| `session_summary_spoken` | Whether the participant heard the end of the session, which research question 3 asks about |

`question_asked` and `question_answered` are not read, because asking aloud is not a task here. `spoken_line_dropped` is not read, because [it is registered and not yet emitted](../../analytics.md#the-events) until [issue #175](https://github.com/Running-Coach-App/running-coach-app/issues/175) lands.

### What the test adds

One field, not an event: **`participant_code`** (string, optional, usability-test traffic only) on every event a session emits. It is added to the event rows in [`docs/analytics.md`](../../analytics.md#the-events) in the same change as the code that emits it.

The sessions run on a **usability build** of the app: a debug build whose telemetry source is fixed to `usability-test`, and which carries a start-up control, present only in that build, where the facilitator enters the `P-nn` code before handing the phone over. No release build has either.

### How one session's records are told from another's

By the `P-nn` participant code, with the session's time window as the cross-check. The code is the documented exception to the opaque-identifier rule: it identifies a session, and only the identity mapping in the private repository turns it into a person. That mapping is never in this repository.

The product's own `session_id` is a random uuid per session and is not derived from anything about the runner, so it tells one session from another but not whose it was. The `P-nn` code is what joins the phone's record to the observer's sheet.

### Where the data goes

There is no analytics pipeline and no backend to send anything to: [`ADR-005`](../../architecture/adr/ADR-005.md), [`ADR-006`](../../architecture/adr/ADR-006.md), and [`DEC-028`](../../decisions.md#dec-028) keep every record on the phone, and [`QR-08`](../../quality-requirements/qr/QR-08.md) holds the product to having no network permission at all. The store the record names is therefore **the phone's own file sink**: a session's events are written to a file on the device, and after the session the facilitator exports that file over a cable and commits it to the private usability-data repository as that session's telemetry export. The export carries no IP address, no location, no user agent, no referrer, and no free text — only the fields [the events table](../../analytics.md#the-events) lists, plus the `P-nn` code.

Every metric on [the analytics page](../../analytics.md) excludes `source = usability-test` as well as `source = smoke`, so none of this traffic is ever presented as a value of the product's metrics.

### What the instrumentation cannot cover

- **Both secondary tasks.** Looking back at a run and changing the voice speed are screens, not sessions: they emit no event, and the product has no screen-view event. Both outcomes are read from the observation alone, and the results will say so rather than invent a metric.
- **Where the phone was.** No event records whether the phone was in a pocket or in a hand, which is the centre of research question 2. Only the observer sees that.
- **Whether the participant heard anything.** The events record that the coach produced a line and that the session spoke it, not that it reached the participant's ears. The think-aloud and the post-test carry that.

### The verification before the first counted session

The instrumentation is verified before the first counted session, and the verification is a run of its own: a teammate completes the main task on the usability build under a reserved code, and the team then confirms three things — that the session's events reach the file sink this record names, that the export carries the `P-nn` code and can be filtered to that one run, and that `source` on every record reads `usability-test`.

The implementation is scheduled in [`SPRINT-07`](../../project-plan.md#sprint-07) and the verification in [`SPRINT-08`](../../project-plan.md#sprint-08), before the first counted session. If a counted session is arranged inside `SPRINT-07`, the verification moves into `SPRINT-07` ahead of it. The dry run counts as the verification only when it runs after the implementation and before the first counted session; otherwise the verification is its own run.

**Verified:** not yet. This record is updated with the date and with what was confirmed when it is, and no session is counted before then.

## Analysis Plan

Written before the first session, and not changed after the data.

1. **The per-participant table** in [`results.md`](results.md), one row per participant: the main task's outcome, its time and its SEQ; secondary task 1's outcome, time and SEQ; secondary task 2's outcome, time and SEQ; the SUS score; and the number of hints given.
2. **The main task's aggregate completion:** the count and the proportion of counted participants who reached the end state at all, and the count and the proportion who reached it `Unaided`. The second of these is what [`QR-09`](../../quality-requirements/qr/QR-09.md) reads.
3. **The main task's median time on task**, in seconds, across the counted participants.
4. **The median SEQ for each task** — the main task and both secondary tasks, reported separately.
5. **The SUS mean and the SUS median**, each with `n=<count>` beside it, because a sample this size supports no claim about a population.
6. **The additional measure this product needs: the pocket exit count** — the number of times a participant took the phone out of the pocket during the main task, after first putting it in, reported per participant and as a median across participants. It is named here, before the first session, because the product's promise is specifically that this number is zero and no other measure reads it. It is an analysis result, not the requirement's measure.
7. **The thematic analysis:** the observations and the quotes grouped into a small number of themes, each naming the sessions it came from. A single participant's remark is not a theme.
8. **The severity rating:** each finding is `Critical`, `Major`, or `Minor`, with the reason for the rating stated.
9. **The instrumentation comparison:** each session's exported events are read against the observer's sheet — the session's start and end against the stopwatch, the spoken lines against what the participant reacted to, and the lost-fix records against any complaint about distance. It states which tasks and questions the instrumentation could not cover, listed above, rather than inventing an event or a metric, and it never presents a test event as a product metric.
10. **The limitations:** the sample size, the participants' relation to the target user, the build, the environment, and what the team could not measure.

The findings template and the triage plan are in [`results.md`](results.md), which carries no finding until the run sprint.

## Schedule

The design is finished in `SPRINT-07`, inside the Week 7 deadline of 2026-11-15. The counted sessions are planned for `SPRINT-08`, 16 to 21 November 2026, and the results are due with Submission 8 on 2026-11-21.

The team has not fixed the session dates, and this record carries them when it has. How it arranges them:

- Recruiting starts as soon as the design is merged, in person and through the course's channels, against the profile above.
- Each session needs about 40 minutes, outdoors, dry, and in daylight, which on this calendar means late afternoon.
- Sessions are booked one at a time as participants agree, and this record and [the index](../README.md) gain the dates as they are set.
- A session may run as soon as the design is written and the instrumentation is verified, including before the Week 7 deadline. None is arranged in `SPRINT-07` as this is written; if one is, the verification moves ahead of it and the index lists both run sprints.
- The last counted session is planned no later than 2026-11-19, so the results, the findings, and the triage can be written before the Submission 8 deadline.

## Roles

| Role | Member | What they do |
| --- | --- | --- |
| Facilitator | [@sirjaey](https://github.com/sirjaey) | Runs every counted session, reads the scenarios verbatim, applies the help rule and the stop rule |
| Observer | [@Ezekiel-Gadzama](https://github.com/Ezekiel-Gadzama) | Records the outcome, the hints, the time on task, the pocket exits, the friction, and the quotes |
| Recordings and raw notes | [@ObeTech1](https://github.com/ObeTech1) | Keeps the recordings in the cloud folder, and the consent records, the identity mapping and the raw notes in the private repository |

The same facilitator runs all the counted sessions, so no participant is helped differently from another. At least two of the three are present at every session.

## Environment

The product is an Android application that runs entirely on the phone and holds no network permission, so there is no deployment to point a participant at and nothing on the university network for them to reach. [`DEC-033`](../../decisions.md#dec-033) records the `Customer` agreeing that an installable build from GitHub is enough and that the university virtual machine is not required for this product. The sessions are therefore in person and on foot rather than in person and on the network, and `reports/week-07/README.md` declares that as a deviation in its `## Deviations`.

- **The build:** the usability build described under [Instrumentation](#instrumentation) — the debug APK of the release the sessions run against, with the telemetry source fixed to `usability-test` and the `P-nn` control present. It is installed on the team's phone and never on a participant's own.
- **The seed:** the app's data is cleared on the phone before every session, so each participant starts from a product that has never been run. That is the only seed this product has: there is no database to reset and no synthetic data to load. Clearing it is what makes the first-use reading in research question 1 real.
- **The place:** outdoors on or beside the university campus, on a route the facilitator has walked beforehand, in daylight and in dry weather, with a pavement the participant can run on without watching their feet.
- **No payment:** the product takes no payment of any kind, so no real payment can be made. There is nothing to put in a sandbox.
- **No network:** the phone needs no connection for the session, and the product cannot use one. Airplane mode changes nothing about its behaviour, and `QR-08`'s scan is what proves that rather than the session.

Before every session the facilitator checks: the data cleared, the usability build installed, the `P-nn` code entered, the battery above 50%, the headphones working, the recorder working, and the consent collected.

## Consent And Data

A durable consent is collected before every counted session, on the template in [`consent.md`](consent.md). Consent to the recording and to the sanitized public results is required for a session to count; consent to an anonymized quote is separate and optional, and a participant who refuses a quote still counts.

| What | Where it lives | Who can see it |
| --- | --- | --- |
| The signed consent records | the private usability-data repository | the team and the instructors |
| The identity mapping from `P-nn` to a person | the private usability-data repository | the team and the instructors |
| The raw notes and the working analysis | the private usability-data repository | the team and the instructors |
| A session's exported telemetry file | the private usability-data repository | the team and the instructors |
| The recordings | the team's cloud recordings folder | the team and the instructors |
| This record, the surveys, the consent template, the sanitized session notes, the results, the images | this repository | anyone |

The private repository is [`Running-Coach-App/running-coach-app-usability-data`](https://github.com/Running-Coach-App/running-coach-app-usability-data). It is private, it holds text only, and the team and the course instructors are its readers. Its link needs authentication, so the link check excludes it, with the reason recorded beside the exclusion in `.lycheeignore`. The recordings folder is a team-owned cloud folder, linked from the private repository and from the Moodle submission rather than from any public file, because its link is an access grant.

**Retention.** The private repository, its history, and the recordings are deleted after the course is graded. The sanitized public record — this file, the surveys, the consent template, the session notes, the results, and the images — stays.

No participant's name, email address, phone number, address, or any free text they wrote or said is committed to this repository, in any file, at any point.

## Evidence Map

| Item | Where it goes |
| --- | --- |
| The record, the surveys, the consent template, the session instructions | `docs/usability-tests/ut-01/` |
| The sanitized session notes, one per counted session | `docs/usability-tests/ut-01/sessions/P-nn.md` |
| The sanitized images | `docs/usability-tests/ut-01/images/` |
| The results, the findings, and the limitations | [`docs/usability-tests/ut-01/results.md`](results.md) |
| The `QR-09` verdict | [the quality requirement testing plan](../../project-plan.md#quality-requirement-testing-plan) |
| The signed consents, the identity mapping, the raw notes, the working analysis, the telemetry exports | the private usability-data repository |
| The recordings | the team's cloud recordings folder, linked from the private repository |
| The private repository's and the recordings folder's links and access instructions | the Moodle submission wrapper |
| The design summary and the Week 8 handoff | `reports/week-07/README.md`, its `## Usability test` section |
| The results summary | the Week 8 report |

No item is in two places, and no raw participant data is in this repository.

The results are in [results.md](results.md), which carries no finding until the sessions have run.
