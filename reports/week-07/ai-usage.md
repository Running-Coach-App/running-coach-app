# AI usage — Week 07

## Tools

Claude Code, driven from a terminal, attached to this repository. No other AI tool was used.

## What we used it for

Reading Assignment 7 at the commit the course pinned, and auditing all fourteen parts against the repository before any work started.

Carrying out the action point this sprint inherited twice: reading Google's own Core app quality and Android vitals pages and writing [the research](../../docs/research/play-store-quality.md) from them, then turning three of their criteria into [`QR-06`](../../docs/quality-requirements/qr/QR-06.md), [`QR-07`](../../docs/quality-requirements/qr/QR-07.md), and [`QR-08`](../../docs/quality-requirements/qr/QR-08.md) with their tests.

Writing `scripts/scan.sh`, the `Security scan` workflow, and the negative test the workflow performs on every run, and enabling Gradle dependency locking with the lock file that the scan reads.

Writing `StabilitySoakTest`, the five-test soak that `QR-06` is checked by.

Designing [`UT-01`](../../docs/usability-tests/ut-01/README.md): the record, the tasks and their success criteria, the help rule, the surveys, the consent template, the session instructions and observation sheet, the results stub with its findings template and triage plan, [`QR-09`](../../docs/quality-requirements/qr/QR-09.md) and its manual test, the four new risks, the ten glossary terms, the `participant_code` field on the event table, the sprint and release blocks in the plan, this week's meeting script, and this report.

Adding the `Docs` workflow that runs `mkdocs build --strict` on pull requests, which closes an action carried since `SPRINT-05`.

## What we did with the output

**Kept:** the structure of every file, written against the course rule for that artifact and checked field by field against it.

**Found rather than generated, and the most valuable thing this week:** three separate bugs in `scripts/scan.sh` that made it print `PASSED` when it should have failed. One was a shell helper that did not forward its arguments, so the dependency check crashed and the script reported success anyway. One was the private-key search pattern beginning with `-----`, which `grep` read as command-line options, so that check could never fire. The third was the worst: the script had two code paths with different meanings — one source of advisories failed only on dependencies that ship in the app, the other failed on any advisory at all — and because only the second path runs in CI, the branch failed on nine build-tool advisories that cannot reach a runner. Our own pull request description had asserted the opposite. All three were found by deliberately breaking the thing being checked and confirming the scan noticed; the third was found by CI rather than by us, which is the reason the workflow now performs the sabotage itself on every run.

**Corrected:** it wrote a link-check exclusion whose comment claimed the private usability-data repository had been opened and checked by hand on 2026-11-13. That repository does not exist yet. The comment now says when the check happens and who does it, and claims nothing that has not.

**Corrected:** it wrote links from `docs/project-plan.md` and the `UT-01` record into `reports/`, using relative paths. Those leave `mkdocs`'s `docs_dir`, which the link checker passes and the strict build rejects — the exact failure that has broken the published site three times. They are now either absolute links into `main` for files that are on `main`, or plain paths with no link for files that are not. Then the `Docs` workflow was added so that the next one is caught by a check rather than by somebody remembering.

**Corrected:** it had written [the analytics page](../../docs/analytics.md) to say that usability-test traffic is *not* excluded from the product's metrics, "because the Week 7 work needs to see them". That is backwards: the test reads its own exported records, not the metrics, and leaving the team's own facilitated sessions inside the focus metric would have made that metric say the opposite of what it exists to say. Every metric now excludes `usability-test` as well as `smoke`.

**Owned by the team and not generated:** the choice of `Learnability` over the other two sub-characteristics, and the bar of 0.6 in `QR-09` — a number that decides whether the product is reported as usable, set before any data exists and deliberately not movable afterwards. The three tasks and the decision to leave the spoken question out of them. The participant profile, the recruitment target, and the roles. The judgement that `QR-07`'s test moves to `SPRINT-08` rather than being run badly in `SPRINT-07`. Every decision the `Customer` makes, and the product code he has asked for.

**Still to be confirmed by the team and the `Customer`:** the roles in the `UT-01` record are the team's to agree rather than assign; the session dates; and whether the design review changes the sub-characteristic, the measure, or the bar, which [Part 11](../../docs/project-plan.md#sprint-07) requires to be applied as same-week rework rather than carried as an action.

## Usability material given to an AI tool

**None, because none exists.** No session has been run, so there is no recording, no raw note, no consent record, and no identity mapping to give to anything. Everything the tool was given this week about the usability test is material the team wrote itself and that is public in this repository.

The consent template states in advance what the rule will be when sessions do run: anything from a session that is given to such a tool is the sanitized note, never the recording, the private notes, or the list joining a code to a person, and any copy a tool holds is deleted when the course is graded. The Week 8 report answers this question again, against real sessions.

## What was not used

No AI output was used as a research finding. Every claim on the research page comes from a Google page that was read, and each is linked at the bottom of it.

No generated text was submitted unchecked. The Markdown check, the link-and-anchor check, and the strict documentation build were run before this week's pull request, and the scanner was run against both a clean checkout and a deliberately broken manifest.
