buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath(Plugins.kotlin)
        classpath(Plugins.gradle)
    }
}

plugins {
    id("org.jlleitschuh.gradle.ktlint") version Versions.ktLint
// ToDo: Add Detekt
}

allprojects {

    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

subprojects {
    apply(plugin = Plugins.ktLint)
    ktlint {
        debug.set(true)
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        outputColorName.set("RED")
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
