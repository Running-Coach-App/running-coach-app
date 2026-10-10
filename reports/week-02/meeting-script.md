# Week 2 validation meeting script

## Context

Our problem-space sentence going in: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal).

The 2 October kickoff changed what we build. The `Customer` asked for a voice in the ear during the run and did not mention a training plan. The record is [the kickoff report](../week-01/meeting-report.md).

We have written that down. [VP-01](../../docs/research/value-proposition.md#vp-01) is the in-run voice coach. [VP-02](../../docs/research/value-proposition.md#vp-02) is two preset sessions spoken by that coach, after the coach is in place. [BND-01](../../docs/product-vision.md#bnd-01) leaves an adaptive training plan outside the product, and [BND-02](../../docs/product-vision.md#bnd-02) leaves an explanation of a plan change outside it. [BND-06](../../docs/product-vision.md#bnd-06) leaves a conversational exchange during the run outside it, and that is the part we are least sure of.

What we believe, and are sending to be argued with: the runner does not look at the phone, the first release speaks fixed cues (time, pace, distance, and a simple intensity cue), and the two presets come after that coach.

The `Customer` agreed to skip the live meeting and take this in writing. This script is that message. There is no room and no recording.

**The meeting has to settle:** whether the prototype, the boundary, and the minimum usable product candidate are right.

Questions marked ★ are the ones that would change the project most.

## Agenda

1. Permission.
   Send: nothing else.
   Questions 1–3.
2. The research this message carries.
   Send: [the alternatives](../../docs/research/alternatives.md), [the comparison](../../docs/research/comparison.md), [the decisions log](../../docs/decisions.md), and [the assumptions log](../../docs/assumptions.md).
   Questions: none.
3. The boundary.
   Send: [the boundary list](../../docs/product-vision.md#boundary), [the context diagram](../../docs/architecture/context.svg), and [the gap analysis](../../docs/research/gap-analysis.md).
   Question 4.
4. The prototype.
   Send: [the prototype record](prototypes.md) and [its screenshot](images/voice-cue-prototype.png).
   Question 5.
5. The candidate and the build order.
   Send: [VP-01](../../docs/research/value-proposition.md#vp-01) and [VP-02](../../docs/research/value-proposition.md#vp-02).
   Core task, in one line: the runner puts the phone in a pocket, starts a session, and hears what to do and how the run is going until they stop.
   The candidate is VP-01 and VP-02, in that order, and nothing else.
   Question 6.
6. Read back the decisions and action points.
   Send: a reply in the same chat, once the `Customer` has answered, stating what we think was settled so he can correct it.

## Questions

### Permission

1. _(closed)_ May we keep your reply, as text or a voice note, as the meeting note?
2. _(closed)_ May we publish a sanitized transcript of that reply in the repository?
3. _(closed)_ If you refuse publication, may we share that transcript privately with the instructors?

### The boundary

4. _(closed)_ ★ Do [GAP-01](../../docs/research/gap-analysis.md#gap-01) and [GAP-03](../../docs/research/gap-analysis.md#gap-03) stay, or do they go?

### The prototype

5. _(closed)_ ★ For the first release, are fixed spoken cues enough, or does the coach need to talk back?

### The candidate and the build order

6. _(closed)_ ★ Is the fixed-cue coach, [VP-01](../../docs/research/value-proposition.md#vp-01), plus two preset sessions, [VP-02](../../docs/research/value-proposition.md#vp-02), the right order for the first release?

## Key improvements

### "We will use your reply as the meeting note." -> "May we keep your reply, as text or a voice note, as the meeting note?"

The original tells him what we will do with his words.
The rewrite asks permission, and the next two questions split publication from a private copy, so a refusal of one is not a refusal of the other.

### "Do you want us to build an adaptive training plan?" -> "Do GAP-01 and GAP-03 stay, or do they go?"

The original offers him a solution and asks for a preference.
The rewrite points at two gaps already in the research and asks for a keep-or-cut, which he can answer without agreeing to our idea.

### "Is the prototype good enough?" -> "For the first release, are fixed spoken cues enough, or does the coach need to talk back?"

The original invites a verdict on our mock.
The rewrite asks which of the two behaviours the first release needs, which is the part [the prototype](prototypes.md) was built to test.
