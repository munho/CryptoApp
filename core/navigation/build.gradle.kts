plugins {
    id("cryptocurrency.android.library")
    id("cryptocurrency.android.hilt")
    id("cryptocurrency.android.library.compose")
}

android {
    namespace = "com.jeremy.crypto.core.navigation"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(libs.androidxHiltNavigationCompose)
    implementation(libs.androidxNavigationCompose)
}