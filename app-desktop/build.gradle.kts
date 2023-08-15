plugins {
    alias(libs.plugins.jvm)
    // alias(libs.plugins.compose.desktop.plugin)
    alias(libs.plugins.compose)
}

dependencies {
    implementation(project(":shared"))

    implementation(compose.desktop.currentOs)

    testImplementation(libs.kotlin.test)
    testImplementation(libs.turbine)
    testImplementation(libs.ktor.mock)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinX.coroutines.test)
}

compose.desktop {
    application {
        mainClass = "DesktopApplicationKt"
    }
}
