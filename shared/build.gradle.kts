import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin(Plugins.multiplatform)
    id(Plugins.androidLibrary)
}

android {
    compileSdk = AndroidSdk.compileSdkVersion
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion
    }
}

kotlin {
    android()

    jvm()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        when {
            System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
            System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
            else -> ::iosX64
        }
    iosTarget("iOS") {}

    sourceSets {
        sourceSets["commonMain"].dependencies {
            api(MultiplatformDependencies.koinCore)
        }

        sourceSets["commonTest"].dependencies {
            implementation(kotlin("test"))
        }

        sourceSets["androidMain"].dependencies {
        }

        sourceSets["androidTest"].dependencies {
        }

        sourceSets["iOSMain"].dependencies {
        }

        sourceSets["iOSTest"].dependencies {
        }

        sourceSets["jvmMain"].dependencies {
        }

        sourceSets["jvmTest"].dependencies {
        }
    }
}
