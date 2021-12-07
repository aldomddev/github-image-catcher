import Dependencies.Deps

plugins {
    id(Dependencies.BuildPlugins.androidApplication)
    id(Dependencies.BuildPlugins.kotlinAndroid)
    id(Dependencies.BuildPlugins.daggerHiltAndroid)
    id(Dependencies.BuildPlugins.kotlinKapt)
    id(Dependencies.BuildPlugins.kotlinSerialization)
    id(Dependencies.BuildPlugins.kotlinParcelize)
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "br.com.amd.githubimagecatcher"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.appVersionCode
        versionName = Config.appVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf("room.schemaLocation" to "$projectDir/schemas")
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.kotlinTarget
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Deps.androidxActivity)
    implementation(Deps.androidxAppCompat)
    implementation(Deps.androidxConstraintLayout)
    implementation(Deps.androidxCore)
    implementation(Deps.androidMaterial)
    implementation(Deps.androidxSwipeToRefresh)
    implementation(Deps.coil)
    implementation(Deps.kotlinSerialization)
    implementation(Deps.timber)
    dependOnNavigation()
    dependOnCoroutines()
    dependOnHilt()
    dependOnLifecycle()
    dependOnRetrofit()
    dependOnRoom()
    // tests
    dependOnTests()
}