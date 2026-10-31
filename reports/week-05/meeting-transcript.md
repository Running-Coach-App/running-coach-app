# Week 5 validation meeting transcript

- **Date:** 2026-10-31
- **Participants:** Ezekiel-Gadzama, sirjaey, ObeTech1, Customer
- **Note:** Sanitized from the call recording transcript the `Customer` supplied. Speakers are labelled with GitHub usernames or `Customer`. Filler and unrelated course-administration discussion were shortened. The raw recording stays out of the repository.

[00:00] Ezekiel-Gadzama: Thank you for your time. We continued developing the app, updated the UI, and added extra functionality you did not ask for. Before we show that: did you install the previous app on your Android?
[00:40] Customer: Not yet. I am working on it. It is a bit more involved than I expected. I will install for sure. Hopefully this weekend.
[00:57] Ezekiel-Gadzama: Last meeting we agreed to add a speech display, so whenever the app speaks it shows the text. We did that. We do not have a video; we have screenshots. We wanted you to have tried it yourself. I will show these.
[01:26] Customer: Send me the screenshots. You can send them on Telegram.
[02:17] Ezekiel-Gadzama: I sent them.
[02:19] Customer: You could have posted them in the channel. Anything you want to share, posting in the channel is fine.
[02:45] Customer: It looks pretty good. I was confused about History, then I saw Run is highlighted. That makes sense: there is no history from that run yet.
[03:32] Customer: One comment on the interface. Profile is highlighted when selected, and above it says Profile. History is the same. When you pick Run, the heading is a different word: Interval. I understand why — interval versus steady — but the inconsistency throws you off. History and Profile keep the same word above and below; Run changes it. Either change History and Profile the same way, or make Run also say Run, and put Interval in another place or font.
[05:11] Ezekiel-Gadzama: We also wanted to ask about the name of the app. Do you have a specific name or logo? We made a logo with a mark and two stripes. We are thinking of a name.
[05:36] Customer: I will let you name it anything you want. I did not have any specific name or logo.
[05:53] Ezekiel-Gadzama: Are you happy with this screen?
[06:00] Customer: It is pretty good. You have Start interval. I am not quite sure what Start steady means. You do not need to say Start: Interval, Steady, and Stop. I think it is good for a first iteration.
[06:53] Customer: In the box you probably want to specify what kind of questions they can ask. Right now it says type a question, which leads the user to type anything, like the weather. It would be nice if you showed the response. This screenshot just says type a question, and I do not know where the answer would be.
[07:32] Ezekiel-Gadzama: The last image is the green overlay: you covered no distance, time. That is the coach.
[08:06] Customer: Then Ask should not provide typing. Speak so I can ask. Typing questions is not useful if it is already showing the stats. When I first see it, it does not show me anything.
[08:36] Customer: Maybe it should just show whatever it has right away. I do not even need to ask. If that is the only thing I can ask for, just show it to me.
[08:48] Ezekiel-Gadzama: I am not clear what you mean.
[08:53] Customer: The box, type a question, and Ask at the bottom. If I type what are my stats, it shows the stats. Besides stats, what else can you show me?
[09:28] Ezekiel-Gadzama: Not yet. It is just that.
[09:31] Customer: Why make me ask for this if that is the only thing I can ask? If it is the only thing on the menu, just bring it. Do not give me a menu.
[10:09] Customer: Maybe you meant the microphone: turn it on so I can speak. There is no point in a type-a-question box, because you will just produce the stats. I open the phone, I see them. Maybe give me control over the microphone: turn it on, then it listens.
[11:19] Customer: Replace Ask with the microphone.
[11:42] sirjaey: If you turn off the microphone, how do you turn it back on?
[11:49] Customer: You open the app and turn it back on. It has to be very clear that the microphone is off, and then we will not get any commands. That is a good feature: I meet a friend, I do not want the app listening, I stop the microphone, I talk, then I turn Interval or Steady, turn the microphone on, and put the phone in the pocket. You are giving me control. You are not listening all the time.
[13:04] Ezekiel-Gadzama: Do you currently have quality requirements — how many users at launch, what we should test?
[13:25] Customer: Open the Google Play requirements for publishing. That list says what the app should and should not do. Play Store will punish an app that takes a lot of CPU or battery. In terms of quality requirements, go with what Play Store requires: the top things, as many as fit this course. Do not invent wheels. Work towards publishing on the Play Store. The app also has to work in the background; they have requirements for that, and the background should not crash.
[15:12] Customer: For myself I would add some kind of automated scanner in the repository that checks for vulnerabilities, security problems, and package dependencies. That is a quality requirement from me. It takes research. The most important qualities are security and proof, for open source, that you are not sending data somewhere. People know the scanner: they can run it and see. For everything else, Google Play Store publishing requirements. Limit the scope: quality is not the only thing you need to do. The most important 80 percent, if we can complete that, would be great.
[17:32] Ezekiel-Gadzama: For the next iteration we plan to include sign-in and sign-up so the user can see their history later, because we would back the data in a database. Do you prefer a particular database?
[18:25] Customer: Store everything on the device. If I delete the app and I did not export the history, it will be gone, and that is fine. Adding login or storing things elsewhere adds complexity: security, complying with storing data, users uploading crazy stuff, securing the database. I think it is outside of the scope. If this app just works without sending human data, and stores the runs locally, I would rather work on data export and import: export from the app to something like comma-separated values I can put wherever I want. That is the user's problem. I would rather not have the app connecting to any servers we do not need.
[20:20] Ezekiel-Gadzama: We want to test it with a runner, give a student who runs the app, and ask for feedback next week.
[20:35] Customer: That would be cool. That would be interesting, what people are doing, how it works.
[20:46] sirjaey: You asked the questions I had in mind. No questions from my end. Thank you.
[20:56] Customer: You are doing a great job. I will be one of your users. I will install. Two things to highlight again: Google quality requirements for publishing in Play Store, and a security check in the repository that I can run for myself, and that anyone who wants to install can run.
[22:02] ObeTech1: Sorry, I had an electricity and connection issue.
[22:05] Customer: Do not worry. You can watch the recording. I have the transcript. Do you have any questions?
[22:15] ObeTech1: No.
[22:18] Customer: I will post the recording as soon as it is ready. Remind me if I have not posted in an hour.
[23:23] Customer: Thank you. Bye.
