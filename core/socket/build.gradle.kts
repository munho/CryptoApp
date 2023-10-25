plugins {
    id("cryptocurrency.android.library")
    id("cryptocurrency.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.jeremy.crypto.core.socket"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
}

dependencies {
    implementation(libs.okHttpCore)
    implementation(libs.okhttpLogging)

    implementation(libs.thunder)
    implementation(libs.thunderOkhttp)

    testImplementation(libs.junit)
    testImplementation(libs.kotlinxCoroutinesTest)
    androidTestImplementation(libs.espressoCore)
}
