# Configuration plan

**Reviewed:** 2026-11-19

The configuration this project actually has, read from the repository rather than from memory of it. This is an inventory, not a change plan: it says what each item is, who keeps it true, what it connects to, and what breaks without it. Proposals for changing any of it live in the week's evaluation, `reports/week-08/cm-evaluation.md`.

Items are grouped by the job they do. A set of files is one item at its index or entry point. A private setting is named in words; no address, credential, or secret value appears here.

## Source control and release

### CFG-01

Branch protection on `main`, which requires a pull request and an approving review from somebody other than the last pusher.

- **Status:** Active
- **Type:** Repository setting
- **Purpose:** It is the only mechanism that stops work reaching `main` unreviewed. Without it the convention "another member approves" is a sentence in a document, and the first hurried merge quietly ends it.
- **Owner:** sirjaey
- **Where:** The repository's branch-protection settings page on GitHub, under the rule for `main`. Not a file in this repository.
- **Connections:**
  - **Enforces** [`CONTRIBUTING.md`](https://github.com/Running-Coach-App/running-coach-app/blob/main/CONTRIBUTING.md) and [`AGENTS.md`](https://github.com/Running-Coach-App/running-coach-app/blob/main/AGENTS.md), which both say work lands through a pull request. Without it those documents describe a habit rather than a rule.
  - **Gates** every item in **Checks**: a required check only blocks a merge because this setting makes it required.
  - **Blocked** [#246](https://github.com/Running-Coach-App/running-coach-app/pull/246) on 2026-11-19 until a human approved it, which is the behaviour working.
- **What good looks like:** A pull request cannot merge into `main` without a review from somebody other than its author, and the status checks are required rather than advisory. The course rule is [Repository Requirements](https://github.com/inno-itpd/itpd/blob/main/requirements/repository-requirements.md).

### CFG-02

The release tags, their GitHub releases, and the APK asset each one carries.

- **Status:** Active
- **Type:** Repository artifact and setting
- **Purpose:** It is what the `Customer` and any usability participant installs. Without it there is no build anybody outside the team can get, and `REL-nn` in the plan refers to nothing.
- **Owner:** sirjaey
- **Where:** The repository's tags and releases on GitHub, `v0.1.0` to `v0.5.0`, each tag recorded in [`docs/project-plan.md`](project-plan.md) as a `REL-nn` block and in [`CHANGELOG.md`](https://github.com/Running-Coach-App/running-coach-app/blob/main/CHANGELOG.md).
- **Connections:**
  - **Is published from** `CFG-08`: the APK the release carries is built from the wrapper and the lockfile.
  - **Is described by** [`CHANGELOG.md`](https://github.com/Running-Coach-App/running-coach-app/blob/main/CHANGELOG.md) and the `REL-nn` blocks in the plan; a release whose changelog section is missing cannot be read by whoever deploys it.
  - **Contradicts** [`README.md`](https://github.com/Running-Coach-App/running-coach-app/blob/main/README.md) as of this review in one respect recorded at [#248](https://github.com/Running-Coach-App/running-coach-app/issues/248): the published asset is a debug build, and the documentation described a release build.
- **What good looks like:** Every `REL-nn` in the plan has a tag, the tag is protected from being moved or deleted, the release body says whether an upgrade is required, and the asset is the build the documentation says it is. The course rule is [Releases Requirements](https://github.com/inno-itpd/itpd/blob/main/requirements/releases-requirements.md).

## Checks

### CFG-03

The continuous integration workflow set: nine workflows that run on every pull request and on `main`.

- **Status:** Active
- **Type:** Configuration files
- **Purpose:** They are the only automatic statement about whether the repository is in a state worth merging. Without them a broken build, a dead link, or a vulnerable dependency reaches `main` unnoticed.
- **Owner:** sirjaey
- **Where:** [`.github/workflows/`](https://github.com/Running-Coach-App/running-coach-app/blob/main/.github/workflows) — `actionlint.yml`, `android.yml`, `deploy-campus.yml`, `docs.yml`, `lychee.yml`, `markdown.yml`, `osv-scanner.yml`, `pages.yml`, and `scan.yml`.
- **Connections:**
  - **Is required by** `CFG-01`: these checks block a merge only because branch protection makes them required.
  - **Depends on** `CFG-08`: `android.yml` and `deploy-campus.yml` resolve Gradle from the wrapper file, so a wrapper bump changes what they run.
  - **Publishes** `CFG-11`: `pages.yml` builds the documentation site from `mkdocs.yml`.
  - **Pins** every action by commit SHA, which `CFG-09` keeps current.
- **What good looks like:** Each workflow pins its actions by SHA, the set runs on pull requests and on `main`, and a check that is green means the tree it ran against is the tree that will merge. The second half is where this item is currently weakest, and the evaluation says so. The course rule is [Repository Requirements](https://github.com/inno-itpd/itpd/blob/main/requirements/repository-requirements.md).

### CFG-04

The product scanner, `scripts/scan.sh`, and the `Security scan` workflow that runs it.

- **Status:** Active
- **Type:** Script and configuration file
- **Purpose:** It is the `Customer`'s own request made mechanical — "proof, for open source, that you are not sending data somewhere. People know the scanner: they can run it and see." It is the evidence for [`QR-08`](quality-requirements/qr/QR-08.md). Without it the product's central privacy claim rests on the team's word.
- **Owner:** sirjaey
- **Where:** [`scripts/scan.sh`](https://github.com/Running-Coach-App/running-coach-app/blob/main/scripts/scan.sh), run by [`.github/workflows/scan.yml`](https://github.com/Running-Coach-App/running-coach-app/blob/main/.github/workflows/scan.yml).
- **Connections:**
  - **Verifies** the main manifest and `app/src/main`, and reads the lockfile that `CFG-08` carries.
  - **Is cited by** [`QR-08`](quality-requirements/qr/QR-08.md) and by the testing plan's `QR-08` row as that requirement's evidence.
  - **Asserts its own failure**: `scan.yml` checks that adding a network permission makes the script exit non-zero, so the check cannot rot into one that always passes.
  - **Does not cover** the artifact `CFG-02` publishes, which is [#248](https://github.com/Running-Coach-App/running-coach-app/issues/248).
- **What good looks like:** The scanner checks the build a reader can actually install, and its result does not say `PASSED` while leaving the shipped artifact unexamined. It does not meet that today, and the gap is recorded rather than hidden. The course rule is [Quality Requirements](https://github.com/inno-itpd/itpd/blob/main/requirements/quality-requirements-requirements.md).

### CFG-05

The link checker's configuration: `lychee.toml` and `.lycheeignore`.

- **Status:** Active
- **Type:** Configuration files
- **Purpose:** The documentation is most of this project's deliverable, and a citation that does not resolve is a claim without a source. Without this configuration the check either cannot run or is silenced wholesale.
- **Owner:** ObeTech1
- **Where:** [`lychee.toml`](https://github.com/Running-Coach-App/running-coach-app/blob/main/lychee.toml) and [`.lycheeignore`](https://github.com/Running-Coach-App/running-coach-app/blob/main/.lycheeignore) at the repository root, used by [`.github/workflows/lychee.yml`](https://github.com/Running-Coach-App/running-coach-app/blob/main/.github/workflows/lychee.yml).
- **Connections:**
  - **Excludes** the private usability-data repository, which cannot be checked anonymously, with the reason and the manual-check date written in place.
  - **Depends on** external hosts staying reachable, which is this item's main weakness: `web.archive.org` returned four spurious failures on 2026-11-18 and 2026-11-19 for links that resolve when fetched directly.
  - **Is relied on by** the usability and research documents, which cite archived copies of vendor pages.
- **What good looks like:** Every excluded link carries a reason and a manual-check date, the list stays short, and a red link check means a link is actually broken. The last part does not hold today. The course rule is [Repository Requirements](https://github.com/inno-itpd/itpd/blob/main/requirements/repository-requirements.md).

## Environments and secrets

### CFG-06

The untracked build-time configuration file, `local.properties`.

- **Status:** Active
- **Type:** Untracked configuration file
- **Purpose:** It supplies the Android SDK path and the two build-time values the product reads — the campus collector address and the download address — without any of them entering the repository. Without it the build cannot find the SDK; without its absence from version control, the collector address would be public.
- **Owner:** Each member, on their own machine; the values for a published build are whoever runs that build.
- **Where:** `local.properties` at the repository root, deliberately untracked. Its absence from version control is asserted by `CFG-04`.
- **Connections:**
  - **Feeds** `build.gradle.kts`, which reads `collector.url` and `download.url` into `BuildConfig`.
  - **Is checked by** `CFG-04`, which fails if the file becomes tracked.
  - **Explains** a property of the published build recorded at [#248](https://github.com/Running-Coach-App/running-coach-app/issues/248): because the build machine has no `local.properties`, the published APK carries no collector address and uploads nothing.
- **What good looks like:** The file is never committed, the scanner proves it, and no secret value appears in any tracked file. This holds today. The course rule is [Configuration Management Requirements](https://github.com/inno-itpd/itpd/blob/main/requirements/configuration-management-requirements.md).

### CFG-07

The campus deployment: the scripts under `deploy/`, the workflow that runs them, and the repository secrets it reads.

- **Status:** Active
- **Type:** Scripts, configuration file, and repository settings
- **Purpose:** It puts a build and the telemetry collector on the university virtual machine, which is where the `Customer` reaches the product from the university network. Without it the course's deployment requirement has no artifact.
- **Owner:** Ezekiel-Gadzama
- **Where:** [`deploy/`](https://github.com/Running-Coach-App/running-coach-app/blob/main/deploy) — `vm`, `collector`, and `apk-serve` — driven by [`.github/workflows/deploy-campus.yml`](https://github.com/Running-Coach-App/running-coach-app/blob/main/.github/workflows/deploy-campus.yml). The host, the ports, and the credentials are repository secrets and are named in words only: the deployment host, the deployment user, and that user's key. The addresses themselves go to the Moodle submission wrapper, never to a public file.
- **Connections:**
  - **Deploys** the artifact `CFG-08` builds, on every push to `main` when the secrets are set.
  - **Serves** the collector that the debug build's upload targets, which [`DEC-031`](decisions.md#dec-031) permits.
  - **Failed** on 2026-11-19 on commit `d45aaeb` while `android.yml` passed on the same commit, which is recorded at [#260](https://github.com/Running-Coach-App/running-coach-app/issues/260).
- **What good looks like:** The deployment runs from the commit that passed its checks rather than from a hand-edited machine, the runbook in [`docs/deployment.md`](deployment.md) matches what the scripts do, and no address or credential appears in a public file. The course rule is [Configuration Management Requirements](https://github.com/inno-itpd/itpd/blob/main/requirements/configuration-management-requirements.md).

## Dependencies and builds

### CFG-08

The build's pinned toolchain and variants: the Gradle wrapper properties, app build configuration, and dependency lockfile.

- **Status:** Active
- **Type:** Configuration files
- **Purpose:** Together they decide which Gradle builds the product and which dependency versions ship in it. Without the pin, two members and the continuous integration build produce different artifacts from the same source.
- **Owner:** sirjaey
- **Where:** [`gradle/wrapper/gradle-wrapper.properties`](https://github.com/Running-Coach-App/running-coach-app/blob/main/gradle/wrapper/gradle-wrapper.properties), [`app/build.gradle.kts`](https://github.com/Running-Coach-App/running-coach-app/blob/main/app/build.gradle.kts), and [`app/gradle.lockfile`](https://github.com/Running-Coach-App/running-coach-app/blob/main/app/gradle.lockfile). The wrapper jar is deliberately not in the repository, so each member installs a matching Gradle. The app defines `debug`, `release`, and the isolated `usabilityTest` build type; the latter uses a separate application ID, a fixed usability event source, and an empty collector URL.
- **Connections:**
  - **Is resolved by** `CFG-03`: `android.yml` and `deploy-campus.yml` both take their Gradle version from the wrapper file, so a bump changes every build at once.
  - **Is bumped by** `CFG-09`, weekly and automatically.
  - **Is read by** `CFG-04`, which checks the locked dependencies against OSV.
  - **Separates** the usability-test artifact from release builds: only `usabilityTest` prompts for a participant code and tags its local event records `usability-test`; its collector URL is empty.
  - **Is documented by** [`docs/setup.md`](setup.md), which names the wrapper file as the version to trust.
  - **Broke** twice on 2026-11-19 after an automatic bump to 9.9.1, intermittently and not reproducibly, which is recorded at [#260](https://github.com/Running-Coach-App/running-coach-app/issues/260).
- **What good looks like:** The wrapper and the lockfile move together in one change, the documented version and the pinned version agree, and a bump is judged on a check that ran against the tree it will merge into. The course rule is [Configuration Management Requirements](https://github.com/inno-itpd/itpd/blob/main/requirements/configuration-management-requirements.md).

### CFG-09

The automatic dependency updates, configured in `.github/dependabot.yml`.

- **Status:** Active
- **Type:** Configuration file
- **Purpose:** It keeps the pinned action SHAs and the Gradle dependencies current without anybody remembering to look. Without it the pins in `CFG-03` and `CFG-08` silently age, and a known vulnerability stays shipped until `CFG-04` catches it.
- **Owner:** sirjaey
- **Where:** [`.github/dependabot.yml`](https://github.com/Running-Coach-App/running-coach-app/blob/main/.github/dependabot.yml), two ecosystems — GitHub Actions and Gradle — both weekly.
- **Connections:**
  - **Updates** `CFG-03` and `CFG-08`, and opens the pull requests that `CFG-01` then gates.
  - **Holds** the Gradle wrapper away from one version, with the reason in place, after [#260](https://github.com/Running-Coach-App/running-coach-app/issues/260).
  - **Cannot complete** a bump it cannot resolve: [#196](https://github.com/Running-Coach-App/running-coach-app/pull/196) arrives without a lockfile because the plugin collision stops resolution, and stays red until somebody supplies one.
- **What good looks like:** Each proposal arrives with whatever else must move with it, an ignored version carries its reason and is revisited rather than forgotten, and a bump is not merged on a stale green check. The course rule is [Configuration Management Requirements](https://github.com/inno-itpd/itpd/blob/main/requirements/configuration-management-requirements.md).

## Agent context and artifacts

### CFG-10

The agent instruction set: the team's `AGENTS.md`, its per-tool routers, and the rule files they point to.

- **Status:** Active
- **Type:** Documentation and configuration files
- **Purpose:** It is what every coding agent reads before it touches this repository, and it is the only thing standing between the team's conventions and an agent that invents its own. Without it an agent commits with a tool's name in the message, pushes to `main`, or edits a submitted week's report.
- **Owner:** sirjaey
- **Where:** [`AGENTS.md`](https://github.com/Running-Coach-App/running-coach-app/blob/main/AGENTS.md) is the **only committed file in this item**. `CLAUDE.md`, `GEMINI.md`, `.github/copilot-instructions.md`, `AGENTS.override.md`, and `.cursor/rules/` all exist on members' machines and **none of them is tracked**; they are listed in the repository's local exclude file. This was checked with `git ls-files` while writing this plan, not assumed.
- **Connections:**
  - **Points at** this plan, [`CONTRIBUTING.md`](https://github.com/Running-Coach-App/running-coach-app/blob/main/CONTRIBUTING.md), and [`docs/definition-of-done.md`](definition-of-done.md).
  - **Constrains** what reaches `CFG-01`: the no-agent-name rule is enforced by a local commit hook as well as by the instruction. The hook is also untracked, so it protects only the machines that already have it.
  - **Reaches an agent only partly from a clean clone.** `AGENTS.md` is there, so a tool that looks for it finds the team's rules. The per-tool routers that tell Claude Code, Gemini CLI, and Copilot to read it are not, so those three start a fresh clone with no project instructions at all. Everything in `.cursor/rules/` — ten files including the no-agent-trailer rule and the branch rules — is in the same position.
- **What good looks like:** An agent reading a clean checkout finds every rule it must follow, the routers agree with the file they route to, and no instruction contradicts another. The internal contradiction found on 2026-11-19 — two different Gradle versions named seven lines apart in `AGENTS.md` — is the kind of defect this item exists to prevent. The course rule is [Agent Instructions Requirements](https://github.com/inno-itpd/itpd/blob/main/requirements/agent-instructions-requirements.md).

### CFG-11

The documentation site configuration, `mkdocs.yml`, and the strict build that publishes it.

- **Status:** Active
- **Type:** Configuration file
- **Purpose:** It turns `docs/` into the site a reader outside the team actually reads, and its strict mode is what catches a link that resolves on GitHub but breaks on the site. Without it the documentation is only browsable by people who already know the repository.
- **Owner:** ObeTech1
- **Where:** [`mkdocs.yml`](https://github.com/Running-Coach-App/running-coach-app/blob/main/mkdocs.yml) at the repository root, built by [`.github/workflows/docs.yml`](https://github.com/Running-Coach-App/running-coach-app/blob/main/.github/workflows/docs.yml) and published by [`.github/workflows/pages.yml`](https://github.com/Running-Coach-App/running-coach-app/blob/main/.github/workflows/pages.yml).
- **Connections:**
  - **Covers** every page under `docs/`, so a new page is added to its navigation in the same change.
  - **Diverges from** `CFG-05`: a link that leaves `docs_dir` passes the link check and GitHub but fails the strict build. This divergence has caused five separate build failures across the project.
  - **Publishes to** GitHub Pages, which is a repository setting rather than a file.
- **What good looks like:** `mkdocs build --strict` is clean on every pull request, a new page under `docs/` appears in the navigation in the same change that adds it, and the site and the repository show the same documentation. The course rule is [Repository Requirements](https://github.com/inno-itpd/itpd/blob/main/requirements/repository-requirements.md).

## Dropped items

A configuration item that is retired keeps its section here with `**Status:** Dropped` and a `**Dropped:**` date and reason, so no `CFG-nn` is reused and the history stays readable where the item used to be.

**There are none yet.** This is a statement of fact rather than an omission: `git log --diff-filter=D` over the whole history returns exactly one deleted file, `week-2-TODO.md`, which was a scratch list and never a configuration item. No workflow, script, settings page, or configuration file has been retired since the repository was created. The first one to go will be recorded here in the form above.
