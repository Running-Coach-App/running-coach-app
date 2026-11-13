# Week 7 meeting script

For the `SPRINT-07` validation meeting, which is the sprint's Sprint Review. Thirty minutes. The team runs it; one member keeps the transcript.

## Context

Our problem-space sentence: a beginner to intermediate runner with only a phone hears what to do and how the run is going while they are running, without looking at the screen. That sentence is the [product vision goal](../../docs/product-vision.md#goal), and [the threshold of success](../../docs/threshold-of-success.md) is the bar for it.

Two things make this meeting different from the last one.

**The carried action is done.** The `Customer` asked for the Play Store research in Week 5 and asked again in Week 6 whether we had done it. We had not, and he called that even with his own missed install. It is done now, it is written down, it produced three quality requirements and one defect, and the scanner he asked for runs on every change. Part 3 is that answer, and it is the part of this meeting we should be most confident in. Lead with it.

**This week's deliverable is a test, not a feature.** We designed a usability test: three tasks, three to five strangers, a consent form, surveys, and a private place for the raw data. Nobody has run it yet. The point of Part 4 is to find out whether the thing we plan to measure is the thing he wants measured, *before* the sessions happen, because after them it is too late to change.

What we believe now, and are bringing to be argued with: the product is finished enough that the most useful thing left is finding out where it loses a person who has never seen it. What we do not know is whether he agrees that is worth a sprint, and whether the tasks we chose are the ones he would have chosen.

**The meeting has to settle:** whether the `UT-01` design will answer his questions, whether the participant profile, the recruitment target, and the session plan are right, and what the results have to show for them to be worth having.

Questions marked ★ are the ones that would change the project most; ask them even if time runs short.

## Agenda

1. Permission questions (2 min). Show: nothing. Questions 1–3.
2. The product as it stands (3 min). Show: the release page, and a live session on the phone. Questions 4–5.
3. **Play Store quality and the scanner — the carried action (8 min).** Show: [the research page](../../docs/research/play-store-quality.md) and `./scripts/scan.sh` running. Questions 6–9.
4. The `UT-01` design (10 min). Show: [the record](../../docs/usability-tests/ut-01/README.md), the surveys, the consent, the instrumentation, the session plan, and [`QR-09`](../../docs/quality-requirements/qr/QR-09.md). Questions 10–15.
5. The Week 8 plan (3 min). Show: [`SPRINT-08`](../../docs/project-plan.md#sprint-08). Questions 16–17.
6. Open questions carried from Week 6 (3 min). Show: nothing. Questions 18–23.
7. Close (1 min). Read back every decision and every action point.

## Before the call

- The latest release page open, with the APK visible under Assets.
- The app running on a phone, so a session can be started during the call.
- A terminal with `./scripts/scan.sh` ready to run, and its output from a clean run already in the scrollback in case the live run is slow.
- [The research page](../../docs/research/play-store-quality.md) open.
- [The `UT-01` record](../../docs/usability-tests/ut-01/README.md) open, and the printed consent form in hand to show him.
- [The Week 6 action points](../week-06/meeting-report.md#action-points) open, so each one can be closed out loud.

**What we cannot show, and should say rather than be caught on.** The course asks for a deployed production instance and a staging deployment. This product has neither, and that is his own decision: [`DEC-033`](../../docs/decisions.md#dec-033) records him agreeing that an installable build from GitHub is enough and that the university virtual machine is not required for an Android app. So "production" is the tagged release he can install, and the usability sessions run against a debug build on our phone, outdoors. Say that in one sentence when we get to it; do not let it look like something we forgot.

## Part 1: Permission questions (2 minutes)

Ask all three, separately, and do not carry an answer over from a previous meeting. Nothing is recorded until question 1 is answered.

1. May we record this meeting?
2. May we publish a sanitized transcript of it in the public repository?
3. If not, may we share the transcript privately with the course instructors?

## Part 2: The product as it stands (3 minutes)

Short. He has seen the app; this is to put a working thing on the table before we talk about documents.

4. ★ Did you install it this time? If you did: what happened on the run? If you did not, what stopped you — and is there something we can change to make it easier, or is it time?
5. Anything we can start a session on the phone right now and show you?

> If he has still not installed: do not spend the meeting on it. Note it, move on, and pick it up in the action points. This is the fourth week of asking, and the usability test now exists precisely because the product cannot keep waiting on one person's install to learn anything.

## Part 3: Play Store quality and the scanner (8 minutes)

**This is the carried action from Week 5 and Week 6. Lead with the answer, not with an apology.**

Opening line, roughly:

> "You asked us twice what Google requires for an app to count as high quality, and last week we had not done it. It is done now. There is a page in the repository with the research, three of the requirements it produced are now quality requirements with tests, one of them we currently fail, and the scanner you asked for runs on every change. Here it is."

### What to say about the research

**The thing worth knowing: there are two different Google documents, and only one of them has teeth.**

- **Core app quality** is Google's checklist. It calls itself "the minimum quality that all apps should meet". It is a list of named criteria — roughly sixty of them — and nothing on that page says an app is rejected for missing one. It is advice.
- **Android vitals** is the part with consequences. Google publishes a "bad behaviour threshold" for each core vital, and two of them apply to every app:

  | What Google measures | Overall, across all devices | On a single phone model |
  | --- | --- | --- |
  | User-perceived crash rate | 1.09% | 8% |
  | User-perceived ANR rate ("app not responding") | 0.47% | 8% |

  Play reads the last 28 days. Over a threshold, Google says it "may reduce the visibility of your title" and "may also show users a warning on your store listing".

**He predicted this almost exactly, and it is worth telling him so.** In Week 6 he said Google "collects metrics anyway, and if it crashes a lot on some phones they will hide it from Google Play for those phones". That is the per-phone-model 8% threshold, in his own words, before we had read the page.

**He was also right about battery, but through a different door.** He said "Play Store will punish an app that takes a lot of CPU or battery". The battery vital Play actually enforces is excessive partial wake locks — and Google currently lists it as in beta, where exceeding the threshold "does not currently make your app less discoverable". So the battery pressure is real but soft today. The hard thresholds are crashes and not-responding.

### The three that became requirements

> "We took the top things that fit the weeks we have left, which is what you asked for, and we turned three of them into requirements with tests rather than notes in a document."

| Google's criterion | What we did with it |
| --- | --- |
| `Stability_ANR` — the app must not crash or freeze | [`QR-06`](../../docs/quality-requirements/qr/QR-06.md). An hour-long session is driven through the coach's decision loop at the real one-second cadence, with the GPS fix dropping for 90 seconds in every 10 minutes, ticks that run backwards and jump a thousand kilometres, 500 spoken answers, and 50 start-and-stop cycles. Five tests, all passing. The whole simulated hour of decisions takes 10 milliseconds against a 2-second budget. |
| `Background_Service_Optimization` — which names "keeping GPS powered on" as poor use of a background service | [`QR-07`](../../docs/quality-requirements/qr/QR-07.md). This is the one we are closest to failing by design: a coach that does not know where you are cannot speak pace. So the requirement is not "do not use GPS", it is "hold it only while a session is running, and let go the instant it stops". |
| `SDK_Maintenance` and `Minimize_Permissions`, plus his own scanner | [`QR-08`](../../docs/quality-requirements/qr/QR-08.md), tested by `scripts/scan.sh`. |

### The one we fail today — say it before he finds it

> "There is one criterion we fail right now. An app that plays audio in the background has to style its notification with Google's media style, and ours does not — it is a plain ongoing notification. It is a small fix and it is filed as [issue #197](https://github.com/Running-Coach-App/running-coach-app/issues/197). We found it by reading the actual criteria instead of guessing, which is the best argument for having done this properly."

Two more honest notes, if there is time:

- The app asks for both fine and coarse location while Google asks for coarse "where possible". Fine is the right call for pace over short distances, but nothing in the repository said why, so now it does.
- Google's criteria for sign-in, web views, and video do not apply to us: we have none of those. And the three networking-security criteria are satisfied by absence — the app holds no network permission at all, which is a stronger position than any configuration.

### The scanner he asked for

> "You said: some kind of automated scanner in the repository that checks vulnerabilities, security problems, and dependencies, that you can run and anyone who wants to install can run. That is `./scripts/scan.sh`. One command, no Android tools needed, no account needed."

**Run it live if the connection allows.** What it checks, in order:

1. **Dependencies with known vulnerabilities.** All 149 locked dependencies are checked against Google's OSV advisory database. **Nothing that ships inside the app has a known vulnerability.** Nine packages with advisories do get pulled in by the build — Netty, Guava, Protobuf, Commons IO — and every one of them appears only in the Android build tool's harness for running tests on a device, which this project never invokes. They are not in the installable app and cannot reach a runner, so the scan reports them as warnings and does not fail on them. The reasoning is written into the script itself, not just into a document.
2. **The product cannot send data anywhere.** It checks that the manifest declares none of the six network permissions, that no file in the source references a networking type, and that a built app, if one is present, declares no network permission either.
3. **No credentials are committed.** Private keys, tokens, and API keys, over every tracked file.

It exits 0 when everything passes, 1 when a check fails, and 2 when a check could not run — because a scanner that silently checks nothing and prints "passed" is worse than no scanner.

**Two things to say about why it can be trusted, because they are the interesting part:**

- **We broke it on purpose and it caught us.** Adding `android.permission.INTERNET` to the manifest makes it fail with that reason named — and the CI workflow performs exactly that sabotage on every single run, so the test cannot rot into a check that always passes. During development three separate bugs were found that made it pass when it should have failed; one of them was caught by CI rather than by us. All three are fixed, and the negative tests are what found them.
- **It cannot be fooled by the tool being missing.** The advisories can come from two places: Google's `osv-scanner` tool when it is installed, or the OSV.dev web API when it is not. Those two could have reached different verdicts — and in an earlier version they did. Now neither decides anything: each produces a plain list of packages and advisory numbers, and a single piece of logic decides what fails. A package an advisory names that is not in the lock file at all counts as shipping, because we cannot prove it does not.

Google's own scanner workflow also runs alongside it and records its findings to the repository's security tab, with its own gate switched off deliberately: our script is what blocks a change, so there is one answer rather than two.

The dependency versions are also now locked — a lock file lists the exact version of all 149 — so an upgrade has to be a deliberate, reviewed change rather than something that happens quietly between two builds.

### What to ask him

6. ★ We scoped this to stability, background battery use, and security, and left the store-listing and device-matrix items out because there are three weeks left. Is that the 80 percent you meant, or is there something in there you would have put ahead of them?
7. The notification style is a real failure against Google's criteria and a small fix. Do you want it in this coming sprint, or behind the things you have already asked for — the screen titles, the Start labels, and the microphone control?
8. ★ You said "work towards publishing on the Play Store". Three things would have to change before a real submission: the build has to be an App Bundle rather than an APK, it has to be signed with a release key, and Google needs a data-safety declaration — which, now that you have asked us to collect usage metrics, would have to say so. Do you want us to actually move toward a submission, or is "ready to publish" enough for this course?
9. Run the scanner yourself, from the repository, whenever you like. If it tells you something you do not believe, that is the most useful bug report we could get. Would you?

## Part 4: The `UT-01` design (10 minutes)

Show [the record](../../docs/usability-tests/ut-01/README.md) on screen and walk it top to bottom. The framing:

> "This week we did not build a feature. We designed a test, because the one thing we have never had is somebody outside this team using the product. Everything we claim about not having to look at the phone, we have claimed about ourselves. We want to fix that, and we want you to tell us the test is asking the right thing before we run it rather than after."

**What to show, in this order:**

- **The three research questions.** Does a first-time runner work out how to start without being told; where do they take the phone back out of the pocket, and what are they looking for; do they recognise from sound alone that the session is running and then that it has ended.
- **The tasks.** One main task — be coached through a short run with the phone away, 12 minutes — and two secondary ones: find what the coach said on that run, and make the coach speak more slowly. Same three tasks, same order, every participant. The wording names no button and no screen, on purpose: the moment we say "press the volume key" we have tested our own instructions instead of the product.
- **Why asking a question aloud is not one of the tasks.** The question box is still a typed box, which is exactly the thing he asked us to replace with a microphone. Testing it now would measure a gap we have already agreed to close. It becomes a task in the next test.
- **The surveys.** A background questionnaire before, one standard ease question after each task, the ten standard System Usability Scale items after all three, and open questions at the end. All standard wording, so the numbers can be compared with anybody else's.
- **The instrumentation and its verification.** During a session the app tags its own records as usability-test traffic and stamps them with the participant's code, so the stopwatch can be checked against what the phone actually did. We verify that works on one of our own runs before the first real participant, and no session counts before that. It cannot cover the two secondary tasks or the question of where the phone was — only the observer sees that — and the record says so rather than pretending otherwise.
- **The consent, and the private repository.** Show the printed form. Every participant is 18 or older, is recorded, agrees that a sanitized summary is published, and can withdraw at any time. The recording, the raw notes, and the list joining a code to a name live in a private repository and a private folder that only the team and the instructors can open, and all of it is deleted after the course is graded. Nothing with a person's name in it goes near the public repository.
- **The recordings folder.** A team-owned cloud folder, shared with the instructors, linked from the private repository and the Moodle submission and never from a public page.
- **The session plan.** Three participants minimum, five as the target, 40 minutes each, outdoors on campus in the late-afternoon daylight, between 16 and 19 November.
- **[`QR-09`](../../docs/quality-requirements/qr/QR-09.md), and the bar.** The requirement this test settles is whether a stranger can start a coached session, hear it through and end it *without being told how*. The bar is set before the sessions: at least 0.6 of the participants have to do it with no help at all — 2 of 3, or 3 of 5. Below that, the product does not keep its promise, and we will report that it does not.

**What to ask him:**

10. ★ Does this test ask the thing you would want to know? If you could only have the answer to one of those three questions, which one?
11. The participant profile is somebody who runs or walks briskly for exercise and takes a phone along — not an athlete. Is that the person you want this tested on, or did you have someone narrower in mind?
12. Three participants minimum, five as the target. Is that enough for you to believe a result, or would you want more?
13. ★ The bar is that at least 0.6 of them get through the main task with no help. We set it before the sessions deliberately, so we cannot move it afterwards to make the result look better. Would you set it somewhere else — and if so, say now, because after the data it is not honest to change it.
14. The second and third tasks are looking back at a finished run, and changing the voice speed. Is there something else you would rather we watched someone try?
15. Do you want to be in the room for a session, or would that change what we see?

> If he pushes for the sessions to run this week rather than next: that is allowed. The design just has to be merged and the instrumentation verified first, and the record says both.

## Part 5: The Week 8 plan (3 minutes)

16. ★ Next sprint is the sessions, the results, and whatever they turn up as work. The results are due on 21 November. Does anything you have asked for need to come ahead of that?
17. When the results exist, how do you want them — the sanitized write-up in the repository, a walk-through in the meeting, or both?

## Part 6: Open questions carried from Week 6 (3 minutes)

These six have now been carried for two weeks because the meetings ran short. Ask them in this order and take whatever time is left. If we reach only two, reach these two first: 18 and 19.

18. ★ The speech recognition the phone provides may send what you say to Google to turn it into text. We did not choose that; it is how Android works unless we turn it off, and turning it off means some phones stop recognising speech at all. Which would you rather have? (`DEC-031` allowed performance and usage metrics to leave the phone; it did not settle spoken audio, and we are not treating it as if it did.)
19. ★ One of our goals was that somebody outside the team would finish a whole session by the end of Week 5. It did not happen and we recorded it as missed rather than quietly moving it. Should we set that goal again with a new date, or has it stopped being the right bar — given that the usability test is now how we get a stranger onto the product?
20. Do the two preset sessions still follow this coach, or have they left the plan?
21. After using the app, is heart rate from a wearable still worth one of the weeks that are left?
22. Are professional runners in scope later, or is this product for beginners to intermediates for good?
23. For the file export you preferred over a server: what would you do with that file once you had it?

## Close (1 minute)

- Read back every decision made, in his words, and say that each will appear as a `DEC-nnn` in [the decisions page](../../docs/decisions.md).
- Read back every action point, with its owner and its due date, and confirm each owner out loud.
- Confirm what we are allowed to publish from this meeting, which was answered in Part 1.
- Say when the results of the usability test will exist: 21 November.

### Carried action points to close out loud

Each of these was due 2026-11-14. Say what happened to each one, including the ones that did not happen.

| Action from Week 6 | What to say |
| --- | --- |
| Choose the Play Store publishing rules that fit, and add a scanner a stranger can run | Done. Part 3 is the answer. |
| Title the run screen Run, drop Start from the labels, show the stats without a typed question, replace Ask with a microphone control | Say honestly whether it is built. If it is not, it is now blocking a usability task as well as him. |
| Build the app, install it on his phone, confirm pocket and headset use | His. Part 2. |
| Ask the carried questions on the presets, professional runners, the wearable, the recogniser, and the export shape | Part 6 is that. |
| Add the metrics opt-out, default on | Say honestly whether it is built. |
