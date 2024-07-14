package com.example.Students.service

import com.example.Students.clients.GradeClient
import com.example.Students.dto.StudentGradeDto
import com.example.Students.entity.Students
import com.example.Students.repository.StudentsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentsService {
    @Autowired
    lateinit var studentsRepository: StudentsRepository
    @Autowired
    lateinit var gradeClient: GradeClient

    fun findAll(): List<Students>{
        return studentsRepository.findAll()
    }

    fun findById(id: Long?): Students{
        val student = studentsRepository.findById(id)?:
        throw NoSuchElementException("student not found")
        return  student
    }

    fun findByIdWithGrades(id: Long?): StudentGradeDto{
        val student = studentsRepository.findById(id)?:
        throw NoSuchElementException("student not found")

        val grades = gradeClient.findByStudentId(student.id ?: error("student id must not be null"))

        val studentGrades = StudentGradeDto()
        studentGrades.id = student.id
        studentGrades.fullName = student.fullName
        studentGrades.grades = grades

        return  studentGrades
    }

    fun save(student: Students): Students{
        return  studentsRepository.save(student)
    }
}