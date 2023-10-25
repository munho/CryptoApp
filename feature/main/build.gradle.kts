plugins {
    id("cryptocurrency.android.feature")
    id("cryptocurrency.android.library.compose")
}

android {
    namespace = "com.jeremy.crypto.feature.main"
}

dependencies {
    implementation(project(":feature:home"))
    implementation(project(":feature:favorite"))

    implementation(libs.androidxComposeMaterial)
    implementation(libs.androidxComposeFoundation)
    implementation(libs.androidxComposeFoundationLayout)
    implementation(libs.androidxComposeUiTooling)
    implementation(libs.androidxComposeUiToolingPreview)
    implementation(libs.androidxComposeUiUi)
    implementation(libs.androidxComposeRuntime)

    implementation(libs.junit)
    implementation(libs.extJunit)
}
