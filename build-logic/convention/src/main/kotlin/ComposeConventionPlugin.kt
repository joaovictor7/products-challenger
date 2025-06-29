import com.android.build.gradle.BaseExtension
import extension.debugImplementation
import extension.getLibrary
import extension.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

internal class ComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.plugin.compose")
//                apply("com.android.compose.screenshot") //~> revert after update
            }
            extensions.configure<BaseExtension> {
                buildFeatures.compose = true
            }
            dependencies {
                implementation(platform(getLibrary("compose.bom")))
                implementation(getLibrary("compose.activity"))
                implementation(getLibrary("compose.ui.tooling.preview"))
                implementation(getLibrary("compose.material3"))
                implementation(getLibrary("compose.navigation"))
                implementation(getLibrary("androidx.lifecycle.runtime.compose"))
                implementation(getLibrary("androidx.hilt.navigation.compose"))
                debugImplementation(getLibrary("compose.ui.tooling"))
//                screenshotTestImplementation(getLibrary("compose.ui.tooling")) //~> revert after update
//                screenshotTestImplementation(getLibrary("android.screenshot.validation")) // ~> revert after update
            }
        }
    }
}