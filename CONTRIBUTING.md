# Contributing

Running Coach App, team 4.

## Commit messages

One short sentence, in the imperative, saying what the change does.

`Add the spoken start and stop for a pocket session.`

Do not put a type tag in the subject. Do not name a tool, an agent, or a model in the message, the pull request title, the pull request body, or a pull request comment.

## How a change gets in

1. Branch from `main`. Name the branch `<task-number>-<short-description>`, for example `41-spoken-start-stop`.
2. One pull request closes exactly one task issue. The body uses [the pull request template](.github/pull_request_template.md), and the closing line is `Closes #<task>`.
3. A user-visible change adds an entry under `[Unreleased]` in [`CHANGELOG.md`](CHANGELOG.md).
4. Another member approves. The author does not approve their own pull request. The reviewer checks the task's acceptance criteria against [the definition of done](docs/definition-of-done.md) and ticks them on the issue before merging.
5. Run `./scripts/scan.sh` before pushing anything that touches the manifest, a dependency, or `app/src`. It is [`QR-08`](docs/quality-requirements/qr/QR-08.md)'s test and the `Security scan` workflow runs it anyway, but it takes seconds locally and the failure message is clearer than a red check.
6. Merge into `main`. Direct pushes to `main` are blocked.

## Upgrading a Gradle dependency

Dependency locking is on, and `app/gradle.lockfile` is committed. It is what [`QR-08`](docs/quality-requirements/qr/QR-08.md)'s scan reads to tell a vulnerable dependency that ships in the app from one that only the build uses.

The cost is that a version bump needs the lockfile regenerated in the same change. A bump that leaves the lockfile alone fails the build with:

```text
Did not resolve 'androidx.fragment:fragment:1.5.4' which is part of the dependency lock state
```

So on a Dependabot pull request that touches `app/build.gradle.kts` or a Gradle plugin version, check out its branch and run:

```sh
gradle :app:dependencies --write-locks
```

Then commit the regenerated `app/gradle.lockfile` onto that branch. A bump to a *lower* version does not fail; the lock quietly raises it back, which is worth knowing when a downgrade appears to have no effect.

Adding or removing a dependency needs the same step.

## GitHub project

The team uses one public project: [Running Coach App](https://github.com/orgs/Running-Coach-App/projects/3). Its table view is the view that matters: it shows `Responsible`, `Accountable`, `Assignees`, and `Milestone`, and it is grouped by `Milestone`, so a sprint is one group.

`Responsible` is the member doing the work. `Accountable` is the member who checks it. Both are assignees on the issue. The options on each field are the four GitHub usernames: `sirjaey`, `JustACommonMan-OSDD`, `ObeTech1`, `Ezekiel-Gadzama`.

Open issues are also listed from [the repository issues](https://github.com/Running-Coach-App/running-coach-app/issues).
