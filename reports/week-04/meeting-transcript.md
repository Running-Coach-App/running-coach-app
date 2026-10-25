# Week 4 validation meeting transcript

- **Date:** 2026-10-23
- **Participants:** Ezekiel-Gadzama, sirjaey, ObeTech1, Customer
- **Note:** Sanitized from the call recording transcript the `Customer` supplied. Speakers are labelled with GitHub usernames or `Customer`. Filler and unrelated course-administration discussion were shortened. The raw recording stays out of the repository.

[00:00] Customer: I started recording.
[00:08] Ezekiel-Gadzama: We have been developing and achieved some of the functionality. This meeting is to understand the quality of what we built. We sent you an APK to install — have you tried it?
[00:56] Customer: I have not installed it. I would like to run it in a VM first, or use your repository and build the APK myself. I trust you, but when you send an APK via Telegram I do not know which build it is. I will use the repository so I know what I install on my phone.
[02:01] Ezekiel-Gadzama: We can share screen and show what the app does.
[02:11] Customer: Yes, share screen.
[02:33] Ezekiel-Gadzama: Session started. Jog. What is my distance? Distance is not available yet. What is my time? Time zero minutes twenty-two seconds. What will I eat today? Food is for after the run — keep moving. A second off-topic question gets a focus-on-the-run reply. What's my pace? Hard. Not my department — save it for the finish line. Session stopped.
[04:11] Ezekiel-Gadzama: What is your overall view of what you watched?
[04:29] Customer: The audio was good. It would be nice if the same information were displayed on screen when I ask and when it speaks. If I have the app open, what it says and what it shows should match. What did you use for speech-to-text and text-to-speech?
[06:03] sirjaey: Android platform APIs in the coach service code — not a baked-in model.
[06:44] Ezekiel-Gadzama: We plan to improve the UI next so spoken lines also appear on screen; for now we focused on functionality.
[07:18] Customer: Fine. Did you make it rule-based or use an LLM?
[08:05] sirjaey: Rule-based — keywords for themes like weather and food; otherwise it asks you to focus on time, pace, and distance.
[08:34] Customer: It would be interesting to try distance, pace, and time in different phrasings — not only "what's my time" but "how long have I been running" or "how am I doing". For the first cut this sounds fine. It would definitely be nice to see stats on the screen. I like it so far.
[09:45] Ezekiel-Gadzama: How would you rate the responses — anything to add?
[10:08] Customer: For a first usable product it is okay. A bit more polite and brisk would be nice. If I ask the same question twice, different wording would be interesting, but not required. Showing the data on the phone is more important.
[11:10] Ezekiel-Gadzama: That is all from my questions.
[11:23] ObeTech1: Next time we can show distance on screen and a better UI, or share a UI prototype before we implement it.
[12:02] Customer: I will build from your repository once I have the tooling installed and put it on my phone, but I will not install an APK I did not build. I work in security — healthy paranoia.
[13:04] sirjaey: When you install, please try screen-off pocket use and Bluetooth headsets; we tested those paths.
[13:34] Customer: Good. Feedback from my own run will take until later this week — not tonight. You can proceed with showing stats on screen. Screen off and headset matter.
[15:02] sirjaey: One of us is on academic leave; we are three on the team now.
[15:10] Customer: For the course the important part is practising stages, getting feedback early, and planning several weeks ahead.
[17:20] Ezekiel-Gadzama: Question about using a real customer company in a later course — answered with the university registration process and risk rules.
[22:47] Ezekiel-Gadzama: Thank you. See you Saturday at this time.
[23:02] Customer: Yes, Saturday. You can send questions or app videos on Telegram asynchronously; I will check when I can.
[23:34] Customer: Have a nice day. Bye.
