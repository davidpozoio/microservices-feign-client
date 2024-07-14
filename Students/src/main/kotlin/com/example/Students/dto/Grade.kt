package com.example.Students.dto

import lombok.Data

@Data
class Grade {
    var id: Long? = null
    //var userId: Long? = null
    var subject: String? = null
    var score: Long? = null
}