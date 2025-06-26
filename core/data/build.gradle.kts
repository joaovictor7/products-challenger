plugins {
    alias(libs.plugins.productsChallenger.library)
}

android {
    namespace = "com.productschallenge.core.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.common)
    implementation(libs.androidx.work.manager)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.config)
    api(libs.androidx.dataStore)
}