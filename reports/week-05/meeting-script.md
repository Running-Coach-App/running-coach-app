# Week 5 validation meeting script

## Context

Our problem-space sentence: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal). The bar for it is [the threshold of success](../../docs/threshold-of-success.md).

Last week the `Customer` accepted all four candidate stories from a screen share and asked for one thing: the stats he hears should also be on the screen, per [`DEC-018`](../../docs/decisions.md#dec-018) and [`DEC-022`](../../docs/decisions.md#dec-022). That is built and released. He also said he would build the app himself from this repository rather than install an APK we sent, per [`DEC-021`](../../docs/decisions.md#dec-021), and would try it on his own run.

What we believe now, and are bringing to be argued with: the product is finished enough that the next useful thing is getting it in front of someone who is not us. What we do not know is whether he got it onto his phone, and what a real run told him that a screen share could not.

[`TOS-02`](../../docs/threshold-of-success.md#tos-02) is the bar this week is judged against: somebody outside the team follows the setup page and finishes one pocket session. Whether he managed that is the single most useful thing this meeting can settle.

**The meeting has to settle:** whether the product is usable by someone outside the team without our help, and what the next increment is for.

Questions marked ★ are the ones that would change the project most; ask them even if time runs short.

## Agenda

1. Permission questions (2 min).
   Show: nothing.
   Questions 1–3.
2. His own run (10 min).
   Show: nothing at first — let him describe it before we show anything.
   Questions 4–7.
3. The screen, now that it exists (6 min).
   Show: the app running, with the spoken lines appearing on screen.
   Questions 8–10.
4. What we promise, and what we check (6 min).
   Show: [the quality requirements index](../../docs/quality-requirements/README.md) and the checks that run on every change.
   Questions 11–13.
5. What the next increment is for (8 min).
   Show: [the plan's milestones](../../docs/project-plan.md#milestones).
   Questions 14–17.
6. Read back the decisions and action points (3 min).
   Show: the note taker's list.

## Questions

### Permission

1. _(closed)_ May we record this meeting?
2. _(closed)_ May we publish a sanitized transcript of it in the public repository?
3. _(closed)_ If not, may we share the transcript privately with the instructors?

### His own run

4. _(closed)_ ★ Did you get it onto your phone and run with it?
5. _(open)_ ★ Walk us through what happened, from opening the repository to the end of the run. Where did you stop or have to guess?
6. _(open)_ What did it say during the run that you did not expect?
7. _(open)_ If you had been running alone with no interest in helping us, where would you have given up?

### The screen, now that it exists

8. _(closed)_ Last week you asked for the stats on screen as well as spoken. Is this what you meant?
9. _(open)_ ★ With the screen there, is there anything you now want spoken *less* often?
10. _(open)_ What is on this screen that you would not miss?

### What we promise, and what we check

11. _(open)_ ★ Here are the four qualities we have promised to be judged on, and the two we can now prove automatically. Which of the four would you most want proved next?
12. _(closed)_ We check the spoken decisions on every change, but nobody checks that it still works on a real phone. Is that the right place to stop?
13. _(open)_ When this app has let you down on a run, what will have happened?

### What the next increment is for

14. _(open)_ ★ The next increment is about finding out what a runner who is not you hears. Who would you want us to put this in front of?
15. _(closed)_ Do the two preset sessions still follow this coach, or have they left the plan?
16. _(open)_ Are professional runners in scope later, and does anything we build now have to generalise to them?
17. _(open)_ You called a watch worth exploring. After using the app, is heart rate still worth a week of the ones we have left?

## Roles

Ezekiel-Gadzama runs the meeting and keeps the time. Sirjaey shows the app and the documents, and takes the notes. Obetech1 observes, and records anything the `Customer` says that contradicts something we have written down, and any question we do not get to.

The team is three members: @JustACommonMan-OSDD has taken academic leave.

## Key improvements

### "Did the app work for you?" -> "Walk us through what happened, from opening the repository to the end of the run. Where did you stop or have to guess?"

The original can be answered with one word, and the word is usually "yes" from someone being kind. The rewrite asks for the sequence, which he can only give by remembering it, and it names the two things we actually want — where he stopped, and where he had to guess — so a polite answer still contains the failure.

### "Are you happy with the screen?" -> "With the screen there, is there anything you now want spoken less often?"

The original asks him to approve something we built to his own request, so the answer is predetermined. The rewrite assumes the screen is fine and asks what it makes redundant, which is the question that could change the product: if the screen covers the stats, the three-minute spoken cadence he fixed in [`DEC-013`](../../docs/decisions.md#dec-013) may be worth less than it was.

### "Which quality requirement matters most?" -> "Which of the four would you most want proved next?"

The original asks him to rank a list he did not write, and ranking is cheap. The rewrite attaches a cost: proving one is a week of our remaining time, so his answer tells us what he would spend it on rather than what sounds important.
