# Features

What the Running Coach App lets a runner do, in the user's words. The words this project uses in its own sense are defined in [the glossary](glossary.md).

Each entry links what owns its facts: the story that carries the need, the requirement that owns the behaviour, and the record behind the decision. Nothing here restates a behaviour or an acceptance criterion those records already carry.

## Start and stop a run without looking

You begin a [session](glossary.md#session) and end it later without taking the phone out of your pocket or unlocking it, and the coach tells you each time which has happened.

- **Stories:** [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37)
- **Behavior:** [FR-001](functional-requirements/fr/FR-001.md)
- **Decisions:** [ADR-001](architecture/adr/ADR-001.md), [DEC-015](decisions.md#dec-015)

## Hear how the run is going

While you run, the coach speaks your elapsed time, your pace, and your distance on its own, so you learn how the run is going without asking and without reading anything.

- **Stories:** [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38)
- **Behavior:** [FR-002](functional-requirements/fr/FR-002.md), [FR-006](functional-requirements/fr/FR-006.md)
- **Decisions:** [ADR-002](architecture/adr/ADR-002.md), [DEC-011](decisions.md#dec-011), [DEC-013](decisions.md#dec-013)

## Hear what effort to hold

On an [interval session](glossary.md#interval-session) the coach tells you when to push and when to ease off, at the moment the effort changes, so you do not have to watch a timer. A [steady session](glossary.md#steady-session) stays quiet about effort.

- **Stories:** [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39)
- **Behavior:** [FR-003](functional-requirements/fr/FR-003.md)
- **Decisions:** [ADR-002](architecture/adr/ADR-002.md), [DEC-014](decisions.md#dec-014)

## Ask about your run out loud

You ask how far, how fast, or how long, in your own words rather than a fixed phrase, and the coach answers out loud while you keep running.

- **Stories:** [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40)
- **Behavior:** [FR-004](functional-requirements/fr/FR-004.md)
- **Decisions:** [ADR-004](architecture/adr/ADR-004.md), [DEC-008](decisions.md#dec-008), [DEC-016](decisions.md#dec-016)

## Ask about anything else and be sent back to the run

Ask the coach something that is not about this run and it answers in its own voice and turns you back to running, rather than guessing at something it cannot know.

- **Stories:** [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40)
- **Behavior:** [FR-005](functional-requirements/fr/FR-005.md)
- **Decisions:** [ADR-004](architecture/adr/ADR-004.md), [DEC-012](decisions.md#dec-012)

## See on screen what the coach says

When you do look at the phone, the screen shows the same run you are hearing, so what the coach says and what the screen shows never disagree.

- **Stories:** [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38)
- **Behavior:** [FR-010](functional-requirements/fr/FR-010.md)
- **Decisions:** [DEC-018](decisions.md#dec-018), [DEC-022](decisions.md#dec-022)

## Hear the run once you have stopped

When you finish, the coach tells you what the run was, so you know how it went without opening anything afterwards.

- **Stories:** [US-05](https://github.com/Running-Coach-App/running-coach-app/issues/41)
- **Behavior:** [FR-007](functional-requirements/fr/FR-007.md)
- **Decisions:** [ADR-002](architecture/adr/ADR-002.md)
