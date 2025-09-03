pluginManagement {
    repositories {
        google()
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

rootProject.name = "BrightSprouts"

include(":app")
include(":tv")
include(":core")
include(":data")
include(":design")
include(":feature-math")
include(":feature-english")
include(":feature-animals")
include(":feature-kg")
include(":testing")
