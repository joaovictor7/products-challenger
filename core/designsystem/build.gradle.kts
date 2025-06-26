plugins {
    alias(libs.plugins.productsChallenger.library)
    alias(libs.plugins.productsChallenger.compose)
}

android {
    namespace = "com.productschallenge.core.designsystem"
}

dependencies {
    implementation(projects.common)
    implementation(projects.core.domain)
    implementation(projects.core.ui)
    implementation(projects.core.router)
    implementation(libs.androidx.appcompat)
    implementation(libs.coil)
    implementation(libs.coil.network)
}