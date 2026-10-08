# Gap Analysis

Each gap passes the four tests in the course's process requirements: someone needs it, the alternatives do not serve it, it is reachable, and a team of 3 or 4 can build it in this course.
Evidence points at rows of [the comparison](comparison.md) and at [the alternatives](alternatives.md) by `ALT-nn`.
Gaps are sorted by strength of evidence.

## GAP-01

The runner is not told why the plan changed

- **Status:** Active
- **Who needs it and what they cannot do:** a recreational runner whose plan changes after a missed or difficult week.
  Today they either get a changed plan with no reason, or no change at all, so they cannot judge whether to trust the new workout or override it.
- **Evidence:** row P2 of [the comparison](comparison.md#table), candidate C1.
  Only ALT-01 documents showing a reason, and only for pace changes from speed sessions; its skip-driven recalibration shows none.
  ALT-02 does not document any explanation.
  ALT-03 and ALT-04 do not change the plan automatically, so they have nothing to explain.
- **What closing it looks like:** every automatic change to the plan comes with a one-screen explanation naming the run or runs that caused it, the rule that fired, and what the plan would have been otherwise, with an option to revert.
- **Buildable by us in this course:** yes.
  It is a change log attached to a rule-based plan engine; the rules are ours, so we can always say which one fired.
- **Confidence:** medium.
  Strong for ALT-01, ALT-03, and ALT-04; for ALT-02 the absence is in the documentation and has not been checked on a device.

## GAP-02

No adaptation from how a phone-recorded run actually went

- **Status:** Active
- **Who needs it and what they cannot do:** a beginner or returning runner without a sports watch, often on a walk/run plan, whose runs go slower or shorter than planned.
  The products that adapt to performance need a Garmin watch (ALT-02) or exclude walk/run sessions (ALT-01); the rest adapt only to whether a run happened (ALT-01 skip logic, ALT-03 app).
- **Evidence:** rows P1 and P3 of [the comparison](comparison.md#table), candidate C2.
- **What closing it looks like:** after each run recorded on the phone or entered by hand, the product compares planned and actual distance, duration, and a perceived-effort rating, and adjusts the next sessions, including walk/run intervals.
- **Buildable by us in this course:** yes, if we use phone GPS or manual entry plus a perceived-effort rating (RPE) rather than heart rate.
  Building our own GPS recorder is not required; manual entry and file import are enough for the first release.
- **Confidence:** medium to high.
  The Garmin hardware requirement and the Runna walk/run exclusion are both stated in official help articles.
- **Rests on:** [ASM-02](../assumptions.md#asm-02).
- **Changed:**
  - Dropped the perceived-effort rating as a first-release input: the `Customer` ruled out typed health data, per [`DEC-003`](../decisions.md#dec-003), so the closing test above is to be restated when action point A1 in [the kickoff report](../../reports/week-01/meeting-report.md#action-points) re-scores this file against the in-run voice coach.

## GAP-03

Training load is measured but not connected to the plan

- **Status:** Active
- **Who needs it and what they cannot do:** a runner increasing volume toward a half marathon, who wants the plan to hold them back when they ramp up too fast.
  Where load is computed (ALT-02 load ratio, ALT-04 CTL/ATL/TSB), it is shown as a chart and is not documented as changing the plan; where there is a plan (ALT-01, ALT-03), recovery is scheduled by fixed rules, not measured.
- **Evidence:** row P7 of [the comparison](comparison.md#table), candidate C3.
- **What closing it looks like:** a simple, documented load measure (for example session RPE multiplied by duration) whose acute-to-chronic ratio, when it crosses a stated threshold, reduces the next week's volume and says so.
- **Buildable by us in this course:** yes, as a rule on top of GAP-02's inputs.
  We would not claim injury prevention; see the rejected list.
- **Confidence:** medium.
  ALT-02's documentation is silent rather than negative, so Garmin may already do this without saying so.

## Gaps we chose not to pursue

| Candidate | Why we rejected it |
| --- | --- |
| C4. Closed coaching apps are not portable (row P6) | Real for ALT-01, but ALT-02 exports runs and ALT-04 exports everything. A beginner in our problem space is unlikely to choose an app for its export. We will export our own data as a matter of course, but it is not a differentiator. |
| C5. Free options do not adapt, adaptive options cost money or hardware (rows P1, P5) | A price position, not a need. It is a consequence of GAP-02, not a separate gap, and a lower price is copied in a day. |
| Injury prediction or diagnosis | Needs medical validation we cannot do in this course, and a wrong answer causes harm. GAP-03 only adjusts volume and says so; it does not predict injury. |
| Human-coach quality at app prices | TrainingPeaks CoachMatch shows the human alternative costs $149 or more per month. Matching a human coach is not reachable by a team of 3 or 4 in ten weeks. |
| Our own GPS run recorder | Phone and watch apps already record runs well. Recording is not where any alternative fails; adaptation is. We will import or accept manual entry instead. |
