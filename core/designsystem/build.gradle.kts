plugins {
    id("cryptocurrency.android.application")
    id("cryptocurrency.android.application.compose")
}

android {
    namespace = "com.jeremy.crypto.designsystem"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxComposeFoundation)
    implementation(libs.androidxComposeFoundationLayout)
    implementation(libs.androidxComposeMaterial)
    implementation(libs.androidxComposeUiTooling)
    implementation(libs.androidxComposeUiToolingPreview)
    implementation(libs.androidxComposeUiUi)
    implementation(libs.androidxComposeRuntime)
}