plugins {
    alias(libs.plugins.productsChallenger.application)
    alias(libs.plugins.productsChallenger.compose)
    alias(libs.plugins.productsChallenger.test)
}

android {
    val appPackage = "com.productschallenge"
    namespace = appPackage
    defaultConfig {
        applicationId = appPackage
    }
}

dependencies {
    implementation(projects.common)
    implementation(projects.core.designsystem)
    implementation(projects.core.ui)
    implementation(projects.core.router)
    implementation(projects.core.database)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.analytic)
    implementation(projects.feature.product)
    implementation(platform(libs.firebase.bom))
    implementation(libs.androidx.hilt.work)
    implementation(libs.androidx.splash.screen)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.startup)
}