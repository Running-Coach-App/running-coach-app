# Week 03 report

## Project

Running Coach App, team 4.

Our problem-space sentence: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal). The bar for it is [the threshold of success](../../docs/threshold-of-success.md).

## Summary

The Week 3 validation meeting was held live on Zoom on 2026-10-17. No working binary was shown. From description, the `Customer` affirmed the intended pocket-coach behaviours for [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37), [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38), [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39), and [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40), with refinements in [DEC-010](../../docs/decisions.md#dec-010) through [DEC-016](../../docs/decisions.md#dec-016). No candidate story moved out. [TOS-01](../../docs/threshold-of-success.md#tos-01) is `Met`.

`REL-03` is not cut. There is no release tag. The plan's [REL-03](../../docs/project-plan.md#rel-03) section is still empty, and [CHANGELOG.md](../../CHANGELOG.md) still holds the week's entries under `[Unreleased]`.

Still open from the meeting: professional runners, wearable value, and whether the two presets still follow the coach. Those are in [the meeting report](meeting-report.md#open-questions).

## Customer meeting

- Script: [meeting-script.md](meeting-script.md)
- Report: [meeting-report.md](meeting-report.md)
- Transcript: [meeting-transcript.md](meeting-transcript.md)

Story outcomes at that meeting (description only; no install was demonstrated):

| Story | Outcome | Decision |
| --- | --- | --- |
| [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) | Affirmed; pocket start and stop without motion detection | [DEC-015](../../docs/decisions.md#dec-015) |
| [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38) | Affirmed; three-minute stats cadence for the MUP; missing stats spoken once then omitted | [DEC-013](../../docs/decisions.md#dec-013), [DEC-011](../../docs/decisions.md#dec-011) |
| [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39) | Affirmed; interval effort cues; no unnecessary effort prompts on steady | [DEC-014](../../docs/decisions.md#dec-014) |
| [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) | Affirmed; off-topic gets a focus-on-running reply; prefer on-device intent with keywords as backup | [DEC-012](../../docs/decisions.md#dec-012), [DEC-016](../../docs/decisions.md#dec-016) |

Nothing moved out of the candidate.

## Coverage

| Deliverable | Artifact |
| --- | --- |
| Threshold of success | [docs/threshold-of-success.md](../../docs/threshold-of-success.md) |
| Project plan | [docs/project-plan.md](../../docs/project-plan.md) |
| Risk register | [docs/risks.md](../../docs/risks.md) |
| Stack decision | [docs/decisions.md#dec-009](../../docs/decisions.md#dec-009) |
| Definition of Done | [docs/definition-of-done.md](../../docs/definition-of-done.md) |
| Contributing guide | [CONTRIBUTING.md](../../CONTRIBUTING.md) |
| Sprint milestones and issue fields | [SPRINT-03 milestone](https://github.com/Running-Coach-App/running-coach-app/milestone/1); `Responsible` and `Accountable` are project fields defined in [CONTRIBUTING.md](../../CONTRIBUTING.md); assignees visible on that milestone's issues include @sirjaey, @ObeTech1, and @Ezekiel-Gadzama |
| GitHub project | Not linked from this repository. The public org projects page lists none without sign-in. Field rules are in [CONTRIBUTING.md](../../CONTRIBUTING.md) |
| Minimum usable product | Candidate [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) through [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40); pocket-session code on `main` via [#64](https://github.com/Running-Coach-App/running-coach-app/pull/64), [#66](https://github.com/Running-Coach-App/running-coach-app/pull/66), and [#67](https://github.com/Running-Coach-App/running-coach-app/pull/67); not demonstrated at the meeting |
| Changelog and first release | [CHANGELOG.md](../../CHANGELOG.md); `REL-03` not cut (no tag) |
| Documentation site | [https://running-coach-app.github.io/running-coach-app/](https://running-coach-app.github.io/running-coach-app/) |
| Setup and run instructions | [docs/setup.md](../../docs/setup.md) |
| Week 2 action points | [reports/week-03/meeting-report.md#previous-action-points](meeting-report.md#previous-action-points) |
| Week 2 open questions | [reports/week-03/meeting-report.md#previous-open-questions](meeting-report.md#previous-open-questions) |
| Meeting script | [reports/week-03/meeting-script.md](meeting-script.md) |
| Customer validation | [reports/week-03/meeting-report.md](meeting-report.md), [reports/week-03/meeting-transcript.md](meeting-transcript.md) |
| AI usage | [reports/week-03/ai-usage.md](ai-usage.md) |

## Minimum Usable Product Candidate

Core task: the runner puts the phone in a pocket, starts a session, and hears what to do and how the run is going until they stop.

The `Must Have` stories that complete that task are still [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37), [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38), [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39), and [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40). None moved out at the Week 3 meeting. [US-06](https://github.com/Running-Coach-App/running-coach-app/issues/42) stays `Should Have` and out of the candidate; the two-presets order was not asked.

Customer's verdict on those four stories: affirmed from description, with the refinements above. Device acceptance still waits on an installable build.

## Contribution

| Member | Work |
| --- | --- |
| @sirjaey | [#63](https://github.com/Running-Coach-App/running-coach-app/pull/63) meeting script, [#64](https://github.com/Running-Coach-App/running-coach-app/pull/64) start/stop, [#66](https://github.com/Running-Coach-App/running-coach-app/pull/66) effort cue, [#67](https://github.com/Running-Coach-App/running-coach-app/pull/67) spoken question, [#68](https://github.com/Running-Coach-App/running-coach-app/pull/68) threshold, [#88](https://github.com/Running-Coach-App/running-coach-app/pull/88) transcript, [#89](https://github.com/Running-Coach-App/running-coach-app/pull/89) validation outcome, [#90](https://github.com/Running-Coach-App/running-coach-app/pull/90) this report |
| @ObeTech1 | [#69](https://github.com/Running-Coach-App/running-coach-app/pull/69) definition of done and contributing, [#70](https://github.com/Running-Coach-App/running-coach-app/pull/70) project plan, [#71](https://github.com/Running-Coach-App/running-coach-app/pull/71) risk register, [#72](https://github.com/Running-Coach-App/running-coach-app/pull/72) on-device feasibility, [#73](https://github.com/Running-Coach-App/running-coach-app/pull/73) value propositions; approved [#64](https://github.com/Running-Coach-App/running-coach-app/pull/64) |
| @Ezekiel-Gadzama | [#74](https://github.com/Running-Coach-App/running-coach-app/pull/74) DEC-009, [#75](https://github.com/Running-Coach-App/running-coach-app/pull/75) setup page, [#76](https://github.com/Running-Coach-App/running-coach-app/pull/76) AI usage, [#77](https://github.com/Running-Coach-App/running-coach-app/pull/77) docs site; approved [#64](https://github.com/Running-Coach-App/running-coach-app/pull/64) |
| @JustACommonMan-OSDD | No merged pull request in this week's list above |

## Repository evidence

Merged pull request that closed its task issue: [pull request #89](https://github.com/Running-Coach-App/running-coach-app/pull/89), which closed [issue #84](https://github.com/Running-Coach-App/running-coach-app/issues/84).

Latest green link check on `main`, commit `6f12e37`: [run 39083192610](https://github.com/Running-Coach-App/running-coach-app/actions/runs/39083192610).

Latest green Markdown check on `main`, same commit: [run 39083192536](https://github.com/Running-Coach-App/running-coach-app/actions/runs/39083192536).

The Pages URL is excluded in [`lychee.toml`](../../lychee.toml) until the site resolves after the Pages workflow runs on `main`.

## Deviations

1. **No working app was demonstrated.**
   The meeting corrected direction from description only. Device acceptance of the slice still waits on an installable build.
2. **The three scripted permission questions were not asked one by one.**
   The `Customer` offered the transcript and the recording himself, so publication was taken as permitted. That shortcut is recorded here and in [the meeting report](meeting-report.md#deviations).
3. **Professional runners, wearable value, and the two-presets order were not asked.**
   They remain open for the next validation.
4. **`REL-03` is not cut.**
   There is no release tag. The changelog stays under `[Unreleased]`, and the plan's `REL-03` section is empty.
5. **The GitHub project table view is not linked here.**
   No project URL is stored in this repository, and the public org projects page lists none without sign-in. This report points at [CONTRIBUTING.md](../../CONTRIBUTING.md) for the project field rules instead of inventing a URL.
6. **`Responsible` and `Accountable` values are not copied into this table.**
   Those fields live on the project board. This report links the [SPRINT-03 milestone](https://github.com/Running-Coach-App/running-coach-app/milestone/1) and the assignees visible on its issues.

## Privacy

The Zoom passcode is not in this repository. The recording file is not committed. The sanitized transcript is [meeting-transcript.md](meeting-transcript.md). No private-only material was committed to this repository.
