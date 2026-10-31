# Project plan

Running Coach App, team 4.

## Milestones

### MLS-03

- Due: 2026-10-17
- Sprints: [SPRINT-03](#sprint-03)
- Advances: [TOS-01](threshold-of-success.md#tos-01)

A runner puts the phone in a pocket, starts a session, and hears what to do and how the run is going until they stop.
That slice is the Week 2 candidate: [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37), [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38), [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39), and [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40).

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

#### REL-04

- **Tag:** [`v0.2.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.2.0)
- **Date:** 2026-10-25
- **Ships:** the spoken coach brought in line with `DEC-011`, `DEC-012`, and `DEC-013`, the quality and functional requirements, the container view and the architectural decision records, the glossary and the team's `AGENTS.md`, and a workflow that builds and tests the product code.

### SPRINT-05

A person outside the team can run the core task from the published setup, and the checks run on every pull request.

- Due: 2026-10-31

#### REL-05

### SPRINT-06

The team can tell, from the product itself, whether a runner heard the coach during a session.

- Due: 2026-11-07

#### REL-06

### SPRINT-07

A runner who is not on the team can be asked to use the coach, and the team has a written way to watch that use.

- Due: 2026-11-14

#### REL-07

### SPRINT-08

The repository's configuration is the one the team will keep through the end of the course.

- Due: 2026-11-21

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
| [QR-01](quality-requirements/qr/QR-01.md) | [QR-01 QRT-01](quality-requirements/qr/QR-01.md#qrt-01) | Not verified | None | [SPRINT-05](#sprint-05) | None |
| [QR-02](quality-requirements/qr/QR-02.md) | [QR-02 QRT-01](quality-requirements/qr/QR-02.md#qrt-01) | Not verified | None | [SPRINT-05](#sprint-05) | None |
