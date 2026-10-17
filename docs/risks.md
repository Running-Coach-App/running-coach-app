# Risks

| ID | Status | Impact | Likelihood | Risk |
| --- | --- | --- | --- | --- |
| [RISK-01](#risk-01) | Open | High | High | The team has not run an on-device model, so Gemma may not fit a phone the team can show this week, which would leave the spoken-question story without an engine at the Week 3 meeting. |
| [RISK-02](#risk-02) | Open | High | Medium | The team has no second reviewer free before Saturday, so a pull request may sit unmerged, which would leave the slice off main at the hard deadline. |
| [RISK-03](#risk-03) | Open | Medium | Medium | No physical Android phone is in the room, so the pocket criteria may be shown only on an emulator, which would leave the customer unable to accept a session whose screen stayed covered. |

## RISK-01

The team has not run an on-device model, so Gemma may not fit a phone the team can show this week, which would leave the spoken-question story without an engine at the Week 3 meeting.

- Status: Open
- Impact: High
  - [TOS-01](threshold-of-success.md#tos-01) needs a verdict on [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40). A story with no spoken answer cannot be accepted.
- Likelihood: High
  - [ASM-09](assumptions.md#asm-09) is still open. [The on-device feasibility spike issue #54](https://github.com/Running-Coach-App/running-coach-app/issues/54) finds that Gemma 3n is built for phones and that its weights are not in this repository.
- Trigger: no phone in the team's hands has answered a stat question from a Gemma build by Thursday 15 October 2026.
- Window: [SPRINT-03 in project plan issue #48](https://github.com/Running-Coach-App/running-coach-app/issues/48), up to the Week 3 meeting.
- Mitigation: answer time, pace, and distance with an on-device phrase matcher in the Week 3 binary, and keep Gemma out of that binary until a phone has run it.
- Contingency: show [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) against the phrase matcher, and ask the customer to keep Gemma as the later engine rather than as a Week 3 blocker.

## RISK-02

The team has no second reviewer free before Saturday, so a pull request may sit unmerged, which would leave the slice off main at the hard deadline.

- Status: Open
- Impact: High
  - [MLS-03 in project plan issue #48](https://github.com/Running-Coach-App/running-coach-app/issues/48) is the slice on main. An unmerged branch is not the minimum usable product.
- Likelihood: Medium
  - main needs another member's approval, and the hard deadline is 2026-10-17.
- Trigger: a pull request for a candidate story has had no approval by Friday 16 October 2026 at 18:00 WAT.
- Window: [SPRINT-03 in project plan issue #48](https://github.com/Running-Coach-App/running-coach-app/issues/48).
- Mitigation: open one pull request per task as soon as that task is ready, and name the reviewer in the request.
- Contingency: drop the unmerged story from the meeting's "finished" list and ask the customer whether it leaves the candidate, recorded as a DEC-nnn.

## RISK-03

No physical Android phone is in the room, so the pocket criteria may be shown only on an emulator, which would leave the customer unable to accept a session whose screen stayed covered.

- Status: Open
- Impact: Medium
  - [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) and [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38) are about not looking. An emulator window is a screen.
- Likelihood: Medium
  - [CON-08](product-vision.md#con-08) already records that the team has no sports watch. A phone is a separate gap, and the meeting may be in writing, as Week 2 was.
- Trigger: the day before the meeting, nobody has a physical Android phone that has run the slice.
- Window: [SPRINT-03 in project plan issue #48](https://github.com/Running-Coach-App/running-coach-app/issues/48), up to the Week 3 meeting.
- Mitigation: rehearse on a physical phone the day before, headphones on, screen covered, and keep that phone for the meeting.
- Contingency: hold the meeting in writing and send a screen recording of the covered-phone rehearsal, if the customer allows the recording questions.
