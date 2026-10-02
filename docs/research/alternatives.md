# Alternatives

**Problem space:** a recreational runner training for a 5K to half-marathon race, often without a sports watch, needs a training plan that changes when their real runs differ from the plan and tells them why it changed, so they can trust it enough to keep following it.

Sources were read on 2026-09-29 unless a section says otherwise.
The full search, including the candidates we cut, is in [the candidate list](../../reports/week-01/candidate-list.md).

<!-- TODO(team): replace BOARD_LINK below with the view-only Miro/Figma board URL once it exists, and add frame names per ALT-nn. -->

## Properties

We fixed these seven properties before evaluating any product.
Each is written as a question a runner in the problem space would ask.

| ID  | Property          | The question behind it                                                                                         |
| --- | ----------------- | -------------------------------------------------------------------------------------------------------------- |
| P1  | Plan adaptation   | When my run goes differently from the plan (missed, shorter, slower, faster), does the plan change, and what triggers it? |
| P2  | Explainability    | When the plan changes, am I told why, in terms I can check?                                                    |
| P3  | Input requirements | What must I own or record for the product to work: a specific watch, heart rate, phone GPS, or manual entry?   |
| P4  | Onboarding        | What do I have to answer and do before my first planned workout?                                               |
| P5  | Cost model        | What is free, what is paid, and what do I lose if I stop paying?                                               |
| P6  | Data portability  | Can I take my runs and my plan somewhere else (FIT, GPX, CSV, API)?                                            |
| P7  | Load and recovery | Does the product measure training load or fatigue, and does that measurement change the plan?                  |

## ALT-01: Runna

**Kind:** direct competitor.
**Link:** <https://www.runna.com/>
**Version looked at:** help-center articles and pricing page as published on 2026-09-29.
**Depth of evaluation:** read the official help center (plan creation, skipping, realignment, Pace Insights, recovery, subscription, account deletion) and the pricing page.
<!-- TODO(team): install the app, create a 5K plan, skip one run, and record what happened. Update this line with that depth. -->
Did not use the app hands-on in this pass.

**Problem it solves:** gives a runner a structured, subscription-based plan toward a race or distance goal, which adjusts when sessions are skipped and suggests new paces from speed sessions.

**Observations by property**

