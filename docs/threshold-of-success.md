# Threshold of success

Running Coach App, team 4.

## TOS-01

By the end of Week 3 the customer has given a yes or a no on each story in the Week 2 candidate.

- **Status:** Met
- **Measure:** one `DEC-nnn` per candidate story, [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) through [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40), in the Week 3 meeting report, by 2026-10-17.
- **Outcome:** Affirmed from description (no working binary shown) with refinements in [DEC-010](decisions.md#dec-010) through [DEC-016](decisions.md#dec-016); see [the Week 3 meeting report](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-03/meeting-report.md#decisions).

## TOS-02

By the end of Week 5 a person who is not on the team follows the setup page from a clean checkout and finishes one pocket session: start, hear time, pace, and distance, hear an effort cue, ask one stat aloud, and stop.

- **Status:** Missed
- **Measure:** that run is written up in the Week 5 report, naming the commit they checked out and which acceptance criteria they heard, by 2026-10-30.
- **Outcome:** Missed. The date passed with nobody outside the team having run the core task. The `Customer` had not installed the product by the Week 5 meeting, so [the Week 5 report](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-05/README.md) records no such run, and [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38) was accepted from screenshots rather than from his own phone. A signed-for-install APK was attached to [v0.3.0](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.3.0) after the meeting, which is what the goal needed and did not have.

  Still missed at Week 7, and now missed on evidence rather than on absence. On 2026-11-14 the `Customer` built the product from `main`, installed it on his own phone and ran with it for about twelve minutes, which is the first time anybody outside the team has done so. He did not clear this goal: with the phone in a pouch and the screen off nothing answered him and neither volume key worked, so he took the phone out; pace was never spoken however he asked for it; and the stats line arrived once in about ten minutes. He started a session, heard effort cues, and stopped, which is three of the six things the goal asks for. [The Week 7 meeting report](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-07/meeting-report.md#summary) carries his account, and the failures are [#219](https://github.com/Running-Coach-App/running-coach-app/issues/219), [#220](https://github.com/Running-Coach-App/running-coach-app/issues/220), [#221](https://github.com/Running-Coach-App/running-coach-app/issues/221) and [#223](https://github.com/Running-Coach-App/running-coach-app/issues/223). The goal is left as it stands rather than re-dated: it is still the right bar, and the product does not yet clear it.

## TOS-03

By the end of Week 9 a spoken question about the current run's time, pace, or distance is answered on the phone, with no round trip to a server.

- **Status:** Open
- **Measure:** one session on a physical Android phone, cited from the Week 9 report, whose answer was produced on the device, by 2026-11-27.

## Failure And Success Statements

| Goal | Success statement | Failure statement |
| --- | --- | --- |
| [TOS-01](#tos-01) | The customer accepts the Week 2 candidate, or moves a story out of it on purpose. | The customer never gives a verdict, and the team cannot tell a finished story from a guess. |
| [TOS-02](#tos-02) | Someone outside the team runs the core task from the setup page. | Only the team can run the product, so it was never delivered. |
| [TOS-03](#tos-03) | A spoken stat question is answered on the phone. | The answer needs a server, or the question gets a made-up number. |
| — | The two preset sessions still come after the coach, if the customer still wants them. | The ten weeks go into presets or a wearable, and the pocket coach never finishes. |
