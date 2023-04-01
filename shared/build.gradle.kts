import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinX.serialization.plugin)
    alias(libs.plugins.sqlDelight.plugin)
    // alias(libs.plugins.nativeCocoapod)
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = compileSdk
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
            api(libs.koin.core)

            api(libs.ktor.core)
            api(libs.ktor.cio)
            implementation(libs.ktor.contentNegotiation)
            implementation(libs.ktor.json)
            implementation(libs.ktor.logging)

            implementation(libs.kotlinX.serializationJson)

            implementation(libs.sqlDelight.runtime)
            implementation(libs.sqlDelight.coroutine)

            implementation(libs.multiplatformSettings.noArg)
            implementation(libs.multiplatformSettings.coroutines)

            api(libs.napier)

            implementation(libs.kotlinX.dateTime)
        }

        sourceSets["commonTest"].dependencies {
            implementation(libs.kotlin.test)
            // implementation(kotlin("test"))
        }

        sourceSets["androidMain"].dependencies {
            implementation(libs.sqlDelight.android)
        }

        sourceSets["androidTest"].dependencies {
        }

        sourceSets["iOSMain"].dependencies {
            implementation(libs.sqlDelight.native)
        }

        sourceSets["iOSTest"].dependencies {
        }

        sourceSets["jvmMain"].dependencies {
            implementation(libs.sqlDelight.jvm)
        }

        sourceSets["jvmTest"].dependencies {
        }
    }
}

/*sqldelight {
    database(name = "AppDatabase") {
        packageName = "com.vickikbt.kmptemplate.data.cache.sqldelight"
        sourceFolders = listOf("kotlin")
    }
}*/
