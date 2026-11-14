# Week 7 validation meeting transcript

- **Date:** 2026-11-14
- **Participants:** Customer, sirjaey, Ezekiel-Gadzama, ObeTech1
- **Note:** Sanitized from the WebVTT the `Customer` supplied on 2026-11-14. Speakers are labelled with GitHub usernames or `Customer`. Filler, unrelated asides, and duplicate fragments were shortened. The raw recording stays out of the repository.

[00:03] Customer: I am ready. Do you have any questions for me?

[00:27] sirjaey: The first question: have you installed the app on your phone?

[00:36] Customer: Yes. I built the most recent version from `main` and tried running with it.

[00:52] Customer: Starting a session worked. As I was running, it would tell me to run harder or slow down. I thought that was okay.

[02:05] Customer: On a Pixel 8, with the screen off in a running pouch, no commands responded. Volume up and volume down did not help. I had to take the phone out. Only with the app in the foreground could I ask anything, and even then only sometimes.

[02:50] Customer: I could say what is my time and it would respond sometimes. What is my pace — I tried several phrasings — it never would.

[03:18] Customer: It feels like the program is listening on the phone microphone, not the headphones. When I moved the phone closer it answered more often; behind me, with working headphones, it did not.

[04:04] Customer: It is very rigid in what I can ask. If I said stats it told me to keep running and not ask questions, which is okay — we agreed on that — it was kind of funny. Cars passing made it worse.

[04:51] Customer: In about twelve minutes — roughly eight in the background and five with me looking at the screen — it used 6% of my battery. For comparison, 37 minutes of a game used 9%. Something is happening with battery consumption.

[06:04] Customer: Android's own voice recognition shows about 3%, which is fine. Extrapolating, an hour of running would hurt the battery badly. The phone got warm.

[07:02] Customer: The box where you type a question is useless. I had to stop running to enter what I already see on screen. That has to go. If something stays on screen, it should be a microphone toggle.

[07:52] Customer: It would be nice to set the stats update interval. In about ten minutes it spoke my stats once; I thought we agreed on something like every two minutes. Effort cues were fine.

[08:52] Customer: I checked the repository on security and other points — all fine, nothing concerning.

[09:13] Customer: The README should explain how to start and what value you get. I had to ask a coding assistant what to do with the repository instead.

[10:05] Customer: In summary, as it stands it is not very useful for running. Voice commands did not work. Maybe as a watch app it could show distance, but other apps already do that.

[10:35] Ezekiel-Gadzama: We will try to fix voice using the phone instead of the headset, and improve question matching.

[11:01] Customer: It is only my suspicion that it uses the phone mic — I tested closer and further but I am not sure.

[11:16] sirjaey: On my phone, with the screen off in a pocket, it still works with my headset — but we will look into the Pixel 8.

[11:37] Ezekiel-Gadzama: For rigid questions, maybe we add a small on-device model to map questions better.

[12:29] Customer: Try a different approach first. Ask a language model to generate many rules and phrasings — not just time, pace, and distance. More rules detecting intent may be enough. Moving to an embedded model is a lot of work and will make battery life worse — maybe five seconds and then done.

[14:04] Customer: Some apps show controls on the lock screen. At least let me see stats and stop without unlocking. Look up what blocks that on Pixel 8.

[15:45] Customer: And remove the typed question box when I look at the app.

[15:55] sirjaey: That is done — it was merged this morning, about twelve hours ago, and is on `main` now. If you pull the latest debug APK you will see the UI changes.

[16:37] Customer: I will try that. I saw you can get the run report as JSON; I will pull one and send it.

[17:06] sirjaey: We finished Play Store publishing research and set up the repository scanner so a stranger can see permissions and what the app does.

[17:31] sirjaey: For battery: GPS was on for the whole session before; now GPS runs only while a run is active and stops when the runner stops.

[18:37] Customer: You could turn GPS on only occasionally — a pace or step detector could tell you how far I walked. Consumer GPS does not need a continuous fix. Every 200 steps might be enough.

[20:19] sirjaey: We also implemented turning the microphone off mid-run, as you asked last time.

[20:51] Customer: I will try the new build again.

[21:10] Customer: The on-screen display is enough for this project. The point was whether voice control while running is feasible and useful.

[22:03] Customer: Does the app save the conversation from speech-to-text? I probably should not — but maybe for debugging, for a version, save what we get.

[22:56] Customer: Maybe tie the microphone to running: detect running, turn listening on, say command mode is on; when I stop, command mode off. Another idea.

[24:03] sirjaey: We will try that. Thank you for the feedback. Any more questions from colleagues?

[24:18] Ezekiel-Gadzama: I have none.

[24:28] Ezekiel-Gadzama: We could end — unless anyone has questions.

[24:37] Customer: Obe joined — camera is off now?

[24:44] ObeTech1: I am here; I had electricity issues and turned the camera off. Sorry.

[25:20] Customer: What are your plans for the next part?

[25:31] Ezekiel-Gadzama: I am setting up the university server to auto-deploy from `main`, with an install URL plus building from GitHub. Error and usage logs could go to the server when usage data is on. We will work through your comments on battery and the rest.

[27:04] Customer: Joshua was probably right — constant GPS checks; the phone got warm. Be clever about cheap versus expensive sensors.

[28:35] Customer: In about two weeks there is usability study work — are you planning to ask students or other users to try the app?

[29:07] Ezekiel-Gadzama: We have to. In Russia it is about 4°C; I do not think anyone will run outside in this weather. Someone in Nigeria might be better.

[29:33] Customer: What is the temperature there now?

[29:43] Ezekiel-Gadzama: About 4 degrees, feels like minus one. There is some snow but not much.

[30:02] ObeTech1: Here in Nigeria it is about 20 degrees Celsius this morning.

[30:02] Customer: I had the opposite — hot when I ran. If you have friends elsewhere, ask them.

[30:43] sirjaey: How do we document their responses?

[30:47] Customer: Pre-test questionnaire, then post-test after they use the app. Remote is harder to follow, but you can give instructions and see what they think.

[31:52] Customer: The app is not as important as you practicing questionnaires, talking to users, and processing messy responses.

[32:39] Customer: You can try the questionnaire on me when I install the updated app — but you need more than one participant.

[33:10] sirjaey: The submission deadline is still today. Thank you for sending transcript and recording early last week.

[33:27] Customer: You want the transcript early today — yes, I will work on it.

[33:42] sirjaey: Thank you very much.
