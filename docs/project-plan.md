# Project plan

Running Coach App, team 4.

## Milestones

### MLS-03

- Due: 2026-10-17
- Sprints: [SPRINT-03](#sprint-03)
- Advances: [TOS-01](threshold-of-success.md#tos-01)

A runner puts the phone in a pocket, starts a session, and hears what to do and how the run is going until they stop.
That slice is the Week 2 candidate: [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37), [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38), [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39), and [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40).

### MLS-05

- Due: 2026-10-31
- Sprints: [SPRINT-05](#sprint-05)
- Advances: [TOS-02](threshold-of-success.md#tos-02)

Somebody outside the team gets the product onto a phone and finishes one pocket session, without a member of the team present.

The slice stops being a thing we demonstrate and becomes a thing another person can obtain, install, and use. The build is published rather than passed around, the steps to get it are written down, and the checks that say it works run without anyone asking them to.

### MLS-07

- Due: 2026-11-14
- Sprints: [SPRINT-06](#sprint-06), [SPRINT-07](#sprint-07)
- Advances: [TOS-02](threshold-of-success.md#tos-02), [TOS-03](threshold-of-success.md#tos-03)

A runner who is not on the team uses the coach on a real run, and the team can say afterwards what that runner heard.

This increment is about evidence rather than features. It needs the product to report enough about a session for the team to tell what happened, and a written way of asking a runner to use it and recording what they say, so the next decisions rest on a stranger's run rather than on ours.

## Sprints

### SPRINT-03

A clean checkout of main speaks a start, the run's time, pace, and distance, an effort cue when the effort changes, and an answer to one spoken stat question, then a stop.

- Due: 2026-10-17

#### REL-03

- **Tag:** [`v0.1.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.1.0)
- **Date:** 2026-10-18
- **Ships:** the Week 3 pocket-session slice on `main` (start/stop, spoken time/pace/distance, effort cue, spoken stat answer), plus the Week 3 docs and validation record.

### SPRINT-04

The same slice has a repeatable build, tests, and an architecture the next increment can extend.

- Due: 2026-10-24
- Sprint Backlog: [the issues scheduled into SPRINT-04](https://github.com/Running-Coach-App/running-coach-app/milestone/2)
- Planned Velocity: 0 points. No story was scheduled into this sprint; all nineteen issues in its milestone were tasks, so there were no `Story Points` to plan with.
- Actual Velocity: 0 points. Nothing moved out of the sprint: every issue scheduled into it closed. The stories the work served stayed unscheduled, so no story points were earned, and they remain in the product backlog for `SPRINT-05` to select.

#### REL-04

- **Tag:** [`v0.2.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.2.0)
- **Date:** 2026-10-25
- **Ships:** the spoken coach brought in line with `DEC-011`, `DEC-012`, and `DEC-013`, the quality and functional requirements, the container view and the architectural decision records, the glossary and the team's `AGENTS.md`, and a workflow that builds and tests the product code.

### SPRINT-05

Somebody outside the team can obtain the product, install it, and finish a pocket session, and the checks that say it works run without being asked.

- Due: 2026-10-31
- Sprint Backlog: [the issues scheduled into SPRINT-05](https://github.com/Running-Coach-App/running-coach-app/milestone/3)
- Planned Velocity: 22 points, from the `Story Points` of the five stories scheduled into this sprint: [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) 5, [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39) 3, [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) 8, [US-05](https://github.com/Running-Coach-App/running-coach-app/issues/41) 3, and [US-10](https://github.com/Running-Coach-App/running-coach-app/issues/141) 3.
- Actual Velocity: 3 points, from [US-05](https://github.com/Running-Coach-App/running-coach-app/issues/41) alone. [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37), [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39), [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40), and [US-10](https://github.com/Running-Coach-App/running-coach-app/issues/141) moved to [SPRINT-06](#sprint-06), 19 points in all, because the `Customer` has not installed the product and could not accept them against their criteria. `US-05` was closed on the team's judgement rather than on his acceptance, which [the definition of done](definition-of-done.md) requires.

#### REL-05

- **Released:** [v0.3.0](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.3.0) on 2026-10-31.
- **Checked QRs:**
  - [QR-01](quality-requirements/qr/QR-01.md)
  - [QR-02](quality-requirements/qr/QR-02.md)

Each test's result, and the sprint of its last check, is in the [Quality Requirement Testing Plan](#quality-requirement-testing-plan).

### SPRINT-06

The product records what it did during a session, so the team can tell how the coach was used and why a run went wrong, without asking the runner.

- Due: 2026-11-08
- Sprint Backlog: [the issues scheduled into SPRINT-06](https://github.com/Running-Coach-App/running-coach-app/milestone/4)
- Planned Velocity: 27 points, from the `Story Points` of the six stories scheduled into this sprint: [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) 5, [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39) 3, [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) 8, [US-10](https://github.com/Running-Coach-App/running-coach-app/issues/141) 3, [US-12](https://github.com/Running-Coach-App/running-coach-app/issues/167) 5, and [US-13](https://github.com/Running-Coach-App/running-coach-app/issues/168) 3. Four of them carried from `SPRINT-05` unaccepted.
- Actual Velocity: 0 points. No story was completed, because [the definition of done](definition-of-done.md#story) closes a story only on the `Customer`'s acceptance and nothing was presented at the Week 6 meeting. All six scheduled stories move to `SPRINT-07`, 27 points in all. [US-12](https://github.com/Running-Coach-App/running-coach-app/issues/167) is the one that was built: its acceptance criteria pass on `main` and both its task issues closed, but its user is a product analyst on this team rather than the `Customer`, so the rule as written leaves it open. [US-13](https://github.com/Running-Coach-App/running-coach-app/issues/168) was specified and not built, and its instrumentation is [issue #175](https://github.com/Running-Coach-App/running-coach-app/issues/175).

#### REL-06

- **Released:** [v0.4.0](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.4.0) on 2026-11-08.
- **Checked QRs:**
  - [QR-05](quality-requirements/qr/QR-05.md)

Each test's result, and the sprint of its last check, is in the [Quality Requirement Testing Plan](#quality-requirement-testing-plan).

### SPRINT-07

A runner who has never seen the product can be handed it and asked to use it, and the team can tell from a written test, rather than from being in the room, where the product loses them.

- Due: 2026-11-15
- Sprint Backlog: [the issues scheduled into SPRINT-07](https://github.com/Running-Coach-App/running-coach-app/milestone/5)
- Planned Velocity: 27 points, from the `Story Points` of the six stories carried into this sprint unaccepted at the close of `SPRINT-06`: [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) 5, [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39) 3, [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) 8, [US-10](https://github.com/Running-Coach-App/running-coach-app/issues/141) 3, [US-12](https://github.com/Running-Coach-App/running-coach-app/issues/167) 5, and [US-13](https://github.com/Running-Coach-App/running-coach-app/issues/168) 3. The week's own work — the `UT-01` design, its instrumentation, the quality requirement, and the release — is tasks, which carry no points. [`SPRINT-06`'s retrospective](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-06/sprint-retrospective.md#actions) carries an action to plan only the points the team can finish on its own, and four of these six stories are still blocked on an install the team cannot perform; they are recorded here as scheduled because they are in the milestone, and what the sprint actually finished is in `Actual Velocity` below.
- Actual Velocity: not yet set. It is computed at the sprint's close, after the Sprint Review on which [the definition of done](definition-of-done.md#story) makes every one of these six stories depend, with one sentence on what moved out and to which sprint.

#### REL-07

- **Released:** not yet cut. `REL-07` is tagged `v0.5.0` on the release commit at the sprint's end, on the state after the Sprint Review and any same-week rework, and this field carries the tag and the date once it is.
- **Checked QRs:**
  - [QR-06](quality-requirements/qr/QR-06.md)
  - [QR-08](quality-requirements/qr/QR-08.md)

Each test's result, and the sprint of its last check, is in the [Quality Requirement Testing Plan](#quality-requirement-testing-plan).

### SPRINT-08

The usability sessions have been run and reported, and the repository's configuration is the one the team will keep through the end of the course.

- Due: 2026-11-21
- Sprint Backlog: [the issues scheduled into SPRINT-08](https://github.com/Running-Coach-App/running-coach-app/milestone/6)

This goal is provisional: it is set in `SPRINT-07` so the results sprint has its target already, and it is replaced at `SPRINT-08`'s planning. The sprint carries the counted [`UT-01`](usability-tests/ut-01/README.md) sessions, their sanitized notes, the results, the findings and their triage, the [`QR-09`](quality-requirements/qr/QR-09.md) verdict, and `REL-08`.

#### REL-08

### SPRINT-09

The product on main is the one the team will pitch.

- Due: 2026-11-28

#### REL-09

## Progress Monitoring

- Review: the team's weekly review, Thursdays at 18:00 WAT, before the soft deadline. It reads [the threshold of success](threshold-of-success.md) and tracks [risk register issue #49](https://github.com/Running-Coach-App/running-coach-app/issues/49).
- Checked by: the accountable member of each scheduled issue reports its state, and the team walks that sprint's GitHub milestone against the sprint's goal.
- Visible at: the public GitHub project's table view, grouped by milestone, and the seven SPRINT-nn GitHub milestones. Both are created with the plan; this line gains their links once GitHub has assigned the numbers.

## Quality Requirement Testing Plan

One row per quality requirement test, in the order of [the quality requirements index](quality-requirements/README.md), with a test's number breaking a tie inside one requirement. Each row carries the test's result at its last check; the test's own section carries its definition.

| QR | QRT | Status | Checked | Planned for sprint | Evidence |
| --- | --- | --- | --- | --- | --- |
| [QR-01](quality-requirements/qr/QR-01.md) | [QR-01 QRT-01](quality-requirements/qr/QR-01.md#qrt-01) | Passes | SPRINT-05 | [SPRINT-05](#sprint-05) | [Android build #32 on `main`](https://github.com/Running-Coach-App/running-coach-app/actions/runs/41182999822): test step passed; local run had 18 passed, 0 skipped, and the cadence test took 0.002 s. |
| [QR-02](quality-requirements/qr/QR-02.md) | [QR-02 QRT-01](quality-requirements/qr/QR-02.md#qrt-01) | Passes | SPRINT-05 | [SPRINT-05](#sprint-05) | [Android build #32 on `main`](https://github.com/Running-Coach-App/running-coach-app/actions/runs/41182999822): unit tests and debug assembly passed. A temporary change to `SessionEngine.start` made `startAndStopAreSpokenAndTheSessionGoesQuiet` fail; restored source and reran all 18 tests successfully. |
| [QR-05](quality-requirements/qr/QR-05.md) | [QR-05 QRT-01](quality-requirements/qr/QR-05.md#qrt-01) | Passes | SPRINT-06 | [SPRINT-06](#sprint-06) | [reports/week-06/qr-05-qrt-01.md](https://github.com/Running-Coach-App/running-coach-app/blob/0cdccb28338deeb5d55a10c4a167d4d44076e9d2/reports/week-06/qr-05-qrt-01.md): scripted test reads a failed line from the file telemetry sink by its line ID and verifies the diagnostic fields. |
| [QR-06](quality-requirements/qr/QR-06.md) | [QR-06 QRT-01](quality-requirements/qr/QR-06.md#qrt-01) | Passes | SPRINT-07 | [SPRINT-07](#sprint-07) | `StabilitySoakTest`, 5 tests, 0 failures, run in the full suite of 35: an hour-long session at the real one-second cadence with the fix dropping for 90 s in every 10 min, ticks that go backwards and jump, 500 answers, and 50 start-and-stop cycles. The timed session took 10 ms against a 2,000 ms budget. |
| [QR-09](quality-requirements/qr/QR-09.md) | [QR-09 QRT-01](quality-requirements/qr/QR-09.md#qrt-01) | Not verified | None | [SPRINT-08](#sprint-08) | None. The test is [`UT-01`](usability-tests/ut-01/README.md), designed in `SPRINT-07` and run in `SPRINT-08`: no session has been counted, so there is nothing to read. The verdict is recorded here with the results, against the bar of 0.6 the team set before the first session. |
| [QR-08](quality-requirements/qr/QR-08.md) | [QR-08 QRT-01](quality-requirements/qr/QR-08.md#qrt-01) | Passes | SPRINT-07 | [SPRINT-07](#sprint-07) | `./scripts/scan.sh` exits 0: 149 locked dependencies checked against OSV.dev with none shipping an advisory, no network permission in the manifest or the built APK, no networking type in the source, and no credential in a tracked file. Adding `android.permission.INTERNET` makes it exit 1, which the `Security scan` workflow asserts on every run. |
| [QR-07](quality-requirements/qr/QR-07.md) | [QR-07 QRT-01](quality-requirements/qr/QR-07.md#qrt-01) | Not verified | None | [SPRINT-08](#sprint-08) | Defined and not run, and moved from `SPRINT-07` to `SPRINT-08`. It reads `adb shell dumpsys location` before, during, and after a session on a physical phone. The reason for the move is that `SPRINT-07` put the team's one Android phone on the [`UT-01`](usability-tests/ut-01/README.md) design instead, and the `SPRINT-08` sessions bring a phone and a route together anyway, so the run is cheapest there. `reports/week-07/README.md` declares the move in its `## Deviations`. |
