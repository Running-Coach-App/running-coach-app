# Risks

| ID | Status | Impact | Likelihood | Risk |
| --- | --- | --- | --- | --- |
| [RISK-01](#risk-01) | Open | High | High | The team has not run an on-device model, so Gemma may not fit a phone the team can show this week, which would leave the spoken-question story without an engine at the Week 3 meeting. |
| [RISK-04](#risk-04) | Open | High | High | The team has never recruited anybody from outside itself, so fewer than three people may agree to a session, which would leave `QR-09` unverified and Week 8 with no usability result to report. |
| [RISK-02](#risk-02) | Open | High | Medium | The team has no second reviewer free before Saturday, so a pull request may sit unmerged, which would leave the slice off main at the hard deadline. |
| [RISK-07](#risk-07) | Open | High | Medium | The sessions need daylight, dry weather, and a participant free at the same hour, so the last counted session may not happen before Submission 8, which would leave the test unfinished and its requirement unverified into `SPRINT-09`. |
| [RISK-03](#risk-03) | Open | Medium | Medium | No physical Android phone is in the room, so the pocket criteria may be shown only on an emulator, which would leave the customer unable to accept a session whose screen stayed covered. |
| [RISK-05](#risk-05) | Open | Medium | Medium | The recording is required for a session to count, so a participant may refuse it or withdraw afterwards, which would cost the team a counted session and the time it took to arrange. |
| [RISK-06](#risk-06) | Open | Medium | Low | The private usability data lives in a GitHub repository and a cloud folder, so an instructor may be unable to open one of them, which would leave the raw evidence for the usability test unreachable by the people marking it. |

## RISK-01

The team has not run an on-device model, so Gemma may not fit a phone the team can show this week, which would leave the spoken-question story without an engine at the Week 3 meeting.

- **Status:** Open
- **Impact:** High
  - [TOS-01](threshold-of-success.md#tos-01) needs a verdict on [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40). A story with no spoken answer cannot be accepted.
- **Likelihood:** High
  - [ASM-09](assumptions.md#asm-09) is still open. [The on-device feasibility spike issue #54](https://github.com/Running-Coach-App/running-coach-app/issues/54) finds that Gemma 3n is built for phones and that its weights are not in this repository.
- **Trigger:** no phone in the team's hands has answered a stat question from a Gemma build by Thursday 15 October 2026.
- **Window:** [SPRINT-03 in project plan issue #48](https://github.com/Running-Coach-App/running-coach-app/issues/48), up to the Week 3 meeting.
- **Mitigation:** answer time, pace, and distance with an on-device phrase matcher in the Week 3 binary, and keep Gemma out of that binary until a phone has run it.
- **Contingency:** show [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) against the phrase matcher, and ask the customer to keep Gemma as the later engine rather than as a Week 3 blocker.

## RISK-02

The team has no second reviewer free before Saturday, so a pull request may sit unmerged, which would leave the slice off main at the hard deadline.

- **Status:** Open
- **Impact:** High
  - [MLS-03 in project plan issue #48](https://github.com/Running-Coach-App/running-coach-app/issues/48) is the slice on main. An unmerged branch is not the minimum usable product.
- **Likelihood:** Medium
  - main needs another member's approval, and the hard deadline is 2026-10-17.
- **Trigger:** a pull request for a candidate story has had no approval by Friday 16 October 2026 at 18:00 WAT.
- **Window:** [SPRINT-03 in project plan issue #48](https://github.com/Running-Coach-App/running-coach-app/issues/48).
- **Mitigation:** open one pull request per task as soon as that task is ready, and name the reviewer in the request.
- **Contingency:** drop the unmerged story from the meeting's "finished" list and ask the customer whether it leaves the candidate, recorded as a DEC-nnn.

## RISK-03

No physical Android phone is in the room, so the pocket criteria may be shown only on an emulator, which would leave the customer unable to accept a session whose screen stayed covered.

- **Status:** Open
- **Impact:** Medium
  - [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) and [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38) are about not looking. An emulator window is a screen.
- **Likelihood:** Medium
  - [CON-08](product-vision.md#con-08) already records that the team has no sports watch. A phone is a separate gap, and the meeting may be in writing, as Week 2 was.
- **Trigger:** the day before the meeting, nobody has a physical Android phone that has run the slice.
- **Window:** [SPRINT-03 in project plan issue #48](https://github.com/Running-Coach-App/running-coach-app/issues/48), up to the Week 3 meeting.
- **Mitigation:** rehearse on a physical phone the day before, headphones on, screen covered, and keep that phone for the meeting.
- **Contingency:** hold the meeting in writing and send a screen recording of the covered-phone rehearsal, if the customer allows the recording questions.

## RISK-04

The team has never recruited anybody from outside itself, so fewer than three people may agree to a session, which would leave `QR-09` unverified and Week 8 with no usability result to report.

- **Status:** Open
- **Impact:** High
  - [`UT-01`](usability-tests/ut-01/README.md) is designed for a minimum of three counted sessions, and [`QR-09`](quality-requirements/qr/QR-09.md) reads a proportion across them. Two sessions do not settle it: the row stays `Not verified`, and the week's main deliverable is a design nobody ran.
- **Likelihood:** High
  - Three weeks of trying to get one person outside the team to install the product have produced nobody, including the `Customer`, who has said twice that he would and has not. Recruiting five strangers for forty minutes each, outdoors, is a larger ask than that.
- **Trigger:** by 2026-11-17, fewer than three people have agreed to a session and a date.
- **Window:** [`SPRINT-07`](project-plan.md#sprint-07) and [`SPRINT-08`](project-plan.md#sprint-08), up to the last date a session can run and still be written up, 2026-11-19.
- **Mitigation:** start recruiting the day the design is merged rather than the week the sessions are due; ask in person, where a request is harder to leave unanswered than a message; recruit against the profile's broad reading, since somebody who walks briskly for exercise qualifies and not only a runner; and book five to land three.
- **Contingency:** recruit replacements under the next free codes. If three still cannot be found, keep the [`QR-09 QRT-01`](quality-requirements/qr/QR-09.md#qrt-01) row `Not verified` in `SPRINT-08` or move it to `SPRINT-09` with the reason, declare the shortfall in the weekly report, and claim no usability result. Report what the sessions that did run showed, as results, without reading the requirement's measure from a sample below its minimum.

## RISK-05

The recording is required for a session to count, so a participant may refuse it or withdraw afterwards, which would cost the team a counted session and the time it took to arrange.

- **Status:** Open
- **Impact:** Medium
  - A refused recording means the session cannot run at all, and a withdrawal after the fact means its data has to be deleted. Either way the count drops by one, which matters because the minimum is three, and it feeds [`RISK-04`](#risk-04).
- **Likelihood:** Medium
  - Being recorded while jogging and talking aloud is a more uncomfortable thing to agree to than filling in a form, and the consent is deliberately explicit about it rather than burying it, so a participant who is uneasy will say so.
- **Trigger:** a participant declines the recording clause at the consent step, or asks after their session for their data to be removed.
- **Window:** every counted session, from the first to the last, and up to the moment the course is graded for a withdrawal.
- **Mitigation:** say what the recording is and who hears it when the session is arranged, not when the participant is already standing there in a jacket; keep the recording to audio rather than video; and make the quote clause separately optional, so the one thing most people hesitate over is not bundled with the thing the session needs.
- **Contingency:** do not count the session, remove the raw text from the private repository and the recording from the cloud folder, retire the participant's code so nothing is ever filed under it again, and recruit a replacement under the next free code. Record the retired code and the reason in [the results](usability-tests/ut-01/results.md), with nothing about the person.

## RISK-06

The private usability data lives in a GitHub repository and a cloud folder, so an instructor may be unable to open one of them, which would leave the raw evidence for the usability test unreachable by the people marking it.

- **Status:** Open
- **Impact:** Medium
  - The consent promises the participants that the instructors can see the private material, and the course requires it. Evidence the markers cannot open is, for grading, evidence that does not exist, and the sanitized public record alone does not show that a session happened as described.
- **Likelihood:** Low
  - Both are ordinary tools, and the course already works through GitHub. The failure here is an account the team does not know about, or a cloud folder shared to the wrong address, rather than a platform problem.
- **Trigger:** an instructor says they cannot open the private repository or the recordings folder, or a sharing invitation is still unaccepted at the Submission 8 deadline.
- **Window:** from the private repository's creation in `SPRINT-07` until the course is graded.
- **Mitigation:** create the repository with the team and the instructors as readers at the same time rather than adding them afterwards; share the cloud folder to the addresses the course gives; and have a member who is not the owner open both from their own account before the first session, so the access is tested rather than assumed.
- **Contingency:** give the private text through a Moodle-only archive, which is the one channel every instructor certainly has, and declare the deviation in the weekly report. The recordings go the same way if the folder is the part that cannot be opened. The product repository carries no raw participant data either way.

## RISK-07

The sessions need daylight, dry weather, and a participant free at the same hour, so the last counted session may not happen before Submission 8, which would leave the test unfinished and its requirement unverified into `SPRINT-09`.

- **Status:** Open
- **Impact:** High
  - Week 8's deliverable is the results, the findings, and the triage. A test whose last session runs after the deadline produces none of them on time, and [`REL-08`](project-plan.md#rel-08) carries no fix, because there is no finding to fix.
- **Likelihood:** Medium
  - Three to five outdoor sessions of forty minutes each have to fit between 2026-11-16 and 2026-11-19, in the late-afternoon daylight this calendar leaves, around the participants' own timetables and the rest of `SPRINT-08`'s work. One wet afternoon removes a slot.
- **Trigger:** by 2026-11-18, fewer than three sessions have been completed, or the only remaining slots fall after 2026-11-19.
- **Window:** [`SPRINT-08`](project-plan.md#sprint-08), from the first session to 2026-11-19.
- **Mitigation:** book the sessions one at a time as participants agree rather than waiting for a full set; put the first one as early in the sprint as the verified instrumentation allows; keep a reserve slot each day; and write the per-participant table as each session finishes instead of all of it at the end.
- **Contingency:** move the [`QR-09 QRT-01`](quality-requirements/qr/QR-09.md#qrt-01) row to [`SPRINT-09`](project-plan.md#sprint-09) with the reason, declare the open window in the weekly report, and claim no usability result. Report the sessions that did run as results, and schedule the remainder in `SPRINT-09`, before the pitch.
