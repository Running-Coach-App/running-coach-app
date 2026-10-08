# Comparison

Rows are the properties fixed in [the alternatives](alternatives.md#properties) before any product was evaluated.
Columns are [ALT-01 Runna](alternatives.md#alt-01), [ALT-02 Garmin Coach](alternatives.md#alt-02), [ALT-03 Hal Higdon](alternatives.md#alt-03), and [ALT-04 GoldenCheetah](alternatives.md#alt-04).

Each cell is written as **Observed:** what the source says, followed by **Reading:** what we conclude from it for the runner in our problem-space sentence.
The reading is ours and can be disputed; the observation can be checked in the cited `ALT-nn` section.

## Table

| Property | ALT-01 Runna | ALT-02 Garmin Coach | ALT-03 Hal Higdon | ALT-04 GoldenCheetah |
| --- | --- | --- | --- | --- |
| **P1** When my run differs from the plan, does the plan change, and what triggers it? | **Observed:** a skipped run triggers recalibration; realignment only after more than 3 missed workouts or a week; Pace Insights proposes new paces from speed sessions only (ALT-01). **Reading:** adapts to skipping and to fast speed sessions, not to an easy run that went badly. | **Observed:** Run Coach changes day to day from performance and health metrics; missed workouts cannot be rescheduled (ALT-02). **Reading:** the most adaptive, but only on its own terms and its own hardware. | **Observed:** free plan never changes; paid app reschedules on compliance and settings (ALT-03). **Reading:** adaptation is attendance-based; how the runs went is not an input. | **Observed:** no automatic adaptation; manual drag-and-drop (ALT-04). **Reading:** the runner is the coach. |
| **P2** When the plan changes, am I told why? | **Observed:** yes for Pace Insights, with contributing workouts and a revert option; nothing documented for skip-driven changes (ALT-01). **Reading:** the best in the set, but covers one kind of change. | **Observed:** not documented in any official FAQ or the blog we read (ALT-02). **Reading:** unverified; our confidence is medium until someone sees it on a device. | **Observed:** static plan explains its structure in prose; app not verified (ALT-03). **Reading:** explains the plan, not changes to it. | **Observed:** no changes to explain; adherence chart shows missed and shifted runs (ALT-04). **Reading:** shows what happened, not what to do about it. |
| **P3** What must I own or record? | **Observed:** phone alone works; syncs with four watch brands (ALT-01). **Reading:** lowest hardware barrier among the adaptive products. | **Observed:** compatible Garmin watch required; Run Coach only on newer models (ALT-02). **Reading:** excludes phone-only runners completely. | **Observed:** nothing for the free plan; app syncs only with Garmin (ALT-03). **Reading:** no barrier, because nothing is measured. | **Observed:** device files, copied to a desktop; zones must be set for running load (ALT-04). **Reading:** high effort per run for a phone-only runner. |
| **P4** What must I do before my first workout? | **Observed:** plan type, ability, mileage, runs per week, goal, preview (ALT-01). **Reading:** a guided questionnaire a beginner can answer. | **Observed:** similar questionnaire; without a VO2 max estimate the plan starts with benchmark workouts (ALT-02). **Reading:** a new watch owner does test runs before real training. | **Observed:** pick a plan and check a written prerequisite (ALT-03). **Reading:** fastest start, but the runner self-assesses fitness. | **Observed:** install, create athlete, set zones, import; no goal questionnaire (ALT-04). **Reading:** not designed for someone who wants to be told what to run. |
| **P5** What is free, what is paid? | **Observed:** $119.99 per year; free users get week 1 only; monthly users see 4 weeks ahead (ALT-01). **Reading:** the adaptive features are fully paywalled. | **Observed:** free with the watch; Connect+ adds content only (ALT-02). **Reading:** cost is the device, which is a one-time barrier of a different size. | **Observed:** free plan; app $59.99 per year (ALT-03). **Reading:** cheapest, and the paid tier is where the adaptation is. | **Observed:** free, GPL-2.0 (ALT-04). **Reading:** free in money, expensive in time. |
| **P6** Can I take my runs and plan elsewhere? | **Observed:** no documented export; deletion removes all data (ALT-01). **Reading:** lock-in risk, softened by sync to Garmin and Strava. | **Observed:** FIT, TCX, GPX per activity; developer API is business-only; plan export not documented (ALT-02). **Reading:** runs are portable, plans are not. | **Observed:** PDF portable; app export not verified (ALT-03). **Reading:** portable because it is paper. | **Observed:** full export including schedules (ALT-04). **Reading:** the best in the set. |
| **P7** Is load or fatigue measured, and does it change the plan? | **Observed:** no load metric; rule-based deloads and a manual "not feeling 100%" option (ALT-01). **Reading:** recovery is scheduled, not measured. | **Observed:** acute and chronic load and a load ratio exist; not documented as changing Run Coach (ALT-02). **Reading:** the metric exists, the link to the plan is invisible. | **Observed:** rest days in the schedule; no metric (ALT-03). **Reading:** recovery is scheduled, not measured. | **Observed:** CTL, ATL, TSB fully documented; never changes the plan (ALT-04). **Reading:** the metric is transparent, but disconnected from any plan. |

## What the table shows

Read as a whole, the table shows five candidate patterns.
Each one is either a gap in [the gap analysis](gap-analysis.md) or a rejected candidate there.

1. **C1. Explaining a change is rare.**
   Row P2: only ALT-01 documents it, and only for speed-session pace changes.
   Became [GAP-01](gap-analysis.md#gap-01).
2. **C2. Adaptation is tied either to specific hardware or to attendance only.**
   Rows P1 and P3: ALT-02 adapts from rich signals but needs a Garmin watch; ALT-01 and ALT-03 adapt to skipped runs, not to how a completed run went; ALT-01 excludes walk/run from pace adaptation.
   Became [GAP-02](gap-analysis.md#gap-02).
3. **C3. Where load is measured, it does not visibly change the plan.**
   Row P7: ALT-02 and ALT-04 both compute an acute/chronic load model, and neither documents it changing the plan.
   Became [GAP-03](gap-analysis.md#gap-03).
4. **C4. The closed coaching apps are the least portable.**
   Row P6: ALT-01 has no documented export; ALT-04 is fully portable.
   Rejected, see [gaps we chose not to pursue](gap-analysis.md#gaps-we-chose-not-to-pursue).
5. **C5. The free options do not adapt, and the adaptive options are paid or need hardware.**
   Rows P1 and P5.
   Rejected as a gap in itself, see [gaps we chose not to pursue](gap-analysis.md#gaps-we-chose-not-to-pursue).

**Reading down the columns:** ALT-02 is the strongest product for a runner who owns a recent Garmin watch, and ALT-01 is the strongest for everyone else.
ALT-01 is the product we could lose to, and the bar for our work.
