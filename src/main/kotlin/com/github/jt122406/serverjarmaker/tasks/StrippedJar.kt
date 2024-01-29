package com.github.jt122406.serverjarmaker.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.get

open class StrippedJar : DefaultTask() {

    init {
        group = "strippedJar"
        description = "Creates a stripped jar without client resources"
    }



    fun createStrippedJar() : Jar {
        val jar = project.tasks.create("strippedJar", Jar::class.java) {
            from(project.extensions.getByType(SourceSetContainer::class.java)["main"])
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