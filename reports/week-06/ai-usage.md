# AI usage — Week 06

## Tools

Claude Code, driven from a terminal, attached to this repository.

## What we used it for

Reading Assignment 6 at the commit the course pinned, and auditing all sixteen parts against the repository before any work started.

Testing the open Dependabot pull requests against the real toolchain, rather than reading their check results.

Planning `SPRINT-06`: the sprint's goal, its due date, the planned velocity computed from the scheduled stories, and the two new stories for the product analyst and the system operator.

Recording `TOS-02` as missed, with the reason and the evidence.

## What we did with the output

Kept: the structure of every file, written against the course rule for that artifact and checked field by field against it.

Corrected: it had twice advised closing the Gradle 9.8.2 bump as "the same break" as the Android Gradle plugin 9 bump that was reverted in `SPRINT-04`. The two are separate upgrades. Building the product with Gradle 9.8.2 against the pinned plugin and Kotlin versions succeeded, with the unit tests passing, so the advice was wrong and the pull request is safe to merge. The lesson taken is that one bad upgrade in a family does not condemn the family.

Found rather than generated: three of the five Dependabot pull requests carried check results from 2026-10-28, nine days before the branch they would merge into. A green check from a nine-day-old checkout says nothing about today's `main`, and the habit of reading the check's timestamp rather than its colour came out of this.

Owned by the team and not generated: the decisions the `Customer` made, the product code, the estimates behind the story points, and the judgement that `TOS-02` is missed rather than revised.

Still to be confirmed by the team: the focus metric and the counter-metric behind it, and what the `Customer` agrees the threshold should measure next.

## What was not used

No AI output was used as a research finding, and no claim about an alternative was generated this week.

No generated text was submitted unchecked. The Markdown check and a link-and-anchor check were run before each pull request, and every dependency upgrade recommended this week was built locally before it was recommended.

## Additional work for the Week 6 closeout

Codex was used to compare the repository and GitHub state with Assignment 6, prepare QR-05 and its scripted test evidence, check the sprint's accepted story points, review the existing sprint-close PR, and draft this report.

The report was checked against the Week 6 meeting record, the current issue and pull-request states, the analytics and observability plans, the threshold document, and the latest green workflows on `main`. The test result was run locally. The report was corrected to distinguish a scripted file-sink check from production per-line telemetry, and to state that `REL-06` and the dashboards are still pending. No AI-generated statement was treated as a research finding or as evidence of customer acceptance.
