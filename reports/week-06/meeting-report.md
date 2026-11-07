# Week 6 validation meeting report

## Metadata

- **Date:** 2026-11-07
- **Duration:** about 13 minutes
- **Attended:** Ezekiel-Gadzama, sirjaey, Customer
- **Presented:** nothing. The installed product, the analytics dashboards, the observability dashboards, and the threshold proposal were not shown. The meeting stayed on the university virtual machine, metrics collection, GPS jamming, and whether the `Customer` had installed.
- **Recording:** permitted — the `Customer` ran the recording and said he would send the transcript.
- **Transcript publication:** script questions 1 to 3 were not asked separately; the team publishes a sanitized transcript in this repository from the recording the `Customer` supplied.
- **Transcript shared privately:** script question 3 was not asked separately.
- **Transcript:** [meeting-transcript.md](meeting-transcript.md)
- **Script:** [meeting-script.md](meeting-script.md)

## Previous action points

| Action | Outcome | Decision |
| --- | --- | --- |
| [`reports/week-05/meeting-report.md`](../week-05/meeting-report.md#action-points): "Title the run screen Run, label the session actions Interval and Steady without Start, show time, pace, and distance without a typed question, and replace Ask with a microphone on/off control" | Not carried out: `app/src/main/res/values/strings.xml` still has `Start interval`, and the run screen still uses a typed Ask box. The meeting script had already said this work is not in [`v0.3.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.3.0). Re-listed below. | None |
| [`reports/week-05/meeting-report.md`](../week-05/meeting-report.md#action-points): "Choose the Play Store publishing rules that fit the remaining weeks, and add a repository scanner for vulnerabilities and package dependencies that a stranger can run" | Not carried out: Ezekiel-Gadzama said the team has not researched what Google requires for a high-quality application. The `Customer` treated that as even with his own missed install. Re-listed below. | None |
| [`reports/week-05/meeting-report.md`](../week-05/meeting-report.md#action-points): "Build the app from the repository, install it on the `Customer`'s phone, and confirm pocket and Bluetooth headset use" | Not carried out: the `Customer` has still not installed. He started looking, named Android development as more involved than he expected, and said again that he will install this weekend. Pocket and headset use on his device remain unconfirmed. Re-listed below. | None |
| [`reports/week-05/meeting-report.md`](../week-05/meeting-report.md#action-points): "Ask the carried questions on the two presets, professional runners, and the wearable" | Not carried out: the meeting ran about 13 minutes and did not reach script questions 15 to 19. The five Week 5 questions are in `## Previous open questions`. Re-listed below. | None |

## Previous open questions

| Question | Answer | Decision |
| --- | --- | --- |
| [`reports/week-05/meeting-report.md`](../week-05/meeting-report.md#open-questions): "Are professional runners in scope later?" | Not asked. Re-listed below. | None |
| [`reports/week-05/meeting-report.md`](../week-05/meeting-report.md#open-questions): "After using the app, is heart rate still worth a week of the ones that are left?" | Not asked. He has not used the app. Re-listed below. | None |
| [`reports/week-05/meeting-report.md`](../week-05/meeting-report.md#open-questions): "Do the two preset sessions still follow this coach, or have they left the plan?" | Not asked. Re-listed below. | None |
| [`reports/week-05/meeting-report.md`](../week-05/meeting-report.md#open-questions): "May Android `SpeechRecognizer` send spoken audio off the device?" | Not asked. He allowed sending application performance and usage data, which does not settle whether spoken audio may leave the phone. Re-listed below. | None |
| [`reports/week-05/meeting-report.md`](../week-05/meeting-report.md#open-questions): "What file shape should a later export and import use besides comma-separated values?" | Not asked. Re-listed below. | None |

## Summary

- The `Customer` has still not installed from the repository. He started looking, is more interested in this product than the other course apps, and said again that he will install this weekend.
- Collecting usage and performance metrics is required even though the product is local and has no joint database. Collection is on by default; a runner who is not comfortable sending that data can refuse.
- Hosting the Android application on the university virtual machine is not required. An installable build from GitHub is enough.
- The coach should show whatever the phone's GPS reports. Jamming and jumps are not the team's problem at this stage. He pointed at stride and other sensors rather than using GPS all the time.
- The Play Store quality research from last week is still not done. He treated that as even with his missed install, and sirjaey asked that the install not stay recorded as missed into another sprint.

## Decisions

- [DEC-030: Collect usage and performance metrics, enabled by default, with a runner opt-out.](../../docs/decisions.md#dec-030)
- [DEC-031: Sending those metrics off the device is allowed; it is not an account or a run-history server.](../../docs/decisions.md#dec-031)
- [DEC-032: Show whatever the phone's GPS reports; do not try to correct jamming or jumps.](../../docs/decisions.md#dec-032)
- [DEC-033: Do not host the Android product on the university virtual machine; an installable build from GitHub is enough.](../../docs/decisions.md#dec-033)

## Action points

| Action | Owner | Due |
| --- | --- | --- |
| Title the run screen Run, label the session actions Interval and Steady without Start, show time, pace, and distance without a typed question, and replace Ask with a microphone on/off control | Ezekiel-Gadzama | 2026-11-14 |
| Choose the Play Store publishing rules that fit the remaining weeks, and add a repository scanner for vulnerabilities and package dependencies that a stranger can run | sirjaey | 2026-11-14 |
| Build the app from the repository, install it on the `Customer`'s phone, and confirm pocket and Bluetooth headset use | `Customer` | 2026-11-14 |
| Ask the carried questions on the two presets, professional runners, the wearable, the platform recogniser, and the export file shape | Ezekiel-Gadzama | 2026-11-14 |
| Add the metrics opt-out the `Customer` asked for, default on | Ezekiel-Gadzama | 2026-11-14 |

## Open questions

| Question | What it would change | Follow-up |
| --- | --- | --- |
| Are professional runners in scope later? | Whether anything built now must generalise to faster runners | Next customer meeting — script question 18 |
| After using the app, is heart rate still worth a week of the ones that are left? | Whether [US-07](https://github.com/Running-Coach-App/running-coach-app/issues/43) enters the remaining plan | Next customer meeting — script question 17 |
| Do the two preset sessions still follow this coach, or have they left the plan? | Build order after the pocket coach, and [US-06](https://github.com/Running-Coach-App/running-coach-app/issues/42) | Next customer meeting — script question 16 |
| May Android `SpeechRecognizer` send spoken audio off the device? | Whether [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) still matches [DEC-004](../../docs/decisions.md#dec-004) | Next customer meeting — script question 15. [DEC-031](../../docs/decisions.md#dec-031) covers performance and usage metrics, not spoken audio. |
| What file shape should a later export and import use besides comma-separated values? | The export work that [DEC-028](../../docs/decisions.md#dec-028) prefers over a server | Next customer meeting — script question 19 |
| Should [TOS-02](../../docs/threshold-of-success.md#tos-02) be set again with a new date, or has it stopped being the right bar? | Whether the threshold moves, which only a `DEC-nnn` at the Sprint Review can do | Next customer meeting — script question 14. Not asked in this meeting. |

## Disagreements

| Your position | Customer's position | What you changed |
| --- | --- | --- |
| A local product with no joint database does not need to collect metrics, and does not need the university virtual machine | Collect usage and performance metrics anyway, default on, with an opt-out; sending that data is fine; GitHub plus an installable build is enough and the VM is not required to host the app | Recorded as [DEC-030](../../docs/decisions.md#dec-030), [DEC-031](../../docs/decisions.md#dec-031), and [DEC-033](../../docs/decisions.md#dec-033) |
| GPS jamming could make spoken stats and answers wrong, so the app might need to stay quiet | Show whatever GPS shows; accuracy when GPS is jammed is not this product's job | Recorded as [DEC-032](../../docs/decisions.md#dec-032) |
