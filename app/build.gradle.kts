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
        targetSdkVersion(AppConfig.targetSdkVersion)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    testOptions {
        unitTests.apply {
            isReturnDefaultValues = true
        }
    }

    packagingOptions {
        exclude ("**/attach_hotspot_windows.dll")
        exclude ("META-INF/licenses/**")
        exclude( "META-INF/AL2.0")
        exclude ("META-INF/LGPL2.1")
    }
}

dependencies {

    implementation(Dependencies.kotlinCore)
    implementation(Dependencies.kotlinKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.googleMaterial)
    implementation(Dependencies.constraintLayout)