# Week 6 validation meeting transcript

- **Date:** 2026-11-07
- **Participants:** Ezekiel-Gadzama, sirjaey, Customer
- **Note:** Sanitized from the call recording transcript the `Customer` supplied. Speakers are labelled with GitHub usernames or `Customer`. Filler and unrelated asides were shortened. The raw recording stays out of the repository.

[00:00] Ezekiel-Gadzama: We have finished development of our tasks. The TA gave us access to a university virtual machine to host the application, but you already required that we store everything locally. There is no need for the server, because our data is not being sent externally. Is it completely fine if we do not host the application there?
[00:56] Customer: Sorry, I did not quite understand. What are you trying to achieve there?
[01:08] Ezekiel-Gadzama: Our TA gave us access to a virtual machine so we could host the application. Since you expect everything to be localised, there is no need to host it on that server.
[01:43] Customer: Since it is an Android application, you can have it on GitHub. What you will need to do is collect metrics from the application. Whenever somebody installs it, you need to collect how they use it, and you use those metrics to understand what is going on. When an application runs on Android, Google collects metrics anyway, and if it crashes a lot on some phones they will hide it from Google Play for those phones.
[02:48] Customer: You should add collecting information from the device: how often it crashes, how it works, performance, and other metrics. This will help you in development, and it will help you in usability studies. You can ask a user to do something and then give them a questionnaire, but with the phone it is nicer when you can record where it goes, or whether it crashed.
[03:50] Ezekiel-Gadzama: Yes.
[03:51] Customer: You should do that. Even if it is localised, even if they have to download it onto the phone, you should still add collecting metrics. Be nice to the user and ask them: are you okay with that? That option is good. If Alice wanted to try the application and was not comfortable sending your server information about her phone, that is fine, they can choose that. You should have that option. By default, enable it.
[04:53] Customer: It is local, yes, you are not sending it, and you do not have a joint database somewhere in the cloud. It is okay to send your application performance data, the usage data, and so on.
[05:18] Ezekiel-Gadzama: Two more questions. Have you installed the app and tried it? And in Russia there is GPS jamming: you can be in one location and GPS shows a different one. What should the app do in that period? If it speaks and you ask questions then, the data would be incorrect.
[06:01] Customer: Why would it not be correct? My phone is with me, I installed your application on my phone, so it just sends the data from whatever my phone sees. If I am in Russia, it is in Russia.
[06:25] Ezekiel-Gadzama: If you go to Kazan, you can be in one location and the GPS shows another.
[06:35] Customer: I see. They jam GPS. There are also other things, like stride: a sensor that shows your walking stride, how many steps you made. You could do that, but you have the complete complexity of this. Show whatever GPS shows. It is not your goal to be accurate when GPS is not accurate. You just show whatever GPS shows. If it took you in one second to Kazan and then in another second to Quebec, congratulations, you are the best person in the world. Do not worry about it.
[07:39] Ezekiel-Gadzama: That happens?
[07:42] Customer: This is an educational application. Some things we do not worry about. We assume they will work fine, and whenever we have to deal with them we will deal with them, but at this point we do not need to.
[08:07] Customer: Look at the host of sensors you can use for running, like stride. Using GPS all the time is not recommended, because even without jamming it is very jumpy. You cannot constantly get GPS; it has to do other tricks. Look into other sensors, like stride and something else.
[09:01] Customer: To answer your other question: I am pretty close to trying your app. I started looking into it. I even looked into what can be done, and I looked into sensors. My hope is this week. I know I said that last week, and it is recorded: last week I said this weekend I will do it, and I did not. I will say it again: this weekend I will do it.
[09:39] Ezekiel-Gadzama: No problem.
[09:41] Customer: I am interested in the actual application. Out of all the other ones, this project is more interesting to me, so that is one I will definitely look into. You will get even more feedback than you hoped from me about this than other apps.
[10:13] Customer: Last time you asked me about application quality. Have you done anything towards that? Have you researched what Google requires from an application to be considered high quality?
[10:31] Ezekiel-Gadzama: We have not yet, for this week.
[10:49] Customer: That is fine. I did not install your app, and you did not do the quality thing, so we even out. We have not fulfilled each other's promises. Thank you for not doing it, then I do not feel guilty.
[11:19] Customer: We are all procrastinators, so that is nice.
[11:23] Ezekiel-Gadzama: We promised to do it this week.
[11:28] sirjaey: We were supposed to have gotten the feedback from you for using the app about two weeks ago. It is affecting our sprint to keep recording that as missed. We are hoping that by the next meeting we will have it.
[11:46] Customer: Yes. I know. I have not done any Android development, so I a bit underestimated things. I did not see it coming, but I will get there.
[12:15] Ezekiel-Gadzama: That is all for this meeting. Thank you very much.
[12:20] Customer: Lovely short meeting. Thank you for having a short meeting.
[12:28] sirjaey: Thank you. Respecting the transcript and the recording?
[12:34] Customer: I will send you a transcript. It takes some time, so if I do not forget I will send it to you.
[12:41] sirjaey: No problem, thank you very much.
[12:43] Customer: Okay, bye guys.
