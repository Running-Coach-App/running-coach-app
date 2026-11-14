# UT-01 recruitment

How the team finds counted participants, checks them against [the profile](README.md#participant-profile), and books sessions without recording anybody who declines.

Recruitment is tracked in [issue #215](https://github.com/Running-Coach-App/running-coach-app/issues/215). It serves [`RISK-04`](../../risks.md#risk-04).

## Target

- **Minimum:** three counted sessions (`P-01`–`P-03`).
- **Design target:** five (`P-04` and `P-05` as reserves if someone withdraws).

Instrumentation and the private data setup can lag; **booking people cannot**.

## Channels

1. **Classmates outside team 4** — in person after lectures; ask whether they run or walk briskly with a phone.
2. **University sports facilities** — runners at the track or gym (when weather allows outdoor use).
3. **Course channels** — only messages that do not name or pressure individuals who said no.

The host city is cold in November ([Week 7 report](https://github.com/Running-Coach-App/running-coach-app/blob/main/reports/week-07/meeting-report.md)); if nobody local will run outdoors, remote participation conflicts with the in-person observer protocol. Resolve that with the `Customer` before counting a remote session, or recruit from someone who will be on campus.

## Profile check

Before assigning a code, confirm in conversation (not impression):

- 18 or older
- Runs or walks briskly for exercise at least occasionally
- Takes a phone when exercising
- Has used some phone app while exercising
- Not a teammate, not the `Customer`, not an instructor, not course staff

Teammates may join a **dry run**, which is not counted and gets no `P-nn` code.

## What goes where

| Material | Where |
| --- | --- |
| Code → person mapping | Private `Running-Coach-App/running-coach-app-usability-data` repository, `identity.md` only |
| Session date and time | [Schedule](README.md#schedule) in this repository |
| Declined invitations | Nowhere. [Issue #215](https://github.com/Running-Coach-App/running-coach-app/issues/215) AC-05 |
| Consent forms (filled) | Private repository before the session starts |

## Outreach text (copy-paste)

> We are team 4 (Running Coach App). We need **one outdoor session (~40 minutes)** with our Android running coach: you would run or walk briskly with our phone in a pocket while the coach speaks. We observe and record the session (with your consent). You must be 18+, not on our team, and you should already exercise with a phone sometimes. No payment. Interested in **\<date\>** around **\<time\>** on or beside campus? Reply here or in person.

Adjust the date after [the schedule table](README.md#schedule).

## RISK-04

- **Trigger:** fewer than three agreed sessions by **2026-11-17**.
- **Contingency:** follow [`RISK-04` contingency](../../risks.md#risk-04); do not claim a `QR-09` result from fewer than three counted sessions.