plugins {
    id("com.android.application") version "8.7.3" apply false
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
}

// Dependency locking writes the resolved graph to gradle.lockfile, which is what
// osv-scanner reads. See docs/research/play-store-quality.md and scripts/scan.sh.
allprojects {
    dependencyLocking {
        lockAllConfigurations()
    }
}
