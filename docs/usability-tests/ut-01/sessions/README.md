# UT-01 session instructions

Everything the two team members running a session need, in the order they need it. The design is in [the record](../README.md); the questions are in [`surveys.md`](../surveys.md); the consent is [`consent.md`](../consent.md).

One sanitized note per counted session is filed beside this file as `P-01.md`, `P-02.md`, and so on, from the template at the end.

## Before the participant arrives

Both members, together, on the day:

- [ ] The route walked, dry, and in daylight. A pavement where somebody can jog without watching their feet.
- [ ] The app's data cleared on the phone, so the product has never been run. This is the seed.
- [ ] The usability build installed — telemetry source `usability-test`, the `P-nn` control present. Not a release build.
- [ ] The next free `P-nn` code entered in that control.
- [ ] Phone battery above 50%. Headphones working. Volume at a level a participant can hear outdoors.
- [ ] The audio recorder working, tested on a sentence, and with space on it.
- [ ] A printed consent form, a printed observation sheet, a pen, and a stopwatch that is not the phone under test.
- [ ] The phone's own notifications silenced, so nothing but the coach speaks.

## Roles for the session

| Role | Member | During the session |
| --- | --- | --- |
| Facilitator | [@sirjaey](https://github.com/sirjaey) | Speaks. Reads the scenarios verbatim, applies the help rule, applies the stop rule. |
| Observer | [@Ezekiel-Gadzama](https://github.com/Ezekiel-Gadzama) | Silent. Fills the observation sheet: outcome, hints, time, pocket exits, friction, quotes. |
| Recordings and notes | [@sirjaey](https://github.com/sirjaey) | Afterwards: files the recording, the consent, the sheets, and the telemetry export. |

The same facilitator runs every counted session. At least two of the three are present. The observer does not speak to the participant during a task. The facilitator holds the filing role as well, for [the reason in the record](../README.md#roles); it is done after the session, so it does not compete with running one.

## The script

Read the parts in quotation marks as they are written. Everything else is an instruction to the facilitator.

### 1. Welcome

> "Thanks for coming. We are building an app that coaches you out loud while you run, so you do not have to look at your phone. We want to find out where it is confusing.
>
> The important thing is that we are testing the app, not you. If something does not make sense, that is the app's fault and it is exactly what we need to find. There is nothing you can get wrong here.
>
> This will take about forty minutes. Part of it is a short run — about five minutes, at whatever pace you like, and you can walk it if you prefer. You can stop at any point for any reason, and you do not have to tell me why."

### 2. Consent and the recording check

Hand over [`consent.md`](../consent.md) printed. Let them read it; do not summarise it for them. Then:

> "Before anything else, I have to ask about recording. We record the audio of the session, which is what you say and what the app says. It stays private — only our three team members and the course instructors can hear it. It is deleted when the course is graded.
>
> Are you happy for us to record?"

**If they say no, the session stops here.** Thank them, record nothing, and recruit a replacement under the next free code.

> "There is also an optional one: we may publish an anonymized quote of something you say. That one is entirely up to you, and the session goes ahead either way."

Collect the signed form. **Start the recorder now**, and say the date and the `P-nn` code aloud onto the recording so it is identifiable without the name.

### 3. The pre-test

Ask the eight pre-test questions from [`surveys.md`](../surveys.md#pre-test-before-the-tasks) in order. Question 1 is the 18-or-older check; if the answer is no, stop and record nothing.

Write the answers on the observation sheet. Do not comment on any answer.

### 4. The think-aloud instruction

> "While you are using it, please say out loud what you are thinking — what you are looking at, what you expect to happen, what is confusing you. It feels odd at first and it is the most useful thing you can give us.
>
> If you go quiet I might say 'keep thinking aloud'. That is not a hint, it is just a nudge.
>
> I will not be able to answer questions about the app itself while you are working. If you ask me something, I may not reply, and that is not me being rude — it is so that what you do is what a person on their own would do."

### 5. The main task

Hand them the phone, unlocked, with the app open on the screen it opens on. Start the stopwatch at the end of the last word.

> "You are about to go out for a short run, and you want this app to coach you out loud while it is in your pocket. The phone is in your hand with the app open. Go when you are ready, and finish the session when you have had enough."

Then be quiet. Walk or jog alongside, far enough back not to be looked at for guidance. The observer notes every pocket exit and everything said.

Stop the stopwatch when the session has been ended, or at 12 minutes, whichever is first.

**The help rule**, per [the record](../README.md#the-help-rule): help is anything that moves them forward that they did not work out themselves. If they are stuck and ask directly, wait ten seconds, then give the smallest hint that unblocks them and **say the word "hint" aloud** so the recording marks it. From that moment the task is `Assisted`. Write down what the hint was.

Then ask the SEQ, about this task only:

> "Overall, how difficult or easy was that task to complete? One is very difficult, seven is very easy."

### 6. Secondary task 1

Stopwatch resets. Read it verbatim:

> "You have finished the run. You want to see what the coach told you while you were out, and how far you went."

Three minutes. Then the SEQ for this task.

### 7. Secondary task 2

> "On your next run, you would like the coach to speak more slowly than it just did."

Three minutes. Then the SEQ for this task.

### 8. The SUS

All ten items from [`surveys.md`](../surveys.md#sus-after-all-the-tasks), in the printed order, read as written, five-point scale. Do not explain an item, and do not agree or disagree with an answer. If asked what an item means:

> "Whatever it means to you — there is no definition I am supposed to give you."

### 9. The open-ended post-test

The six questions from [`surveys.md`](../surveys.md#open-ended-post-test-after-the-sus). Let them talk. Do not defend the product, do not explain what it was supposed to do, and do not say what other participants did.

### 10. The debrief

> "That is everything. Is there anything you said today that you would rather we did not keep?
>
> If you change your mind later, tell any of us and we will delete your recording and your notes, no reason needed, any time before the course is graded."

Answer any question about the app now — this is after the data, so it costs nothing. **Stop the recorder** and say so aloud.

### The stop rule

The facilitator stops the session when:

- the participant asks to stop, for any reason or none;
- the participant seems unwell, or the route has become unsafe;
- the team sees a critical or security-sensitive problem in the product.

Say what is happening, stop the recorder, and write the stop and its reason on the sheet. A session stopped before its data is complete does not count, its code is retired, and a replacement is recruited under the next free code.

## After the session

- [ ] Export the session's telemetry file off the phone over a cable, with the `P-nn` code in it.
- [ ] File the recording in the cloud recordings folder, under the code.
- [ ] File the consent form, the observation sheet, the answer sheets, and the telemetry export in the private usability-data repository, under the code.
- [ ] Add the row to the identity mapping in the private repository.
- [ ] Write the sanitized note in this directory as `P-nn.md`, from the template below.
- [ ] Clear the app's data on the phone, ready for the next session.
- [ ] Nothing from the session is committed to this repository except the sanitized note.

## The observation sheet

Printed, one per session, filled by the observer. It stays in the private repository; the sanitized note is what becomes public.

```text
P-__        Date: ________        Facilitator: ________        Observer: ________

Recording consent: Y / N          Public results consent: Y / N      Quote consent: Y / N

PRE-TEST  (answers 1-8, from surveys.md)
______________________________________________________________________________

MAIN TASK — coached session, phone in pocket                       limit 12:00
  Outcome:  Unaided / Assisted / Failed            Time on task: ____:____
  Pocket exits (count):  ____     at what moment, and looking for what:
  Hints given (verbatim, with the time):
  Said out loud (verbatim where possible):
  Friction:
  SEQ (1-7): ____

SECONDARY 1 — find what the coach said on that run                  limit 3:00
  Outcome:  Unaided / Assisted / Failed            Time on task: ____:____
  Hints:                                            SEQ (1-7): ____
  Notes:

SECONDARY 2 — make the coach speak more slowly                      limit 3:00
  Outcome:  Unaided / Assisted / Failed            Time on task: ____:____
  Hints:                                            SEQ (1-7): ____
  Notes:

SUS  (1-5 each, as given)
  1:__  2:__  3:__  4:__  5:__  6:__  7:__  8:__  9:__  10:__     Score: ____

POST-TEST  (answers 1-6)
______________________________________________________________________________

Stopped early?  N / Y — reason:
Telemetry export taken?  Y / N        Recording filed?  Y / N
```

## The sanitized session note template

Filed as `P-nn.md` in this directory. Public. It carries no name, no email address, no phone number, no address, no free-text identification, and no recording — and a quote only when that participant's consent covered it.

```markdown
# P-01

- **Relation to the target user:** <runs or walks for exercise, how often, in their own terms but not their words>
- **Familiarity:** <the kinds of app used while exercising>
- **Device:** the team's Android phone, <wired or wireless> headphones, <pocket or jacket>

## Outcomes

| Task | Outcome | Time on task | SEQ | Hints |
| --- | --- | --- | --- | --- |
| Main: coached session, phone away | Unaided | 4:10 | 6 | 0 |
| Secondary 1: what the coach said | Assisted | 1:45 | 4 | 1 |
| Secondary 2: slower voice | Unaided | 0:40 | 6 | 0 |

- **Pocket exits during the main task:** 0
- **SUS:** 77.5

## What happened

<two to five sentences: what they did, where they hesitated, what they said they expected, and what the hint was if one was given>

## Themes

- <theme, in the team's words, not a single remark dressed up as a theme>

## Quotes

<Only with quote consent. Otherwise write: No quote is published from this session.>
```

A note for a session that did not count is not filed here at all: it goes to the private repository with the reason, and [the results](../results.md) record that the code was retired.
