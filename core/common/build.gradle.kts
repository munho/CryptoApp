plugins {
    id("cryptocurrency.android.library")
    kotlin("kapt")
}

android {
    namespace = "com.jeremy.crypto.core.common"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(libs.kotlinxCoroutinesAndroid)

    testImplementation(libs.junit)
    testImplementation(libs.extJunit)

    implementation(libs.hiltAndroid)
    kapt(libs.hiltAndroidCompiler)
}
