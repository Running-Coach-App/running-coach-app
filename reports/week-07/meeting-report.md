# Week 7 validation meeting report

## Metadata

- **Date:** 2026-11-14
- **Duration:** about 34 minutes
- **Attended:** sirjaey, Ezekiel-Gadzama, ObeTech1, Customer
- **Presented:** nothing was shown on screen, and it was not needed: the `Customer` had built the product from `main` and run with it, so the meeting was his account of that run rather than a demonstration of ours. The Play Store research, the scanner, and the GPS lifecycle were described rather than shown; the three interface changes merged that morning he had not yet seen.
- **Recording:** the `Customer` ran the recording himself, as in Week 6, and sent the transcript the same day.
- **Transcript publication:** **not asked.** The meeting opened directly on whether he had installed the product, and the three permission questions were never put. No permission to publish exists for this meeting, so the transcript is shared privately through the Moodle submission and is not committed here. Declared in [the report's deviations](README.md#deviations).
- **Transcript shared privately:** yes, through the Moodle wrapper.
- **Transcript:** [meeting-transcript.md](meeting-transcript.md) records why there is none in this repository.
- **Script:** [meeting-script.md](meeting-script.md)

## Previous action points

The five action points [the Week 6 report](../week-06/meeting-report.md#action-points) recorded, each due 2026-11-14.

| Action | Outcome | Decision |
| --- | --- | --- |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#action-points): "Build the app from the repository, install it on the `Customer`'s phone, and confirm pocket and Bluetooth headset use" | **Carried out, after four weeks of being carried.** He built the most recent version from `main`, installed it on a Pixel 8, and ran with it for about twelve minutes with Bluetooth headphones. Pocket use is **confirmed broken** rather than confirmed working: with the phone in a running pouch and the screen off, no spoken command was answered and neither volume key did anything, and he had to take the phone out | None. The failures became [#219](https://github.com/Running-Coach-App/running-coach-app/issues/219) and [#220](https://github.com/Running-Coach-App/running-coach-app/issues/220) |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#action-points): "Choose the Play Store publishing rules that fit the remaining weeks, and add a repository scanner for vulnerabilities and package dependencies that a stranger can run" | **Carried out**, and checked by him rather than only reported to him. He read the repository: "in terms of security, and other things, it was all fine... No problems around that, I didn't find anything." [`QR-08`](../../docs/quality-requirements/qr/QR-08.md) is the first quality requirement this product has that the `Customer` has verified himself | None |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#action-points): "Title the run screen Run, label the session actions Interval and Steady without Start, show time, pace, and distance without a typed question, and replace Ask with a microphone on/off control" | **Carried out and merged**, about twelve hours before the meeting, which was after he had built and run. He had therefore tested the old interface and raised the typed box as a fault — "it's quite useless, like, I had to stop running to enter what I already know" — before being told it was already gone. He will retest on the new build | None |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#action-points): "Add the metrics opt-out the `Customer` asked for, default on" | **Carried out**, as [#209](https://github.com/Running-Coach-App/running-coach-app/pull/209), which was not yet merged at the time of the meeting and was not raised in it | None |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#action-points): "Ask the carried questions on the two presets, professional runners, the wearable, the platform recogniser, and the export file shape" | **Not carried out**, for the third meeting running. The meeting was given over to his account of the run, which was worth more than the questions. Only the export touched one of them, in passing: he intends to pull the run report as JSON and send it back. Re-listed below | None |

## Previous open questions

The six questions [the Week 6 report](../week-06/meeting-report.md#open-questions) left open. **None was asked.** The meeting ran on the `Customer`'s feedback from his run, and the script's Part 6 was never reached. All six are carried again, now for a third week.

| Question | Answer | Decision |
| --- | --- | --- |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#open-questions): "May Android `SpeechRecognizer` send spoken audio off the device?" | Not asked. He raised a neighbouring question himself — whether the product should save what the recogniser heard, for debugging — which is in `## Open questions` below and bears on the same [`DEC-004`](../../docs/decisions.md#dec-004) boundary | None |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#open-questions): "Should [TOS-02](../../docs/threshold-of-success.md#tos-02) be set again with a new date, or has it stopped being the right bar?" | Not asked. The run itself has largely answered it: the goal is still the right bar and is still missed, now on evidence rather than on absence. See `## Summary` | None |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#open-questions): "Do the two preset sessions still follow this coach, or have they left the plan?" | Not asked. Re-listed | None |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#open-questions): "After using the app, is heart rate still worth a week of the ones that are left?" | Not asked, although he has now used the app. Re-listed | None |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#open-questions): "Are professional runners in scope later?" | Not asked. Re-listed | None |
| [`reports/week-06/meeting-report.md`](../week-06/meeting-report.md#open-questions): "What file shape should a later export and import use besides comma-separated values?" | Partly answered without being asked: he noticed the run report is available as JSON and said he would pull one and send it back. That is the shape he intends to read, so JSON stands until he says otherwise | None |

## Summary

The `Customer` used the product for the first time, and his verdict was plain: **"In summary, as it stands, it's not very useful for running."** The rest of this section is what produced that verdict, because the detail is worth more than the sentence.

**What worked.** Starting a session worked from the button. The effort cues worked and he was happy with them: "as I was running, it would tell me to run harder, or slow down. I thought it was okay." The off-topic reply worked and amused him — asked for something outside the three stats, the coach told him to keep running and not ask questions, "which is okay, we agreed on that, so that was kind of funny". The on-screen stats he judged sufficient: "display as it is... I think for this project, it's okay, it's enough." And he read the repository's security work and found nothing wrong with it.

**The pocket session failed completely.** With the phone in a running pouch and the screen off, nothing responded: no spoken command, and neither volume key. He had to take the phone out, and only with the screen on and the app in the foreground could he ask anything. This is [`US-01`](https://github.com/Running-Coach-App/running-coach-app/issues/37) and [`QR-03`](../../docs/quality-requirements/qr/QR-03.md) failing on the first device outside the team, and it is the product's central promise. @sirjaey reports the same actions working on his own phone, so it is device-specific or build-specific rather than missing; the `Customer` suspects something particular to the Pixel 8. [#219](https://github.com/Running-Coach-App/running-coach-app/issues/219).

**The coach may be listening on the wrong microphone.** His own diagnosis, offered as a suspicion rather than a finding: the product listens on the phone's microphone and not the headset's. He tested it by moving the phone — closer and it answered more often, behind him and it did not, while the headphones kept working. If he is right it explains much of the rest, because a phone in a pouch is exactly where the phone's own microphone hears least. [#220](https://github.com/Running-Coach-App/running-coach-app/issues/220).

**The questions it understands are too few.** Time was answered sometimes. Pace was never answered at all, however he phrased it. A request for the stats as a whole fell through to the off-topic reply. He gave the fix and ruled out the alternative the team proposed in the meeting, recorded as [`DEC-034`](../../docs/decisions.md#dec-034). [#221](https://github.com/Running-Coach-App/running-coach-app/issues/221).

**The battery cost is the hardest number the project has been given.** Twelve minutes of running cost 6% of his battery — about eight minutes in the background and five with the screen on — against 9% for thirty-seven minutes of a game. His phone grew warm. He and @sirjaey agreed on the cause in the meeting, the location fix being held continuously, and he proposed sampling it against a step detector instead, recorded as [`DEC-035`](../../docs/decisions.md#dec-035). He separately noted Android's own voice recognition at about 3% and said that was fine. [#222](https://github.com/Running-Coach-App/running-coach-app/issues/222).

**The coach spoke its stats once in ten minutes**, where he had expected roughly every two, and he asked to be able to change the interval. [`DEC-036`](../../docs/decisions.md#dec-036), [#223](https://github.com/Running-Coach-App/running-coach-app/issues/223).

**He wants the phone usable without unlocking it** — stats visible and the session stoppable from the lock screen, as other apps manage. [`DEC-037`](../../docs/decisions.md#dec-037), [#224](https://github.com/Running-Coach-App/running-coach-app/issues/224), which is the same change as the `MediaStyle` notification the product already fails Google on.

**He could not get started from the README** and asked an AI assistant what to do with the repository instead. [`DEC-038`](../../docs/decisions.md#dec-038), [#225](https://github.com/Running-Coach-App/running-coach-app/issues/225).

**On the usability study**, he asked unprompted what was planned, described the pre-test and post-test method the team has already designed, and said what it is for: "the app is not as important as you practicing creating questionnaires... talking to users, processing messy responses". He offered to fill a questionnaire himself and immediately added that one respondent is not enough. [`DEC-039`](../../docs/decisions.md#dec-039). The team's problem with arranging the sessions is in `## Open questions`.

**[`TOS-02`](../../docs/threshold-of-success.md#tos-02) stays missed, and is now missed on evidence.** The goal asks for somebody outside the team to finish one *pocket* session: start, hear time, pace and distance, hear an effort cue, ask one stat aloud, and stop. He started, heard effort cues, and stopped. He never heard pace, never completed a question from the pocket, and took the phone out. The goal is still the right bar, and the product does not yet clear it.

## Decisions

- [DEC-034: Widen the spoken-question rules rather than add an on-device model, and generate the phrasings with a language model.](../../docs/decisions.md#dec-034)
- [DEC-035: Sample the location fix occasionally, against a step or pace detector, rather than holding it for the whole session.](../../docs/decisions.md#dec-035)
- [DEC-036: Let the runner set how often the coach speaks the stats line.](../../docs/decisions.md#dec-036)
- [DEC-037: Put the session's stats and a stop control where they can be reached without unlocking the phone.](../../docs/decisions.md#dec-037)
- [DEC-038: The README must say what a runner gets from the product and how to start, without the reader having to ask anybody.](../../docs/decisions.md#dec-038)
- [DEC-039: Run the usability study with a pre-test questionnaire and a post-test questionnaire, on more than one participant.](../../docs/decisions.md#dec-039)

Each has a task issue opened in the same change that records it, which is what [`SPRINT-06`'s retrospective](../week-06/sprint-retrospective.md#actions) has asked for four times and no previous meeting has done.

## Action points

| Action | Owner | Due |
| --- | --- | --- |
| Retest on the build that carries the three interface changes, and send the run report as JSON | `Customer` | 2026-11-21 |
| Establish why the pocket session failed on a Pixel 8, and fix it or record it as a constraint | sirjaey | 2026-11-21 |
| Establish whether the recogniser uses the phone or the headset microphone, and route it to the headset | Ezekiel-Gadzama | 2026-11-21 |
| Widen the question rules per `DEC-034`, with no on-device model | Ezekiel-Gadzama | 2026-11-21 |
| Sample the location fix against a step detector per `DEC-035`, and measure the battery before and after | sirjaey | 2026-11-21 |
| Send the `UT-01` pre-test and post-test questionnaires to the `Customer` to fill in, as one respondent among several | ObeTech1 | 2026-11-19 |
| Ask the `Customer` whether this meeting's transcript may be published, since the permission questions were not put | Ezekiel-Gadzama | 2026-11-21 |

## Open questions

| Question | What it would change | Follow-up |
| --- | --- | --- |
| Should the product save the text the recogniser heard, for debugging? | The product records that a question was asked and its topic, never its words, which is what [`DEC-004`](../../docs/decisions.md#dec-004) and a unit test hold in place. He raised both sides himself — "I shouldn't be saving the conversation" and then "maybe for debugging purposes, maybe we should do that, for a version" — so it is open rather than decided | Next customer meeting. Needs its own `DEC-nnn` either way, and a retention rule if the answer is yes |
| Do the product's error logs go to a server, and does that mean the app gains the `INTERNET` permission? | Everything. The product holds no network permission, which is what [`QR-08`](../../docs/quality-requirements/qr/QR-08.md), [`ADR-005`](../../docs/architecture/adr/ADR-005.md), [`ADR-006`](../../docs/architecture/adr/ADR-006.md) and [`DEC-028`](../../docs/decisions.md#dec-028) rest on, and it is the claim the `Customer` personally verified this week. A log shipper would reverse it | Within the team first, before any server work lands. Raised in the meeting as work in progress rather than as a proposal |
| Where do the usability participants come from, if nobody will run outdoors in the host city? | The whole shape of [`UT-01`](../../docs/usability-tests/ut-01/README.md): in person, on the team's phone, with an observer watching and the session recorded. Remote participants break all four | Within the team, before the first session. The `Customer` acknowledged the difficulty — "in your case it will be a bit difficult to follow them and see how they use it" — and suggested giving instructions instead |
| Is a wearable the product's real home? | He raised a pivot to a watch and then argued against it himself, "but other apps can do it already". Not a proposal, but the first time the product's shape has been questioned | Next customer meeting |
| The five carried from Week 6: the presets, professional runners, heart rate, the platform recogniser, and the export shape | As recorded in [the Week 6 report](../week-06/meeting-report.md#open-questions) | Next customer meeting. Third week carried; they should be asked first rather than last |

## Disagreements

| Your position | Customer's position | What you changed |
| --- | --- | --- |
| The rigid question matching should be answered with a small on-device model, proposed in the meeting | Try more rules first: have a language model generate many phrasings and keep the matcher. An embedded model is "quite a bit of work" and would make the battery worse — "it will work for 5 seconds, and then done" | Accepted. Recorded as [DEC-034](../../docs/decisions.md#dec-034), and [#221](https://github.com/Running-Coach-App/running-coach-app/issues/221) says explicitly that no embedded model is added |
| Holding the location fix only while a session runs is enough, which is the line [`QR-07`](../../docs/quality-requirements/qr/QR-07.md) takes and the product already meets | Not enough: 6% for twelve minutes is too much, and the fix should be sampled against a step detector rather than held | Accepted. Recorded as [DEC-035](../../docs/decisions.md#dec-035); `QR-07`'s measure is revisited in [#222](https://github.com/Running-Coach-App/running-coach-app/issues/222) |
