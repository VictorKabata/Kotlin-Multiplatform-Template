plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    compileSdk = 34
    namespace = "com.company.kmp_template"

    defaultConfig {
        applicationId = "com.company.kmp_template"
        minSdk = 21
        targetSdk = compileSdk
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlin {
        jvmToolchain(11)
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.compose.activity)
    implementation(libs.appCompat)
    implementation(libs.koin.android)
}
