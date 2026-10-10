# Week 02 prototypes

## Spoken cue walkthrough

- **What it is:** a static three-screen mock of what the runner hears — before the run, during it, and after it — with the coach's line shown as the loudest block on each screen.
- **View:** [the mock](images/voice-cue-prototype.png).
- **Tested:** [`US-02`](https://github.com/Running-Coach-App/running-coach-app/issues/38), [`US-03`](https://github.com/Running-Coach-App/running-coach-app/issues/39), and [`US-05`](https://github.com/Running-Coach-App/running-coach-app/issues/41), exercising `AC-01` of each; and [`ASM-08`](../../docs/assumptions.md#asm-08), because whether fixed cues are enough to ship is the risky part, not whether speech can be produced. The customer's answer added [`US-04`](https://github.com/Running-Coach-App/running-coach-app/issues/40).
- **Question:** will he accept fixed spoken cues for the first release, or does he need the model to talk back?
- **What the customer said:**
  > Fixed cues alone are not enough. For the scope of the project it is enough to read available stats to the user and to respond to simple verbal queries such as asking for the stats or the elapsed time, with no fixed command list. He suggested Google's open source small model Gemma to handle those queries and generate the responses. `GAP-01` and `GAP-03` can go, because they are not important. He found the alternatives research very helpful.
- **What changed:**
  > [`ASM-08`](../../docs/assumptions.md#asm-08) is `Refuted`: the first release must answer simple verbal stats queries, not only speak fixed cues. The scope is decided in [`DEC-008`](../../docs/decisions.md#dec-008), and [`GAP-01`](../../docs/research/gap-analysis.md#gap-01) and [`GAP-03`](../../docs/research/gap-analysis.md#gap-03) are `Dropped` in [`DEC-007`](../../docs/decisions.md#dec-007). Restating `VP-01`, `VP-02`, and the affected story acceptance criteria for the query-response scope is an action point in [the meeting report](meeting-report.md#action-points).

## Why this and not something else

`Validation` rule 2 says to build the thing we are least sure about.
We are not unsure that a phone can speak a number — that is settled engineering.
We are unsure that he will accept the first release without a model listening, and that is what the mock shows:
the fixed cue in the middle screen, with the note under it saying plainly that nothing is listening.
The mock is deliberately not beautiful and does not need to work.
It exists so he can react to the part we got wrong rather than to the part we got right.

## Disposal

The mock's HTML source is not committed.
`Where Prototypes Live` rule 4 keeps disposable prototype code off `main` in Week 2, and the evidence for this week is this record and its screenshot.
