package com.github.jt122406.serverjarmaker.tasks

import net.fabricmc.loom.task.RemapJarTask
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class ServerJarTask : DefaultTask() {


    init {
        group = "serverJar"
        description = "Creates a server jar without client resources"
    }

    @TaskAction
    fun createServerJar() {
        val strippedJar = StrippedJar().createStrippedJar()
        project.tasks.create("serverJar", RemapJarTask::class.java) {
            inputFile.set(strippedJar.archiveFile)
            archiveFileName.set("ServerJar.jar")
        }
        StrippedJar().deleteStrippedJar(strippedJar)
    }



}