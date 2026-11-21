import java.util.Properties

plugins {
    id("com.android.application")
}

val localProperties = Properties().apply {
    val file = rootProject.file("local.properties")
    if (file.exists()) {
        file.inputStream().use { load(it) }
    }
}
val collectorUrl = localProperties.getProperty("collector.url", "")
val downloadUrl = localProperties.getProperty("download.url", "")

fun envOrNull(name: String): String? = System.getenv(name)?.takeIf { it.isNotBlank() }

val releaseStoreFile = envOrNull("RELEASE_STORE_FILE")?.let { file(it) }?.takeIf { it.isFile }
val releaseStorePassword = envOrNull("RELEASE_STORE_PASSWORD")
val releaseKeyAlias = envOrNull("RELEASE_KEY_ALIAS")
val releaseKeyPassword = envOrNull("RELEASE_KEY_PASSWORD")
val releaseSigningReady =
    releaseStoreFile != null &&
        releaseStorePassword != null &&
        releaseKeyAlias != null &&
        releaseKeyPassword != null

android {
    namespace = "app.runningcoach"
    compileSdk = 35

    defaultConfig {
        applicationId = "app.runningcoach"
        minSdk = 26
        targetSdk = 35
        versionCode = 6
        versionName = "0.6.0"
        buildConfigField("String", "COLLECTOR_URL", "\"$collectorUrl\"")
        buildConfigField("String", "DOWNLOAD_URL", "\"$downloadUrl\"")
        buildConfigField("boolean", "USABILITY_BUILD", "false")
    }

    buildFeatures {
        buildConfig = true
    }

    signingConfigs {
        if (releaseSigningReady) {
            val store = releaseStoreFile!!
            val password = releaseStorePassword!!
            val alias = releaseKeyAlias!!
            val keyPass = releaseKeyPassword!!
            create("release") {
                storeFile = store
                storePassword = password
                keyAlias = alias
                keyPassword = keyPass
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            if (releaseSigningReady) {
                signingConfig = signingConfigs.getByName("release")
            }
        }
        create("usabilityTest") {
            initWith(getByName("debug"))
            applicationIdSuffix = ".usability"
            versionNameSuffix = "-usability"
            isDebuggable = true
            buildConfigField("boolean", "USABILITY_BUILD", "true")
            buildConfigField("String", "COLLECTOR_URL", "\"\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.core:core-splashscreen:1.2.0")
    implementation("androidx.appcompat:appcompat:1.8.0")
    implementation("androidx.media:media:1.7.0")
    testImplementation("junit:junit:4.13.2")
}
