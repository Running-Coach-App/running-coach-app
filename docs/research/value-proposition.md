# Value Proposition

Each value proposition closes at least one gap from [the gap analysis](gap-analysis.md), names what it costs, and says how a competitor would respond.

## VP-01: A plan that shows its reasoning

**User:** recreational runner training for a 5K to half marathon who has had a plan change on them without a reason.
**Problem:** when a plan adapts, the runner cannot see which run caused the change or which rule fired, so they cannot decide whether to trust it.
**What we do that the alternatives do not:** every automatic change comes with a short explanation naming the runs that caused it, the rule, and the workout it replaced, with a one-tap revert.
Measured by: 100% of automatic plan changes have an explanation the runner can open, and the runner can revert any change.
**Closes:** [GAP-01](gap-analysis.md#gap-01-the-runner-is-not-told-why-the-plan-changed), and the visible half of [GAP-03](gap-analysis.md#gap-03-training-load-is-measured-but-not-connected-to-the-plan).
**What it costs:** the plan engine has to be rule-based and simple enough to explain in a sentence, so it will be less sophisticated than Garmin's (ALT-02) multi-signal model.
We give up opaque cleverness for trust.
**How a competitor would respond:** Runna (ALT-01) already has the pattern for Pace Insights and could extend it to skip-driven changes in a release.
The explanation screen is not a moat; the moat, if any, is that our whole engine is designed to be explainable, so there is no change we cannot explain.

## VP-02: Adaptive coaching with only a phone, including walk/run

**User:** beginner or returning runner without a sports watch, often starting on walk/run intervals.
**Problem:** the products that adapt to how a run went need a Garmin watch or exclude walk/run, so this runner gets either a static plan or adaptation to attendance only.
**What we do that the alternatives do not:** adapt the next sessions, including walk/run intervals, from planned-versus-actual distance and duration and a perceived-effort rating, entered on the phone or imported from a file.
Measured by: a runner with no watch receives an adjusted next session within one minute of logging a run.
**Closes:** [GAP-02](gap-analysis.md#gap-02-no-adaptation-from-how-a-phone-recorded-run-actually-went), and the load half of [GAP-03](gap-analysis.md#gap-03-training-load-is-measured-but-not-connected-to-the-plan).
**What it costs:** perceived effort is a noisier signal than heart rate, and asking for it after every run adds a step the runner may skip.
We also give up the sleep and stress inputs a watch provides.
**How a competitor would respond:** Runna could include walk/run sessions in Pace Insights, and Garmin will not target phone-only runners because selling watches is the point.
Runna is the real threat to this proposition, and we cannot out-feature it; `VP-01` is what would keep a runner with us.

## Assumptions

| Assumption | Supports | How to check, and when |
| --- | --- | --- |
| Runners distrust or override plan changes they are not given a reason for. | GAP-01, VP-01 | Ask three recreational runners outside the team what they did the last time their app changed a workout; Week 2. |
| Garmin Coach does not show the reason for a change on the watch or in Connect. | GAP-01 | A team member or a friend with a Run Coach-compatible watch screenshots a changed workout; Week 2. |
| A meaningful share of beginners train without a sports watch. | GAP-02, VP-02 | Ask the customer at the kickoff; then ask five beginner runners in Week 2 what they record runs with. |
| Runners will enter a perceived-effort rating after most runs. | VP-02, GAP-03 | Measure the rate in the Week 7 usability test. |
| Session RPE times duration is a good enough load signal to justify reducing volume. | GAP-03 | Check the sports-science literature on session RPE in Week 2 and record the source in `docs/`. |
| The customer accepts a rule-based engine rather than a machine-learning one. | VP-01 | Present it at the Week 1 kickoff. |
