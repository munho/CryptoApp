plugins {
    id("cryptocurrency.android.library")
    id("cryptocurrency.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.jeremy.crypto.core.network"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    implementation(libs.retrofit)
    implementation(libs.okHttpCore)
    implementation(libs.okhttpLogging)
    implementation(libs.serializationConverter)
    implementation(libs.kotlinSerializationJson)

    testImplementation(libs.junit)
    testImplementation(libs.kotlinxCoroutinesTest)
    androidTestImplementation(libs.espressoCore)
}
