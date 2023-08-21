plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.compose)
}

dependencies {
    implementation(project(":shared"))
}

compose.desktop {
    application {
        mainClass = "DesktopApplicationKt"

        nativeDistributions {
            packageName = "KMP Template Desktop"
            packageVersion = "1.0.0"
        }
    }
}
