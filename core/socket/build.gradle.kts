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
    implementation(project(":core:model"))
    implementation(project(":core:data"))

    implementation(libs.okHttpCore)
    implementation(libs.okhttpLogging)

    implementation(libs.thunder)
    implementation(libs.thunderOkhttp)

    testImplementation(libs.junit)
    testImplementation(libs.kotlinxCoroutinesTest)
}
