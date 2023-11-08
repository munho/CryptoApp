plugins {
    id("cryptocurrency.android.library")
    id("cryptocurrency.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.jeremy.crypto.core.data"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:model"))
    implementation(project(":core:datastore"))
    implementation(project(":core:cache"))

    implementation(libs.retrofit)
    implementation(libs.okHttpCore)
    implementation(libs.okhttpLogging)

    testImplementation(libs.junit)
    testImplementation(libs.kotlinxCoroutinesTest)
    androidTestImplementation(libs.espressoCore)
}
