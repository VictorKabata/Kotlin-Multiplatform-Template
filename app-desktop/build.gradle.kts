plugins {
    kotlin(Plugins.jvm)
    id(Plugins.compose) version Versions.composeDesktop

    // alias(libs.plugins.jvm)
    // alias(libs.plugins.compose.desktop.plugin)
}

dependencies {
    implementation(project(BuildModules.shared))

    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "DesktopApplicationKt"
    }
}
