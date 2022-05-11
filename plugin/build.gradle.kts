import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.18.2-R0.1-SNAPSHOT")
    implementation(project(":itembuilder"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

group = "dev.vetther.plugin"
version = "1.0-SNAPSHOT"

bukkit {
    main = "dev.vetther.main.java.plugin.Main"
    apiVersion = "1.13"
    prefix = "SpigotUtilities"
    name = "SpigotUtilities"
    version = "${project.version}"
}

tasks.withType<ShadowJar> {
    archiveFileName.set("SpigotUtilities v${project.version}.jar")

    exclude("org/intellij/lang/annotations/**")
    exclude("org/jetbrains/annotations/**")
    exclude("org/checkerframework/**")
    exclude("META-INF/**")
    exclude("javax/**")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}