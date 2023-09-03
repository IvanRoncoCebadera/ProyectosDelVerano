import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // Koin
    implementation("io.insert-koin:koin-core:3.4.0")
    implementation("io.insert-koin:koin-logger-slf4j:3.4.0")

    // Gson
    implementation("com.google.code.gson:gson:2.10.1")

    // Simple XML
    implementation("org.simpleframework:simple-xml:2.7.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}