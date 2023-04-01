pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "KMP_Template"
include(":app-android")
include(":app-desktop")
include(":shared")
