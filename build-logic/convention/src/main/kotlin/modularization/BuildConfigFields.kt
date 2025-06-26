package modularization

import com.android.build.api.dsl.ApplicationBuildType
import com.android.build.api.dsl.ApplicationProductFlavor
import enums.BuildType
import enums.Flavor
import file.LoadPropertiesFile
import org.gradle.api.Project

internal fun ApplicationBuildType.setBuildConfigFields(
    project: Project,
    buildType: BuildType
) {
}

internal fun ApplicationProductFlavor.setBuildConfigFields(
    project: Project,
    flavor: Flavor
) {
    val properties = LoadPropertiesFile(project, flavor)
    buildConfigField("String", "DUMMY_JSON_API_HOST", properties.getProperty("host.dummy-json"))
}