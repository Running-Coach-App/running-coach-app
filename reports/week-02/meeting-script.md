# Week 2 validation meeting script

## Context

Our problem-space sentence going in: a recreational runner training for a 5K to half-marathon race, often without a sports watch, needs a training plan that changes when their real runs differ from the plan and tells them why it changed, so they can trust it enough to keep following it.

The 2 October kickoff changed what we build. He asked for a voice in the ear during the run, and he did not mention a training plan in twenty-nine minutes.

We have written that down: [VP-01](../../docs/research/value-proposition.md#vp-01) is the in-run voice coach, [VP-02](../../docs/research/value-proposition.md#vp-02) is two preset sessions spoken by that coach, and the product vision puts a plan that adapts, and the explanation of a plan change, outside the product.

The record of the kickoff is [the meeting report](../week-01/meeting-report.md).

What we believe now, and are bringing to be argued with: the runner never looks at the phone while running, and everything the product says comes out of the speaker or the headphones.
What we do not know is whether that alone is a product, or a feature of one.

**The meeting has to settle:** whether the prototype, the boundary, and the minimum usable product candidate are right.

Questions marked ★ are the ones that would change the project most; ask them even if time runs short.

## Agenda

1. Permission questions (2 min).
   Show: nothing.
2. What we built to show you (3 min).
   Show: [the prototype record](prototypes.md) and its screenshot.
   Questions 1–3.
3. The boundary: what this will not do (7 min).
   Show: [the system context diagram and the boundary list](../../docs/product-vision.md#boundary).
   Questions 4–7.
4. The candidate and the build order (8 min).
   Show: [the candidate](README.md#minimum-usable-product-candidate) and [the issue list filtered by the `user-story` label](https://github.com/Running-Coach-App/running-coach-app/issues?q=label%3Auser-story).
   Core task, in one line: the runner puts the phone in a pocket, starts a session, and hears what to do and how it is going until they stop.
   The candidate is [US-01](https://github.com/Running-Coach-App/running-coach-app/issues?q=is%3Aissue+US-01), [US-02](https://github.com/Running-Coach-App/running-coach-app/issues?q=is%3Aissue+US-02), and [US-04](https://github.com/Running-Coach-App/running-coach-app/issues?q=is%3Aissue+US-04), and nothing else.
   Questions 8–11.
5. What the kickoff left open (6 min).
   Show: [the kickoff's open questions](../week-01/meeting-report.md#open-questions).
   Questions 12–14.
6. Read back the decisions and action points (4 min).
   Show: the note taker's list.

## Questions

### The prototype

1. _(open)_ ★ Watching this, what is missing that you expected to hear?
2. _(closed)_ You suggested the model could talk back to you mid-run. For the first release, are fixed spoken cues enough?
3. _(open)_ ★ The last time an app or a plan changed a workout on you, what did you do: follow it, ignore it, or change it back? Why?

### The boundary

4. _(open)_ ★ Which of these would you miss first if it were not built: an adaptive training plan, an explanation of why something changed, or sharing a run with a friend?
5. _(closed)_ We have written down that this will not upload medical documents, will not share a run with anyone, and will not give you a plan that rewrites itself. Which of those three do you disagree with?
6. _(open)_ If a plan that rewrites itself is out of scope, is there anything else you expect this to do that we have not written down?
7. _(open)_ Is there anything a runner you know would want here that we have ruled out?

### The candidate and the build order

8. _(open)_ ★ Here is the core task in one line: phone in your pocket, start a session, hear what to do and how it is going until you stop. Which story would you miss first if it were not built?
9. _(closed)_ The candidate is the spoken stats and two preset sessions. Is that the product, or a demo of the product?
10. _(closed)_ You placed the preset programmes after the talking coach. Do you agree the build order is coach first, presets second?
11. _(open)_ Is there a point in the first release where you would stop and say this is not worth shipping?

### What the kickoff left open

12. _(closed)_ ★ A rule-based engine, or do you expect machine learning?
13. _(open)_ Think of a runner you know who would use this. What do they record their runs with today?
14. _(open)_ Are professional runners in scope later, and does anything we build have to generalise to them?

## Roles

`@Ezekiel-Gadzama` asks the questions and controls the time, `@Sirjaey` takes the notes, and `@JustACommonMan-OSDD` observes and records what we did not ask.
`@Obetech1` attends; the whole team is in the meeting.

## Key improvements

### "Do you want us to build an adaptive training plan?" -> "The last time an app or a plan changed a workout on you, what did you do: follow it, ignore it, or change it back? Why?"

The original offers him a solution and asks for a preference, so the answer tells us what he thinks of our idea.
The rewrite asks for something that already happened, which he can describe without agreeing or disagreeing with anything.

### "Is the prototype good enough?" -> "Watching this, what is missing that you expected to hear?"

The original invites agreement, and agreement from a customer about our own idea tells us almost nothing.
The rewrite asks for the absence, which is a reaction we can turn into a change rather than a verdict we have to interpret.
