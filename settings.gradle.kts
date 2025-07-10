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
        maven("https://jitpack.io")
        maven {
            credentials {
                username = ("6256cd6c7e8dbc28d896a661")
                password = ("KRuEgA3WYUVy")
            }
            url = uri("https://packages.aliyun.com/maven/repository/2302596-release-mpvXBR/")
        }
    }
}

rootProject.name = "AndroidTemplate"
include(":app")
