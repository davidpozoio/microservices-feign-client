package com.example.Students.clients

import com.example.Students.dto.Grade
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("GRADES-MS")
interface GradeClient {
    @RequestMapping(method = [RequestMethod.GET], value = ["/grades"])
    fun findAll(): List<Grade>

    @GetMapping("grades/students/{id}")
    fun findByStudentId(@PathVariable("id") studentId: Long): List<Grade>
}