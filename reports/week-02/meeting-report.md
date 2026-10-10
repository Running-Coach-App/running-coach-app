# Week 2 validation meeting report

## Metadata

- **Date:** 2026-10-09
- **Duration:** not applicable, held asynchronously in writing.
- **Attended:** sirjaey, Ezekiel-Gadzama, Obetech1, JustACommonMan-OSDD, Customer
- **Presented:** the Week 2 material as links in writing: the product vision, the value proposition, the gap analysis, the context diagram, the decisions log, the assumptions log, and the spoken cue prototype screenshot.
- **Recording:** not applicable, held in writing.
- **Transcript publication:** not refused, see [the transcript](meeting-transcript.md).
- **Transcript shared privately:** not applicable.
- **Transcript:** [meeting-transcript.md](meeting-transcript.md)
- **Script:** [meeting-script.md](meeting-script.md)

## Previous action points

| Action | Outcome | Decision |
| --- | --- | --- |
| [`reports/week-01/meeting-report.md`](../week-01/meeting-report.md#action-points): "Rewrite the problem-space sentence and re-score the gap analysis against a real-time audio coach, then decide whether `VP-01` survives as our lead proposition or is replaced." | Carried out before this exchange: the problem-space sentence is rewritten in [the product vision](../../docs/product-vision.md), and [VP-01](../../docs/research/value-proposition.md#vp-01) leads in [the value proposition](../../docs/research/value-proposition.md). This exchange closed the re-scoring: [`GAP-01`](../../docs/research/gap-analysis.md#gap-01) and [`GAP-03`](../../docs/research/gap-analysis.md#gap-03) are `Dropped` in [the gap analysis](../../docs/research/gap-analysis.md). | [DEC-007: Drop GAP-01 and GAP-03.](../../docs/decisions.md#dec-007) |
| [`reports/week-01/meeting-report.md`](../week-01/meeting-report.md#action-points): "Put the divergence to the `Customer` directly at the next meeting: show him `VP-01` and ask whether an adaptive training plan is wanted at all, or whether the in-run coach is the whole product." | Carried out in this exchange: the in-run coach is the whole product, and no adaptive training plan is wanted. The coach reads available stats aloud and answers simple verbal stats queries. | [DEC-007: Drop GAP-01 and GAP-03.](../../docs/decisions.md#dec-007), [DEC-008: Scope the first release to reading stats aloud and answering simple verbal stats queries, with Gemma as the candidate engine.](../../docs/decisions.md#dec-008) |
| [`reports/week-01/meeting-report.md`](../week-01/meeting-report.md#action-points): "Confirm the next meeting slot offline and send the invitation. The `Customer` asked for 08:00 WAT if the team can manage it; the team offered 08:30." | Superseded: no live slot was fixed, because the `Customer` agreed to skip the live meeting and answered in writing instead. The substitution is declared as a deviation in [the Week 2 report](README.md#deviations). | None |
| [`reports/week-01/meeting-report.md`](../week-01/meeting-report.md#action-points): "Ask the `Customer` whether a rule-based engine is acceptable rather than machine learning. The assumption table lists this as "present it at the Week 1 kickoff"; it was not asked." | Carried out in this exchange: fixed spoken cues stand, and a small model answers the verbal queries. The `Customer` suggested Gemma for that part. See [the prototype record](prototypes.md). | [DEC-008: Scope the first release to reading stats aloud and answering simple verbal stats queries, with Gemma as the candidate engine.](../../docs/decisions.md#dec-008) |
| [`reports/week-01/meeting-report.md`](../week-01/meeting-report.md#action-points): "Research on-device text-to-speech and small-model options for Android, starting from the `Customer`'s own suggestion of Gemma, and report feasibility within the ten weeks." | Not carried out: feasibility is still unknown, and the due date of Thu 8 Oct 2026 has passed. It reappears below with a new due week. | None |
| [`reports/week-01/meeting-report.md`](../week-01/meeting-report.md#action-points): "Ask the three unasked starred questions from `meeting-script.md` (Q3, Q7, Q10) at the next meeting." | Not carried out live: Q3 is moot now that no adaptive plan is wanted, and Q7 and Q10 were not asked. The two that still matter reappear below with a new due week. | None |

## Previous open questions

| Question | Answer | Decision |
| --- | --- | --- |
| [`reports/week-01/meeting-report.md`](../week-01/meeting-report.md#open-questions): "Does the `Customer` want an adaptive **training plan** at all, or only the in-run coach?" | Only the in-run coach: the coach reads available stats aloud and answers simple verbal stats queries. [`GAP-01`](../../docs/research/gap-analysis.md#gap-01) and [`GAP-03`](../../docs/research/gap-analysis.md#gap-03) are `Dropped`, [`ASM-07`](../../docs/assumptions.md#asm-07) is `Confirmed`, and the scope is decided. | [DEC-007: Drop GAP-01 and GAP-03.](../../docs/decisions.md#dec-007), [DEC-008: Scope the first release to reading stats aloud and answering simple verbal stats queries, with Gemma as the candidate engine.](../../docs/decisions.md#dec-008) |
| [`reports/week-01/meeting-report.md`](../week-01/meeting-report.md#open-questions): "Rule-based engine or machine learning?" | A small model for the query answers: the `Customer` suggested Gemma, and fixed cues stand for the rest. [`ASM-08`](../../docs/assumptions.md#asm-08) is `Refuted`, and feasibility is still open in [`ASM-09`](../../docs/assumptions.md#asm-09). | [DEC-008: Scope the first release to reading stats aloud and answering simple verbal stats queries, with Gemma as the candidate engine.](../../docs/decisions.md#dec-008) |
| [`reports/week-01/meeting-report.md`](../week-01/meeting-report.md#open-questions): "Which ships first if only one can: the explanation of a plan change, or phone-only adaptation?" | Neither ships: both gaps behind the question are `Dropped` in [the gap analysis](../../docs/research/gap-analysis.md). | [DEC-007: Drop GAP-01 and GAP-03.](../../docs/decisions.md#dec-007) |
| [`reports/week-01/meeting-report.md`](../week-01/meeting-report.md#open-questions): "Are professional runners in scope later?" | Still unanswered: the exchange did not touch it. It reappears below. | None |
| [`reports/week-01/meeting-report.md`](../week-01/meeting-report.md#open-questions): "What does a wearable add, and can we reach one in ten weeks?" | Still unanswered: it waits on the feasibility spike. It reappears below. | None |

## Summary

- No live meeting was held: the `Customer` agreed to skip it and answered in writing on 2026-10-09, and that exchange is [the transcript](meeting-transcript.md).
- [`GAP-01`](../../docs/research/gap-analysis.md#gap-01) and [`GAP-03`](../../docs/research/gap-analysis.md#gap-03) are dropped: the `Customer` judged them not important.
- The first release reads available stats aloud and answers simple verbal stats queries, with Gemma as the suggested engine and no fixed command list.
- Fixed cues alone are not enough, so the prototype changed the scope instead of confirming it.
- The minimum usable product candidate has no explicit verdict yet: the presets were not addressed, so confirmation waits for Week 3.

## Decisions

- [DEC-007: Drop GAP-01 and GAP-03.](../../docs/decisions.md#dec-007)
- [DEC-008: Scope the first release to reading stats aloud and answering simple verbal stats queries, with Gemma as the candidate engine.](../../docs/decisions.md#dec-008)

## Action points

| Action | Owner | Due |
| --- | --- | --- |
| Complete the on-device text-to-speech and small-model feasibility spike, starting from Gemma, and report whether it fits in the ten weeks | Obetech1 | End of Week 3 |
| Ask the remaining script questions (Q7, Q10) at the Week 3 validation | Ezekiel-Gadzama | End of Week 3 |
| Restate VP-01 and VP-02 and the affected story acceptance criteria for the query-response scope | Obetech1 | End of Week 3 |
| Arrange the Week 3 validation with the `Customer`, live or in writing | Ezekiel-Gadzama | End of Week 3 |

## Open questions

| Question | What it would change | Follow-up |
| --- | --- | --- |
| Are professional runners in scope later? | Whether anything built now must generalise to them | Week 3 validation |
| What does a wearable add, and can we reach one in ten weeks? | Whether heart rate is an input at all | Obetech1, feasibility spike in Week 3 |
| Has the `Customer` accepted the minimum usable product candidate with the query-response scope, and do the two presets still follow the coach? | The build order and the story priorities | Week 3 validation |

## Disagreements

| Your position | Customer's position | What you changed |
| --- | --- | --- |
| Fixed spoken cues are enough for the first release, and no conversational coach is needed to ship | The coach must also answer simple verbal stats queries | Added query responses to the scope, refuted [`ASM-08`](../../docs/assumptions.md#asm-08), and set the restatement of the value propositions and story criteria as an action point |
