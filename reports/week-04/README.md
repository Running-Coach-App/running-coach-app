# Week 04 report

## Project

Running Coach App, team 4.

Our problem-space sentence: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal). The bar for it is [the threshold of success](../../docs/threshold-of-success.md).

## Summary

This week the product got the requirements and the architecture behind it: four quality requirements with their priority matrix, six functional requirements, a container view, and four architectural decision records. The slice itself did not grow; what changed is that a reader can now walk from a driver to the record that answers it.

Three of the `Customer`'s Week 3 decisions had never reached the code. `DEC-013` fixed a three-minute stats cadence and the engine spoke every minute; `DEC-012` asked for a focus-on-running reply and the engine said "That is not a stat of this run."; `DEC-011` asked for a missing stat to be named once and the engine repeated it on every line. All three are now implemented and covered by unit tests. Writing the functional requirements is what found them.

`v0.1.0` was built from a clean checkout and installed on a team phone on 2026-10-23, and the core task was run end to end outdoors: start, spoken stats, effort cues, a spoken question answered from the pocket with the screen off, and stop.

`REL-04` is not cut. The customer meeting has not been held.

## Customer meeting

Not held at the time of writing. The script is [meeting-script.md](meeting-script.md); the report and the transcript are [meeting-report.md](meeting-report.md) and [meeting-transcript.md](meeting-transcript.md).

Story verdicts: none recorded yet. They belong in the meeting report, each citing its `DEC-nnn`.

## Coverage

| Deliverable | Artifact |
| --- | --- |
| Sprint plan and estimates | [docs/project-plan.md#sprint-04](../../docs/project-plan.md#sprint-04). `**Planned Velocity:**` and `**Actual Velocity:**` are not set: no story carries `Story Points`, because the three issue fields do not exist yet |
| Product backlog refinement | Not done. It needs the `Story Points` field, which is part of the same gap |
| Issue catch-up | Not done. The `User Story` and `Task` types and the `MoSCoW` field do not exist yet, so the six labels are still the priority marker |
| Quality requirements | [docs/quality-requirements/](../../docs/quality-requirements/README.md), with [README.md](../../docs/quality-requirements/README.md) as the priority matrix |
| Functional requirements | [docs/functional-requirements/](../../docs/functional-requirements/README.md), with `README.md` as the index and `fr/` for the records |
| Container view | [docs/architecture/README.md#container-view](../../docs/architecture/README.md#container-view), its image and source, and [#container-responsibilities](../../docs/architecture/README.md#container-responsibilities) |
| Architecture and drivers | [docs/architecture/README.md](../../docs/architecture/README.md), with the drivers it links and the ADR index |
| Architectural decisions | [docs/architecture/adr/](../../docs/architecture/adr/ADR-001.md) and [the ADR index](../../docs/architecture/README.md#architectural-decisions) |
| Glossary | [docs/glossary.md](../../docs/glossary.md) |
| Team `AGENTS.md` | [AGENTS.md](../../AGENTS.md) |
| Issue fields in the project view | Not done. `Responsible` and `Accountable` exist on [the project](https://github.com/orgs/Running-Coach-App/projects/3); `MoSCoW`, `Story Points`, and `Priority` do not |
| Documentation site | [https://running-coach-app.github.io/running-coach-app/](https://running-coach-app.github.io/running-coach-app/), whose navigation lists the quality requirements, functional requirements, architecture, and glossary pages |
| Week 3 action points | [`## Previous action points`](meeting-report.md#previous-action-points) in the meeting report |
| Week 3 open questions | [`## Previous open questions`](meeting-report.md#previous-open-questions) in the same report |
| Meeting script | [reports/week-04/meeting-script.md](meeting-script.md) |
| Customer validation | [reports/week-04/meeting-report.md](meeting-report.md) and [meeting-transcript.md](meeting-transcript.md); no verdicts yet |
| `REL-04` | Not cut. [CHANGELOG.md](../../CHANGELOG.md) holds the sprint's entries under `[Unreleased]`, and the plan's `REL-04` section is empty |
| Sprint retrospective | [reports/week-04/sprint-retrospective.md](sprint-retrospective.md) |
| AI usage | [reports/week-04/ai-usage.md](ai-usage.md) |

## What changed

The spoken coach now matches the decisions the `Customer` made in Week 3, and `docs/setup.md` describes what it actually does rather than what it did.

The sprint due dates moved to the Saturdays Assignment 4 sets, in both the plan and the seven GitHub milestones.

Nothing was dropped from the minimum usable product candidate, and no requirement changed status.

## Contribution

| Member | Work |
| --- | --- |
| @sirjaey | TODO — fill from the merged pull requests before submitting |
| @ObeTech1 | TODO |
| @Ezekiel-Gadzama | TODO |

@JustACommonMan-OSDD has taken academic leave and did not take part this week.

## Repository evidence

TODO — one merged pull request that closed its task issue, the latest green link check run on `main`, and the latest green Markdown check run on `main`.

The link check on `main` is currently **red**, and not because of anything this week changed: `docs/research/alternatives.md` cites a Garmin developer FAQ that now returns 404. The page is archived and the citation can be repointed at the snapshot; until that is done every pull request carries a red link check.

## Deviations

1. **The three issue fields and the issue catch-up are not done.**
   `MoSCoW`, `Story Points`, and `Priority` are GitHub Projects fields, and the `User Story` and `Task` issue types are set through the same surface. Nobody with project access has created them yet, so Part 1 item 5 and Part 7 are outstanding, and with them the sprint's planned and actual velocity.
2. **`REL-04` is not cut and the customer meeting has not been held.**
   The release is cut on the state after the meeting, so both wait on it.
3. **The repository has no workflow that builds or tests the product code.**
   `gradle :app:testDebugUnitTest` and `gradle :app:assembleDebug` are run by hand. A Kotlin regression would not be caught by any check on a pull request.
4. **Three pull requests have to merge in order, and their link checks are red until they do.**
   `reports/week-04/meeting-script.md` and this report link the requirements and architecture pages, which arrive in an earlier pull request. The link check correctly reports those links as missing until that one merges, so the order is the documentation set, then the meeting script, then this report.

## Privacy

No private-only material was committed to this repository.
