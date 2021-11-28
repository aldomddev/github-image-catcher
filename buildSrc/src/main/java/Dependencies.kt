import org.gradle.api.artifacts.dsl.DependencyHandler
import java.util.Locale
import Dependencies.Deps
import org.gradle.api.JavaVersion

object Config {
    const val minSdk = 21
    const val compileSdk = 31
    const val targetSdk = 31

    const val appVersionName = "1.0.0"
    const val appVersionCode = 1

    val javaVersion = JavaVersion.VERSION_1_8
    const val kotlinTarget = "1.8"
}

object Dependencies {

    object BuildPlugins {
        const val android = "android"

        const val androidApplication = "com.android.application"
        const val androidExtensions = "android.extensions"
        const val androidLibrary = "com.android.library"

        const val kotlinAndroid = "kotlin-android"
        const val kotlinAndroidExtensions = "kotlin-android-extensions"
        const val kotlinKapt = "kotlin-kapt"
        const val kotlinParcelize = "kotlin-parcelize"

        const val navigationSageArgs = "androidx.navigation.safeargs.kotlin"

        const val daggerHiltAndroid = "dagger.hilt.android.plugin"
        const val daggerHiltAndroidGradle =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltAndroid}"

        const val gradleVersionsPlugin = "com.github.ben-manes.versions"
        const val gradleVersionsClasspath =
            "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleVersionsPlugin}"
    }

    object Deps {
        const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"

        const val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
        const val androidxConstraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraintLayout}"
        const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
        const val androidxLifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycle}"
        const val androidxLifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifecycle}"
        const val androidxRoomCompiler = "androidx.room:room-compiler:${Versions.androidxRoom}"
        const val androidxRoomExtensions = "androidx.room:room-ktx:${Versions.androidxRoom}"
        const val androidxRoomRuntime = "androidx.room:room-runtime:${Versions.androidxRoom}"
        const val androidxRoomTesting = "androidx.room:room-testing:${Versions.androidxRoom}"

        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroid}"
        const val hiltExtensionCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltExtensionCompiler}"
        const val hiltAndroidWorkManager = "androidx.hilt:hilt-work:${Versions.hiltExtensionCompiler}"
        const val jetBrainsCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.jetBrainsCoroutines}"

        // Tests
        const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
        const val androidxEspresso = "androidx.test.espresso:espresso-core:${Versions.androidxEspresso}"

        const val junit = "junit:junit:${Versions.junit}"
    }

    @JvmStatic
    fun isNonStable(version: String): Boolean {
        val stableKeyword =
            listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase(Locale.ROOT).contains(it) }
        val regex = "^[0-9,.v-]+(-r)?$".toRegex()
        val isStable = stableKeyword || regex.matches(version)
        return isStable.not()
    }
}

// region dependencies extensions
fun DependencyHandler.dependOnLifecycle() {
    implementation(Deps.androidxLifecycleRuntime)
    implementation(Deps.androidxLifecycleViewModel)
}

fun DependencyHandler.dependOnCoroutines() {
    implementation(Deps.jetBrainsCoroutines)
}

fun DependencyHandler.dependOnHilt() {
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltAndroidCompiler)
    dependOnHiltExtensions()
}

fun DependencyHandler.dependOnHiltExtensions() {
    implementation(Deps.hiltAndroidWorkManager)
    kapt(Deps.hiltExtensionCompiler)
}

fun DependencyHandler.dependOnRoom() {
    implementation(Deps.androidxRoomRuntime)
    implementation(Deps.androidxRoomExtensions)
    kapt(Deps.androidxRoomCompiler)
}

fun DependencyHandler.dependOnTests() {
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.androidxJunit)
    androidTestImplementation(Deps.androidxEspresso)
}
// endregion

// region dependencies utils
private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

private fun DependencyHandler.debugImplementation(depName: String) {
    add("debugImplementation", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}

private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}
// endregion