plugins {
    kotlin("jvm") version "1.9.21"
    java
    idea
    `java-gradle-plugin`
    `kotlin-dsl`
    `maven-publish`
}

group = "com.github.jt122406"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

dependencies {
    implementation(gradleApi())
    api("net.fabricmc:fabric-loom:1.4-SNAPSHOT")
}

gradlePlugin {
    plugins {
        create("serverJarMaker") {
            displayName = "Server Jar Maker"
            description = "Creates a server jar without client resources"
            id = "server-jar-maker"
            implementationClass = "com.github.jt122406.serverjarmaker.ServerJarMaker"
            tags.set(listOf("minecraft"))
        }
    }
}

kotlin.jvmToolchain(17)

publishing {
    publications {
        repositories.mavenLocal()
    }
}