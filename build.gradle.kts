val itemBuilderArtifact by extra("itembuilder")

plugins {
    id("java-library")
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
}

allprojects {

    group = "dev.vetther"
    version = "1.0.1"

    apply(plugin = "java-library")
    apply(plugin = "maven-publish")
    apply(plugin = "com.github.johnrengelman.shadow")

    java {
        withSourcesJar()
    }
}

subprojects {

    repositories {
        mavenLocal()
        mavenCentral()
        maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    publishing {
        repositories {
            mavenLocal()
            maven {
                name = "eternalcode-repository"
                url = uri("https://repo.eternalcode.pl/releases")
                credentials {
                    username = properties["user"] as String
                    password = properties["pass"] as String
                }
            }
        }
    }
}