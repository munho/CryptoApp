plugins {
    id("cryptocurrency.android.feature")
    id("cryptocurrency.android.library.compose")
}

android {
    namespace = "com.jeremy.crypto.feature.home"
}

dependencies {
    implementation(libs.androidxComposeMaterial)
    implementation(libs.androidxComposeFoundation)
    implementation(libs.androidxComposeFoundationLayout)
    implementation(libs.androidxComposeUiTooling)
    implementation(libs.androidxComposeUiToolingPreview)
    implementation(libs.androidxComposeUiUi)
    implementation(libs.androidxComposeRuntime)
}
