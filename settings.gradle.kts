pluginManagement {
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

    // Corrected version catalog declaration
    versionCatalogs {
        libs {
            // Specify the correct path to your TOML file
            from('libs.versions.toml')
        }
    }
}

rootProject.name = "pr2"
include(":app")
