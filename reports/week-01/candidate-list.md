# Candidate list — Week 01

The wide search behind [the alternatives](../../docs/research/alternatives.md), kept so a later week does not repeat it.
Searched on 2026-09-29 through review sites, "alternatives to" pages, app help centers, and GitHub.
Problem space: see the top of [the alternatives](../../docs/research/alternatives.md).

<!-- TODO(team): add the candidates the two people outside the team suggested (guide: "ask two people outside your team"), with who asked (by role, not name). -->

| # | Candidate | Kind | URL | Why it might be relevant | Decision |
| --- | --- | --- | --- | --- | --- |
| 1 | Runna | Direct competitor | <https://www.runna.com/> | Subscription app with adaptive plans that react to skipped runs and speed sessions. | **Kept as ALT-01.** The product a phone-only runner would pick today. |
| 2 | Garmin Coach | Direct competitor, hardware-bound | <https://support.garmin.com/en-US/?faq=IkvWNeIoSd48GIYCjkhlo7> | Free adaptive plans driven by watch metrics. | **Kept as ALT-02.** The most adaptive product, and the one a watch owner already has. |
| 3 | Nike Run Club plans | Direct competitor, free | <https://www.nike.com/running/training-plans> | Free 8 to 18 week plans with audio-guided runs. | Cut: its official pages document no adaptation to completed runs, so as a comparison point it overlaps with Hal Higdon. Reconsider if we study guided-run audio. |
| 4 | TrainAsONE | Direct competitor, AI | <https://trainasone.com/how-it-works> | Rebuilds the plan from synced watch data with a neural network. | Cut: too close to Garmin Coach in approach (watch-driven, opaque model); two clones tell us nothing. First replacement if ALT-02 has to be dropped. |
| 5 | ASICS Runkeeper plans | Direct competitor | <https://help.runkeeper.com/en/hc/runkeeper-training-plans> | Paid plans; "Running for Exercise" generates new workouts weekly from what was completed. | Cut: overlaps with Runna on compliance-based adaptation, with less documentation. |
| 6 | Strava training plans and Athlete Intelligence | Platform | <https://support.strava.com/en-us/articles/15401942-training-plans-for-runners> | New running plans are now powered by Runna; AI activity summaries for subscribers. | Cut: its plans are Runna's, already ALT-01. |
| 7 | COROS Training Hub | Direct competitor, hardware-bound | <https://support.coros.com/hc/en-us/articles/360048955151-Creating-and-Using-Training-Plans> | Self-built and coach-library plans synced to the watch. | Cut: no automatic adaptation documented, and hardware-bound like ALT-02. |
| 8 | TrainingPeaks | Plan marketplace | <https://www.trainingpeaks.com/> | Coach-written plans for sale, including Hal Higdon's. | Cut: sells static plans, covered by ALT-03. |
| 9 | TrainingPeaks CoachMatch | Adjacent substitute, human coach | <https://www.trainingpeaks.com/coach-match/> | Matches a runner with a human coach from $149 per month. | Cut: a human coach is the ceiling on explanation, but not a product we can compare on the same properties. Used as the price anchor in the rejected gaps. |
| 10 | Final Surge | Coach-athlete log | <https://www.finalsurge.com/> | Free workout log and plan tool for athletes and coaches. | Cut: a log for coaches to push plans, not a coach itself. |
| 11 | Hal Higdon plans and Run With Hal | Adjacent substitute, static plan | <https://www.halhigdon.com/training-programs/half-marathon-training/novice-1-half-marathon/> | Free printable schedule; optional paid app that reschedules on compliance. | **Kept as ALT-03.** What many runners use instead of an app. |
| 12 | ChatGPT-generated plans | Adjacent substitute, generic LLM | <https://chatgpt.com/overview/> | Runners ask a chatbot for a plan. | Cut: no documented running feature and not reproducible run to run, so claims could not be checked. Worth revisiting if the customer raises it. |
| 13 | Apple Watch Custom Workouts | Adjacent substitute, DIY | <https://support.apple.com/guide/watch/create-a-custom-workout-apd66fcd5c5c/watchos> | Build structured interval workouts on the watch. | Cut: workouts, not plans; no adaptation. |
| 14 | intervals.icu | Free platform, closed source | <https://www.intervals.icu/pricing/> | Free training-load analysis and calendar. | Cut: free but not open source, so it does not fill the open-source slot. |
| 15 | GoldenCheetah | Open source (GPL-2.0) | <https://github.com/GoldenCheetah/GoldenCheetah> | Desktop analysis with CTL/ATL/TSB and, since v3.8, a plan calendar. | **Kept as ALT-04.** The only maintained open-source option with load analysis and planning. |
| 16 | Runalyze | Formerly open source, now freemium | <https://github.com/Runalyze/Runalyze> | Running analysis; the open-source version is archived and discontinued. | Cut: the open-source version was last released in 2018. |
| 17 | FitTrackee | Open source (AGPL-3.0), self-hosted | <https://github.com/SamR1/FitTrackee> | Self-hosted workout tracker. | Cut: tracks, does not coach. |
| 18 | OpenTracks | Open source (Apache-2.0), Android | <https://github.com/OpenTracksApp/OpenTracks> | Privacy-focused phone GPS tracker; the GitHub mirror is archived and development moved to Codeberg. | Cut: tracks, does not coach. Possible recording source for our product's imports. |
