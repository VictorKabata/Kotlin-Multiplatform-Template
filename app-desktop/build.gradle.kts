plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
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
