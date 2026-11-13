# UT-01 surveys

Every question a participant is asked in a `UT-01` session, in the order it is asked. The record is [`README.md`](README.md); the facilitation script that holds these together is [`sessions/README.md`](sessions/README.md).

Nothing here asks for a name, an email address, a phone number, an address, or anything else that identifies a person. The participant is known by their `P-nn` code, and only the identity mapping in the private usability-data repository joins the code to a person.

## Pre-test, before the tasks

Asked once, at the start of the session, after the consent.

1. **Are you 18 or older?** (Yes / No. A participant who answers No does not take part, and nothing about them is recorded.)
2. How often do you run, jog, or walk briskly for exercise? (Less than once a month / once or twice a month / about once a week / more than once a week)
3. Do you take a phone with you when you do? (Always / sometimes / never)
4. Which apps, if any, have you used while exercising? (Open answer: the kind of app, not an account or a username.)
5. Have you used an app that talks to you while you exercise? (Yes / No / Not sure. If yes: which kind, and what did you make of it?)
6. Where do you usually keep your phone while exercising? (Pocket / armband or belt / hand / somewhere else / I do not take it)
7. Do you usually wear headphones while exercising? (Yes, wired / yes, wireless / no)
8. Before you have seen anything of it: what would you expect an app that coaches you out loud while you run to do for you?

## SEQ, after each task

Asked immediately after each of the three tasks, about that task only, in the standard wording and on the standard seven-point scale.

> **Overall, how difficult or easy was the task to complete?**
>
> 1 is very difficult, and 7 is very easy.

| 1 | 2 | 3 | 4 | 5 | 6 | 7 |
| --- | --- | --- | --- | --- | --- | --- |
| Very difficult | | | | | | Very easy |

A higher score means the task was easier. The answer is recorded as the number the participant gives, and the facilitator does not discuss it before the next task.

## SUS, after all the tasks

Asked once, after all three tasks, in the standard order and the standard wording, with no item reworded and none left out.

Each item is answered on a five-point scale from strongly disagree (1) to strongly agree (5).

| # | Item | 1 | 2 | 3 | 4 | 5 |
| --- | --- | --- | --- | --- | --- | --- |
| 1 | I think that I would like to use this system frequently. | | | | | |
| 2 | I found the system unnecessarily complex. | | | | | |
| 3 | I thought the system was easy to use. | | | | | |
| 4 | I think that I would need the support of a technical person to be able to use this system. | | | | | |
| 5 | I found the various functions in this system were well integrated. | | | | | |
| 6 | I thought there was too much inconsistency in this system. | | | | | |
| 7 | I would imagine that most people would learn to use this system very quickly. | | | | | |
| 8 | I found the system very cumbersome to use. | | | | | |
| 9 | I felt very confident using the system. | | | | | |
| 10 | I needed to learn a lot of things before I could get going with this system. | | | | | |

### The score

```text
SUS = 2.5 × (20 + sum(odd items) - sum(even items))
```

The odd items are the five positively worded ones — 1, 3, 5, 7, and 9 — and the even items are the five negatively worded ones — 2, 4, 6, 8, and 10. The even answers are subtracted rather than added, which is what the formula does with them.

The responses used in the formula are the recorded 1-to-5 answers as the participant gave them. **The even items are not reverse-coded before the formula**, because the formula already accounts for their direction; reverse-coding them first and then subtracting them would count their direction twice.

The score runs from 0 to 100 and is not a percentage. [The results](results.md) report the mean and the median with `n=<count>` beside each, because a sample of three to five supports no claim about a population.

Worked check, so the arithmetic can be verified: a participant who answers 5 to every odd item and 1 to every even item gives `sum(odd) = 25` and `sum(even) = 5`, so `SUS = 2.5 × (20 + 25 - 5) = 100`. One who answers 1 to every odd item and 5 to every even gives `SUS = 2.5 × (20 + 5 - 25) = 0`. One who answers 3 to everything gives `SUS = 2.5 × (20 + 15 - 15) = 50`.

## Open-ended post-test, after the SUS

Asked once, after the SUS, and answered in the participant's own words. The observer writes down what is said; the recording carries the rest.

1. What was your overall impression of being coached out loud while you ran?
2. Was there a moment where you did not know what the app was doing, or what to do next? What was happening then?
3. You took the phone out of your pocket (or did not). What were you looking for when you did — or what kept you from needing to?
4. What would you change about it?
5. Would you use this on your own next run? Why, or why not?
6. What did we not ask that we should have?

## What is done with the answers

The pre-test, the SEQ, the SUS, and the post-test are recorded for every counted participant, and missing data is never invented: a question a participant did not answer is recorded as not answered.

The raw answer sheets go to the private usability-data repository. The sanitized session note in [`sessions/`](sessions/README.md) carries the SEQ numbers, the SUS score, the themes, the device, the familiarity, and the relation to the target user — and a quote only when that participant's consent covers it. [The analysis plan](README.md#analysis-plan) says what is computed from them.
