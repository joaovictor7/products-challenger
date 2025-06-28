pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ProductsChallenger"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":common")
include(":core:test")
include(":core:router")
include(":core:designsystem")
include(":core:ui")
include(":core:data")
include(":core:domain")
include(":core:database")
include(":core:security")
include(":core:network")
include(":core:analytic")
include(":feature:product")
include(":feature:form")
