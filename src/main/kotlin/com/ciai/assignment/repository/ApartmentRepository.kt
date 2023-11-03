package com.ciai.assignment.repository

import com.ciai.assignment.data.Apartment
import com.ciai.assignment.data.Period
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.Date
import java.util.Optional

@Repository
interface ApartmentRepository : CrudRepository<Apartment, Long> {

    @Query(
        "select p from Period p where " +
                "p.apartment.apartmentId=:apartmentId and " +
                "p.startDate <= :startDate and " +
                "p.endDate >= :endDate and " +
                "p.status = com.ciai.assignment.data.enums.PeriodStatus.AVAILABLE or " +
                "p.status = com.ciai.assignment.data.enums.PeriodStatus.UNDER_CONSIDERATION"
    )
    fun findAvailablePeriod(@Param("apartmentId") apartmentId: Long,
                                         @Param("startDate") startDate: Date,
                                         @Param("endDate") endDate: Date): Optional<Period>
}