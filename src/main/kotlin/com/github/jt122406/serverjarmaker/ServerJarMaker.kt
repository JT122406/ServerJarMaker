package com.github.jt122406.serverjarmaker

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.github.jt122406.serverjarmaker.tasks.ServerJarTask

class ServerJarMaker : Plugin<Project> {
    override fun apply(target: Project) {
        if (!target.plugins.hasPlugin("fabric-loom")) {
            target.logger.error("com.github.jt122406.ServerJarMaker plugin must have fabric-loom plugin installed")
            return
        }
        target.tasks.register("serverJar", ServerJarTask::class.java)
    }

}