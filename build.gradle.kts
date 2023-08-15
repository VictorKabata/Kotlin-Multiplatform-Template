plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.kotlin) apply false
    alias(libs.plugins.multiplatform) apply false
    alias(libs.plugins.jvm) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.nativeCocoapod) apply false

    alias(libs.plugins.ktLint) // ToDo: Add ktLint to all sub-projects
    alias(libs.plugins.detekt)
    alias(libs.plugins.gradleVersionUpdates)
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    detekt {
        parallel = true
        config = files("${project.rootDir}/config/detekt/detekt.yml")
    }

    tasks.withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
        checkForGradleUpdate = true
        outputFormatter = "html"
        outputDir = "build/reports/dependencyUpdates"
        reportfileName = "report"
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
