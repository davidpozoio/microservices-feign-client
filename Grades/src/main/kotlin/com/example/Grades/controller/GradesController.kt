package com.example.Grades.controller
import com.example.Grades.entity.GradesEntity
import com.example.Grades.service.GradesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/grades")   //endpoint
class GradesController {
    @Autowired
    lateinit var gradesService: GradesService

    @GetMapping
    fun list ():List <GradesEntity>{
        return gradesService.list()
    }

    @GetMapping("/students/{id}")
    fun findAllByStudentId(@PathVariable("id") studentId: Long): List<GradesEntity>{
        return  gradesService.findAllByStudentId(studentId)
    }

    @PostMapping
    fun save (@RequestBody gradesEntity: GradesEntity):ResponseEntity<GradesEntity>{
        return ResponseEntity(gradesService.save(gradesEntity), HttpStatus.OK)
    }
}