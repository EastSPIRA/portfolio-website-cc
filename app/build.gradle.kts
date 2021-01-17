plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android{
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig{
        applicationId = "pawel.hn.coinmarketapp"
        minSdkVersion(AppConfig.minSdkVersion)
