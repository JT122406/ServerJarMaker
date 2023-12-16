package com.github.jt122406.serverjarmaker.tasks

import net.fabricmc.loom.task.RemapJarTask
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class ServerJarTask : DefaultTask() {

    init {
        group = "serverJar"
        description = "Creates a server jar without client resources"
    }

    @TaskAction
    fun createServerJar(modid: String) {
        dependsOn(StrippedJar::class)
        val strippedJar = StrippedJar().createStrippedJar(modid)
        val jar = project.tasks.create("serverJar", RemapJarTask::class.java) {
            inputFile.set(strippedJar.archiveFile)
        }
        jar.archiveFileName.set("serverJar.jar")
        jar.from("src/main/server")
        StrippedJar().deleteStrippedJar(strippedJar)
    }

}