# Week 9 meeting script

## Context

Our problem-space sentence: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal), and [the threshold of success](../../docs/threshold-of-success.md) is the bar for it.

What we believe: the build on the university VM lets a runner start a session, hear and ask for their stats, and stop it, all with the phone in a pocket; the usage-data opt-out holds; and a stationary phone can still gain a few metres ([#251](https://github.com/Running-Coach-App/running-coach-app/issues/251)).

The meeting is `SPRINT-09`'s Sprint Review, held as a live video call because the `Customer` is travelling. The VM is reachable only from the university network, so a teammate on campus runs the three acceptance tests on a phone installed from it while the `Customer` watches and judges each one.

Target: the `Customer`'s verdict on [`UAT-01` to `UAT-03`](../../docs/user-acceptance-tests.md#the-tests), and what he expects to receive at the handoff.

## Agenda

1. **Permission (2 min).** Show nothing. Questions 1–3.
2. **The three acceptance tests (18 min).** Show the phone on camera, with the app installed from the VM's production page, and [the UAT record](../../docs/user-acceptance-tests.md) on screen. Run [`UAT-01`](../../docs/user-acceptance-tests.md#uat-01), then [`UAT-02`](../../docs/user-acceptance-tests.md#uat-02), then [`UAT-03`](../../docs/user-acceptance-tests.md#uat-03), reading each expected result aloud before the run. Questions 4–7.
3. **Quality and threshold (5 min).** Show [the quality requirement testing plan](../../docs/project-plan.md#quality-requirement-testing-plan) and [`TOS-03`](../../docs/threshold-of-success.md#tos-03). Questions 8–9.
4. **Open items from Week 8 (4 min).** Show [the v0.6.1 release page](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.6.1). Questions 10–11.
5. **Handoff expectations (6 min).** Show nothing. Questions 12–14.
6. **Read back (3 min).** Show nothing. Read back every verdict, decision, and action point with its owner and due date.

Total: 38 minutes.

## Questions

1. (closed) May we record this meeting, for the team and the course instructors only?
2. (closed) May we publish a sanitized transcript in the public repository?
3. (closed) May we quote you by role, as "the Customer", in the public report?
4. (closed) **`UAT-01`: did the session start, speak, and stop by voice as the expected result says — pass or fail?**
5. (closed) **`UAT-02`: was each question answered with the stat you asked for — pass or fail?**
6. (closed) **`UAT-03`: did the session after turning usage data off leave the exported records unchanged — pass or fail?**
7. (open) What did you expect to happen in these three runs that did not?
8. (closed) Do you accept the answers heard in `UAT-02` as `TOS-03`'s evidence: a spoken question answered on the phone with no server?
9. (open) Two quality checks have no result yet: releasing the location fix and the usability test. What would you need to see from the usability sessions with other runners to judge the product's direction?
10. (closed) Is the signed release build the one you want to install from now on?
11. (closed) Is three minutes still the right default for the stats line?
12. (open) **What do you expect to receive at the handoff on 6 December?**
13. (open) What access do you need after the handoff: the APK, the VM, the source, or something else?
14. (open) What would make you not accept the handoff?

## Roles

- Moderator: sirjaey.
- Runs the tests on campus: Ezekiel-Gadzama.
- Note taker: ObeTech1, with the open threshold goal and its measure ([`TOS-03`](../../docs/threshold-of-success.md#tos-03)) and the recorded quality results ([`QR-07` and `QR-09` not verified, the other five passing](../../docs/project-plan.md#quality-requirement-testing-plan)) in front of them.

## Key improvements

- Before: "What do you think of the app now?"
- After: "`UAT-01`: did the session start, speak, and stop by voice as the expected result says — pass or fail?"
- Principle: ask for a verdict against a criterion written before the meeting, so the answer is a result the team can record rather than an impression it has to interpret.
