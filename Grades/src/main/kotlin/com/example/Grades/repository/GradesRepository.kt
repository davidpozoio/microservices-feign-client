package com.example.Grades.repository

import com.example.Grades.entity.GradesEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.swing.text.html.parser.Entity

@Repository
interface GradesRepository : JpaRepository<GradesEntity, Long?> {
    @Query(nativeQuery = true, value = "SELECT * FROM grades WHERE student_id = ?")
    fun findAllByStudentId(studentId: Long): List<GradesEntity>
}
