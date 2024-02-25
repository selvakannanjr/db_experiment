package com.database.dto

import com.database.entity.EmployeeAttendanceEntity
import com.database.entity.EmployeeEntity
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDate

@Serdeable
data class Attendance(
    val id:String,
    val name:String,
    val date: LocalDate,
    val status:String
)
{
    fun toEmployeeAttendanceEntity():EmployeeAttendanceEntity{
        val attendanceEntity = EmployeeAttendanceEntity()
        attendanceEntity.employeeId = this.id
        attendanceEntity.status = this.status
        attendanceEntity.date = this.date

        return attendanceEntity
    }
}
