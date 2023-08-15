rootProject.name = "KMP_Template"

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
}

include(":app-android")
include(":app-desktop")
include(":shared")
