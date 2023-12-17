package com.github.jt122406.serverjarmaker.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.SourceSetOutput
import org.gradle.api.tasks.bundling.Jar

open class StrippedJar : DefaultTask() {

    init {
        group = "strippedJar"
        description = "Creates a stripped jar without client resources"
    }


    fun createStrippedJar(set: SourceSetOutput) : Jar {
        val jar = project.tasks.create("strippedJar", Jar::class.java) {
            from(set)
            exclude("assets/**")
        }
        jar.archiveFileName.set("strippedJar.jar")
        jar.from("src/main/custom")
        return jar
    }

    fun deleteStrippedJar(jar : Jar) {
        jar.archiveFile.get().asFile.delete()
    }
}