// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.productsChallenger.application) apply false
    alias(libs.plugins.productsChallenger.library) apply false
    alias(libs.plugins.productsChallenger.compose) apply false
    alias(libs.plugins.productsChallenger.test) apply false
    alias(libs.plugins.productsChallenger.kover) apply true
    alias(libs.plugins.kotlinSerialization) apply false
    alias(libs.plugins.googleServices) apply false
    alias(libs.plugins.firebaseCrashlytics) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
//    alias(libs.plugins.screenshot) apply false // ~> revert after update
    alias(libs.plugins.kover) apply false
}