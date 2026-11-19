# Week 8 meeting script

This week's meeting is `SPRINT-08`'s **Sprint Review**. Its subject is the usability results and the fixes the sprint landed. The configuration evaluation is not presented: it is a repository artifact, and the meeting's time belongs to what the `Customer` can see and judge.

Read the parts in quotation marks as they are written. Everything else is an instruction to whoever runs the meeting.

## Context

The sprint carried two streams. The product stream answered the Week 7 meeting: four of his six decisions are built, and a crash that nobody had seen was found on a phone and fixed. The usability stream did not reach its bar — **no `UT-01` session has been counted** — and this meeting declares that rather than dressing it up.

Two things in this script are uncomfortable to say and are said early on purpose: the build on the releases page is not the build the documentation described, and the control he asked for — turning the record off — was the one that stopped the app opening. He asked for proof rather than promises; this is what proof looks like when it goes against us.

## Agenda

1. Permission questions (2 min). Show: nothing. Questions 1–3.
2. What landed since the last meeting (6 min). Show: the deployed product on the phone, a live session, the lock screen. Questions 4–6.
3. **The two findings that go against us (6 min).** Show: the release page's asset, and the crash as it was. Questions 7–9.
4. The usability shortfall (5 min). Show: [the test record](../../docs/usability-tests/ut-01/README.md) and [the empty results](../../docs/usability-tests/ut-01/results.md). Questions 10–12.
5. The dashboards (3 min). Show: the analytics and observability dashboards on the university network.
6. Open questions carried from Week 7 (4 min). Show: nothing. Questions 13–18.
7. Close (2 min). Read back every decision and every action point.

## Before the call

