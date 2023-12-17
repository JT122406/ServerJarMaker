package com.github.jt122406.serverjarmaker.tasks

import net.fabricmc.loom.task.RemapJarTask
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.SourceSetOutput
import org.gradle.api.tasks.TaskAction

class ServerJarTask : DefaultTask() {

    private var jarName = "serverJar"

    init {
        group = "serverJar"
        description = "Creates a server jar without client resources"
    }

    @TaskAction
    fun createServerJar(set : SourceSetOutput) {
        val strippedJar = StrippedJar().createStrippedJar(set)
        project.tasks.create("serverJar", RemapJarTask::class.java) {
            inputFile.set(strippedJar.archiveFile)
            archiveFileName.set("$jarName.jar")
        }
        StrippedJar().deleteStrippedJar(strippedJar)
    }


    fun serverJarName(name : String) {
        this.jarName = name
    }

}