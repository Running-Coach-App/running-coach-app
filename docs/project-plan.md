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

#### REL-04

- **Tag:** [`v0.2.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.2.0)
- **Date:** 2026-10-25
- **Ships:** the spoken coach brought in line with `DEC-011`, `DEC-012`, and `DEC-013`, the quality and functional requirements, the container view and the architectural decision records, the glossary and the team's `AGENTS.md`, and a workflow that builds and tests the product code.

### SPRINT-05

Somebody outside the team can obtain the product, install it, and finish a pocket session, and the checks that say it works run without being asked.

- Due: 2026-10-31
- Sprint Backlog: [the issues scheduled into SPRINT-05](https://github.com/Running-Coach-App/running-coach-app/milestone/3)
- Planned Velocity: to be set from the `Story Points` of the stories selected into this sprint

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
