plugins {
    alias(libs.plugins.productsChallenger.library)
    alias(libs.plugins.productsChallenger.compose)
    alias(libs.plugins.productsChallenger.test)
}

android {
    namespace = "com.productschallenge.feature.product"
}

dependencies {
    implementation(projects.common)
    implementation(projects.core.network)
    implementation(projects.core.router)
    implementation(projects.core.designsystem)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.database)
    implementation(projects.core.ui)
    implementation(projects.core.analytic)
}