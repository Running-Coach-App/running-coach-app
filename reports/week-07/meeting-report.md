# Week 7 validation meeting report

> **Written after the meeting.** The Week 7 Sprint Review has not been held at the time this file is created. The two tables that do not depend on it — `## Previous action points` and `## Previous open questions` — carry the outcomes the sprint's work has already settled, and the cells marked `At the meeting` are filled from the meeting itself. The script the meeting follows is [meeting-script.md](meeting-script.md).

## Metadata

- **Date:** At the meeting.
- **Duration:** At the meeting.
- **Attended:** At the meeting.
- **Presented:** At the meeting. The script shows the tagged release and a live session on the phone, [the Play Store research](../../docs/research/play-store-quality.md) and `./scripts/scan.sh` running, and [the `UT-01` design](../../docs/usability-tests/ut-01/README.md) — the record, the surveys, the consent, the instrumentation, the session plan, and [`QR-09`](../../docs/quality-requirements/qr/QR-09.md).
- **Recording:** At the meeting — script question 1, asked before anything is recorded.
- **Transcript publication:** At the meeting — script question 2.
- **Transcript shared privately:** At the meeting — script question 3, asked only if question 2 is refused.
- **Transcript:** [meeting-transcript.md](meeting-transcript.md)
- **Script:** [meeting-script.md](meeting-script.md)

## Previous action points

The five action points [the Week 6 report](../week-06/meeting-report.md#action-points) recorded, each due 2026-11-14.

| Action | Outcome | Decision |
| --- | --- | --- |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#action-points): "Choose the Play Store publishing rules that fit the remaining weeks, and add a repository scanner for vulnerabilities and package dependencies that a stranger can run" | **Carried out.** [`docs/research/play-store-quality.md`](../../docs/research/play-store-quality.md) is the research, read from Google's own Core app quality and Android vitals pages. Three criteria became requirements with tests — [`QR-06`](../../docs/quality-requirements/qr/QR-06.md), [`QR-07`](../../docs/quality-requirements/qr/QR-07.md), and [`QR-08`](../../docs/quality-requirements/qr/QR-08.md) — and one criterion the product fails today, `Audio_Notification_Style`, became [issue #197](https://github.com/Running-Coach-App/running-coach-app/issues/197) rather than a requirement. The scanner is `scripts/scan.sh`: it checks 149 locked dependencies against OSV.dev, that the product declares no network permission and references no networking type, and that no credential is in a tracked file. The `Security scan` workflow runs it on every pull request and every push to `main`, and asserts on every run that adding `android.permission.INTERNET` makes it fail | At the meeting — script questions 6 to 9 |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#action-points): "Title the run screen Run, label the session actions Interval and Steady without Start, show time, pace, and distance without a typed question, and replace Ask with a microphone on/off control" | **Carried out**, on the due date, under [#202](https://github.com/Running-Coach-App/running-coach-app/issues/202). The run screen's heading is `Run`, matching its tab, with the session kind on a line of its own below it ([`DEC-024`](../../docs/decisions.md#dec-024)); the session actions read `Interval` and `Steady` ([`DEC-025`](../../docs/decisions.md#dec-025)); and the typed question box and its `Ask` button are replaced by one microphone control, on by default, which the runner can turn off mid-run to stop the coach listening while they talk to somebody ([`DEC-026`](../../docs/decisions.md#dec-026)). The stats half of `DEC-026` was already satisfied by `DEC-018` and `DEC-022` in `v0.3.0`. Spoken questions already worked; what was missing was the control over them. The change also made the `UT-01` record's reason for leaving the spoken question out of its tasks false, and [the record now carries the two reasons that hold](../../docs/usability-tests/ut-01/README.md#why-asking-the-coach-a-question-aloud-is-not-a-task) | At the meeting — script question 7 |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#action-points): "Build the app from the repository, install it on the `Customer`'s phone, and confirm pocket and Bluetooth headset use" | At the meeting — script question 4. This is the fourth week the action has been carried. The `UT-01` design exists partly so that the product can be put in front of somebody outside the team without waiting on it | At the meeting |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#action-points): "Ask the carried questions on the two presets, professional runners, the wearable, the platform recogniser, and the export file shape" | At the meeting. All five are in the script as questions 18 to 23, placed before the close rather than last, which is what the previous two meetings ran out of time to reach | At the meeting |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#action-points): "Add the metrics opt-out the `Customer` asked for, default on" | At the meeting. The outcome is read from `main` at the sprint's close and stated here either way. [`DEC-030`](../../docs/decisions.md#dec-030) is the decision it serves and still has no task issue, which [this sprint's retrospective](sprint-retrospective.md#actions) re-lists for the fourth time | At the meeting |

## Previous open questions

The six questions [the Week 6 report](../week-06/meeting-report.md#open-questions) left open. Five have now been carried for two weeks because both meetings ran short; all six are in this week's script before the close.

| Question | Answer | Decision |
| --- | --- | --- |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#open-questions): "May Android `SpeechRecognizer` send spoken audio off the device?" | At the meeting — script question 18. Not answered by [`DEC-031`](../../docs/decisions.md#dec-031), which allows performance and usage metrics to leave the phone and says nothing about audio, and the team has not treated it as if it did | At the meeting |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#open-questions): "Should [TOS-02](../../docs/threshold-of-success.md#tos-02) be set again with a new date, or has it stopped being the right bar?" | At the meeting — script question 19. The `UT-01` design changes what the question means: a counted session is a person outside the team finishing a whole session, which is what `TOS-02` asked for | At the meeting |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#open-questions): "Do the two preset sessions still follow this coach, or have they left the plan?" | At the meeting — script question 20 | At the meeting |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#open-questions): "After using the app, is heart rate still worth a week of the ones that are left?" | At the meeting — script question 21 | At the meeting |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#open-questions): "Are professional runners in scope later?" | At the meeting — script question 22 | At the meeting |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#open-questions): "What file shape should a later export and import use besides comma-separated values?" | At the meeting — script question 23 | At the meeting |

## Summary

At the meeting. It records what the `Customer` said about the Play Store research and the scanner, whether the `UT-01` design asks what he wants asked, whether the participant profile, the recruitment target of three with five as the target, and the session plan are right, what the results have to show, and the Week 8 execution plan agreed with him.

## Decisions

At the meeting. Every decision the `Customer` makes is written here and added to [the decisions page](../../docs/decisions.md) as the next free `DEC-nnn`, and anything it changes cites it. A decision that changes the `UT-01` sub-characteristic, its measure, or its bar is applied to [`QR-09`](../../docs/quality-requirements/qr/QR-09.md) and the record as same-week rework rather than carried as an action, per [Part 11 of the assignment](../../docs/project-plan.md#sprint-07).

## Action points

At the meeting. At least two, each due after Week 7 and at least one due in Week 8. The ones the sprint already knows will be here:

| Action | Owner | Due |
| --- | --- | --- |
| Recruit at least three participants matching [the profile](../../docs/usability-tests/ut-01/README.md#participant-profile), and arrange their sessions | At the meeting | 2026-11-17 |
| Implement the `UT-01` instrumentation and verify it on a team run before the first counted session | At the meeting | 2026-11-18 |
| Run the counted sessions, write the sanitized notes and the results, triage the findings, and record the [`QR-09`](../../docs/quality-requirements/qr/QR-09.md) verdict | At the meeting | 2026-11-21 |

## Open questions

At the meeting. Any question the meeting does not reach, or that the `Customer` does not settle, with what it would change and when it is next asked.

## Disagreements

At the meeting. Where the team's position and the `Customer`'s differed, and what the team changed as a result.
