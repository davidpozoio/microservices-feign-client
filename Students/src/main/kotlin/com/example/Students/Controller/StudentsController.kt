package com.example.Students.Controller
import com.example.Students.clients.GradeClient
import com.example.Students.dto.Grade
import com.example.Students.dto.StudentGradeDto
import com.example.Students.entity.Students
import com.example.Students.service.StudentsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/students")
class StudentsController {
    @Autowired
    lateinit var studentsService: StudentsService
    @Autowired
    lateinit var gradeClient: GradeClient

    @GetMapping
    fun findAll(): List<Students>{
        return studentsService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Long?): Students{
        return studentsService.findById(id)
    }

    @GetMapping("/{id}/grades")
    fun findByIdWithGrades(@PathVariable("id") id: Long?): StudentGradeDto{
        return studentsService.findByIdWithGrades(id)
    }

    @GetMapping("/sub-grades")
    fun findAllGrades(): List<Grade>{
        return gradeClient.findAll()
    }

    @PostMapping
    fun save(@RequestBody student: Students): Students{
        return  studentsService.save(student)
    }

}