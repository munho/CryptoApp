plugins {
    id("cryptocurrency.android.application")
    id("cryptocurrency.android.application.compose")
    id("cryptocurrency.android.hilt")
}

android {
    namespace = "com.jeremy.crypto"

    defaultConfig {
        applicationId = "com.jeremy.crypto"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        named("debug") {
            isMinifyEnabled = false
        }

        named("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":feature:home"))
    implementation(project(":feature:favorite"))

    implementation(project(":core:socket"))
    implementation(project(":core:cache"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:model"))
    implementation(project(":core:network"))
    implementation(project(":core:designsystem"))

    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxActivityCompose)
    implementation(libs.androidxComposeRuntime)
    implementation(libs.androidxComposeUiUi)
    implementation(libs.androidxComposeMaterial)
    implementation(libs.androidxLifecycleRuntimeCompose)

    implementation(libs.androidxHiltNavigationCompose)
    implementation(libs.androidxNavigationCompose)
    implementation(libs.accompanistNavigationAnimation)

    implementation(libs.thunder)
    implementation(libs.thunderOkhttp)

    testImplementation(libs.junit)
    androidTestImplementation(libs.extJunit)
    androidTestImplementation(libs.espressoCore)
}