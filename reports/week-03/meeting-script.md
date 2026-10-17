# Week 3 validation meeting script

## Context

Our problem-space sentence going in: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal), and the bar for it is [the threshold of success](../../docs/threshold-of-success.md).

Week 2 settled the boundary. [DEC-007](../../docs/decisions.md#dec-007) dropped the adaptive plan and the explanation of a plan change. [DEC-008](../../docs/decisions.md#dec-008) says the first release reads the available stats aloud and answers simple verbal stats queries. The candidate that completes the core task is [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37), [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38), [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39), and [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40). [US-06](https://github.com/Running-Coach-App/running-coach-app/issues/42), the two presets, is not in that candidate.

What we believe, and are sending to be argued with: those four stories are the minimum usable product, the presets still wait, and a wearable is still not required.

**The meeting has to settle:** whether the finished stories do what the customer needs, and what comes next.

Questions marked ★ are the ones that would change the project most.

## Agenda

1. Permission.
   Send: nothing else.
   Questions 1–3.
2. [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37), start and stop without taking the phone out.
   Show: headphones on, screen covered, a session started and then stopped, each with a spoken confirmation, and silence after the stop.
   Ask for a verdict on AC-01, then on AC-02.
   Question 4.
3. [US-02](https://github.com/Running-Coach-App/running-coach-app/issues/38), hear time, pace, and distance.
   Show: one session with no location fix, then one with a distance, and no look at the screen for either number.
   Ask for a verdict on AC-01, then on AC-02.
   Question 5.
4. [US-03](https://github.com/Running-Coach-App/running-coach-app/issues/39), hear the effort.
   Show: an interval session that says Jog, then Hard, then Easier, and a steady session that says none of those.
   Ask for a verdict on AC-01, then on AC-02.
   Question 6.
5. [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40), ask aloud how the run is going.
   Show: "How long have I been running?" answered with the elapsed time, then a question that is not time, pace, or distance, with no invented stat.
   Ask for a verdict on AC-01, then on AC-02.
   Question 7.
6. What this week will not finish.
   Send: [US-06](https://github.com/Running-Coach-App/running-coach-app/issues/42) stays out of the Week 3 build. [VP-02](../../docs/research/value-proposition.md#vp-02) is still the two presets after the coach.
   Question 8.
7. What comes next, including the questions Week 2 still owes.
   Questions 9–12.
8. Read back the decisions and action points.
   Send: a reply stating what we think was settled, so the `Customer` can correct it.

## Questions

### Permission

1. _(open)_ May we record this meeting?
2. _(open)_ May we publish a sanitized transcript in the repository?
3. _(open)_ If you refuse publication, may we share that transcript privately with the instructors?

### US-01

4. _(open)_ ★ Does the start and the stop do what you need: a spoken confirmation each time, and silence after the stop, with the phone face covered?

### US-02

5. _(open)_ ★ Are the spoken time, pace, and distance enough, including the case where distance is missing and we do not invent one?

### US-03

6. _(open)_ ★ Is hearing hard, easier, or jog at a change, and hearing nothing when the effort does not change, the cue you wanted?

### US-04

7. _(open)_ ★ When you ask how long the run has been going, is the spoken elapsed time the answer you wanted, and is it right that any other question gets no invented stat?

### Not in this build

8. _(open)_ ★ Do the two presets in [VP-02](../../docs/research/value-proposition.md#vp-02) still follow this coach, or do they leave the plan?

### Still open from Week 2

9. _(open)_ ★ The last time an app or a plan changed a workout on you, what did you do: follow it, ignore it, or change it back? Why?
10. _(open)_ Are professional runners in scope later?
11. _(open)_ What does a wearable add for you, and should we spend any of the remaining weeks on one?
12. _(open)_ The old question, kept so it is actually asked: if only one of these had shipped, which would you have kept, the explanation of why a plan changed, or adaptation from phone-only runs? Both are already outside the product. We are asking whether that still stands.

## Roles

Ezekiel-Gadzama runs the meeting and asks questions 9 and 12, which Week 2 assigned to him. Sirjaey shows the four stories and takes notes. Obetech1 watches for a criterion we claim and do not show. JustACommonMan-OSDD watches the time and the recording, and only starts it after question 1 is answered yes.

## Key improvements

### "Is the prototype good enough?" -> one part per story, one question per acceptance criterion

A single verdict on the whole app hides which criterion failed. The agenda shows [US-01](https://github.com/Running-Coach-App/running-coach-app/issues/37) through [US-04](https://github.com/Running-Coach-App/running-coach-app/issues/40) separately, and each question asks for the criterion just shown.

### "Should we build presets?" -> "Do the two presets still follow this coach, or do they leave the plan?"

[US-06](https://github.com/Running-Coach-App/running-coach-app/issues/42) is not in the Week 3 build. The question asks him to keep that order or to change it, which is the decision the candidate still lacks.
