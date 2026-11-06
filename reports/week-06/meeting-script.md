# Week 6 meeting script

For the `SPRINT-06` validation meeting. Thirty minutes. The team runs it; one member keeps the transcript.

Two things make this meeting different from the last one. The `Customer` has an installable build for the first time, so the questions about his own run are finally askable. And the week's work is telemetry, which touches the one thing he has already said no to twice: data leaving the phone. Part 3 of the agenda asks for that permission explicitly rather than assuming it.

## Before the call

- Have [`v0.3.0`](https://github.com/Running-Coach-App/running-coach-app/releases/tag/v0.3.0) open, with the APK visible under Assets.
- Have the app running on a phone, so a session can be started during the call.
- Have [the threshold of success](../../docs/threshold-of-success.md) open at `TOS-02`.

## Part 1: His own run (8 minutes)

The whole of Week 5 failed on this. Ask it first, before anything the team built this week.

1. Did you install the app from the release page? If not, what stopped you — the download, the install warning, or time?
2. If you ran with it: what did you hear, and in what order? Did the coach speak the start, the stats, the effort cue, and the stop?
3. Did you keep the phone in your pocket the whole time, or did you take it out? If you took it out, why?
4. Did anything the coach said arrive at the wrong moment — too early, too late, or on top of something else?
5. Did you try asking it a question out loud? What did you ask, and what came back?

## Part 2: The changes you asked for (4 minutes)

`DEC-024`, `DEC-025` and `DEC-026` were agreed last week and are not in this build. Say so before he looks for them.

6. The run screen is still titled by the session kind, the buttons still say Start, and Ask is still a typed box. These are the next work. Does that order still match what you want, or has something moved ahead of them?

## Part 3: Recording what the app does (8 minutes)

This is the week's subject and the week's permission question. Do not lead with the word analytics.

7. When something goes wrong on a run — the coach goes quiet, or says something odd — how would you want us to find out why?
8. For us to answer that, the app would have to keep a record of what it did: when a session started, when it spoke, when it lost the GPS fix. No audio, no words you said, no name, nothing about you. Would you be comfortable with the app keeping that on your phone?
9. Would you be comfortable with that record leaving the phone — sent to us, or exported by you as a file you choose to send?
10. You said last week that runs stay on the device and a file export is better than a server. Does that same answer cover these records, or are they different to you?
11. Is there anything you would not want recorded, even with no name attached?

## Part 4: What the numbers should say (4 minutes)

12. If you could see one number about how the app is being used, what would you want it to be?
13. Would a number about how many people finish a whole session tell you anything useful, or is that the wrong question at this stage?

## Part 5: The threshold (3 minutes)

14. One of the goals we set was that somebody outside the team would run a whole session from the setup page by the end of Week 5. That did not happen, and we have recorded it as missed rather than quietly moving it. The build that would have made it possible only existed afterwards. Should we set that goal again with a new date, or has it stopped being the right bar?

## Part 6: Carried questions (3 minutes)

These are the five from Week 5 that the meeting did not reach. Ask whichever the time allows, in this order.

15. The speech recognition the phone provides may send what you say to Google to turn it into text. We did not choose that; it is how Android works unless we turn it off, and turning it off means some phones stop recognising speech at all. Which would you rather have?
16. Do the two preset sessions still follow this coach, or have they left the plan?
17. After using the app, is heart rate from a wearable still worth one of the weeks that are left?
18. Are professional runners in scope later, or is this product for beginners to intermediates for good?
19. For the export you preferred over a server: what would you do with that file once you had it?

## Close

- Read back every decision made, in his words, and say each will appear as a `DEC-nnn`.
- Confirm the two action points the team owes him by the end of Week 7.
- Ask whether he is recording, and whether the transcript may be published in the repository.
