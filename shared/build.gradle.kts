import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin(Plugins.multiplatform)
    id(Plugins.androidLibrary)
    kotlin(Plugins.kotlinXSerialization) version Versions.kotlinSerialization
    id(Plugins.sqlDelight) version Versions.sqlDelight
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

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        when {
            System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
            System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
            else -> ::iosX64
        }
    iosTarget("iOS") {}

    jvm()

    sourceSets {
        sourceSets["commonMain"].dependencies {
            api(MultiplatformDependencies.koinCore)

            implementation(MultiplatformDependencies.kotlinxCoroutines)
            implementation(MultiplatformDependencies.kotlinxSerialization)
            implementation(MultiplatformDependencies.kotlinxDateTime)

            implementation(MultiplatformDependencies.ktorCore)
            implementation(MultiplatformDependencies.ktorSerialization)
            implementation(MultiplatformDependencies.ktorLogging)

            implementation(MultiplatformDependencies.sqlDelight)
            implementation(MultiplatformDependencies.sqlDelightCoroutine)

            implementation(MultiplatformDependencies.multiplatformSettings)
            implementation(MultiplatformDependencies.multiplatformSettingsCoroutines)

            api(MultiplatformDependencies.napier)
        }

        sourceSets["commonTest"].dependencies {
            implementation(kotlin("test"))
        }

        sourceSets["androidMain"].dependencies {
            implementation(MultiplatformDependencies.ktorAndroid)
            implementation(MultiplatformDependencies.sqlDelightAndroid)
        }

        sourceSets["androidTest"].dependencies {
        }

        sourceSets["iOSMain"].dependencies {
            implementation(MultiplatformDependencies.ktoriOS)
            implementation(MultiplatformDependencies.sqlDelightNative)
        }

        sourceSets["iOSTest"].dependencies {
        }

        sourceSets["jvmMain"].dependencies {
            api(MultiplatformDependencies.ktorJvm)
            implementation(MultiplatformDependencies.sqlDelightJVM)
        }

        sourceSets["jvmTest"].dependencies {
        }
    }
}

sqldelight {
    database(name = "AppDatabase") {
        packageName = "com.vickikbt.kmptemplate.data.cache.sqldelight"
        sourceFolders = listOf("kotlin")
    }
}
