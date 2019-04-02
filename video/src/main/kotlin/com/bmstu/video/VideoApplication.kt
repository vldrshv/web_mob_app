package com.bmstu.video

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class VideoApplication

fun main(args: Array<String>) {
    runApplication<VideoApplication>(*args)
}