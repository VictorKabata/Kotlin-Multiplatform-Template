object AndroidSdk {
    const val appName = "KMP Template"

    const val applicationId = "com.company.kmp_template.android"

    const val buildToolVersion = "30.0.3"

    const val minSdkVersion = 21
    const val compileSdkVersion = 32
    const val targetSdkVersion = compileSdkVersion

    const val versionCode = 1
    const val versionName = "1.0"

    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object AndroidDependencies {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"

    const val material = "com.google.android.material:material:${Versions.material}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val composeUI = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeRuntime =
        "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val composeUtil = "androidx.compose.ui:ui-util:${Versions.compose}"
    const val composeConstraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.compose_constraint}"
    const val composeActivity =
        "androidx.activity:activity-compose:${Versions.compose_activity}"

    const val accompanistPager =
        "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
    const val accompanistInsets =
        "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
    const val accompanistAnimation =
        "com.google.accompanist:accompanist-navigation-animation:${Versions.accompanist}"
    const val accompanistSystemUIController =
        "com.google.accompanist:accompanist-systemuicontroller:0.17.0"
    const val accompanistMaterialPlaceHolder =
        "com.google.accompanist:accompanist-placeholder-material:${Versions.accompanist}"
    const val accompanistPagerIndicator =
        "com.google.accompanist:accompanist-pager-indicators:0.22.0-rc"

    const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    // Koin-Dependency injection
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"

    // Compose Navigation-Navigation between various screens
    const val composeNavigation =
        "androidx.navigation:navigation-compose:${Versions.navigation}"

    // Coil-Image Loader
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
}
