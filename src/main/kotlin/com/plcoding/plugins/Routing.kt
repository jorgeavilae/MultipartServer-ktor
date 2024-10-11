package com.plcoding.plugins

import com.plcoding.routes.helloWorld
import com.plcoding.routes.uploadFile
import com.plcoding.routes.uploadTwoFiles
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        helloWorld()
    }
    routing {
        uploadFile()
    }
    routing {
        uploadTwoFiles()
    }
}
