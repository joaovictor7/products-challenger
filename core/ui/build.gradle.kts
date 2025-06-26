plugins {
    alias(libs.plugins.productsChallenger.library)
    alias(libs.plugins.productsChallenger.compose)
}

android {
    namespace = "com.productschallenge.core.ui"
}

dependencies {
    implementation(projects.common)
    implementation(projects.core.analytic)
    implementation(projects.core.router)
    implementation(libs.android.location)
    api(libs.android.permissions)
}