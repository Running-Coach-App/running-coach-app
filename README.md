# Running Coach App

**An Android app that talks to you while you run, so you can leave your phone in your pocket.**

It speaks your time, your pace and your distance on a cadence you choose, tells you when to push
and when to ease off, and answers a question you ask out loud. Your runs stay on the phone: there
is no account, no server, and nothing to sign in to. [What the build on the releases page
is](#what-the-build-on-the-releases-page-is) sets out exactly what it can and cannot do, rather
than asking you to take that on trust.

## What you get if you install it

- **Spoken stats while you run.** Time, pace and distance, every three minutes by default. You can
  change that to one, two, three or five minutes on the Profile screen.
- **Two kinds of session.** *Steady* just coaches your stats. *Interval* adds effort cues: one
  spoken word a minute, rotating "Jog.", "Hard.", "Easier."
- **Answers to spoken questions.** Ask "what's my pace", or "what are my stats" for all three at
  once, and the coach answers out loud. You can turn the microphone off from the run screen when
  you want to talk to somebody without the app listening.
- **A record of your runs**, kept on the phone, with a summary after each one.

## What it does not do

Being plain about this is quicker than letting you find out:

- **There is no training plan yet.** The project is building towards a coach that adapts a plan to
  the runs you actually did and explains why it changed. That is not in the app today.
- **No heart rate, no watch, no sign-in, no cloud, and no export.** Your runs live on that one
  phone and go nowhere.
- **Pocket use is not reliable on every phone yet.** On a Pixel 8, spoken commands went unanswered
  and the volume keys did nothing, so the phone had to come out. That is being worked on in
  [#219](https://github.com/Running-Coach-App/running-coach-app/issues/219) and
  [#220](https://github.com/Running-Coach-App/running-coach-app/issues/220), and it is the most
  honest thing on this page.
- **A twelve-minute run cost about 6% of one phone's battery**, which is more than it should.
  [#222](https://github.com/Running-Coach-App/running-coach-app/issues/222).

## Install it

1. Open [the latest release](https://github.com/Running-Coach-App/running-coach-app/releases/latest)
   and download the `.apk` file under **Assets**.
2. Open it on an Android phone running Android 8 or newer. Android will ask you to allow installing
   from this source the first time; that is the normal prompt for an app that is not from the Play
   Store.
3. Open the app. It will ask for three permissions, and here is what each is for:
   - **Microphone**, so the coach can hear a question you ask while running. Say no and everything
     else still works; the coach simply will not listen.
   - **Location**, so it can work out your pace and distance. Say no and you still get your time,
     and the coach will say that pace and distance are not available.
   - **Notifications**, so the session can keep running with the screen off and show you where you
     are without unlocking.

### What the build on the releases page is

It is a **debug** build, and being straight about that is worth more to you than a reassuring
sentence:

- **It carries the `INTERNET` permission and allows cleartext traffic.** The debug source set adds
  both, for the campus-collector upload that [`DEC-031`](docs/decisions.md#dec-031) permits on the
  team's own test phones.
- **It has nowhere to send anything.** The collector address is read at build time from
  `local.properties`, which is not in this repository and not on the machine that builds the
  published file, so no `http` or `https` address of any kind is compiled into it.
- **It is debuggable.** Anybody who can plug your phone into a computer can read the app's files,
  including your runs, without unlocking anything further. That is a wider exposure than the
  permission, and it is the reason to prefer a build you made yourself if you care.

You do not have to take our word for any of it. On the file you downloaded:

```sh
aapt2 dump permissions running-coach-app-v0.5.0-debug.apk
unzip -p running-coach-app-v0.5.0-debug.apk 'classes*.dex' | strings | grep -E 'https?://'
```

The first prints what the app may do. The second prints nothing at all.

The build that carries no network permission is the *release* build, which is what
[`QR-08`](docs/quality-requirements/qr/QR-08.md) and `./scripts/scan.sh` describe. This project does
not publish one yet;
[#248](https://github.com/Running-Coach-App/running-coach-app/issues/248) is where that is being
settled.

If you would rather build it yourself than install a release, [docs/setup.md](docs/setup.md) is the
whole process from a clean checkout.

## Your first run

1. On the **Run** screen, tap **Interval** or **Steady**. The coach says "Session started."
2. Put the phone in a pocket or an armband and start running. In an interval session you will hear
   one word about once a minute, rotating "Jog.", "Hard.", "Easier." Your first stats line comes at
   three minutes and sounds like *"Time 3 minutes 0 seconds. Pace 5 minutes 30 seconds per
   kilometre. Distance 0.5 kilometres."*
3. Pace and distance need a location fix, so for the first minute or two the coach will say they are
   not available yet. It says so once rather than repeating it.
4. Ask it something out loud — "what's my pace" — and it answers. Ask it something unrelated and it
   will tell you to get on with the run.
5. Tap **Stop** when you are done. The coach reads back what you did, and the run appears under
   **History**.

## Check it yourself

This app keeps every run on your phone and sends nothing anywhere. You do not have to take
our word for it. From a clean checkout:

```sh
./scripts/scan.sh
```

It needs `bash`, `curl`, and `python3`, and no Android toolchain. It reports whether the app
declares any permission that would let it reach the network, whether any of its code
references a networking type, whether any dependency it ships has a known vulnerability, and
whether anything resembling a credential has been committed. It exits non-zero if any of
those checks fails, and it runs on every pull request. What it inspects is this source tree and the
release build it would produce, **not** the debug build on the releases page, which the section
above describes and [#248](https://github.com/Running-Coach-App/running-coach-app/issues/248)
is about.

The requirement behind it is [`QR-08`](docs/quality-requirements/qr/QR-08.md), and the
research behind what it checks is [`docs/research/play-store-quality.md`](docs/research/play-store-quality.md).

## For the course

**Team 4**, ITPD course, Innopolis University, autumn 2026. This is coursework, and the
documentation is part of what is marked.

- Current week's report: [reports/week-07/README.md](reports/week-07/README.md)
- Maintained documentation: [docs/](docs/)
  - [Alternatives](docs/research/alternatives.md)
  - [Comparison](docs/research/comparison.md)
  - [Gap analysis](docs/research/gap-analysis.md)
  - [Value proposition](docs/research/value-proposition.md)
  - [Play Store quality](docs/research/play-store-quality.md)
- Documentation site:
  [https://running-coach-app.github.io/running-coach-app/](https://running-coach-app.github.io/running-coach-app/)

## Licence

[MIT](LICENSE)
