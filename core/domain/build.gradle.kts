plugins {
    id("cryptocurrency.android.library")
    kotlin("kapt")
}

android {
    namespace = "com.jeremy.crypto.core.domain"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    implementation(libs.kotlinxCoroutinesAndroid)

    testImplementation(libs.junit)
    testImplementation(libs.extJunit)

    implementation(libs.hiltAndroid)
    kapt(libs.hiltAndroidCompiler)
}
