plugins {
    alias(libs.plugins.productsChallenger.library)
    alias(libs.plugins.productsChallenger.compose)
}

android {
    namespace = "com.productschallenge.core.router"
}

dependencies {
    implementation(projects.common)
    implementation(projects.core.network)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlin.json.serializable)
}