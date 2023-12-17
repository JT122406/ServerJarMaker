package com.github.jt122406.serverjarmaker

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.github.jt122406.serverjarmaker.tasks.ServerJarTask

class ServerJarMaker : Plugin<Project> {
    override fun apply(target: Project) {
        target.logger.info("ServerJarMaker plugin Loading")
        if (!target.plugins.hasPlugin("fabric-loom")) {
            target.logger.error("ServerJarMaker plugin must have fabric-loom plugin installed")
            return
        }
        target.tasks.register("serverJar", ServerJarTask::class.java)
        target.logger.info("ServerJarMaker plugin Loaded")
    }

}