- The phone, charged, with the current build installed and the app closed.
- The release page open, with the asset name visible under Assets.
- [`docs/usability-tests/ut-01/results.md`](../../docs/usability-tests/ut-01/results.md) open.
- The staging analytics and observability dashboards open, reachable from the university network.
- [`SPRINT-09`](../../docs/project-plan.md#sprint-09) open.

## Part 1: Permission questions (2 minutes)

Ask these before anything is shown and before any recording starts.

> "Before we start, three permissions.
>
> **1.** May we record this meeting? The recording goes to the course instructors and the team, and nowhere else.
>
> **2.** May we publish the transcript in the public repository? That is separate from recording it — you can say yes to one and no to the other.
>
> **3.** May we quote you by role — 'the Customer' — in the public report? No name, no company."

Record each answer. If recording is refused, say so in the report and write the meeting from notes.

## Part 2: What landed since the last meeting (6 minutes)

> "Six things you decided last time. Four of them are in the build you are looking at."

Show the phone. Start a session.

> "The stats interval is yours now — one, two, three or five minutes, on the Profile screen. Three is still the default, because that is what you agreed in October.
>
> The coach understands many more ways of asking the same thing, generated the way you asked: an agent wrote the phrasings, and no model runs in the app. 'What is my pace' and 'what are my stats' both work — we tested them on a phone, out loud, with the screen locked.
>
> And the run is on the lock screen now, with a stop control, so you can see your pace without unlocking."

Lock the phone. Show the lock screen.

> "Two we have not done: sampling the location fix against a step detector to save battery, and the questionnaires going out to more than one person. Both are in next week's sprint."

**Question 4.** "Is this the interval you expected — and is three minutes still right as the default?"

**Question 5.** "Does the lock screen give you what you asked for, or did you mean something else by on-screen control?"

**Question 6.** "You were going to retest and send us the run report as JSON. Did you manage it?" — if yes, ask him to send it today; the stats question in [#223](https://github.com/Running-Coach-App/running-coach-app/issues/223) is still unanswered without it.

## Part 3: The two findings that go against us (6 minutes)

Say both before he finds them. Do not soften either.

> "Two things we found this week that we got wrong, and you are the person most entitled to hear them first.
>
> **The first is about the scanner you asked for.** You said: proof, for open source, that we are not sending data somewhere — people know the scanner, they can run it and see. The scanner passes. But it checks the source, not the file on our releases page, and the file on our releases page is a debug build. It carries the internet permission, it is debuggable, and it allows unencrypted traffic. Our README said the opposite, and that was wrong.
>
> What is true is that it has nowhere to send anything: there is no address compiled into it, and you can check that yourself on the file you downloaded. But the mechanism was not what we told you it was, and the mechanism is the part you asked to be able to verify."

Show the release page and the asset name.

> "**The second is worse.** The setting that turns off the record the app keeps — the one you asked for so a runner could refuse it — made the app fail to open. Every launch, from the moment you turned it off. We found it on a phone this week, we have fixed it, and we checked the fix by force-stopping and reopening the app three times with the setting off.
>
> Our own crash reporting could never have caught it, because it only records crashes when that same setting is on."

**Question 7.** "Do you want us to publish a signed release build instead of a debug build — and is it worth a sprint?"

**Question 8.** "Does that crash change how much you trust the usage-data switch?"

**Question 9.** "Is there anything else you have turned off or changed that behaved oddly?"

## Part 4: The usability shortfall (5 minutes)

> "We planned three to five usability sessions this sprint. **We have run none.**
>
> The design is finished — the tasks, the questionnaires, the consent, the private place the data goes. What has not happened is the sessions themselves. The questionnaires did not go out, the recordings folder is not shared, and nobody outside the team has been through the test.
>
> So there are no results this week. The requirement that the test was meant to verify stays unverified, and we are not going to present a smaller number as though it were a result."

Show the empty results file and the test record.

**Question 10.** "You offered to be one of the respondents. Our own recruitment rules exclude you, because you have shaped the product and cannot come to it fresh. Would you rather we count your session with that bias recorded, or run yours separately as a practice round?"

**Question 11.** "Do you know anyone outside this course who runs and would give us forty minutes?"

**Question 12.** "If we only get two sessions before the pitch, would you rather have two with real findings, or none and an honest blank?"

## Part 5: The dashboards (3 minutes)

Show the analytics dashboard, then the observability dashboard, from the university network.

> "These are the two dashboards, on the university machine. The analytics one is what sessions the product recorded; the observability one is whether it kept up while it was running."

## Part 6: Open questions carried from Week 7 (4 minutes)

Put each to him, or close it and say why.

**Question 13.** "Should the product save the text the recogniser heard, for debugging?" — tell him we built a temporary version that did exactly that this week, used it to answer one question, and deleted it; the question is whether that should ever ship.

**Question 14.** "Do usage and crash records go to the campus collector, and how does that fit the decision and the scanner?" — this is now partly answered: the published build has no collector address compiled in.

**Question 15.** "Should the coach listen only while the phone thinks the runner is moving, rather than for the whole session?"

**Question 16.** "Where do the usability participants come from, if nobody will run outdoors in the host city?" — now the week's blocking question rather than a hypothetical.

**Question 17.** "Is a wearable the product's real home?" — he raised it and argued against it himself; ask whether he wants it on the table for the pitch.

**Question 18.** The six carried from Week 6: the presets, professional runners, heart rate, the platform recogniser, the export shape, and whether `TOS-02` should be reset. Close any he no longer cares about.

## Close (2 minutes)

Read back, out loud, every decision made in this meeting and every action point, with its owner and its due date. Do not paraphrase: if a decision is going into `docs/decisions.md` as a `DEC-nnn`, read the sentence that will go in.

### Carried action points to close out loud

- Retest on the build carrying the interface changes, and send the run report as JSON — `Customer`, due 2026-11-21.
- Establish why the pocket session failed on a Pixel 8 — sirjaey, due 2026-11-21.
- Establish whether the recogniser uses the phone or the headset microphone — Ezekiel-Gadzama, due 2026-11-21.
- Widen the question rules per `DEC-034` — Ezekiel-Gadzama, due 2026-11-21.
- Sample the location fix against a step detector per `DEC-035`, and measure the battery — sirjaey, due 2026-11-21.
- Send the `UT-01` questionnaires to the `Customer` — ObeTech1, due 2026-11-19.
