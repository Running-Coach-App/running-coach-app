# Week 07 report

## Project

Running Coach App, team 4.

Our problem-space sentence: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal). The bar for it is [the threshold of success](../../docs/threshold-of-success.md).

## Summary

`SPRINT-07` set out to make the product something a stranger could be handed, with a written way to learn what happened to them. **The test is designed and the recruitment is planned. No session has run, and this report claims no usability result.** The results, the findings, the triage, and the [`QR-09`](../../docs/quality-requirements/qr/QR-09.md) verdict are due with Submission 8 on 2026-11-21.

**The test.** [`UT-01`](../../docs/usability-tests/ut-01/README.md) asks whether a runner who has never seen the product can start a coached session, hear it through, and end it without being shown how and without taking the phone back out of a pocket. Three usability test tasks, the same for every participant in a fixed order: the coached session with the phone away as the main task, then finding what the coach said on that run, then making the coach speak more slowly. The record carries the research questions, the tasks and their success criteria, the help rule, the protocol, the measures, the instrumentation, the analysis plan written before any data exists, the schedule, the roles, the environment, the consent and data map, and the evidence map.

**The recruitment target and the participant profile.** At least **three** completed sessions, with **five** as the design target. Every participant is 18 or older, runs or walks briskly for exercise at least occasionally, takes a phone along when they do, has used some phone app while exercising, and is not a teammate, the `Customer`, an instructor, or course staff. [The profile](../../docs/usability-tests/ut-01/README.md#participant-profile) states the criteria in observable terms so a reviewer can judge whether a counted session matched it. The team recruits from classmates outside team 4 and runners at the university's sports facilities, in person and through the course's channels.

**The quality requirement.** [`QR-09`](../../docs/quality-requirements/qr/QR-09.md) is `Interaction Capability` / `Learnability`, `High` business importance and `Medium` technical risk. Its measure is the main task's completion and assistance, read as the proportion of counted participants who finished it `Unaided`, against a bar of **0.6** — 2 of 3 at the minimum, 3 of 5 at the design target. The bar was set before any session and the requirement says in writing that it is not changed after the data. Its [`QRT-01`](../../docs/quality-requirements/qr/QR-09.md#qrt-01) is `manual`, names `UT-01` in its `**Runs at:**`, and carries its `**Why Manual:**`: help is something one person gives another, and only the observer in the room sees whether it happened.

**The private repository and the recordings folder.** The raw material goes to a private `Running-Coach-App/running-coach-app-usability-data` repository — text only: the consent records, the identity mapping, the raw notes, the working analysis, and each session's exported telemetry file — and the recordings go to a team-owned cloud folder. Both have the team and the course instructors as readers. Both are **outstanding at the time of writing**: they are created in `SPRINT-07`, and [Deviations](#deviations) carries that until they exist. The public record links the private repository, and `.lycheeignore` excludes that link with the reason beside it, because it needs authentication. Neither private link appears in any public file; both go to the Moodle wrapper.

**The instrumentation, and what was verified.** The test adds no event. It reuses the Week 6 events — `session_started`, `stats_spoken`, `effort_cue_spoken`, `location_fix_lost`, `location_fix_regained`, `session_stopped`, and `session_summary_spoken` — tagged `source = usability-test`, and adds one field, `participant_code`, which carries the session's `P-nn` code and is now on every row of [the events table](../../docs/analytics.md#the-events). The store is the phone's own file sink, exported over a cable after the session, because the product has no network permission and there is no pipeline to send anything to. **Verified so far: nothing.** The instrumentation is designed and not yet implemented; the implementation is scheduled in `SPRINT-07` and its verification in `SPRINT-08`, before the first counted session, and no session is counted until the verification has confirmed that a run's events reach the file sink, that the export filters to one `P-nn`, and that `source` reads `usability-test` on every record.

**The session plan.** The team has not fixed the dates. The sessions are planned for `SPRINT-08`, between 16 and 19 November, about 40 minutes each, outdoors on or beside campus in late-afternoon daylight, booked one at a time as participants agree. A session may run as soon as the design is merged and the instrumentation is verified, including before the Week 7 deadline; none is arranged in `SPRINT-07` as this is written.

**The design review's transcript.** At the close. The three permission questions are asked at the start of the meeting and are never carried over from an earlier one, so whether the transcript is published in this repository, shared privately with the instructors, or does not exist is answered there and recorded in [the meeting report](meeting-report.md) and [the transcript file](meeting-transcript.md). In Week 6 the `Customer` ran the recording himself and permitted publication.

**`REL-07`** is tagged `v0.5.0` at the sprint's end, on the state after the review and any same-week rework. Its [plan block](../../docs/project-plan.md#rel-07) records the tag and the requirements the sprint checked: [`QR-06`](../../docs/quality-requirements/qr/QR-06.md) and [`QR-08`](../../docs/quality-requirements/qr/QR-08.md).

**The testing plan.** [The quality requirement testing plan](../../docs/project-plan.md#quality-requirement-testing-plan) carries each test's result, its last check, its planned sprint, and its evidence. The rows that are not `Passes` are there; this report does not copy them.

## Customer meeting

At the close. The full record is [the meeting report](meeting-report.md), with [the transcript](meeting-transcript.md) and [the script](meeting-script.md).

The meeting is the sprint's Sprint Review, and what it has to settle is whether the `UT-01` design will answer the `Customer`'s questions, whether the participant profile, the recruitment target, and the session plan are right, what the results must show, and the Week 8 execution plan. The script also closes out the action point this sprint inherited twice — the Play Store research and the scanner — and puts all six open questions carried from Week 6 before the close rather than last, which is where the previous two meetings ran out of time.

## Usability test

### The design

[`UT-01`](../../docs/usability-tests/ut-01/README.md), `Planned`, designed in [`SPRINT-07`](../../docs/project-plan.md#sprint-07) and run in [`SPRINT-08`](../../docs/project-plan.md#sprint-08). It is found from [the usability tests index](../../docs/usability-tests/README.md), from this report, from [the testing plan](../../docs/project-plan.md#quality-requirement-testing-plan), and from [the quality requirements index](../../docs/quality-requirements/README.md) — the same path and the same identifier in each.

Its three research questions: whether a first-time runner works out how to start a coached session without being told; at which point they take the phone back out of the pocket and what they are looking for; and whether they recognise from sound alone that the session is running and then that it has ended.

### The recruitment target and the participant profile

Three counted sessions minimum, five as the design target, every participant 18 or older and matching [the profile](../../docs/usability-tests/ut-01/README.md#participant-profile). Codes are `P-01` onward, assigned as sessions are arranged and never reused; a withdrawn, unconsented, or broken session is not counted, its code is retired, and a replacement is recruited under the next free code. Exact participants and dates are not due this week.

### The tasks

| Task | Scenario, in one line | Limit |
| --- | --- | --- |
| Main | Be coached out loud through a short run with the phone in a pocket, and finish the session | 12 minutes |
| Secondary 1 | Find out what the coach said on that run, and how far it went | 3 minutes |
| Secondary 2 | Make the coach speak more slowly on the next run | 3 minutes |

Each is `Unaided`, `Assisted`, or `Failed` against an end state written before the first session, with [a help rule](../../docs/usability-tests/ut-01/README.md#the-help-rule) that names what counts as help and requires the facilitator to say "hint" aloud onto the recording when one is given. No task names a button, a label, a screen, or a number of steps. Asking the coach a question aloud is deliberately not a task, because the question input is still a typed box and [the record says why](../../docs/usability-tests/ut-01/README.md#why-asking-the-coach-a-question-aloud-is-not-a-task).

### The surveys

[`surveys.md`](../../docs/usability-tests/ut-01/surveys.md): a pre-test carrying the 18-or-older declaration and no identifying field, the standard SEQ after each of the three tasks on its seven-point scale, the full ten standard SUS items in their standard order and wording after all three, and a six-question open-ended post-test. The SUS score is `2.5 × (20 + sum(odd) - sum(even))`, computed from the answers as recorded, and the page works the formula through three cases so the arithmetic can be checked. The results report the SUS mean and median with `n=<count>`.

### The instrumentation and its verification

[The record's `## Instrumentation` section](../../docs/usability-tests/ut-01/README.md#instrumentation) says what the test must observe, which Week 6 events it reuses, the one field it adds, how a session's records are told from another's, where the data goes, and what it cannot cover — the two secondary tasks, which emit no event; where the phone was, which only the observer sees; and whether the participant actually heard anything.

A session is identified by its `P-nn` code, with the session's time window as a cross-check. The code may appear in usability-test telemetry and is the documented exception to the opaque-identifier rule; the mapping from a code to a person is in the private repository and never here. Every metric on [the analytics page](../../docs/analytics.md) now excludes `source = usability-test` as well as `source = smoke`, so no facilitated session is ever presented as a value of a product metric.

Implementation is scheduled in `SPRINT-07`, verification in `SPRINT-08` before the first counted session, and the dry run counts as the verification only if it runs after the implementation and before that session. **Nothing has been verified yet**, and the record says so in those words.

### The consent and the private repository

[`consent.md`](../../docs/usability-tests/ut-01/consent.md) is the public template, with the same clauses the participants sign and the placeholders unfilled: the 18-or-older declaration, participation, the recording, the sanitized public results, the optional anonymized quote, the private repository and the recordings folder, the instructors' access, the tools used and the deletion of their copies, the right to withdraw, and deletion after grading. Consent to the recording and to the sanitized public results is required for a session to count; the quote clause is separate and optional, and a participant who declines it still counts.

The private repository is `Running-Coach-App/running-coach-app-usability-data`, private, text only, with the team and the instructors as readers. **It and the recordings folder are outstanding at the time of writing** — see [Deviations](#deviations).

### The link-check exclusion and its reason

The private repository's link is excluded in [`.lycheeignore`](https://github.com/Running-Coach-App/running-coach-app/blob/main/.lycheeignore), with the reason recorded beside the exclusion: the repository is private by requirement, so an anonymous request returns 404 and the link cannot be checked mechanically. It is checked by hand instead, by a member opening it signed in, and this report records the date of that check once the repository exists. It is the only new exclusion this sprint.

### The recordings folder

A team-owned cloud folder, shared with the course instructors, holding one audio recording per counted session under its `P-nn` code. It is never in this repository and never in the private text repository. Its link and its access instructions are in the Moodle wrapper and in the private repository, and in no public file, because the link is an access grant.

### The quality requirement and its test

[`QR-09`](../../docs/quality-requirements/qr/QR-09.md) and its [`QRT-01`](../../docs/quality-requirements/qr/QR-09.md#qrt-01), as described in the summary. Its row in [the testing plan](../../docs/project-plan.md#quality-requirement-testing-plan) is `Not verified`, `Checked: None`, planned for [`SPRINT-08`](../../docs/project-plan.md#sprint-08), `Evidence: None`. The verdict is recorded there with the results, even if the sessions run early.

`QR-09` sits beside [`QR-03`](../../docs/quality-requirements/qr/QR-03.md) rather than replacing it: `QR-03` is `Operability` and asks whether the session is reachable without the screen; `QR-09` is `Learnability` and asks whether a stranger discovers how. Both files say so, so a reader does not take the pair for a duplication.

### The Week 8 handoff

What `SPRINT-08` starts from, all of it in place except where this says otherwise:

| Handed off | State |
| --- | --- |
| The test design a stranger could run | [Done](../../docs/usability-tests/ut-01/README.md) |
| The recruitment target and the participant profile | Done: three minimum, five target, [profile](../../docs/usability-tests/ut-01/README.md#participant-profile) in observable terms |
| The team's plan for arranging the sessions | Done: [`## Schedule`](../../docs/usability-tests/ut-01/README.md#schedule). Dates not fixed, and not due this week |
| The surveys, the consent template, the session instructions and observation sheet | [Done](../../docs/usability-tests/ut-01/sessions/README.md) |
| The private repository and the recordings folder | **Outstanding.** Created in `SPRINT-07`; declared under [Deviations](#deviations) until they are |
| The instrumentation | Designed, **not implemented**. Implementation in `SPRINT-07`, verification in `SPRINT-08` before the first counted session |
| The `results.md` stub, the findings template, the triage plan | [Done](../../docs/usability-tests/ut-01/results.md) |
| The `QR/QRT` row | Done: `Not verified`, planned for `SPRINT-08` |
| The dry run | **Not run.** Scheduled before the first counted session |
| A usability result | **None, and none is claimed.** Due with Submission 8 |

## Coverage

| Deliverable | Artifact |
| --- | --- |
| Sprint plan | [docs/project-plan.md#sprint-07](../../docs/project-plan.md#sprint-07), with the goal, the due date of 2026-11-15, the sprint backlog, and the planned velocity; and [#sprint-08](../../docs/project-plan.md#sprint-08) with its provisional goal, its due date of 2026-11-21, and its backlog |
| `UT-01` test record | [docs/usability-tests/ut-01/README.md](../../docs/usability-tests/ut-01/README.md), found from [the index](../../docs/usability-tests/README.md) |
| Surveys and post-test | [docs/usability-tests/ut-01/surveys.md](../../docs/usability-tests/ut-01/surveys.md) |
| Tasks and protocol | [docs/usability-tests/ut-01/README.md#the-tasks](../../docs/usability-tests/ut-01/README.md#the-tasks) and [docs/usability-tests/ut-01/sessions/README.md](../../docs/usability-tests/ut-01/sessions/README.md) |
| Test instrumentation | [docs/usability-tests/ut-01/README.md#instrumentation](../../docs/usability-tests/ut-01/README.md#instrumentation) and [docs/analytics.md#the-events](../../docs/analytics.md#the-events), where `participant_code` is now a field on every event row |
| Consent template | [docs/usability-tests/ut-01/consent.md](../../docs/usability-tests/ut-01/consent.md) |
| Private usability-data repository | the private `Running-Coach-App/running-coach-app-usability-data` repository, linked from [the record](../../docs/usability-tests/ut-01/README.md#consent-and-data) and this report and excluded from the link check with its reason. **Outstanding**: see [Deviations](#deviations) |
| Recordings folder | the team's cloud folder, linked in the Moodle submission. **Outstanding**: see [Deviations](#deviations) |
| `QR-09` and its test | [`QR-09`](../../docs/quality-requirements/qr/QR-09.md), `Interaction Capability` / `Learnability`, `High` business importance, with its `manual` [`QRT-01`](../../docs/quality-requirements/qr/QR-09.md#qrt-01), and its row in [the quality requirements index](../../docs/quality-requirements/README.md) |
| Recruitment target and session plan | [docs/usability-tests/ut-01/README.md#participant-profile](../../docs/usability-tests/ut-01/README.md#participant-profile) and [#schedule](../../docs/usability-tests/ut-01/README.md#schedule) |
| Week 8 handoff | [reports/week-07/README.md#the-week-8-handoff](#the-week-8-handoff) |
| Glossary | [docs/glossary.md](../../docs/glossary.md), with `usability test`, `participant`, `usability session`, `consent`, `recording`, `SUS`, and `SEQ`, and `measure`, `metric`, and `statistic` kept apart in a section of their own |
| Risk register | [docs/risks.md](../../docs/risks.md), with [`RISK-04`](../../docs/risks.md#risk-04) recruitment, [`RISK-05`](../../docs/risks.md#risk-05) consent, [`RISK-06`](../../docs/risks.md#risk-06) data access, and [`RISK-07`](../../docs/risks.md#risk-07) schedule, each `Open` and each with the fallback as its `**Contingency:**` |
| Week 6 action points | [`## Previous action points`](meeting-report.md#previous-action-points) |
| Week 6 open questions | [`## Previous open questions`](meeting-report.md#previous-open-questions) |
| Sprint Review | [reports/week-07/meeting-report.md](meeting-report.md) |
| Meeting script | [reports/week-07/meeting-script.md](meeting-script.md) |
| Meeting transcript | [reports/week-07/meeting-transcript.md](meeting-transcript.md), or the one line in it saying why there is none |
| `REL-07` | the tag `v0.5.0` and its release body, [CHANGELOG.md](https://github.com/Running-Coach-App/running-coach-app/blob/main/CHANGELOG.md), and [docs/project-plan.md#rel-07](../../docs/project-plan.md#rel-07) with `Released` and `Checked QRs` |
| Sprint retrospective | [reports/week-07/sprint-retrospective.md](sprint-retrospective.md) |
| AI usage | [reports/week-07/ai-usage.md](ai-usage.md) |

## What changed

The repository gained a usability test that somebody outside this team could run from the record alone: the goal, three research questions, three tasks with their end states and time limits, a help rule precise enough to make `Unaided` and `Assisted` mean the same thing in every session, the standard SEQ and SUS instruments, a facilitation script, an observation sheet, a consent template, an analysis plan fixed before any data exists, and a results stub with its findings template and triage plan.

It gained [`QR-09`](../../docs/quality-requirements/qr/QR-09.md), the first requirement whose test is a person rather than a command, and the first whose bar was written down before the measurement existed.

It gained four risks with their fallbacks, ten glossary terms that keep a measure, a statistic, and a metric apart, and a `participant_code` field on the event table.

It gained a `Docs` workflow that runs `mkdocs build --strict` on pull requests, closing an action carried since `SPRINT-05`. That check immediately matters: two links written this sprint left `docs_dir`, which the link checker passes and the strict build rejects, and they were caught by hand because the workflow did not exist yet.

The product gained no new spoken behaviour this sprint. The run-screen rework the Week 5 meeting asked for, and the metrics opt-out from Week 6, are stated at the close either way in [the meeting report](meeting-report.md).

## Contribution

| Member | Work |
| --- | --- |
| @sirjaey | Authored [the Play Store research](../../docs/research/play-store-quality.md), `scripts/scan.sh`, the `Security scan` workflow and its negative test, the dependency lock, [`QR-06`](../../docs/quality-requirements/qr/QR-06.md) with `StabilitySoakTest`, [`QR-07`](../../docs/quality-requirements/qr/QR-07.md), and [`QR-08`](../../docs/quality-requirements/qr/QR-08.md); designed `UT-01` — the record, the tasks, the surveys, the consent, the session instructions, the results stub — and wrote [`QR-09`](../../docs/quality-requirements/qr/QR-09.md), the four risks, the glossary terms, the `SPRINT-07` and `SPRINT-08` plan blocks, the `Docs` workflow, this report, and the meeting script |
| @Ezekiel-Gadzama | At the close |
| @ObeTech1 | At the close |

The rows for @Ezekiel-Gadzama and @ObeTech1 are filled at the sprint's close from what each of them landed, in their own names. The `UT-01` roles — facilitator, observer, and keeper of the recordings — are written in [the record](../../docs/usability-tests/ut-01/README.md#roles) as a proposal for the team to confirm, not as an assignment made on their behalf.

## Repository evidence

At the close. This section carries one merged pull request that closed its task issue, and the latest green link-check, Markdown-check, `actionlint`, product-code, `Security scan`, and `Docs` runs on `main`, all on the commit `REL-07` is tagged on.

Before this week's pull request was opened, the following were run by hand against the working tree: the Markdown check, the link-and-anchor check, `mkdocs build --strict`, the product's unit suite, and `./scripts/scan.sh` against both a clean checkout and a deliberately broken manifest.

## Deviations

1. **There is no staging deployment and no production instance on the university network, so the sessions do not run on one.**
   The assignment's `UT-01` environment is a staging deployment reached over the university network, with seeded data and a payment sandbox. This product is an Android application that runs entirely on the phone and holds no `INTERNET` permission, and [`DEC-033`](../../docs/decisions.md#dec-033) records the `Customer` agreeing that an installable build from GitHub is enough and that the university virtual machine is not required for it. The sessions therefore run in person and on foot: a debug build on the team's phone, outdoors on or beside campus. The sessions are in person as required; they are not on the university network, because nothing in the product uses a network.
2. **The seed is the app's data cleared, because there is no data to seed.**
   There is no database and no synthetic fixture. Clearing the app's data before each session is the only reset available, and it is also the right one: it is what makes the first-use reading in research question 1 real. [The record](../../docs/usability-tests/ut-01/README.md#environment) says so.
3. **No payment is made because the product takes none.**
   There is nothing to put in a sandbox. The requirement that no real payment is made is met by the product having no payment at all.
4. **No test event goes through an analytics pipeline, because there is no pipeline.**
   The requirement that a pipeline event carries `source = usability-test` and that every metric excludes it is met in the only form available here: the events are written to the phone's own file sink with `source = usability-test` and the session's `participant_code`, exported by cable, and [every metric on the analytics page](../../docs/analytics.md) excludes that source. [`ADR-005`](../../docs/architecture/adr/ADR-005.md) and [`ADR-006`](../../docs/architecture/adr/ADR-006.md) carry the decision this follows from, and it is the same deviation `SPRINT-06` declared for the backends and dashboards.
5. **The private usability-data repository and the recordings folder are not yet created.**
   Both are required this week and both are `SPRINT-07` work the sprint has not finished at the time of writing. The design that depends on them is complete — the consent, the data map, the evidence map, the retention rule, and the link-check exclusion all name them — and nothing of either exists to be filed yet, because no session has run. This report records the date each is created and the date a member other than the owner confirmed the instructors can open both. If an instructor cannot use GitHub, the private text goes through a Moodle-only archive and that becomes a further deviation, which is [`RISK-06`](../../docs/risks.md#risk-06)'s contingency.
6. **The instrumentation is designed and not implemented, so nothing has been verified.**
   The assignment schedules the implementation in `SPRINT-07`, which the sprint has not completed, and allows the verification in `SPRINT-08` provided it precedes the first counted session, which is where it is scheduled. No session is counted before the verification, and [the record](../../docs/usability-tests/ut-01/README.md#the-verification-before-the-first-counted-session) says `Verified: not yet` rather than describing a check that has not happened. [The retrospective](sprint-retrospective.md#what-did-not) records the consequence: the one thing that gates every session is in the same sprint as the sessions.
7. **The dry run has not been run.**
   It is scheduled before the first counted session. It is not evidence and is not counted, and it is the verification only if it runs after the implementation and before the first counted session.
8. **`QR-07 QRT-01` moved from `SPRINT-07` to `SPRINT-08`.**
   It was planned for `SPRINT-07` and was not run. It reads `adb shell dumpsys location` before, during, and after a session on a physical phone; `SPRINT-07` put the team's one Android phone on the `UT-01` design instead, and `SPRINT-08`'s sessions bring a phone and a route together anyway, so the run is cheapest there. [The row](../../docs/project-plan.md#quality-requirement-testing-plan) carries the move and the reason. No other `SPRINT-07` row moved: `QR-06` and `QR-08` were both run and both pass.
9. **The planned velocity is 27 points again, and 19 of them are blocked on somebody outside the team.**
   [`SPRINT-06`'s retrospective](../week-06/sprint-retrospective.md#actions) carries an action not to do this, and the sprint did it anyway. The six stories were moved into the `SPRINT-07` milestone at `SPRINT-06`'s close and nobody took the blocked four back out. The plan [says so in the velocity line itself](../../docs/project-plan.md#sprint-07) rather than presenting the number as a forecast, and [the retrospective](sprint-retrospective.md#actions) re-lists the action with a specific moment attached to it.
10. **No usability result is claimed, and the `Customer` has still not installed the product.**
    Both halves of the evidence the project wants — a stranger using it, and the `Customer` using it — are still outstanding. The `UT-01` design exists partly because the second has now been promised four times, and the product cannot keep waiting on one person's install to learn anything.

## Privacy

No private-only material was committed to this repository, and no participant identity was committed to it. No session has run, so no participant exists yet; the consent template, the surveys, and the session note template are written so that none can be committed when they do — no name, no email address, no phone number, no address, no free text a participant wrote or said, and no recording. The private repository's and the recordings folder's links and access instructions are in the Moodle wrapper and in no public file.
