package org.example

import com.sun.jdi.connect.Connector
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    println("시작 되었습니다.")
    SpringApplication.run(Application::class.java, *args)
}