# User acceptance tests

Each test checks one journey a runner completes end to end on the build deployed to the university VM. `<production-url>` is the VM's production download page; its address is in the Moodle submission, not here. The app has no accounts, so no test account is needed: every test starts from the app installed on an Android phone, and the only data is what the test itself creates.

## The Tests

| Test              | Journey                                                  | Status | SPRINT-09   | SPRINT-10   |
| ----------------- | -------------------------------------------------------- | ------ | ----------- | ----------- |
| [UAT-01](#uat-01) | Run a coached session with the phone locked in a pocket  | Active | Not yet run | Not yet run |
| [UAT-02](#uat-02) | Ask the coach for time, pace, and distance mid-run       | Active | Not yet run | Not yet run |
| [UAT-03](#uat-03) | Turn off usage data and confirm a run is not recorded    | Active | Not yet run | Not yet run |

## UAT-01

A runner starts a coached session, runs with the phone locked in a pocket while the coach speaks, and stops the session by voice without taking the phone out.

**Status:** Active

**Start state:** An Android 8 or newer phone has the app installed from `<production-url>`, with the microphone, location, and notification permissions granted, location turned on, and **Microphone on** in the app. The runner is outdoors, and the app is open on the **Run** screen with no session running.

**Steps:**

1. Tap **Interval**.
2. Lock the phone and put it in a pocket.
3. Walk or jog for at least four minutes without taking the phone out.
4. Still without taking the phone out, wait until the coach has finished speaking and say "Stop".

**Expected result:** The coach says "Session started." at step 1, speaks at least one effort cue during step 3, and speaks a stats line with time, pace, and distance at three minutes. At step 4 the session stops and the coach speaks a one-line summary of the run, with the phone still in the pocket.

| Sprint | Date | Runner | Build | Result | Evidence | DEC-nnn |
| ------ | ---- | ------ | ----- | ------ | -------- | ------- |

## UAT-02

A runner asks the coach aloud for their time, pace, and distance during a session and hears each answered.

**Status:** Active

**Start state:** The phone is in the start state of [UAT-01](#uat-01), the microphone is on in the app, and a session started with **Interval** has been running outdoors for at least one minute, with the phone locked in a pocket.

**Steps:**

1. After the coach finishes speaking, ask aloud "What's my time?"
2. After the answer, ask aloud "What's my distance?"
3. After the answer, ask aloud "What's my pace?"
4. Say "Stop", then compare the last answers with the run screen.

**Expected result:** Each question is answered aloud within a few seconds, with the stat that was asked for. The time agrees with the session's elapsed time; the distance and pace agree with the run screen, or the coach says that pace or distance is not available yet when the phone has no location fix. No question is answered with "keep running" or left unanswered.

| Sprint | Date | Runner | Build | Result | Evidence | DEC-nnn |
| ------ | ---- | ------ | ----- | ------ | -------- | ------- |

## UAT-03

A runner turns off **Usage data** and confirms that a session run afterwards adds nothing to the records the app keeps.

**Status:** Active

**Start state:** The phone is in the start state of [UAT-01](#uat-01), **Usage data** is on in the **Profile** screen, and at least one session has been completed since the app was installed.

**Steps:**

1. On **Profile**, press **Export records** and save the file. Note the time of its last line.
2. Turn **Usage data** off.
3. Close the app completely, open it again, and check that **Usage data** is still off.
4. On **Run**, tap **Interval**, run for at least one minute, and press **Stop**.
5. On **Profile**, press **Export records** again and save the file.

**Expected result:** The app opens normally at step 3 with **Usage data** still off. The file from step 5 has the same number of lines as the file from step 1, and its last line has the same time: the session in step 4 was not recorded.

| Sprint | Date | Runner | Build | Result | Evidence | DEC-nnn |
| ------ | ---- | ------ | ----- | ------ | -------- | ------- |
