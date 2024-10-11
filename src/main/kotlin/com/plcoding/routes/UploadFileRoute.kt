package com.plcoding.routes

import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.helloWorld() {
    get("/") {
        call.respond(message = "Hello World!", status = HttpStatusCode.OK)
    }
}

fun Route.uploadFile() {
    post("/file") {
        val multipart = call.receiveMultipart()
        var message = ""
        multipart.forEachPart { part ->
            when (part) {
                is PartData.FormItem ->  {
                    if(part.name == "message") {
                        message = part.value
                    }
                }
                is PartData.FileItem -> {
                    if(part.name == "image") {
                        part.save("build/resources/main/static/images/", "myImage.jpg")
                    }
                }
                else -> Unit
            }
        }
        call.respond(message = message, status = HttpStatusCode.OK)
    }
}

fun Route.uploadTwoFiles() {
    post("/file2") {
        val multipart = call.receiveMultipart()
        var message = ""
        multipart.forEachPart { part ->
            when (part) {
                is PartData.FormItem ->  {
                    if(part.name == "message") {
                        message = part.value
                    }
                }
                is PartData.FileItem -> {
                    if(part.name == "image") {
                        part.save("build/resources/main/static/images/", "myImage.jpg")
                    }
                    if(part.name == "image2") {
                        part.save("build/resources/main/static/images/", "myImg.png")
                    }
                }
                else -> Unit
            }
        }
        call.respond(message = message, status = HttpStatusCode.OK)
    }
}