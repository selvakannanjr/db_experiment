package com.database.repository

import com.database.entity.EmployeeAttendanceEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.model.query.QueryModel.In
import io.micronaut.data.repository.CrudRepository
import java.time.LocalDate

@Repository
interface AttendanceRepository : CrudRepository<EmployeeAttendanceEntity, Int> {

    fun findByEmployeeIdAndDate(employeeId:String,date: LocalDate):EmployeeAttendanceEntity
    fun countByDateAndStatus(date: LocalDate,status:String):Int
}