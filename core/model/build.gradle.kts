plugins {
    id("kotlin")
    id("kotlinx-serialization")
}

dependencies {
    implementation(libs.kotlinxCoroutinesCore)
    implementation(libs.kotlinSerializationJson)
}
