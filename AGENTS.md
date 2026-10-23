# Agent Instructions

Running Coach App, team 4. This file says how this repository works. The course requirements are routed from [`SKILL.md`](https://github.com/inno-itpd/itpd/blob/main/SKILL.md); read the rule before you change anything it covers.

## Layout

- `app/` is the product, an Android application in Kotlin. `app/src/main/java/app/runningcoach/SessionEngine.kt` decides what the coach says and when and holds no Android types; `CoachService.kt` runs the session and talks to the platform; `MainActivity.kt` is the screen. Unit tests live in `app/src/test/java/app/runningcoach/`.
- `docs/` holds the maintained artifacts, each kept current for the rest of the course: the vision, the plan, the risks, the threshold of success, the decisions, the assumptions, the glossary, the research, `docs/architecture/` with its records under `adr/`, `docs/functional-requirements/` with its records under `fr/`, and `docs/quality-requirements/` with its records under `qr/`.
- `reports/week-NN/` holds one week's evidence. A new week gets a new directory; an earlier week's report is the record of that week.
- `.github/` holds the workflows, the issue forms, and the pull request template.
- `.claude/skills/itpd` is the course materials, as a git submodule. Read from it; never commit inside it.

A new maintained artifact goes under `docs/`. A new week's evidence goes under `reports/week-NN/`. If neither fits, ask rather than inventing a path.

## Checks

Run these from the repository root before you push. Gradle 8.11.1 and JDK 17 are prerequisites; `docs/setup.md` has the full setup.

- `gradle :app:testDebugUnitTest` runs the unit tests. It needs no phone or emulator.
- `gradle :app:assembleDebug` builds the debug APK.
- `npx markdownlint-cli2 "**/*.md"` is the Markdown check. `.github/workflows/markdown.yml` runs it on pull requests and on `main`.
- `lychee .` is the link check, and it needs the network because it fetches external links. `.github/workflows/lychee.yml` runs it on pull requests and on `main`, and `.lycheeignore` and `lychee.toml` hold the exclusions.
- `.github/workflows/pages.yml` publishes `docs/` as the documentation site; `mkdocs.yml` holds its navigation, so a new page under `docs/` is added there too.

There is no workflow that builds or tests the product code yet. Run the two Gradle commands yourself; CI will not catch a Kotlin failure for you.

## Conventions

- Commit messages are one short sentence in the imperative, saying what the change does, with no type tag. Never name a tool, an agent, or a model in a commit message, a pull request title, a pull request body, or a pull request comment.
- Branches are `<task-number>-<short-description>`, such as `41-spoken-start-stop`. Branch from `main`.
- One pull request closes exactly one task issue, with `Closes #<task>` in the body, and follows `.github/pull_request_template.md`. Another member approves; nobody approves their own.
- A user-visible change adds its line under `[Unreleased]` in `CHANGELOG.md`.
- Keep a decision about what the coach says in `SessionEngine.kt` rather than in the service, so a unit test can reach it.
- `CONTRIBUTING.md` carries the same rules for members, and `docs/definition-of-done.md` is what a reviewer checks against.

## Do Not Edit

- `reports/week-NN/` for a week that has been submitted. The report is that week's record; a later correction goes in the current week's report instead. A formatting-only fix is the exception.
- `docs/decisions.md` entries, once written. A decision is never reworded; a reversal is a new `DEC-nnn`.
- `CHANGELOG.md` released sections, and the version headings. During a sprint, add to `[Unreleased]` and touch nothing else; the released section is written when the release is cut.
- `.claude/skills/itpd/`. It is a submodule of the course repository, and a member updates the pin deliberately.
- `docs/architecture/container.svg` by hand. It is generated from `container.mmd`; change the source and regenerate both in the same change.
