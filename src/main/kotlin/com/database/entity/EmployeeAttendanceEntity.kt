package com.database.entity

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import java.time.LocalDate

@Serdeable
@Entity
@Table(name = "attendance")
class EmployeeAttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Int? = null

    lateinit var employeeId:String

    lateinit var date: LocalDate

    var status:String = "not specified"
}