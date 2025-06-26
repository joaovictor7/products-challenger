plugins {
    alias(libs.plugins.productsChallenger.library)
}

android {
    namespace = "com.productschallenge.core.security"
}

dependencies {
    implementation(projects.common)
    implementation(projects.core.domain)
    implementation(projects.core.ui)
    implementation(libs.androidx.biometric)
}