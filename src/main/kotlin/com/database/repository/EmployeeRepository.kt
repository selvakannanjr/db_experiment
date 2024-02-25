package com.database.repository

import com.database.entity.EmployeeEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface EmployeeRepository : CrudRepository<EmployeeEntity, String> {
}