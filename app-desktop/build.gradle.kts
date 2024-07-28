plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
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

dependencies {
    implementation(project(":shared"))
    implementation(compose.desktop.currentOs)
}
