# AI usage — Week 06

## Tools

Claude Code, driven from a terminal, attached to this repository.

## What we used it for

Reading Assignment 6 at the commit the course pinned, and auditing all sixteen parts against the repository before any work started.

Testing the open Dependabot pull requests against the real toolchain, rather than reading their check results.

Planning `SPRINT-06`: the sprint's goal, its due date, the planned velocity computed from the scheduled stories, and the two new stories for the product analyst and the system operator.

Recording `TOS-02` as missed, with the reason and the evidence.

Writing the analytics plan with its metric tree and event table, the observability plan with its two `SLI`s, the instrumentation in `Telemetry.kt`, `TelemetryFiles.kt`, and `SessionEngine.kt` with its unit tests, `FR-013`, the release, and this week's public report.

Producing the Week 6 meeting script, and the task issues for the sprint.

## What we did with the output

Kept: the structure of every file, written against the course rule for that artifact and checked field by field against it.

Corrected: it had twice advised closing the Gradle 9.8.2 bump as "the same break" as the Android Gradle plugin 9 bump that was reverted in `SPRINT-04`. The two are separate upgrades. Building the product with Gradle 9.8.2 against the pinned plugin and Kotlin versions succeeded, with the unit tests passing, so the advice was wrong and the pull request is safe to merge. The lesson taken is that one bad upgrade in a family does not condemn the family.

Found rather than generated: three of the five Dependabot pull requests carried check results from 2026-10-28, nine days before the branch they would merge into. A green check from a nine-day-old checkout says nothing about today's `main`, and the habit of reading the check's timestamp rather than its colour came out of this.

Owned by the team and not generated: the decisions the `Customer` made, the product code, the estimates behind the story points, and the judgement that `TOS-02` is missed rather than revised.

Still to be confirmed by the team: the focus metric and the counter-metric behind it, and what the `Customer` agrees the threshold should measure next.

Corrected again, later in the week: it wrote `docs/observability.md` saying the product emits the per-line log record today. It does not. The sink is there and the record's shape is fixed, but nothing in `CoachService` calls it, so a real session produces no point. The sentence was rewritten and the gap declared in this week's report. The lesson taken is that a plan describing what the code will do reads identically to one describing what it does, and only grepping the source tells them apart.

Corrected: eight unit tests failed on the instrumentation because a hand-written JSON encoder used `joinToString`'s default separator, which put a space after every comma, and because `MutableList.removeFirst()` binds a Java 21 method that is absent on JDK 17. Both were found by running the suite, not by reading the code.

Found rather than generated: Part 8's pull request had been merged into a branch that `main` had already absorbed, so two feature entries and five glossary terms were sitting on a branch nobody would merge again while every check on `main` was green. Comparing the open issues against the merged pull requests is what surfaced it.

## What was not used

No AI output was used as a research finding, and no claim about an alternative was generated this week.

No generated text was submitted unchecked. The Markdown check and a link-and-anchor check were run before each pull request, and every dependency upgrade recommended this week was built locally before it was recommended.
