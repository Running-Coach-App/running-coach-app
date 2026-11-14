import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

val localProperties = Properties().apply {
    val file = rootProject.file("local.properties")
    if (file.exists()) {
        file.inputStream().use { load(it) }
    }
}
val collectorUrl = localProperties.getProperty("collector.url", "")
val downloadUrl = localProperties.getProperty("download.url", "")

android {
    namespace = "app.runningcoach"
    compileSdk = 35

    defaultConfig {
        applicationId = "app.runningcoach"
        minSdk = 26
        targetSdk = 35
        versionCode = 4
        versionName = "0.4.0"
        buildConfigField("String", "COLLECTOR_URL", "\"$collectorUrl\"")
        buildConfigField("String", "DOWNLOAD_URL", "\"$downloadUrl\"")
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.core:core-splashscreen:1.2.0")
    implementation("androidx.appcompat:appcompat:1.8.0")
    implementation("androidx.media:media:1.7.0")
    testImplementation("junit:junit:4.13.2")
}
