plugins {
    alias(libs.plugins.productsChallenger.library)
}

android {
    namespace = "com.productschallenge.core.analytic"
}

dependencies {
    implementation(projects.core.domain)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)
}