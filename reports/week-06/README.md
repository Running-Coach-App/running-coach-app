# Week 6 report

## Project

Running Coach App, team 4. This report covers SPRINT-06, 2 to 8 November 2026, and the state reviewed at its close.

## What we did

The product now records its core session events on the phone, and the team wrote analytics and observability plans for reading those records. The focus metric, weekly completed coached sessions, has no runner value yet: it needs sessions from people outside the team, while team-generated `smoke` traffic is excluded. The query in the analytics plan computes that metric; the product has no backend to run it against today.

The team added a scripted diagnosability test and its evidence in [PR #185](https://github.com/Running-Coach-App/running-coach-app/pull/185). The test writes a synthetic failed-line record through the file sink and finds it by `line_id`. This does not show that a real session emits per-line outcomes: that production wiring remains open in [issue #175](https://github.com/Running-Coach-App/running-coach-app/issues/175).

No story met the definition of done, so SPRINT-06 actual velocity is 0 of 27 planned points. The sprint closeout records the six open stories as carryovers to SPRINT-07; the GitHub milestone updates and closure are still pending the REL-06 cut. The [testing plan](../../docs/project-plan.md#quality-requirement-testing-plan) records the status and evidence for every quality test, including the scripted test that did not run at the assigned deployed level. The planned release is `REL-06`, tag `v0.4.0`; it has not been cut. The version bump is in [PR #189](https://github.com/Running-Coach-App/running-coach-app/pull/189), and the release task remains [issue #187](https://github.com/Running-Coach-App/running-coach-app/issues/187).

No deck or experiment was required this week.

## Threshold review

| Goal | Current measure | Can analytics or observability settle it? | Proposal |
| --- | --- | --- | --- |
| [TOS-03](../../docs/threshold-of-success.md#tos-03) | One session on a physical Android phone, cited from the Week 9 report, with an on-device answer to a spoken time, pace, or distance question by 2026-11-27. | No. Analytics could count questions and answers, and SLI-01 describes line delay, but neither proves that a runner heard an on-device answer during a physical-phone session. | None. The customer did not see a threshold proposal in the Week 6 meeting, and no change was agreed. |

[TOS-03](../../docs/threshold-of-success.md#tos-03) remains open. TOS-01 and TOS-02 were already settled before this review and retain their outcomes in the [threshold of success](../../docs/threshold-of-success.md).

## Coverage

| Deliverable | Artifact |
| --- | --- |
| Sprint plan and new stories | [docs/project-plan.md#sprint-06](../../docs/project-plan.md#sprint-06), [US-12](https://github.com/Running-Coach-App/running-coach-app/issues/167), and [US-13](https://github.com/Running-Coach-App/running-coach-app/issues/168) |
| Analytics plan | [docs/analytics.md](../../docs/analytics.md) |
| Events and instrumentation | [docs/analytics.md#the-events](../../docs/analytics.md#the-events); production per-line outcomes remain open in [issue #175](https://github.com/Running-Coach-App/running-coach-app/issues/175) |
| Analytics dashboards | Not produced: no analytics backend or staging/production dashboard was deployed. |
| Observability plan and SLIs | [docs/observability.md](../../docs/observability.md) |
| Observability dashboards | Not produced: no observability backend or staging/production dashboard was deployed. |
| Feature documentation | Pending [PR #186](https://github.com/Running-Coach-App/running-coach-app/pull/186), which carries the feature entries and glossary terms onto `main`. |
| Functional requirements | [docs/functional-requirements/README.md](../../docs/functional-requirements/README.md), including [FR-013](../../docs/functional-requirements/fr/FR-013.md) and [FR-014](../../docs/functional-requirements/fr/FR-014.md) |
| ADRs and container view | [docs/architecture/README.md](../../docs/architecture/README.md), which contains the ADR index and container view |
| Diagnosability requirement | [QR-05 and QRT-01 in PR #185](https://github.com/Running-Coach-App/running-coach-app/pull/185); the requirement file and scripted evidence are on that branch pending merge. |
| Runtime test re-run | None was run this week; see the [quality requirement testing plan](../../docs/project-plan.md#quality-requirement-testing-plan). |
| Threshold review | [This report's threshold review](#threshold-review) |
| Week 5 action points | [reports/week-06/meeting-report.md#previous-action-points](meeting-report.md#previous-action-points) |
| Week 5 open questions | [reports/week-06/meeting-report.md#previous-open-questions](meeting-report.md#previous-open-questions) |
| Meeting script | [reports/week-06/meeting-script.md](meeting-script.md) |
| Meeting transcript | [reports/week-06/meeting-transcript.md](meeting-transcript.md), sanitized for publication |
| Customer validation | [reports/week-06/meeting-report.md](meeting-report.md); no threshold decision changed the measure. The customer decisions are [DEC-030](../../docs/decisions.md#dec-030) through [DEC-033](../../docs/decisions.md#dec-033). |
| REL-06 | Not cut. [Issue #187](https://github.com/Running-Coach-App/running-coach-app/issues/187) and [version-bump PR #189](https://github.com/Running-Coach-App/running-coach-app/pull/189) are open; `v0.4.0`, the release body, the changelog section, and the plan's release fields are not yet on `main`. |
| Sprint retrospective | [reports/week-06/sprint-retrospective.md](sprint-retrospective.md); closeout is in [PR #190](https://github.com/Running-Coach-App/running-coach-app/pull/190). |
| AI usage | [reports/week-06/ai-usage.md](ai-usage.md) |

## Contribution

| Member | Week 6 work recorded in the repository |
| --- | --- |
| @sirjaey | Merged [PR #169](https://github.com/Running-Coach-App/running-coach-app/pull/169) (sprint plan), [PR #171](https://github.com/Running-Coach-App/running-coach-app/pull/171) (analytics), [PR #173](https://github.com/Running-Coach-App/running-coach-app/pull/173) (observability), and [PR #176](https://github.com/Running-Coach-App/running-coach-app/pull/176) (instrumentation). [PR #186](https://github.com/Running-Coach-App/running-coach-app/pull/186), [PR #189](https://github.com/Running-Coach-App/running-coach-app/pull/189), and [PR #190](https://github.com/Running-Coach-App/running-coach-app/pull/190) remain open. |
| @Ezekiel-Gadzama | Wrote the Week 6 validation record and transcript in merged [PR #180](https://github.com/Running-Coach-App/running-coach-app/pull/180). |
| @ObeTech1 | Prepared the scripted diagnosability test in [PR #185](https://github.com/Running-Coach-App/running-coach-app/pull/185) and the Week 6 report in the PR for [issue #188](https://github.com/Running-Coach-App/running-coach-app/issues/188). |
| @JustACommonMan-OSDD | No Week 6 implementation PR is recorded under this username in the repository history reviewed on 8 November. |

## Repository evidence

Merged [PR #176](https://github.com/Running-Coach-App/running-coach-app/pull/176) closed its task issue, #174. The latest green runs on `main` all checked commit `19ac78b234` on 7 November:

- [Link check](https://github.com/Running-Coach-App/running-coach-app/actions/runs/42370783057)
- [Markdown check](https://github.com/Running-Coach-App/running-coach-app/actions/runs/42370783034)
- [`actionlint` / workflow lint](https://github.com/Running-Coach-App/running-coach-app/actions/runs/42370783124)
- [Android unit tests and debug build](https://github.com/Running-Coach-App/running-coach-app/actions/runs/42370783030)

## Deviations

- The assignment expects four deployed dashboards and a `deployed` QRT. There is no staging environment or telemetry backend, and the product records telemetry to local files without an `INTERNET` permission. The dashboards and screenshots were not produced. QRT-01 therefore used a scripted local file-sink test; it passed, but does not establish deployed behavior.
- The production per-line telemetry path is still missing (`#175`), so the scripted QRT verifies that a synthetic record can be stored and found, not that a real coaching line produces it.
- No story was accepted. The closeout records the six open stories (27 points) for SPRINT-07; issue milestone changes and SPRINT-06 closure wait for the REL-06 release sequence. The testing-plan rows and their evidence are in [docs/project-plan.md#quality-requirement-testing-plan](../../docs/project-plan.md#quality-requirement-testing-plan); they are not repeated here.
- The assigned release is `REL-06` / `v0.4.0`, but it was not tagged by this report. The version bump is still under review in PR #189, so the release body, changelog section, and final `Checked QRs` fields are pending.

## Privacy

No private-only material was committed to this repository.