| Property | Observation |
| --- | --- |
| P1 Plan adaptation | Skipping a single run makes the plan "adapt around your completed sessions"; rearranging a run to another day does not trigger recalibration ([skipping a run](https://support.runna.com/en/articles/15012850-how-and-when-to-skip-a-run-managing-missed-sessions-in-your-training-plan)). After more than 3 missed workouts or a missed week, left unticked and unskipped, Plan Realignment offers to extend, rebuild, restart, or continue, and the choice cannot be undone ([Plan Realignment](https://support.runna.com/en/articles/10026375-how-to-use-the-plan-realignment-feature)). Pace Insights recommends new paces from intervals, tempo runs, time trials and some long runs; the user must accept ([Pace Insights](https://support.runna.com/en/articles/14656203-what-are-pace-insights-and-how-do-they-work)). |
| P2 Explainability | For Pace Insights, the Plan tab shows "Why you received your latest status" and which workouts contributed, with a chart of the last 5 speed workouts, and the change can be rejected or reverted ([Pace Insights](https://support.runna.com/en/articles/14656203-what-are-pace-insights-and-how-do-they-work)). For skip-driven recalibration, the help article describes no reason shown to the user. |
| P3 Input requirements | Phone-only recording works. Syncs with Garmin, Apple Watch, Fitbit and COROS ([Garmin with Runna](https://support.runna.com/en/articles/6169639-using-your-garmin-watch-with-runna), [pricing](https://www.runna.com/pricing)). Pace Insights excludes walk/run sessions and manually recorded workouts. |
| P4 Onboarding | Plan tab, then Create Plan, plan type (Race, Distance, Improvement, General), then ability level, current mileage, runs per week, and goal, then a preview ([creating a plan](https://support.runna.com/en/articles/15443877-how-to-create-a-training-plan-in-runna)). Time to first workout: not measured. |
| P5 Cost model | $19.99 per month or $119.99 per year (US), 7-day trial; free users get week 1 of any plan; monthly subscribers see 4 weeks ahead, annual subscribers the whole plan ([pricing](https://www.runna.com/pricing), [subscription](https://support.runna.com/en/articles/8112247-managing-your-runna-subscription)). |
| P6 Data portability | Account deletion permanently deletes all data and the article mentions no export ([deleting your account](https://support.runna.com/en/articles/10502455-deleting-your-runna-account)). We found no documented FIT, GPX, or CSV export and no public API. Completed runs do reach Garmin or Strava through sync. |
| P7 Load and recovery | No numeric load or fatigue metric is described as driving the plan. Recovery is rule-based: deload weeks, "Long Run Protection", tapers ([recovery](https://support.runna.com/en/articles/15272605-how-does-runna-build-recovery-into-your-training-plan)), and a manual "Not Feeling 100%" option of 3 to 14 days at 4 reduction levels ([feeling unwell](https://support.runna.com/en/articles/12809806-feeling-unwell-how-to-adapt-your-training-plan)). |

**Strengths**

- The only product in our set that documents showing the user why a change happened, with the contributing workouts and the option to revert (P2).
- Works from a phone alone, so a runner without a watch can start (P3).

**Weaknesses**

- A beginner on a walk/run plan gets no pace adaptation, because Pace Insights excludes walk/run sessions.
  This matters for the part of our problem space that starts from zero running fitness.
- Realignment only starts after more than 3 missed workouts or a whole week, and it cannot be undone, so a runner who misses two runs gets no adjustment and a runner who picks the wrong option cannot go back.
- No documented export, and deletion removes everything, so a runner who leaves loses their plan history.
- Monthly subscribers see only 4 weeks of their plan.

**Could not find out:** the logic behind skip-driven recalibration, and how long onboarding takes.

## ALT-02: Garmin Coach (Run Coach and Expert Running Plans)

**Kind:** direct competitor, bound to Garmin hardware.
**Link:** <https://support.garmin.com/en-US/?faq=IkvWNeIoSd48GIYCjkhlo7>
**Version looked at:** Garmin support FAQs at the content versions shown on 2026-09-29 (Garmin Coach FAQ v122.0, missed workouts FAQ v63.0, load FAQ v72.0), and the Garmin blog post of 28 April 2025.
**Depth of evaluation:** read the official support FAQs, the product blog, and the Connect+ pricing FAQ.
<!-- TODO(team): if a member owns a compatible Garmin watch, start a Run Coach plan and record the flow. -->
Did not use a Garmin device in this pass.

**Problem it solves:** gives a Garmin watch owner a free adaptive plan that changes daily from the watch's own performance and health measurements.

**Observations by property**

| Property | Observation |
| --- | --- |
| P1 Plan adaptation | Run Coach workouts "change day-to-day based on your performance and health metrics"; Expert plans adapt from benchmark runs ([Garmin Coach FAQ](https://support.garmin.com/en-US/?faq=IkvWNeIoSd48GIYCjkhlo7)). A missed workout cannot be rescheduled; "the plan automatically adjusts" ([missed workouts FAQ](https://support.garmin.com/en-US/?faq=o21H5a4cSU52FwFAy0R6Z5)). The blog names VO2 max, lactate threshold, training history, sleep, stress and recovery as inputs ([Garmin blog](https://www.garmin.com/en-US/blog/fitness/garmin-training-plans-for-runners/)). |
| P2 Explainability | None of the FAQs or the blog post we read says whether the user is shown why a workout changed. |
| P3 Input requirements | Needs a compatible Garmin watch; Run Coach runs only on newer models, and many older models get only Expert plans ([Garmin Coach FAQ](https://support.garmin.com/en-US/?faq=IkvWNeIoSd48GIYCjkhlo7)). The blog advises wearing the watch while asleep. |
| P4 Onboarding | In Garmin Connect: training focus, current weekly distance and average pace, goal distance, recommended plan, workouts per week, available days, long-run day, then race or end date. Without a VO2 max estimate the plan starts with benchmark workouts ([Garmin Coach FAQ](https://support.garmin.com/en-US/?faq=IkvWNeIoSd48GIYCjkhlo7)). |
| P5 Cost model | Free with a compatible device ([2018 press release](https://www.garmin.com/en-US/newsroom/press-release/sports-fitness/2018-train-for-a-5k-with-garmin-coach-free-adaptive-training-plans-from-garmin/)). Connect+ ($6.99 per month or $69.99 per year) adds guidance content ([Connect+ FAQ](https://support.garmin.com/en-US/?faq=awrd4J1Du94fqM3SxQ0biA)). The real cost is the watch. |
| P6 Data portability | Single activities export as FIT, TCX, or GPX ([export FAQ](https://support.garmin.com/en-US/?faq=BBISz2o26Z37QlY14mTLF9)). The Connect Developer Program is "only for business use" ([developer FAQ](https://developer.garmin.com/gc-developer-program/program-faq/)). We found no documented export of the plan itself. |
| P7 Load and recovery | Tracks acute load (7 days), chronic load (28 days), and a load ratio of acute to chronic ([training load FAQ](https://support.garmin.com/en-US/?faq=SEkNpdGyhR917js0qQL3Q6)). Daily Suggested Workouts use load and recovery, but are replaced by the Coach plan's workouts when a plan is active ([suggested workouts FAQ](https://support.garmin.com/en-US/?faq=oYknGZ910l1pfBNzkDHX6A)). The FAQs do not say whether the load ratio changes a Run Coach plan. |

**Strengths**

- The richest input signal in our set: sleep, stress, recovery, and measured fitness, all from one device (P1, P7).
- Free for anyone who already owns a compatible watch (P5).

**Weaknesses**

- A runner without a compatible Garmin watch cannot use Run Coach at all.
  This excludes the part of our problem space that runs with only a phone.
- A missed Run Coach workout cannot be moved by the runner, which is rigid for someone whose free days change week to week.
- The reason for a change is not documented as shown to the user, so a runner told to do less has to take it on trust.
- Expert plans assume 7:00 min/mile or slower and are generated in imperial units ([Garmin Coach FAQ](https://support.garmin.com/en-US/?faq=IkvWNeIoSd48GIYCjkhlo7)).

**Could not find out:** whether and how changes are explained in the app, the adaptation logic, and plan export.

## ALT-03: Hal Higdon plans (free static plans and the Run With Hal app)

**Kind:** adjacent substitute, a static printable schedule, with an optional paid app.
**Link:** <https://www.halhigdon.com/training-programs/half-marathon-training/novice-1-half-marathon/>
**Version looked at:** Novice 1 Half Marathon page and printable PDF, and Run With Hal help-center articles (updated between 2019 and 24 February 2026), on 2026-09-29.
**Depth of evaluation:** read the free plan and its printable PDF, and the app help center.
<!-- TODO(team): install Run With Hal, start the free plan, and record the onboarding. -->
Did not use the app hands-on in this pass.

**Problem it solves:** gives a runner a well-known, free, fixed schedule toward a race, which many runners print and follow on their own.

**Observations by property**

| Property | Observation |
| --- | --- |
| P1 Plan adaptation | The free plan is a fixed 12-week table; the runner is told "Don't be afraid to juggle the workouts" ([Novice 1 page](https://www.halhigdon.com/training-programs/half-marathon-training/novice-1-half-marathon/), [printable PDF](https://www.halhigdon.com/wp-content/uploads/2018/04/Novice-1-Half-Marathon-Printable.pdf)). The paid Hal+ app reschedules "based on your compliance with the plan" and when settings change ([what the plan adapts to](https://runwithhal.zendesk.com/hc/en-us/articles/360033786051-What-will-the-plan-adapt-to)). |
| P2 Explainability | The static plan explains its reasoning in prose on the page, but it never changes. We could not verify whether the app says why it rescheduled. |
| P3 Input requirements | Static plan: none, run by feel at "conversational pace". App: phone GPS; syncs only with Garmin, not Apple Watch, Strava, or others ([device sync](https://runwithhal.zendesk.com/hc/en-us/articles/360033786871-Can-I-sync-my-Apple-Watch-Strava-or-other-device-account)). |
| P4 Onboarding | Static plan: choose a plan and meet its prerequisite, "ability to run 3 miles, three to four times a week" ([Novice 1 page](https://www.halhigdon.com/training-programs/half-marathon-training/novice-1-half-marathon/)). App onboarding: not verified. |
| P5 Cost model | Web and PDF plans are free. The app is free with Hal+ at $6.99 per month or $59.99 per year ([app cost](https://runwithhal.zendesk.com/hc/en-us/articles/360033786711-How-much-does-the-app-cost)). The same plan on TrainingPeaks costs $29.95 ([TrainingPeaks listing](https://www.trainingpeaks.com/training-plans/running/half-marathon/tp-139213/hal-higdon-half-marathon-novice-1)). |
| P6 Data portability | The PDF is fully portable. We could not verify any app export or API. |
| P7 Load and recovery | Rest days and cross-training are written into the schedule, but there is no load metric in the free plan ([Novice 1 page](https://www.halhigdon.com/training-programs/half-marathon-training/novice-1-half-marathon/)). |

**Strengths**

- Zero cost and zero setup for the free plan: a runner can start today with a printout (P4, P5).
- The plan's reasoning is written out, so a runner understands the structure even though it never adapts (P2).

**Weaknesses**

- The free plan never adapts; after a missed week the runner decides alone how to "juggle" the schedule, which is exactly the decision a beginner is least equipped to make.
- The app adapts to compliance and settings only; no performance or fatigue signal is documented.
- The app syncs only with Garmin, so a runner recording on another device has to log runs twice.
- Most app help articles date from 2019, so current behaviour is uncertain.

**Could not find out:** app onboarding, whether the app explains changes, and export.

## ALT-04: GoldenCheetah

**Kind:** open-source, self-hosted desktop software (GPL-2.0).
**Link:** <https://github.com/GoldenCheetah/GoldenCheetah>
**Version looked at:** v3.8, released 2026-09-20 ([release notes](https://github.com/GoldenCheetah/GoldenCheetah/releases/tag/v3.8)), and the project wiki, on 2026-09-29.
**Depth of evaluation:** read the v3.8 release notes, the Plan chart wiki page, the running FAQ, and the first-steps guide.
<!-- TODO(team): install v3.8, import one of your own runs (FIT/GPX), and add a planned activity. Record what you saw. -->
Did not install it in this pass.

**Problem it solves:** gives a technical athlete full local control of their training data, with load analysis (CTL, ATL, TSB) and, since v3.8, a manual training calendar.

**Observations by property**

| Property | Observation |
| --- | --- |
| P1 Plan adaptation | No automatic adaptation and no plan generation. v3.8 adds planned activities, a calendar, plan adherence, and an "Expected PMC" chart; rescheduling is manual, by drag and drop ([release notes](https://github.com/GoldenCheetah/GoldenCheetah/releases/tag/v3.8), [Plan chart wiki](https://github.com/GoldenCheetah/GoldenCheetah/wiki/UG_ChartTypes_Plan)). |
| P2 Explainability | Nothing changes automatically, so there is nothing to explain. The Plan Adherence chart shows completed, shifted, missed, and unplanned activities ([Plan chart wiki](https://github.com/GoldenCheetah/GoldenCheetah/wiki/UG_ChartTypes_Plan)). |
| P3 Input requirements | Imports files from most devices (FIT, TCX, GPX and others); some devices need files copied manually ([import guide](https://github.com/GoldenCheetah/GoldenCheetah/wiki/UG_First-Steps_Download-or-import)). Running load needs pace zones or critical velocity set up first ([running FAQ](https://github.com/GoldenCheetah/GoldenCheetah/wiki/FAQ-RUNNING-&-SWIMMING)). |
| P4 Onboarding | Install the desktop app, create an athlete, set zones, import data ([first steps](https://github.com/GoldenCheetah/GoldenCheetah/wiki/UG_First-Steps_What-you-need-to-do)). No goal-race questionnaire. |
| P5 Cost model | Free and open source ([repository](https://github.com/GoldenCheetah/GoldenCheetah)). |
| P6 Data portability | Local files; exports to FIT, TCX, GPX, PWX, CSV, and GC JSON ([activity menu](https://github.com/GoldenCheetah/GoldenCheetah/wiki/UG_Menu-Bar_Activity)); v3.8 adds schedule export and import. |
| P7 Load and recovery | Performance Management Chart with CTL (42 days), ATL (7 days) and TSB, with GOVSS and TRIMP for running ([glossary](https://github.com/GoldenCheetah/GoldenCheetah/wiki/UG_Glossary)). "Expected PMC" projects load from planned activities, but the plan is never changed from it. |

**Strengths**

- The most transparent load model in our set: every number is documented and computed locally (P7).
- Complete data ownership and export (P6).

**Weaknesses**

- Desktop only, with no phone app, and built around cycling; a recreational runner would need to copy files from a phone or watch to a computer after every run.
- No plan generation or adaptation, so the load numbers never turn into an adjusted workout; the runner has to interpret CTL and TSB themselves.
- Onboarding assumes the user knows what critical velocity and pace zones are.

**Could not find out:** the exact athlete fields asked at setup.
