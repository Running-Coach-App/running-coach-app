# Week 4 validation meeting script

## Context

Our problem-space sentence: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal).

Week 3 settled what the coach says. The `Customer` affirmed the four candidate stories from description alone, because no working binary was shown, and refined them in [`DEC-010`](../../docs/decisions.md#dec-010) through [`DEC-016`](../../docs/decisions.md#dec-016). This week the product has the requirements and the architecture behind it: [the quality requirements](../../docs/quality-requirements/README.md), [the functional requirements](../../docs/functional-requirements/README.md), and [the architecture document](../../docs/architecture/README.md) with its records.

What we believe, and are bringing to be argued with: the four stories are done, the qualities we chose to promise are the ones he would have chosen, and one Android application with no server is the right shape for the rest of the course.

What we do not know is whether the qualities we wrote down are the ones he judges us on, and whether anything he expects is missing from them.

**The meeting has to settle:** whether the quality requirements and the architecture answer the drivers, and what comes next.

Questions marked ★ are the ones that would change the project most; ask them even if time runs short.

## Agenda

1. Permission questions (2 min).
   Show: nothing.
   Questions 1–3.
2. The install, running (10 min).
   Show: the app on a phone, one story at a time against its acceptance criteria.
   Questions 4–8.
3. What we promise about quality (7 min).
   Show: [the quality requirements index](../../docs/quality-requirements/README.md).
   Questions 9–11.
4. What the product is made of (6 min).
   Show: [the container view](../../docs/architecture/README.md#container-view) and [the ADR index](../../docs/architecture/README.md#architectural-decisions).
   Questions 12–13.
5. The three questions Week 3 left open (6 min).
   Show: nothing.
   Questions 14–16.
6. Read back the decisions and action points (4 min).
   Show: the note taker's list.

## Questions

### Permission

1. _(closed)_ May we record this meeting?
2. _(closed)_ May we publish a sanitized transcript of it in the public repository?
3. _(closed)_ If not, may we share the transcript privately with the instructors?

### The install, running

4. _(closed)_ You have just heard a session start and stop without looking at the screen. [`DEC-015`](../../docs/decisions.md#dec-015) ruled out motion detection, and the volume keys only work while the screen is awake. Are they the right control on those terms?
5. _(open)_ ★ You heard it answer a question with the phone in your pocket and the screen off. What would you want to do from the pocket that you cannot do yet?
6. _(open)_ ★ Listening to the stats line as it is spoken now, what is wrong with it: the words, the order, or how often it comes?
7. _(closed)_ The effort cue speaks only when the effort changes, and a steady session speaks none. Is that what you meant in [`DEC-014`](../../docs/decisions.md#dec-014)?
8. _(open)_ You just heard it answer one spoken question and turn another back to the run. Which of those two replies would make you stop using it?

### What we promise about quality

9. _(open)_ ★ Here are the four things we have promised to be judged on. Which one would you take off this list, and what would you put in its place?
10. _(closed)_ We have promised a spoken line starts within two seconds of falling due. On a run, is two seconds the number you would notice, or is it looser than that?
11. _(open)_ When this app has annoyed you on a run, what will it have done?

### What the product is made of

12. _(closed)_ The product is one Android application with no server, so nothing is kept after a session ends. Is losing the run when it stops acceptable for this release?
13. _(open)_ ★ If one of these decisions turns out to be wrong later, which one do you think it will be?

### The three questions Week 3 left open

14. _(open)_ Think of a runner you know who is faster than you. What would they want that this does not do?
15. _(open)_ You called a watch worth exploring. What would you expect to get from one that the phone has not given you so far?
16. _(closed)_ ★ Do the two preset sessions still follow this coach, or have they left the plan?

## Roles

Ezekiel-Gadzama runs the meeting and keeps the time. Sirjaey shows the install and the documents, and takes the notes. Obetech1 observes, and records any acceptance criterion we claim but do not show, and any question we do not get to.

The team is three members this week: @JustACommonMan-OSDD has taken academic leave, so the moderator also starts the recording once question 1 is answered.

## Key improvements

### "Are you happy with the quality requirements?" -> "Which one would you take off this list, and what would you put in its place?"

The original asks for approval of a document we wrote, and a customer reading our own list back to us tells us nothing. The rewrite makes him spend something: to add one he has to drop one, so the answer ranks the list instead of blessing it.

### "You have just heard a session start and stop with the phone in a pocket" -> "…without looking at the screen", plus a second question about the pocket

The original told the customer what he had just experienced, and it was not true: the volume keys are read by the screen that is in front, so a pocketed phone with the screen off cannot start or stop a session. We only found that by watching the media session state while the keys were pressed, after believing twice that it worked. A question that asserts a false thing teaches us nothing, because the customer either agrees with the premise or spends the answer correcting it. The rewrite claims only what the build does, and the new question 5 asks him what he wants from the pocket, which is the thing we actually do not know.

### "Is the architecture fine?" -> "If one of these decisions turns out to be wrong later, which one do you think it will be?"

The original invites a yes from someone who has no reason to argue with a diagram. The rewrite asks him to predict a failure, which is a question he can answer from his own experience rather than from our reasoning, and the answer tells us which record to revisit first.
