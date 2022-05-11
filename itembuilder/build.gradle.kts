plugins {
    id("java")
    id("maven-publish")
}

group = "dev.vetther.itembuilder"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("org.jetbrains:annotations:20.1.0")

    api("net.kyori:adventure-api:4.9.2")
    api("net.kyori:adventure-text-serializer-legacy:4.9.2")
    api("net.kyori:adventure-text-serializer-gson:4.9.2")

    compileOnly("org.spigotmc:spigot-api:1.18.2-R0.1-SNAPSHOT")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

