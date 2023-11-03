package com.ciai.assignment.repository

import com.ciai.assignment.data.Period
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PeriodRepository : CrudRepository<Period, Long> {
//    fun findAllByApartmentApartmentId(apartmentId: Long)

}