# Week 06 report

## Project

Running Coach App, team 4.

Our problem-space sentence: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal). The bar for it is [the threshold of success](../../docs/threshold-of-success.md).

## Summary

`SPRINT-06` set out to make the product tell the team how it was used and why a run went wrong, without asking the runner. The records arrived. The backends the assignment asks for did not, and could not: the product holds no `INTERNET` permission, so there is nothing for a telemetry service to receive. [`ADR-005`](../../docs/architecture/adr/ADR-005.md) and [`ADR-006`](../../docs/architecture/adr/ADR-006.md) record that decision, and the four dashboards, the two pipelines, and the `deployed` test level are declared under [Deviations](#deviations).

**The focus metric.** [Weekly completed coached sessions](../../docs/analytics.md#weekly-completed-coached-sessions) is the focus metric, expressing [`VP-01`](../../docs/research/value-proposition.md#vp-01). It has no value yet, and it needs one thing: a person outside the team finishing a session. Every event the product has recorded so far is the team's own, tagged `source = smoke` or `source = usability-test`, and the metric excludes the first and labels the second rather than presenting test traffic as a value. The `Customer` still has not installed, so [`TOS-02`](../../docs/threshold-of-success.md#tos-02) stays missed and the metric stays empty.

**The metric computed by its query.** Of the five metrics on the page, [weekly completed coached sessions](../../docs/analytics.md#weekly-completed-coached-sessions) is the one computed by running its query rather than by hand; its section says so. [The spoken line delivery rate](../../docs/analytics.md#spoken-line-delivery-rate) has no value at all, because the `spoken_line_dropped` event it divides by needs the per-line record [`FR-014`](../../docs/functional-requirements/fr/FR-014.md) specifies and [issue #175](https://github.com/Running-Coach-App/running-coach-app/issues/175) has not landed. The event table says so rather than implying the event exists.

**`REL-06`** is tagged [`v0.4.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.4.0). Its [plan block](../../docs/project-plan.md#rel-06) records the tag and [`QR-05`](../../docs/quality-requirements/qr/QR-05.md), the one requirement whose test was checked this sprint.

**What moved out.** The sprint planned 27 points and completed none. Four stories, [`US-01`](https://github.com/Running-Coach-App/running-coach-app/issues/37), [`US-03`](https://github.com/Running-Coach-App/running-coach-app/issues/39), [`US-04`](https://github.com/Running-Coach-App/running-coach-app/issues/40), and [`US-10`](https://github.com/Running-Coach-App/running-coach-app/issues/141), were already carried from `SPRINT-05` unaccepted and are carried again, because the `Customer` has still not installed the product and nothing was shown to him. [`US-12`](https://github.com/Running-Coach-App/running-coach-app/issues/167) was built: its acceptance criteria pass on `main`, its task issues closed, and the events are recorded. It is still open, because [the definition of done](../../docs/definition-of-done.md#story) closes a story only on the customer's acceptance and the meeting presented nothing. [`US-13`](https://github.com/Running-Coach-App/running-coach-app/issues/168) was specified but not built: `FR-014`, `ADR-006`, and the sink exist, and the emission is [issue #175](https://github.com/Running-Coach-App/running-coach-app/issues/175) in `SPRINT-07`. [`#137`](https://github.com/Running-Coach-App/running-coach-app/issues/137), signing the release build, moves to `SPRINT-07` for the second time.

**The testing plan.** [The quality requirement testing plan](../../docs/project-plan.md#quality-requirement-testing-plan) carries each test's result and the sprint of its last check. The rows that are not `Passes` are there; this report does not copy them.

## Customer meeting

Held 2026-11-07, about 13 minutes. The full record is [the meeting report](meeting-report.md), with [the transcript](meeting-transcript.md) and [the script](meeting-script.md).

Nothing was presented. The installed product, the analytics plan, the observability plan, and the threshold proposal were not shown: the meeting stayed on the university virtual machine, on whether metrics must be collected at all, on GPS jamming, and on whether the `Customer` had installed. He had not. The script's last five questions, 15 to 19, were not reached, so all five Week 5 open questions are carried forward again.

| Story | Shown | Verdict | Decision |
| --- | --- | --- | --- |
| [`US-12`](https://github.com/Running-Coach-App/running-coach-app/issues/167) | Not shown | Unvalidated. The events are recorded and the criteria pass on `main`, but he saw none of it | None |
| [`US-13`](https://github.com/Running-Coach-App/running-coach-app/issues/168) | Not shown | Unvalidated, and not built: the per-line record is `SPRINT-07` work | None |
| [`US-01`](https://github.com/Running-Coach-App/running-coach-app/issues/37), [`US-03`](https://github.com/Running-Coach-App/running-coach-app/issues/39), [`US-04`](https://github.com/Running-Coach-App/running-coach-app/issues/40), [`US-10`](https://github.com/Running-Coach-App/running-coach-app/issues/141) | Not shown | Unvalidated for the second sprint: he has not installed | None |

Four decisions came out of the meeting, [`DEC-030`](../../docs/decisions.md#dec-030) to [`DEC-033`](../../docs/decisions.md#dec-033). Two of them reverse a position the team held, and [the meeting report's disagreements table](meeting-report.md#disagreements) records what we changed and why. Five action points are due 2026-11-14, one of them the `Customer`'s own install.

## Threshold review

One goal is `Open` as the review starts. [`TOS-01`](../../docs/threshold-of-success.md#tos-01) was settled `Met` in Week 3 and [`TOS-02`](../../docs/threshold-of-success.md#tos-02) was settled `Missed` in Week 6 planning; neither is reviewed again here, and their outcomes stay in [`docs/threshold-of-success.md`](../../docs/threshold-of-success.md).

| Goal | Current measure | Can the new data settle it? | Proposal |
| --- | --- | --- | --- |
| [`TOS-03`](../../docs/threshold-of-success.md#tos-03) | One session on a physical Android phone, cited from the Week 9 report, whose answer was produced on the device, by 2026-11-27 | Partly. The analytics data can show that the question was asked and answered on the phone, from [`question_asked` and `question_answered`](../../docs/analytics.md#the-events) and the `topic` and `answered` fields they carry. It cannot show that the answer was computed on the device rather than fetched: that is settled by the product holding no `INTERNET` permission, not by a metric. The observability data cannot settle it at all | None |

[`TOS-03`](../../docs/threshold-of-success.md#tos-03) stays `Open`. Its date is 2026-11-27, three sprints away, and its measure is a session on a real phone that nobody has run yet. The analytics added this week make the first half of that measure cheaper to evidence, because the two question events now record that a question was asked and whether it was answered, so the Week 9 report can cite records rather than a recollection. The second half of the measure, that no server was involved, is answered by the manifest and by [`DEC-004`](../../docs/decisions.md#dec-004), and no metric would strengthen it.

The team proposed no change, for two reasons. The goal's measure is already the thing the team wants to be true, and replacing a real session on a real phone with a count of events would make the bar easier to clear without making the product better. And the one goal whose measure has gone stale, `TOS-02`, is not `Open`: it was set to `Missed` before this review began, so moving it would be rewriting a settled outcome rather than reviewing a goal. Whether `TOS-02` should be set again with a new date is instead [an open question for the next meeting](meeting-report.md#open-questions), since only the `Customer`'s `DEC-nnn` can move a bar.

The `Customer` gave no decision on the proposal, because there was no proposal to give one on and the meeting did not reach the threshold question. Script question 14 asked it and was not put; the meeting report records that.

## Dashboards and the observability test

There are no dashboard screenshots. `reports/week-06/images/` does not exist, and the four images the assignment names are not in this report, because the two backends they would be served from are not deployed and will not be: the product has no `INTERNET` permission, so it can reach no collector. [`ADR-005`](../../docs/architecture/adr/ADR-005.md) and [`ADR-006`](../../docs/architecture/adr/ADR-006.md) carry that reasoning and the options rejected with it, and [the container view](../../docs/architecture/README.md#container-view) shows both backends as external systems the team self-hosts and does not build, with no arrow from the product to either.

What exists in their place is the data the dashboards would read, on the phone, in the app's own private storage, one record per line of JSON, exported as a file when a runner chooses to.

The observability test is [`QR-05 QRT-01`](../../docs/quality-requirements/qr/QR-05.md#qrt-01), and its result is [`qr-05-qrt-01.md`](qr-05-qrt-01.md): `Passes`, checked 2026-11-07 at the `scripted` level rather than `deployed`. It names [`SLI-01`](../../docs/observability.md#sli-01), spoken line latency, and reads one failed line back from the record the production sink wrote:

```json
{"occurred_at":1700,"session_id":"session-1","source":"smoke","line_id":"line-failed-1","line_kind":"stats","outcome":"dropped_unavailable","latency_ms":2400}
```

The assignment asks for the request identifier, the route, and the failure labels the test recorded. This product serves no requests and has no routes, which [`docs/observability.md`](../../docs/observability.md#the-unit-of-work) says in its first section: the unit of work is a spoken line. The three labels map onto it as `line_id`, the identifier of the line the test read back; `line_kind`, `stats`, which is the route equivalent, the kind of line that fell due; and `outcome`, `dropped_unavailable`, the failure label, with `latency_ms` carrying the delay up to the moment the line was abandoned. No field in the record identifies the runner.

## Coverage

| Deliverable | Artifact |
| --- | --- |
| Sprint plan and new stories | [docs/project-plan.md#sprint-06](../../docs/project-plan.md#sprint-06), with the goal, the due date, the sprint backlog, and both velocities, and the two internal stories [`US-12`](https://github.com/Running-Coach-App/running-coach-app/issues/167) and [`US-13`](https://github.com/Running-Coach-App/running-coach-app/issues/168) in [the `SPRINT-06` milestone](https://github.com/Running-Coach-App/running-coach-app/milestone/4) |
| Analytics plan | [docs/analytics.md](../../docs/analytics.md), with the metric tree, the seven criteria, the rejected vanity metric, and a section per metric |
| Events and instrumentation | [docs/analytics.md#the-events](../../docs/analytics.md#the-events), and the code in [`Telemetry.kt`](https://github.com/Running-Coach-App/running-coach-app/blob/main/app/src/main/java/app/runningcoach/Telemetry.kt), [`TelemetryFiles.kt`](https://github.com/Running-Coach-App/running-coach-app/blob/main/app/src/main/java/app/runningcoach/TelemetryFiles.kt), and [`SessionEngine.kt`](https://github.com/Running-Coach-App/running-coach-app/blob/main/app/src/main/java/app/runningcoach/SessionEngine.kt) |
| Analytics dashboards | None. No analytics backend is deployed, and none will be: see [Dashboards and the observability test](#dashboards-and-the-observability-test) and [`ADR-005`](../../docs/architecture/adr/ADR-005.md). Declared under [Deviations](#deviations) |
| Observability plan and `SLI`s | [docs/observability.md](../../docs/observability.md), with the signals, [`SLI-01`](../../docs/observability.md#sli-01) `Active`, and [`SLI-02`](../../docs/observability.md#sli-02) `Planned` |
| Observability dashboards | None, for the same reason and with the same declaration: see [`ADR-006`](../../docs/architecture/adr/ADR-006.md) |
| Feature documentation | [docs/features.md](../../docs/features.md), with an entry for each internal capability and no dashboard address |
| Functional requirements | [docs/functional-requirements/README.md](../../docs/functional-requirements/README.md), with [`FR-013`](../../docs/functional-requirements/fr/FR-013.md) and [`FR-014`](../../docs/functional-requirements/fr/FR-014.md) |
| ADRs and container view | [the architectural decisions index](../../docs/architecture/README.md#architectural-decisions), with [`ADR-005`](../../docs/architecture/adr/ADR-005.md) and [`ADR-006`](../../docs/architecture/adr/ADR-006.md), and [docs/architecture/README.md#container-view](../../docs/architecture/README.md#container-view) |
| Observability requirement | [`QR-05`](../../docs/quality-requirements/qr/QR-05.md), `Maintainability` / `Analysability`, `High` business importance, with [`QRT-01`](../../docs/quality-requirements/qr/QR-05.md#qrt-01) |
| Runtime test re-run | None. No runtime test was re-run: [`QR-03`](../../docs/quality-requirements/qr/QR-03.md) and [`QR-04`](../../docs/quality-requirements/qr/QR-04.md) have no implemented test, and the optional re-run the assignment offers needs one that names the same `Active` `SLI`. [docs/project-plan.md#quality-requirement-testing-plan](../../docs/project-plan.md#quality-requirement-testing-plan) carries every row |
| Threshold review | [reports/week-06/README.md#threshold-review](#threshold-review) |
| Week 5 action points | [`## Previous action points`](meeting-report.md#previous-action-points) |
| Week 5 open questions | [`## Previous open questions`](meeting-report.md#previous-open-questions) |
| Meeting script | [reports/week-06/meeting-script.md](meeting-script.md) |
| Meeting transcript | [reports/week-06/meeting-transcript.md](meeting-transcript.md). The `Customer` ran the recording and permitted publication; this is the sanitized transcript taken from it |
| Customer validation | [reports/week-06/meeting-report.md](meeting-report.md). No threshold decision was taken, so there is no `DEC-nnn` for one; the four decisions the meeting did produce are [`DEC-030`](../../docs/decisions.md#dec-030) to [`DEC-033`](../../docs/decisions.md#dec-033) |
| `REL-06` | the tag [`v0.4.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.4.0) and its release body, [the changelog's released section](https://github.com/Running-Coach-App/running-coach-app/blob/main/CHANGELOG.md#040---2026-11-08), and [the plan's `REL-06` block](../../docs/project-plan.md#rel-06) with `Released` and `Checked QRs` |
| Sprint retrospective | [reports/week-06/sprint-retrospective.md](sprint-retrospective.md) |
| AI usage | [reports/week-06/ai-usage.md](ai-usage.md) |

## What changed

The product gained a record of what it did. A session now writes an event when it starts, when each stats line and each effort cue is spoken, when a question is asked and answered, when the location fix is lost and regained, when it stops, and when the after-run summary is spoken. Each event is one line of JSON in the app's own private storage, carries a random session identifier, and carries nothing the runner said. A unit test asserts that last part by checking the recorded fields contain no word from the question.

The repository gained the two plans the records are read with, the event table they are written from, two functional requirements, two architectural decision records, a diagnosability requirement with a test, and the two telemetry backends drawn on the container view as systems the product does not reach.

The product gained no new spoken behaviour, and the run-screen rework the Week 5 meeting asked for is still not in it.

## Contribution

| Member | Work |
| --- | --- |
| @sirjaey | Authored the sprint plan and its velocities, the two internal stories and their task issues, the analytics plan with the metric tree and the event table, the observability plan and the two `SLI`s, the instrumentation and its unit tests, `FR-013`, `REL-06`, and this report; marked `TOS-02` missed, wrote the threshold review, and closed the sprint with its actual velocity and the retrospective |
| @ObeTech1 | Wrote `QR-05` and its `QRT-01`, ran the test and recorded its result with evidence; reviewed the week's pull requests. [`#184`](https://github.com/Running-Coach-App/running-coach-app/issues/184), closing the sprint, was assigned to him and he could not take it before the deadline, so @sirjaey wrote it |
| @Ezekiel-Gadzama | Ran the customer meeting and wrote its report, transcript, and four decisions; wrote `ADR-005` and `ADR-006` and updated the container view; wrote the two feature entries and the week's glossary terms; reviewed the week's pull requests |

## Repository evidence

[`#176`](https://github.com/Running-Coach-App/running-coach-app/pull/176) merged and closed its task issue [`#174`](https://github.com/Running-Coach-App/running-coach-app/issues/174), instrumenting the core task and adding `FR-013`.

The runs on [`b9fddc9`](https://github.com/Running-Coach-App/running-coach-app/commit/b9fddc9), the commit [`v0.4.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.4.0) is tagged on and the one the attached APK was built from, all green:

| Check | Run |
| --- | --- |
| Link check | [run 42479631796](https://github.com/Running-Coach-App/running-coach-app/actions/runs/42479631796) |
| Markdown check | [run 42479631850](https://github.com/Running-Coach-App/running-coach-app/actions/runs/42479631850) |
| Workflow lint | [run 42479631783](https://github.com/Running-Coach-App/running-coach-app/actions/runs/42479631783) |
| Android build | [run 42479631891](https://github.com/Running-Coach-App/running-coach-app/actions/runs/42479631891) |
| Pages | [run 42479631971](https://github.com/Running-Coach-App/running-coach-app/actions/runs/42479631971) |

## Deviations

1. **There is no analytics backend, no observability backend, and no dashboard.**
   The assignment asks for two self-hosted backends on the university network, each with a staging and a production environment scope, and four dashboards. The product is an Android application with no `INTERNET` permission, so it can send nothing to a collector, and a backend with no producer would be a screenshot of an empty chart. [`ADR-005`](../../docs/architecture/adr/ADR-005.md) and [`ADR-006`](../../docs/architecture/adr/ADR-006.md) record the decision and the options rejected with it. The queries the dashboards would run are written out in [`docs/analytics.md`](../../docs/analytics.md) and [`docs/observability.md`](../../docs/observability.md) against the exported file instead.
2. **The university VM was not obtained, so nothing is deployed.**
   Staging and production do not exist, which is also why no test runs at `deployed`. [`DEC-033`](../../docs/decisions.md#dec-033) records that the `Customer` does not require the product to be hosted on the VM, and an installable build from GitHub is enough. [`docs/deployment.md`](../../docs/deployment.md) stays the runbook for when a VM arrives, and it does not carry the two telemetry pipelines' steps and configuration, because there are no pipelines to describe.
3. **`QR-05 QRT-01` falls back from `deployed` to `scripted`.**
   The assignment wants the test to fail a staging request and read the request's log point and the `SLI`'s P95 series from the staging organization with `$OPENOBSERVE_URL`. There is no staging deployment and no OpenObserve. The test instead writes one failed line through the production `FileTelemetrySink` and reads it back by `line_id`, which exercises the sink and the record shape but not a live session. [`QR-05`](../../docs/quality-requirements/qr/QR-05.md) declares this in its scenario and its `QRT-01`.
4. **`SLI-01` is `Active` but the product does not yet emit its points.**
   The sink that writes a per-line record exists and the record's shape is specified by [`FR-014`](../../docs/functional-requirements/fr/FR-014.md), but nothing in `CoachService` calls it: no spoken line produces a point during a real session. [Issue #175](https://github.com/Running-Coach-App/running-coach-app/issues/175) carries that work into `SPRINT-07`. `SLI-01` stays `Active` because it is the `SLI` the week's test reads, and [`docs/observability.md`](../../docs/observability.md#the-slis) now says the emission is outstanding rather than claiming the product already writes it.
5. **No story completed: the actual velocity is 0 of 27 planned points.**
   Nothing was presented at the meeting, so no story could be accepted, and [the definition of done](../../docs/definition-of-done.md#story) closes a story only on the customer's acceptance. [`US-12`](https://github.com/Running-Coach-App/running-coach-app/issues/167) is the uncomfortable case: it was built, its criteria pass on `main`, and its user is a product analyst on this team rather than the `Customer`, so there is nobody outside the team whose acceptance the rule can mean. The team read the rule as written and recorded zero rather than inventing an acceptance. That the definition of done has no provision for a story whose user is internal is a gap in the rule, and [the retrospective](sprint-retrospective.md#what-did-not) records it as the root cause rather than as a story that failed.
6. **This is the second sprint in a row with an actual velocity of zero.**
   `SPRINT-04` also recorded 0, for the same root cause: the `Customer` has not installed the product. Four stories have now been carried unaccepted through two sprints. The planned velocity of 27 points was not a forecast the team could meet, because 19 of those points depended on somebody else installing an APK.
7. **`US-13` was specified but not built.**
   `FR-014`, `ADR-006`, and the sink are in; the emission is not. The story stays open and [issue #175](https://github.com/Running-Coach-App/running-coach-app/issues/175) is scheduled in `SPRINT-07`. The assignment's story-per-internal-user requirement is met by the record; its acceptance criteria are not.
8. **`[Unreleased]` was not kept current through the sprint.**
   [The definition of done](../../docs/definition-of-done.md#pull-request) requires a user-visible change to update `[Unreleased]`, and none of the week's seven pull requests did. The section was filled and moved into `[0.4.0]` in one step when the release was cut, so the changelog is right and the habit that produces it is not. [The retrospective](sprint-retrospective.md#actions) does not carry an action for it: three of its four actions are carried from `SPRINT-05` unchanged, and it names this as one of the two problems it hands to `SPRINT-07` instead.
9. **Part 8's work reached a dead branch and had to be re-landed.**
   [`#182`](https://github.com/Running-Coach-App/running-coach-app/pull/182) was opened against `178-record-the-telemetry-adrs` rather than `main`, and [`#181`](https://github.com/Running-Coach-App/running-coach-app/pull/181) merged that branch into `main` before #182 landed on it, so the two feature entries and the five glossary terms were merged into a branch nobody merges again. [`#186`](https://github.com/Running-Coach-App/running-coach-app/pull/186) carries the same commit onto `main` unchanged. Nothing was lost and no work was redone, but `main` was missing a deliverable for several hours while every check on it was green.
10. **The meeting did not follow the Week 6 agenda.**
    Nothing was shown, and the script's questions 15 to 19 were not reached in about 13 minutes, so all five Week 5 open questions and the threshold question are carried forward. [The meeting report](meeting-report.md) carries the detail.
11. **No story has ever been validated on the `Customer`'s phone.**
    He has not installed the product in the two weeks since a signed-for-install APK was attached to [`v0.3.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.3.0). This is the cause of deviations 5, 6, and 10, and the reason the focus metric has no value.

## Privacy

No private-only material was committed to this repository.
