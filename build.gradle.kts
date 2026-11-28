plugins {
    id("com.android.application") version "9.5.3" apply false
}

// Dependency locking writes the resolved graph to gradle.lockfile, which is what
// osv-scanner reads. See docs/research/play-store-quality.md and scripts/scan.sh.
allprojects {
    dependencyLocking {
        lockAllConfigurations()
    }
}
