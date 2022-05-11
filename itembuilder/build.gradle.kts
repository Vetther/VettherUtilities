plugins {
    id("java-library")
    id("maven-publish")
}

dependencies {
    implementation("org.jetbrains:annotations:23.0.0")

    api("net.kyori:adventure-api:4.10.1")
    api("net.kyori:adventure-text-serializer-legacy:4.10.1")
    api("net.kyori:adventure-text-serializer-gson:4.10.1")

    compileOnly("org.spigotmc:spigot-api:1.18.2-R0.1-SNAPSHOT")
}

val itemBuilderArtifact: String by rootProject.extra

publishing {
    publications {
        create<MavenPublication>("maven") {
            this.artifactId = itemBuilderArtifact
            this.from(components["java"])
        }
    }
}

