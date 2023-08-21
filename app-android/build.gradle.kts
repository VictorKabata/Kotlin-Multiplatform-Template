plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
}

android {
    compileSdk = 33
    namespace = "com.vickikbt.kmp_template"

    defaultConfig {
        applicationId = "com.vickikbt.kmp_template"
        minSdk = 21
        targetSdk = compileSdk
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlin {
        jvmToolchain(11)
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.5"
    }
}

dependencies {
    implementation(project(":shared"))
}
