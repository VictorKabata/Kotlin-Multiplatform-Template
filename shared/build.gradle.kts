import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.nativeCocoapod)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        when {
            System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
            System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
            else -> ::iosX64
        }
    iosTarget("ios") {}

    jvm("desktop")

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../app-ios/Podfile")
        framework {
            baseName = "shared"
            isStatic = false
        }
    }

    sourceSets {
        sourceSets["commonMain"].dependencies {
            api(compose.runtime)
            api(compose.foundation)
            api(compose.material3)
            api(compose.components.resources)

            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.composeViewModel)

            api(libs.napier)

            implementation(libs.coroutines)

            implementation(libs.bundles.ktor)
        }

        sourceSets["commonTest"].dependencies {
        }

        sourceSets["androidMain"].dependencies {
            implementation(libs.ktor.android)
        }

        sourceSets["androidUnitTest"].dependencies {}

        sourceSets["androidInstrumentedTest"].dependencies {}

        sourceSets["iosMain"].dependencies {
            implementation(libs.ktor.darwin)
        }

        sourceSets["iosTest"].dependencies {}

        sourceSets["desktopMain"].dependencies {
            implementation(libs.ktor.java)
        }

        sourceSets["desktopTest"].dependencies {}
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

compose.desktop {
    application {
        mainClass = "DesktopApplicationKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.example.project"
            packageVersion = "1.0.0"
        }
    }
}
