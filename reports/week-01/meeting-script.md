# Kickoff meeting script

## Context

The 2 October kickoff changed the direction we took into the room. The customer asked for a voice coach during the run, for a beginner to intermediate runner, phone first. That is [VP-01](../../docs/research/value-proposition.md#vp-01). [VP-02](../../docs/research/value-proposition.md#vp-02) is two preset sessions after that. The record is the [meeting report](meeting-report.md).

The questions below are the script we took in, and they are unchanged.

Our problem-space sentence going in: a recreational runner training for a 5K to half-marathon race, often without a sports watch, needs a training plan that changes when their real runs differ from the plan and tells them why it changed, so they can trust it enough to keep following it.

We believed the strongest gap was that no alternative tells the runner why the plan changed ([GAP-01](../../docs/research/gap-analysis.md#gap-01)), and that phone-only and walk/run runners get no adaptation from how their runs went ([GAP-02](../../docs/research/gap-analysis.md#gap-02)).
We went in expecting a plan that explains its changes, then phone-only adaptation, from a rule-based engine. The kickoff did not confirm the first.

Before the meeting we had not checked the target runner, whether phone-only was acceptable, or whether a rule-based engine was. The kickoff settled the first two. The engine question was not asked.

**The meeting had to settle:** who the target runner is, and whether explainable adaptation was the direction the customer would accept. He described the voice coach instead.

Questions marked ★ are the ones that would change the project most; ask them even if time runs short.

## Questions

**Business goals**

1. _(open)_ ★ What made you put a running coach in the catalog, and what did you picture a team delivering by December?
2. _(open)_ When a team finishes this project well, what can a runner do that they could not do before?

**End users**

3. _(open)_ ★ Think of a runner you know who would use this. What do they run, how often, and what do they record it with?
4. _(closed)_ Is the target runner someone training for a specific race, or someone running for general fitness?

**Current workflow**

5. _(open)_ Walk us through the last time you, or a runner you know, followed a training plan. What happened in the week it went off track?
6. _(open)_ When a run went worse than planned, what did you do with the next session, and who decided?

**Pain points and constraints**

7. _(open)_ ★ The last time an app or a plan changed a workout on you, what did you do: follow it, ignore it, or change it back? Why?
8. _(closed)_ Must the product work without a sports watch?
9. _(closed)_ Is there anything we must not do: medical or injury advice, storing location data, a specific platform?

**Scope**

10. _(open)_ If only one of these shipped by Week 5, which would you keep: the explanation of why the plan changed, or adaptation from phone-only runs?
11. _(closed)_ Is a rule-based plan engine acceptable, or do you expect machine learning?
12. _(open)_ What would you be disappointed to see us spend time on?

## Roles

Ezekiel-Gadzama interviews, Sirjaey takes notes, Obetech1 observes and records what we did not ask and what the customer did not say, JustACommonMan-OSDD  runs the recording and watches the time.

## Key improvements

**"Would you use an app that explains why your plan changed?" -> "The last time an app or a plan changed a workout on you, what did you do: follow it, ignore it, or change it back? Why?" (question 7)**

**"Is adaptation important to you?" -> "When a run went worse than planned, what did you do with the next session, and who decided?" (question 6)**

**"Do you want the app to work without a watch?" -> "Think of a runner you know who would use this. What do they run, how often, and what do they record it with?" (question 3)**

## After the meeting: what we actually asked

Added after the kickoff on 2 October 2026. The questions above are unchanged — they
are the script we took in. This section records what happened to them.

| # | Starred | Asked as written? | Outcome |
| --- | --- | --- | --- |
| 1 | ★ | Yes, at 00:45 | Answered at length. The whole product description came out of this one question. |
| 2 | | No | — |
| 3 | ★ | No | — |
| 4 | | No | Answered anyway at 23:55 via an improvised question: beginner to intermediate. |
| 5 | | No | — |
| 6 | | No | — |
| 7 | ★ | No | — |
| 8 | | No | Answered anyway at 10:54: phone first, wearable optional. |
| 9 | | No | Partly answered: no cloud processing (15:02), no health-document upload (11:34). Platform constraint came later (23:30). |
| 10 | | No | — |
| 11 | | No | Not asked, although [value-proposition.md](../../docs/research/value-proposition.md) lists the kickoff as where this assumption would be checked. |
| 12 | | No | — |

One of twelve questions was asked as written. Three more were answered without being
asked. Two of the three starred questions were missed.

Six questions were improvised in their place, in this order: live stats for a running
partner (07:17), uploading health documents (09:53), comparable applications (13:42),
goal setting and post-exercise meals (15:38), interface language (20:00), and
availability outside Russia (22:25).

### What to change for the next meeting

The `Customer` opened by asking how we wanted to proceed, and we answered with an open
question instead of presenting our research. Nothing from [gap-analysis.md](../../docs/research/gap-analysis.md) or
[value-proposition.md](../../docs/research/value-proposition.md) was put to him, so nothing in it was confirmed or refuted
directly — the divergence recorded in the [meeting report](meeting-report.md) had to be inferred from what
he volunteered.

Carry the three missed starred questions (3, 7, 10) and question 11 into the next
meeting, and present [VP-01](../../docs/research/value-proposition.md#vp-01) before asking anything.
