plugins {
    kotlin("jvm") version "1.9.22"
    java
    idea
    `java-gradle-plugin`
    `kotlin-dsl`
    `maven-publish`
}

group = "com.github.jt122406"
version = "1.0.2-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

dependencies {
    implementation(gradleApi())
    api("net.fabricmc:fabric-loom:1.5-SNAPSHOT")
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
        repositories {
            mavenLocal()
            maven {
                name = "Generations-Maven"
                url = uri("https://maven.generations.gg/snapshots")
                credentials {
                    username = project.properties["repoLogin"]?.toString()
                    password = project.properties["repoPassword"]?.toString()
                }
            }
        }
    }
}