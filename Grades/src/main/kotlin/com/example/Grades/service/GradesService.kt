package com.example.Grades.service

import com.example.Grades.client.StudentClient
import com.example.Grades.entity.GradesEntity
import com.example.Grades.repository.GradesRepository
import org.apache.catalina.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class GradesService {
    @Autowired
    lateinit var gradesRepository: GradesRepository
    @Autowired
    lateinit var studentClient: StudentClient

    fun list ():List<GradesEntity>{
        return gradesRepository.findAll()
    }
    fun save(gradesEntity: GradesEntity): GradesEntity{
        val student = studentClient.findById(gradesEntity.studentId)?:
        throw NoSuchElementException("student not found")

        return gradesRepository.save(gradesEntity)
    }

    fun findAllByStudentId(studentId: Long): List<GradesEntity>{
        return gradesRepository.findAllByStudentId(studentId)
    }
}