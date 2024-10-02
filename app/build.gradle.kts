plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.devtools.ksp")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.nectar"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nectar"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //SplashScreen
    implementation(libs.androidx.core.splashscreen)
    //Banner
    implementation (libs.androidx.viewpager2)
    implementation (libs.material.v180)  // For TabLayout
    //glide
    implementation (libs.glide)
    annotationProcessor (libs.compiler)
    implementation(libs.glide.transformations)
    //retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    //okhttp
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp3.okhttp)
    implementation(libs.logging.interceptor)
    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
//    // ViewModel
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:<version>")
//    // Fragment KTX for ViewModel delegation
//    implementation ("androidx.fragment:fragment-ktx:<version>")
//    // Kotlin Coroutines
//    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:<version>")

}
kapt {
    correctErrorTypes = true
}