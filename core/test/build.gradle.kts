plugins {
    alias(libs.plugins.productsChallenger.library)

}

android {
    namespace = "com.productschallenge.core.test"
}

dependencies {
    implementation(libs.junit5)
    implementation(libs.kotlin.coroutines.test)
    implementation(libs.mockk)
}