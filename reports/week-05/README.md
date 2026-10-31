# Week 05 report

## Project

Running Coach App, team 4.

Our problem-space sentence: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal). The bar for it is [the threshold of success](../../docs/threshold-of-success.md).

## Summary

`SPRINT-05` set out to let somebody outside the team obtain the product, install it, and finish a pocket session, with the checks that say it works running without being asked. The checks arrived; the install did not reach the `Customer`.

**Deployment.** The university VM was not obtained in time, so staging and production were not deployed. [`docs/deployment.md`](../../docs/deployment.md) names the four environments and is the runbook the deploy uses once the VM exists: development on a teammate's machine, integration in GitHub Actions, and staging and production as two deployments of the same APK on the VM, each with its own port. Real addresses stay out of this repository and go in the Moodle submission. What does run today is the integration environment and the documentation site at <https://running-coach-app.github.io/running-coach-app/>.

**Milestones.** Three are in the plan. [`MLS-03`](../../docs/project-plan.md#mls-03), due 2026-10-17, delivered the pocket session a runner can start, hear, and stop. [`MLS-05`](../../docs/project-plan.md#mls-05), due 2026-10-31, delivers a build a stranger can obtain and the checks that say it works. [`MLS-07`](../../docs/project-plan.md#mls-07), due 2026-11-14, spans `SPRINT-06` and `SPRINT-07` and delivers the coach a runner outside the team can be asked to use.

**`REL-05`** is tagged [`v0.3.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.3.0), cut on the commit where all five workflows are green. Its [plan block](../../docs/project-plan.md#rel-05) records the tag and the requirements checked this sprint.

**CI checks.** Of the five the course names, the product-code workflow runs two as named steps: the build and the automated tests. Type checking is performed by the Kotlin compiler inside the build rather than as a separate step, so it has no step of its own. Linting and formatting are not run at all: no Kotlin linter or formatter is configured in the project. Both would apply to this stack, so neither is recorded as not applicable, and both are declared under [Deviations](#deviations) instead. `actionlint` runs over the workflows themselves on pull requests and on `main`.

**What moved out.** The sprint planned 22 points and completed 3. [`US-01`](https://github.com/Running-Coach-App/running-coach-app/issues/37), [`US-03`](https://github.com/Running-Coach-App/running-coach-app/issues/39), [`US-04`](https://github.com/Running-Coach-App/running-coach-app/issues/40) and [`US-10`](https://github.com/Running-Coach-App/running-coach-app/issues/141) moved to `SPRINT-06`, 19 points in all, because the `Customer` has not installed the product and could not accept them against their criteria. [`#137`](https://github.com/Running-Coach-App/running-coach-app/issues/137), signing the release build, also moved to `SPRINT-06`.

Every row of [the quality requirement testing plan](../../docs/project-plan.md#quality-requirement-testing-plan) reads `Passes` this sprint; the plan carries each result and the sprint of its last check.

## Customer meeting

Held 2026-10-31. The full record is [the meeting report](meeting-report.md), with [the transcript](meeting-transcript.md) and [the script](meeting-script.md).

| Story | Shown | Verdict | Decision |
| --- | --- | --- | --- |
| [`US-02`](https://github.com/Running-Coach-App/running-coach-app/issues/38) | From screenshots, not on his phone | Accepted as a first iteration, with the labelling and microphone changes attached | [`DEC-029`](../../docs/decisions.md#dec-029) |
| [`US-10`](https://github.com/Running-Coach-App/running-coach-app/issues/141) | Seen as a screenshot; not walked against its acceptance criteria | Not rejected, and not accepted. Stays open | None |
| [`US-01`](https://github.com/Running-Coach-App/running-coach-app/issues/37) | Not shown | Unvalidated: he has not installed, so pocket start and stop on his own phone remain unseen | None |

Seven decisions came out of the meeting, [`DEC-023`](../../docs/decisions.md#dec-023) to [`DEC-029`](../../docs/decisions.md#dec-029). Three of them reverse a position the team held, and [the meeting report's disagreements table](meeting-report.md#disagreements) records what we changed and why.

Both implemented tests ran at the `CI` level, not at `deployed`, because staging does not exist:

| Test | Level | Result |
| --- | --- | --- |
| [`QR-01 QRT-01`](../../docs/quality-requirements/qr/QR-01.md#qrt-01) | `CI` | `Passes`, checked in `SPRINT-05` |
| [`QR-02 QRT-01`](../../docs/quality-requirements/qr/QR-02.md#qrt-01) | `CI` | `Passes`, checked in `SPRINT-05`, and confirmed by breaking `SessionEngine.start` on purpose to watch the suite fail |

## Coverage

| Deliverable | Artifact |
| --- | --- |
| Sprint plan and milestones | [docs/project-plan.md#sprint-05](../../docs/project-plan.md#sprint-05) and [#milestones](../../docs/project-plan.md#milestones), with the goal, both velocities, and each milestone's due week |
| New stories | [the issues typed `User Story`](https://github.com/Running-Coach-App/running-coach-app/issues?q=is%3Aissue+type%3A%22User+Story%22), with [`US-10`](https://github.com/Running-Coach-App/running-coach-app/issues/141) and [`US-11`](https://github.com/Running-Coach-App/running-coach-app/issues/142) added this week. `US-10` was scheduled into `SPRINT-05` and has moved to `SPRINT-06` unaccepted |
| Quality requirement tests | [docs/quality-requirements/qr/](../../docs/quality-requirements/README.md), with a `QRT-01` in each active High business-importance requirement, `QR-01` and `QR-02` |
| Testing plan | [docs/project-plan.md#quality-requirement-testing-plan](../../docs/project-plan.md#quality-requirement-testing-plan) |
| Automated tests and CI | [.github/workflows/](https://github.com/Running-Coach-App/running-coach-app/tree/main/.github/workflows), with `actionlint` over the workflows and the Android build running the unit tests and the debug assembly |
| Deployment | [docs/deployment.md](../../docs/deployment.md), with the four environments and the runbook. Staging and production were not deployed: the VM was not obtained, and the core task was not verified on it. Declared under Deviations |
| Feature documentation | [docs/features.md](../../docs/features.md) |
| Week 4 action points | [`## Previous action points`](meeting-report.md#previous-action-points) |
| Week 4 open questions | [`## Previous open questions`](meeting-report.md#previous-open-questions) |
| Meeting script | [reports/week-05/meeting-script.md](meeting-script.md) |
| Meeting transcript | [reports/week-05/meeting-transcript.md](meeting-transcript.md) |
| Customer validation | [reports/week-05/meeting-report.md](meeting-report.md), with each verdict in [`## Story verdicts`](meeting-report.md#story-verdicts) |
| `REL-05` | the tag [`v0.3.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.3.0) and its release body, [the changelog's released section](https://github.com/Running-Coach-App/running-coach-app/blob/main/CHANGELOG.md#030---2026-10-31), and [the plan's `REL-05` block](../../docs/project-plan.md#rel-05) with `Released` and `Checked QRs` |
| Sprint retrospective | [reports/week-05/sprint-retrospective.md](sprint-retrospective.md) |
| AI usage | [reports/week-05/ai-usage.md](ai-usage.md) |

## What changed

The product gained an on-screen view of the run it is speaking, a history of finished runs, a one-run report, and a profile. The repository gained the quality requirement tests and the plan that records their results, the feature documentation, two functional requirements, a workflow lint, and a debug APK published from every run.

The tracker changed more than the product. Every story now carries a `MoSCoW` value and a `Story Points` estimate, five were scheduled into the sprint, and the six labels that had been the only record of a story's priority were retired once the fields replaced them.

## Contribution

| Member | Work |
| --- | --- |
| @sirjaey | Authored the Week 5 artefacts and the quality requirement tests, the sprint plan and its velocities, the two new stories with their requirements, the APK publishing workflow, the version bump, `REL-05`, the site-build fix, the formatting restoration, and this report; set the project's `Story Points` and `MoSCoW` values and retired the six labels |
| @ObeTech1 | Ran both quality requirement tests and recorded their results with evidence; wrote the definition of done's check list and the `SPRINT-04` velocities; reviewed the week's pull requests |
| @Ezekiel-Gadzama | Ran the customer meeting and wrote its report, transcript, and seven decisions; wrote the deployment runbook and the four environments; recorded the speech recogniser assumption; reviewed the week's pull requests |

## Repository evidence

[`#138`](https://github.com/Running-Coach-App/running-coach-app/pull/138) merged and closed its task issue [`#136`](https://github.com/Running-Coach-App/running-coach-app/issues/136), publishing the debug APK from every run.

The latest runs on `main`, all green:

| Check | Run |
| --- | --- |
| Link check | [run 41238945567](https://github.com/Running-Coach-App/running-coach-app/actions/runs/41238945567) |
| Markdown check | [run 41238945473](https://github.com/Running-Coach-App/running-coach-app/actions/runs/41238945473) |
| Workflow lint | [run 41238945526](https://github.com/Running-Coach-App/running-coach-app/actions/runs/41238945526) |
| Android build | [run 41238945360](https://github.com/Running-Coach-App/running-coach-app/actions/runs/41238945360) |

## Deviations

1. **The university VM was not obtained, so nothing was deployed.**
   Staging and production do not exist, the core task was not verified on production, and the Moodle submission carries no addresses because there are none. [`docs/deployment.md`](../../docs/deployment.md) is written as the runbook for when the VM arrives.
2. **Both quality requirement tests fall back to `CI`.**
   The assignment prefers `deployed` when staging is available. It is not, so `QR-01 QRT-01` and `QR-02 QRT-01` are both implemented and run at `CI`. They will be upgraded if staging arrives in the same sprint.
3. **Linting and formatting are not run at all.**
   Of the five checks the course names, the workflow names the build and the automated tests, and type checking happens inside the Kotlin compiler during the build. Linting and formatting both apply to this stack, so neither can honestly be recorded as not applicable; no linter or formatter is configured, and the workflow carries no record of their absence. Both are outstanding work rather than a decision.
4. **The rework the `Customer` asked for is deferred to `SPRINT-06`.**
   [`DEC-024`](../../docs/decisions.md#dec-024), [`DEC-025`](../../docs/decisions.md#dec-025) and [`DEC-026`](../../docs/decisions.md#dec-026) change the run screen's title, the session action labels, and the `Ask` control. The release was cut on the reviewed commit instead, and the changes are due 2026-11-07.
5. **The release ships unsigned.**
   `v0.3.0` is a debug-signed build, because [`#137`](https://github.com/Running-Coach-App/running-coach-app/issues/137) moved to `SPRINT-06`. The release body tells the `Customer` that installing a signed build later will require uninstalling this one and will clear its saved runs.
6. **No story was validated on the `Customer`'s phone.**
   He has not installed the product, so `US-02` was accepted from screenshots rather than walked against its acceptance criteria, and `US-01` was not shown at all. `US-05` was closed during the sprint without being shown to him, which [the definition of done](../../docs/definition-of-done.md) does not allow; the sprint's actual velocity records it and says so.
7. **The meeting did not follow the Week 5 agenda.**
   Questions about his own run could not be asked, and the quality requirements index, the testing plan, and the milestones were not shown. [The meeting report's deviations](meeting-report.md#deviations) carry the detail.
8. **The documentation site was broken on `main` for three pushes.**
   A link leaving `docs_dir` merged green because `mkdocs build --strict` runs only after a merge. It is fixed, and running the strict build on pull requests is an action in [the retrospective](sprint-retrospective.md#actions).
9. **Two files reached `main` with their formatting stripped.**
   Content moved between machines as pasted text lost every code span. It is restored, and the transfer method is an action in the retrospective.

## Privacy

No private-only material was committed to this repository.
