package com.example.Grades.client

import com.example.Grades.dto.StudentDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient("STUDENTS-MS")
interface StudentClient {
    @GetMapping("/students/{id}")
    fun findById(@PathVariable("id") id: Long?): StudentDto?
}