# CM Evaluation

**Baseline:** [`bd3ca33`](https://github.com/Running-Coach-App/running-coach-app/commit/bd3ca33d8c4e83fbbe824c16f4c7c0a23de47768), the state of `main` on 2026-11-19 after [#261](https://github.com/Running-Coach-App/running-coach-app/pull/261) merged.

**Reviewed:** 2026-11-19

## Method

sirjaey judged the configuration on 2026-11-19 against `bd3ca33`, working from [`docs/configuration-plan.md`](../../docs/configuration-plan.md) rather than from memory, and taking the goals in the order the plan's groups appear: deciding a change is safe to merge, reproducing the build a reader installs, keeping the context trustworthy for whoever reads it next, and putting the product where the `Customer` can reach it. Each goal was judged against what the week's own work actually did to it — eleven merged pull requests, four spurious check failures, one toolchain bump and its revert, and one crash found on a phone — rather than against how the configuration is supposed to behave. The product's source code, the usability test's design, and the course's own requirements were out of scope: this judges the machinery around the product, not the product.

## Goal: deciding that a change is safe to merge

A reviewer, or an agent, needs one signal that says whether a branch is fit to land. Everything in the **Checks** group exists for that, and so does the protection that makes those checks matter.

**Today:** [`CFG-01`](../../docs/configuration-plan.md#cfg-01) requires a pull request and a review from somebody other than the last pusher. [`CFG-03`](../../docs/configuration-plan.md#cfg-03) runs nine workflows on every pull request. [`CFG-04`](../../docs/configuration-plan.md#cfg-04) proves the product declares no network permission, and [`CFG-05`](../../docs/configuration-plan.md#cfg-05) proves the citations resolve. [`CFG-11`](../../docs/configuration-plan.md#cfg-11) catches links that break on the published site.

**A more convenient way:** **Keep** every check. **Add** one repository setting: require a branch to be up to date with `main` before it can merge, so each check re-runs against the tree it will actually produce.

**Why:** The goal is achieved by the checks; what fails is knowing *when* a green tick was earned. [#247](https://github.com/Running-Coach-App/running-coach-app/pull/247) was merged on a check that passed at 21:19 the previous evening against a different tree, and the Gradle bump it carried then failed twice. [#257](https://github.com/Running-Coach-App/running-coach-app/pull/257) was **passing** while sitting on a base two toolchain bumps old, so its green tick said nothing about today's `main`. [#259](https://github.com/Running-Coach-App/running-coach-app/pull/259) failed for the same reason and went green the moment its branch was brought up to date. Three instances in one day, and the same shape as the broken documentation link that reached `main` in Week 7 past a failing `Docs` check. The change removes a named mechanism: a human reading timestamps on a checks page and deciding whether a green tick is still true. Nobody did that reliably, including the person writing this.

**Tradeoffs:** Every merge needs its branch updated first, so a busy day means more re-runs and more waiting, and with [`CFG-05`](../../docs/configuration-plan.md#cfg-05) failing spuriously about once per pull request that cost is real rather than theoretical. It also makes merging several pull requests in a row serial instead of parallel, which this week would have slowed an already long day. The team gives up some speed for a tick that means what it says, and a tick that does not mean what it says is worth nothing at all.

## Goal: reproducing the build a reader installs

Anybody — the `Customer`, a participant, an instructor — should be able to get the build the documentation describes, and the team should be able to produce that same build again.

**Today:** [`CFG-08`](../../docs/configuration-plan.md#cfg-08) pins Gradle and locks the dependencies. [`CFG-09`](../../docs/configuration-plan.md#cfg-09) keeps the pins current. [`CFG-06`](../../docs/configuration-plan.md#cfg-06) keeps the build-time addresses out of version control. [`CFG-02`](../../docs/configuration-plan.md#cfg-02) publishes the result as a release asset.

**A more convenient way:** **Keep** the pinning and the lockfile. **Replace** the published debug APK with a signed release build, and **Cut** the sentence in the documentation that describes a release build nobody produces.

**Why:** The pinning half works: the wrapper and the lockfile move together, `CFG-04` reads the lockfile, and the revert in [#261](https://github.com/Running-Coach-App/running-coach-app/pull/261) restored both exactly. The publishing half does not. The asset on the releases page is `running-coach-app-v0.5.0-debug.apk`: it holds `INTERNET`, is `application-debuggable`, and permits cleartext, while the README told a reader it held no internet permission ([#248](https://github.com/Running-Coach-App/running-coach-app/issues/248)). `assembleRelease` produces an unsigned APK nobody can install, because no signing configuration exists, so "the release build" in the documentation names something that is never produced. The change removes a named mechanism: the team remembering which of two builds the documentation is talking about, and getting it wrong in two files.

**Tradeoffs:** A signed release needs a keystore, and the keystore needs somewhere to live that `CFG-04` will not flag as a committed credential — which means a repository secret and one more thing only one member can rotate. The debuggable build is also genuinely more useful for the team's own test phones, so the team gives up some convenience in exchange for shipping what it claims to ship. Worth it, because the claim is a privacy claim made to a customer who asked to verify it himself.

## Goal: keeping the context trustworthy for whoever reads it next

A new member, an instructor, or a coding agent arrives with no memory of this project. What they read has to be true, and it has to be all of it.

**Today:** [`CFG-10`](../../docs/configuration-plan.md#cfg-10) is the agent instruction set; [`CFG-11`](../../docs/configuration-plan.md#cfg-11) publishes the documentation; [`docs/setup.md`](../../docs/setup.md) tells a newcomer how to build.

**A more convenient way:** **Merge** the version numbers into one source — the file the build actually reads — and **Keep** the routers as they are.

**Why:** Three documents named Gradle `8.11.1` while the wrapper the build resolves had said `9.8.2` for weeks and then `9.9.1`. Worse than stale: `docs/setup.md` asserted that its number *was* the one in the wrapper file, so a reader who checked found a contradiction with no way to resolve it, and `AGENTS.md` named a fixed version seven lines above a sentence pointing at the wrapper file. [#259](https://github.com/Running-Coach-App/running-coach-app/pull/259) made the wrapper file the single source and left one number marked as current; when [#261](https://github.com/Running-Coach-App/running-coach-app/pull/261) reverted the wrapper hours later, keeping the documentation true was a one-word edit instead of a hunt. The mechanism removed is a person noticing that a number repeated in three files has drifted — which nobody did for weeks, through a project whose own CI was building on a version no document mentioned.

**Tradeoffs:** Pointing at a file instead of giving a number costs the reader one extra click at exactly the moment they are trying to install something, and "the version in that file" is a worse instruction than "9.8.2" for somebody in a hurry. The compromise in place — name the file as authoritative, give the current number once, marked as current — keeps the convenience and makes the next drift a one-word fix rather than a contradiction. The part this does **not** fix is that `CFG-10` is split between a committed half and an untracked local half, so a clean clone shows an agent only some of the rules it is required to follow. That is a larger change and it is not proposed here.

## Goal: putting the product where the Customer can reach it

The `Customer` is on the university network and does not build from source. Something has to carry a build to where he is.

**Today:** [`CFG-07`](../../docs/configuration-plan.md#cfg-07) deploys to the university virtual machine on every push to `main`, serving the APK and the telemetry collector. [`CFG-02`](../../docs/configuration-plan.md#cfg-02) is the other path — the GitHub release he installs from.

**A more convenient way:** **Keep** both paths, and **Add** the deployment's result to the same place the other checks are read, so a failed deploy is as visible as a failed build.

**Why:** On `d45aaeb` the Android build passed and the campus deploy failed, on the same commit, with the same `setup-java`, the same build action, and the same command, in the same minute. The failure was found only because somebody was reading the workflow list for an unrelated reason. The deploy is the one piece of machinery whose failure the `Customer` experiences directly and the team does not, and it is the one whose result nobody is required to look at. The mechanism removed is noticing, by chance, that a workflow nobody gates on has gone red.

**Tradeoffs:** Making the deploy a gate would block merges on a university virtual machine the team does not control, and on secrets that are not set in every context — which would turn an informative failure into a stopped team. So the proposal is visibility rather than enforcement, and that is weaker on purpose: it still depends on somebody reading it. A stronger version would alert on a transition from green to red, which needs somewhere for an alert to go, and this team has no such place. That is named in **What We Could Not Judge** rather than proposed.

## What We Could Not Judge

- **The repository settings themselves.** [`CFG-01`](../../docs/configuration-plan.md#cfg-01) and the Pages and tag-protection settings are pages on GitHub, not files, and this review read the repository. Their behaviour was inferred from what happened — a merge blocked pending approval, a published site — rather than read directly. The risk is that a setting could be weaker than assumed and nothing in the repository would show it.
- **Whether the campus deployment currently works end to end.** The deploy's build step failed on the baseline's parent, and the review did not re-run it, because a successful run deploys to a live virtual machine and that is not this review's to trigger. The risk is that the address the `Customer` uses may be serving an older build than `main`.
- **The secret values and their rotation.** The names are known and the values are deliberately not, which is correct, and it means the review cannot say whether any of them has ever been rotated or who could do it. The risk is a single point of failure in one member.
- **Whether an alert has anywhere to go.** The team has no shared channel wired to anything mechanical, so "the deploy went red" has no destination. This is a configuration the team **does not have**, named here in words with no `CFG-nn`, because it does not exist yet.

## The First Change

**Require a branch to be up to date with `main` before it can merge.**

It **keeps** every check, every workflow, and the review requirement exactly as they are — nothing is removed and no new tool is introduced. It **removes** one mechanism: a human deciding, from a timestamp on a checks page, whether a green tick is still true. That decision was made wrongly three times in a single day, by the person who had just finished explaining the failure mode to somebody else.

Its **main tradeoff** is speed. Every merge needs its branch brought up to date first, which serialises a queue that is currently parallel, and the cost lands hardest on days when several pull requests are open — exactly the days this is most needed. It is also worse while [`CFG-05`](../../docs/configuration-plan.md#cfg-05) keeps failing spuriously, because each forced re-run is another chance to draw a false red. The team accepts slower merges in exchange for a signal that means what it says, and if the link check's flakiness makes that intolerable, the honest answer is to fix the link check rather than to keep merging on evidence that has expired.
