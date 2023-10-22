buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

// Because of IDE bug https://youtrack.jetbrains.com/issue/KTIJ-19370
plugins {
//    alias(libs.plugins.androidLibraryPlugin) apply false
//    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.androidApplication) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.androidLibraryPlugin) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlinJvmPlugin) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlinSerializationPlugin) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.hiltGradlePlugin) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.ktlintPlugin) apply false
}