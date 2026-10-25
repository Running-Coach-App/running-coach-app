# Week 04 report

## Project

Running Coach App, team 4.

Our problem-space sentence: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal). The bar for it is [the threshold of success](../../docs/threshold-of-success.md).

## Summary

This week the product got the requirements and the architecture behind it: four quality requirements with their priority matrix, six functional requirements, a container view, and four architectural decision records. The slice itself did not grow; what changed is that a reader can now walk from a driver to the record that answers it.

Three of the `Customer`'s Week 3 decisions had never reached the code. `DEC-013` fixed a three-minute stats cadence and the engine spoke every minute; `DEC-012` asked for a focus-on-running reply and the engine said "That is not a stat of this run."; `DEC-011` asked for a missing stat to be named once and the engine repeated it on every line. All three are now implemented and covered by unit tests. Writing the functional requirements is what found them.

`v0.1.0` was built from a clean checkout and installed on a team phone on 2026-10-23, and the core task was run end to end outdoors: start, spoken stats, effort cues, a spoken question answered from the pocket with the screen off, and stop.

The validation meeting was held on 2026-10-23 and all four candidate stories were affirmed. `REL-04` is cut as [`v0.2.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.2.0).

## Customer meeting

Held on 2026-10-23 over a call, recorded with the `Customer`'s permission. The script is [meeting-script.md](meeting-script.md), the report is [meeting-report.md](meeting-report.md), and the sanitized transcript is [meeting-transcript.md](meeting-transcript.md).

The product was shown over screen share rather than on the `Customer`'s own phone: he will install only a build he makes himself from this repository, per [`DEC-021`](../../docs/decisions.md#dec-021).

| Story | Verdict | Decision |
| --- | --- | --- |
| [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) | Accepted from the demonstration | [`DEC-017`](../../docs/decisions.md#dec-017) |
| [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38) | Accepted on audio, with the same stats required on screen next | [`DEC-018`](../../docs/decisions.md#dec-018) |
| [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39) | Accepted for the first usable product | [`DEC-019`](../../docs/decisions.md#dec-019) |
| [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) | Accepted for the first usable product | [`DEC-020`](../../docs/decisions.md#dec-020) |

The meeting did not reach the quality requirements, the architecture, or script questions 14 to 16, so this week does not validate those artifacts against the drivers. That is carried into the next meeting, and the three Week 3 questions remain open.

## Coverage

| Deliverable | Artifact |
| --- | --- |
| Sprint plan and estimates | [docs/project-plan.md#sprint-04](../../docs/project-plan.md#sprint-04), with the sprint's goal and its `Sprint Backlog:` link. `**Planned Velocity:**` and `**Actual Velocity:**` are not set: the `Story Points` field now exists but no story carries a value yet |
| Product backlog refinement | Not done. It needs a `Story Points` value on each story, which is the same gap as the velocities |
| Issue catch-up | Mostly done. Every issue carries the `User Story` or `Task` type, every story's criteria are checkboxes with a `### Specified by`, and every open task has a `### Requirements`. Outstanding: a `MoSCoW` value on each story, and the six labels that cannot retire until it is set |
| Quality requirements | [docs/quality-requirements/](../../docs/quality-requirements/README.md), with [README.md](../../docs/quality-requirements/README.md) as the priority matrix |
| Functional requirements | [docs/functional-requirements/](../../docs/functional-requirements/README.md), with `README.md` as the index and `fr/` for the records |
| Container view | [docs/architecture/README.md#container-view](../../docs/architecture/README.md#container-view), its image and source, and [#container-responsibilities](../../docs/architecture/README.md#container-responsibilities) |
| Architecture and drivers | [docs/architecture/README.md](../../docs/architecture/README.md), with the drivers it links and the ADR index |
| Architectural decisions | [docs/architecture/adr/](../../docs/architecture/adr/ADR-001.md) and [the ADR index](../../docs/architecture/README.md#architectural-decisions) |
| Glossary | [docs/glossary.md](../../docs/glossary.md) |
| Team `AGENTS.md` | [AGENTS.md](../../AGENTS.md) |
| Issue fields in the project view | `Responsible`, `Accountable`, `MoSCoW`, `Story Points`, and `Priority` all exist on [the project](https://github.com/orgs/Running-Coach-App/projects/3). No story carries a `MoSCoW` or `Story Points` value yet |
| Documentation site | [https://running-coach-app.github.io/running-coach-app/](https://running-coach-app.github.io/running-coach-app/), whose navigation lists the quality requirements, functional requirements, architecture, and glossary pages |
| Week 3 action points | [`## Previous action points`](meeting-report.md#previous-action-points) in the meeting report |
| Week 3 open questions | [`## Previous open questions`](meeting-report.md#previous-open-questions) in the same report |
| Meeting script | [reports/week-04/meeting-script.md](meeting-script.md) |
| Customer validation | [reports/week-04/meeting-report.md](meeting-report.md) and [meeting-transcript.md](meeting-transcript.md), with a verdict on each of the four candidate stories, each citing its `DEC-nnn` |
| `REL-04` | [`v0.2.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.2.0), cut on 2026-10-25 from `bb6b5b4` on `main`, with its [changelog section](../../CHANGELOG.md) and the plan's [`REL-04`](../../docs/project-plan.md#rel-04) line |
| Sprint retrospective | [reports/week-04/sprint-retrospective.md](sprint-retrospective.md) |
| AI usage | [reports/week-04/ai-usage.md](ai-usage.md) |

## What changed

The spoken coach now matches the decisions the `Customer` made in Week 3, and `docs/setup.md` describes what it actually does rather than what it did.

The sprint due dates moved to the Saturdays Assignment 4 sets, in both the plan and the seven GitHub milestones.

Nothing was dropped from the minimum usable product candidate, and no requirement changed status.

## Contribution

| Member | Work |
| --- | --- |
| @sirjaey | Authored [#96](https://github.com/Running-Coach-App/running-coach-app/pull/96) sprint dates, [#98](https://github.com/Running-Coach-App/running-coach-app/pull/98) requirements and architecture, [#100](https://github.com/Running-Coach-App/running-coach-app/pull/100) meeting script, [#102](https://github.com/Running-Coach-App/running-coach-app/pull/102) the spoken coach, [#104](https://github.com/Running-Coach-App/running-coach-app/pull/104) this report, [#112](https://github.com/Running-Coach-App/running-coach-app/pull/112) the archived citation, and [#114](https://github.com/Running-Coach-App/running-coach-app/pull/114) the remaining requirements and issue forms; approved [#115](https://github.com/Running-Coach-App/running-coach-app/pull/115) and [#116](https://github.com/Running-Coach-App/running-coach-app/pull/116); created the `User Story` issue type and the project's `MoSCoW`, `Story Points`, and `Priority` fields; attended the validation meeting |
| @ObeTech1 | Approved [#89](https://github.com/Running-Coach-App/running-coach-app/pull/89), [#92](https://github.com/Running-Coach-App/running-coach-app/pull/92), [#94](https://github.com/Running-Coach-App/running-coach-app/pull/94), [#98](https://github.com/Running-Coach-App/running-coach-app/pull/98), [#100](https://github.com/Running-Coach-App/running-coach-app/pull/100), [#102](https://github.com/Running-Coach-App/running-coach-app/pull/102), [#104](https://github.com/Running-Coach-App/running-coach-app/pull/104), [#112](https://github.com/Running-Coach-App/running-coach-app/pull/112), and [#114](https://github.com/Running-Coach-App/running-coach-app/pull/114), which is every pull request this sprint bar the two he could not review as their author's counterpart; attended the validation meeting |
| @Ezekiel-Gadzama | Authored [#115](https://github.com/Running-Coach-App/running-coach-app/pull/115), the workflow that builds and tests the product code, and [#116](https://github.com/Running-Coach-App/running-coach-app/pull/116), the meeting report and transcript; ran the validation meeting; approved [#96](https://github.com/Running-Coach-App/running-coach-app/pull/96) and [#114](https://github.com/Running-Coach-App/running-coach-app/pull/114) |

@JustACommonMan-OSDD has taken academic leave and did not take part this week.

## Repository evidence

Merged pull request that closed its task issue: [pull request #116](https://github.com/Running-Coach-App/running-coach-app/pull/116), which closed [issue #106](https://github.com/Running-Coach-App/running-coach-app/issues/106).

Latest green link check on `main`, commit `61ad6c7`: [run 40215875108](https://github.com/Running-Coach-App/running-coach-app/actions/runs/40215875108).

Latest green Markdown check on `main`, same commit: [run 40215874847](https://github.com/Running-Coach-App/running-coach-app/actions/runs/40215874847).

Latest green Android build and unit-test run on `main`, same commit: [run 40215874916](https://github.com/Running-Coach-App/running-coach-app/actions/runs/40215874916).

The dead Garmin citation that had been turning the link check red was repointed at an archived copy of the same page in [pull request #112](https://github.com/Running-Coach-App/running-coach-app/pull/112).

## Deviations

1. **This week was submitted after its deadline.**
   The hard deadline was 2026-10-24 at 23:59. The customer meeting was held on 2026-10-23, and the work that followed it — the report, the release, and the documentation site — ran past the deadline.
2. **The documentation site went live late in the week.**
   `mkdocs build --strict` had been aborting on fourteen warnings: files under `docs/` linked meeting reports by a relative path that leaves `docs/`, which `mkdocs` cannot resolve. GitHub Pages was also set to deploy from a branch rather than from the workflow. Both are fixed and the site now resolves, but it was not published for most of the sprint, and the Week 3 report had listed it as a satisfied deliverable while it returned 404.
3. **No story carries a `MoSCoW` or `Story Points` value.**
   The three fields now exist on the project, and every issue carries its type, but the values are unset. The sprint therefore has no planned or actual velocity, the product backlog is unrefined, and the `user-story`, `task`, and four `moscow:*` labels cannot retire, because they are still the only record of each story's priority.
4. **Four dependency bumps broke the build, and were reverted.**
   Merging the Android Gradle plugin to 9.4.1 while the Kotlin plugin stayed at 2.0.21 made every build fail at plugin-apply time, and `androidx.core:core-ktx:1.19.1` turned out to require that same major. All four went back to the versions that build, the Kotlin bump was closed rather than merged, and moving to AGP 9 is left as its own piece of work rather than attempted against this deadline.
5. **The meeting covered the working software but not the architecture.**
   Script questions 9 to 16 were not reached, so the quality requirements and the architecture were not put to the `Customer` against the drivers, and the three Week 3 open questions are still open. They are carried into the next meeting.
6. **The product was demonstrated over screen share, not on the `Customer`'s phone.**
   He will install only a build he makes himself from this repository, per [`DEC-021`](../../docs/decisions.md#dec-021), so his own confirmation of pocket and headset use is still outstanding under [#86](https://github.com/Running-Coach-App/running-coach-app/issues/86).

## Privacy

No private-only material was committed to this repository.
