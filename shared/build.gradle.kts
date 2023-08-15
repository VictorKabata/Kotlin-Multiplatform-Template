plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.nativeCocoapod)
    alias(libs.plugins.compose)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../app-ios/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        extraSpecAttributes["resources"] =
            "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }

    sourceSets {
        sourceSets["commonMain"].dependencies {
            implementation(libs.kotlinX.coroutines)
            api(libs.koin.core) // Dependency injection
            api(libs.napier) // Logging

            api(compose.runtime)
            api(compose.foundation)
            api(compose.material3)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            api(compose.components.resources)
        }

        sourceSets["commonTest"].dependencies {
            implementation(libs.kotlin.test)
        }

        sourceSets["androidMain"].dependencies {
            api(libs.androidX.core)
            api(libs.appCompat)
            api(libs.compose.activity)
        }

        sourceSets["androidUnitTest"].dependencies {}

        sourceSets["iosMain"].dependencies {
        }

        sourceSets["iosTest"].dependencies {}

        sourceSets["jvmMain"].dependencies {
        }

        sourceSets["jvmTest"].dependencies {}
    }
}

android {
    compileSdk = 34
    namespace = "com.company.kmp_template.android"

    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
}
