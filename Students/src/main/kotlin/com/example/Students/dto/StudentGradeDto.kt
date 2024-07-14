package com.example.Students.dto

import lombok.Data
import lombok.Getter

@Getter
class StudentGradeDto {
    var id: Long? = null
    var fullName: String? = null
    var grades: List<Grade>? = null
}