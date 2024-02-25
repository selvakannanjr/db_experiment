package com.database.controller

import com.database.dto.Attendance
import com.database.dto.Employee
import com.database.entity.EmployeeAttendanceEntity
import com.database.repository.AttendanceRepository
import com.database.repository.EmployeeRepository
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.QueryValue
import jakarta.inject.Inject
import java.time.LocalDate

@Controller("/api")
class HomeController {

    @Inject
    lateinit var employeeRepository: EmployeeRepository

    @Inject
    lateinit var attendanceRepository: AttendanceRepository

    @Get("/")
    fun hello() = "hello world"

    @Post("/employee")
    fun createEmployee(@Body employee: Employee): String {
        employeeRepository.save(employee.toEmployeeEntity())
        return "created"
    }

    @Post("/addentry")
    fun addAttendance(@Body attendance: Attendance): String {
        attendanceRepository.save(attendance.toEmployeeAttendanceEntity())
        return "attnd created"
    }

    @Get("/getattdn")
    fun getAttendance(@QueryValue id: String, @QueryValue date: LocalDate): EmployeeAttendanceEntity {
        return attendanceRepository.findByEmployeeIdAndDate(id, date)
    }

    @Get("/admin")
    fun getCountForDate(@QueryValue date: LocalDate,@QueryValue status:String): Int {
        return attendanceRepository.countByDateAndStatus(date,status)
    }
}