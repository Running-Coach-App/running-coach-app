# Value Proposition

Each value proposition closes at least one gap from [the gap analysis](gap-analysis.md), names what it costs, and says how a competitor would respond.
The assumptions these propositions rest on are in [the assumptions log](../assumptions.md), and the decisions that changed them are in [the decisions log](../decisions.md).

The 2 October kickoff changed which proposition leads. The customer asked for a voice in the ear during the run. [GAP-01](gap-analysis.md#gap-01) was not confirmed, so a plan that explains its own changes is not a proposition in this file. Phone-only and beginner-to-intermediate did survive, and that is the user in [GAP-02](gap-analysis.md#gap-02).

## VP-01

An in-run voice coach that answers spoken questions about the current run's time, pace, or distance

- **Status:** Active
- **User:** a beginner to intermediate runner, often without a sports watch, who will not keep looking at the phone.
- **Problem:** the products he can already use show pace, distance, and heart rate on a screen. He has to take the phone out to know them, and nothing talks him through the run.
- **What we do that the alternatives do not:** during the run the phone speaks encouragement, a simple intensity cue (hard, then easier, then jog), and the stats it already has: time, pace, distance, and heart rate when a connected device provides it. The runner can ask aloud for the current run's time, pace, or distance and hear that answer. The runner can set how often the stats are spoken. After the run it speaks a short summary. The first release is English, on Android, and processes on the phone where we can.
- **Measured by:** on a phone with no watch, the runner hears time, pace, and distance at least once every three minutes without opening the screen, hears the hard/easy cue in a preset interval session, and can ask aloud for time, pace, or distance and hear the requested current statistic.
- **Closes:** [GAP-02](gap-analysis.md#gap-02).
- **Rests on:** [ASM-01](../assumptions.md#asm-01), [ASM-02](../assumptions.md#asm-02), [ASM-03](../assumptions.md#asm-03), [ASM-04](../assumptions.md#asm-04), [ASM-06](../assumptions.md#asm-06), [ASM-07](../assumptions.md#asm-07), [ASM-08](../assumptions.md#asm-08).
- **What it costs:** without a watch we cannot promise heart rate, so the coach speaks time, pace, and distance, and adds heart rate only when a wearable is connected. Keeping the processing on the phone limits how capable the spoken coach can be. We give up an adaptive training plan in the first release so this can ship.
- **How a competitor would respond:** Runna (ALT-01) and Garmin Coach (ALT-02) already own plan adaptation and could add spoken stats in a release. The customer uses Google Health and dislikes it because it makes him stare at the stats and does not talk. Spoken stats are not a deep moat. They are the part he said his current app does not do.
- **Changed:**
  - Rewritten from a plan that explains its own changes into the in-run voice coach, which the `Customer` described as the base, instead of the direction this file stated before the kickoff. This is not a decision, and [the kickoff report](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#action-points) carries the question forward as action point A2.
  - Expanded to include spoken questions about the current run's time, pace, or distance, per [DEC-008](../decisions.md#dec-008), which scopes the first release to reading stats aloud and answering simple verbal stats queries. [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) is the story for this scope; its criteria should cover each of the three supported statistics.

## VP-02

Two preset sessions on the voice coach, if the customer keeps them

- **Status:** Awaiting customer confirmation
- **User:** the same runner, once VP-01 works.
- **Problem:** if the customer still wants preset sessions, the runner should not have to design each interval. He asked for a small number of programmes after the talking coach is in place, but has not yet decided whether the presets stay in the first release.
- **What we do that the alternatives do not:** if the customer keeps them, offer two preset sessions on top of the voice coach, for example a steady run and a hard/easy interval. This release does not build a weekly plan that rewrites itself.
- **Measured by:** if the customer keeps the presets, the runner can start either one and hear its cues without looking at the phone.
- **Closes:** [GAP-02](gap-analysis.md#gap-02), as a fixed spoken session rather than a post-run rewrite. [GAP-01](gap-analysis.md#gap-01) and [GAP-03](gap-analysis.md#gap-03) are `Dropped` in [DEC-007](../decisions.md#dec-007).
- **Rests on:** [ASM-01](../assumptions.md#asm-01), [ASM-02](../assumptions.md#asm-02), [ASM-07](../assumptions.md#asm-07), [ASM-08](../assumptions.md#asm-08).
- **What it costs:** two presets cannot serve a runner who wants a race plan. We give up granular goal setting, meal advice, and automatic plan edits.
- **How a competitor would respond:** Runna (ALT-01) and Hal Higdon (ALT-03) already ship full plans. They do not need to answer two spoken presets. Copying their plans is not this proposition.
- **Changed:**
  - Narrowed from adaptive coaching with only a phone to two preset sessions, and placed after the in-run coach rather than alongside it, because the `Customer` asked for presets on top of the coach. Action point A2 in [the kickoff report](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-01/meeting-report.md#action-points) puts the order to him.
  - The Week 2 validation added spoken stat queries to the coach in [DEC-008](../decisions.md#dec-008); the customer has not confirmed that the two presets remain, so their inclusion stays conditional until that verdict.
