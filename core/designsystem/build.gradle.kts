plugins {
    id("cryptocurrency.android.library")
    id("cryptocurrency.android.hilt")
    id("cryptocurrency.android.library.compose")
}

android {
    namespace = "com.jeremy.crypto.core.designsystem"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxComposeFoundation)
    implementation(libs.androidxComposeFoundationLayout)
    implementation(libs.androidxComposeMaterial)
    implementation(libs.androidxComposeUiTooling)
    implementation(libs.androidxComposeUiToolingPreview)
    implementation(libs.androidxComposeUiUi)
    implementation(libs.androidxComposeRuntime)
}