plugins {
    alias(libs.plugins.productsChallenger.library)
    alias(libs.plugins.productsChallenger.test)
}

android {
    namespace = "com.productschallenge.core.domain"
}

dependencies {
    implementation(projects.common)
}