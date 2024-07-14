package com.example.Grades

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class GradesApplication

fun main(args: Array<String>) {
	runApplication<GradesApplication>(*args)
}
