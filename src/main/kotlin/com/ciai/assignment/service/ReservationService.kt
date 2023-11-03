package com.ciai.assignment.service

import com.ciai.assignment.data.Period
import com.ciai.assignment.data.Reservation
import com.ciai.assignment.data.enums.PeriodStatus
import com.ciai.assignment.repository.ApartmentRepository
import com.ciai.assignment.repository.PeriodRepository
import org.springframework.stereotype.Service

@Service
class ReservationService(
    val apartmentRepository: ApartmentRepository,
    val periodRepository: PeriodRepository
) {

    fun addReservation(apartmentId: Long, reservation: Reservation) {
        apartmentRepository.findAvailablePeriod(apartmentId, reservation.period.startDate!!, reservation.period.endDate!!)
            .ifPresentOrElse(
                {
                    splitPeriod(it, reservation.period)
                },
                {
                    throw RuntimeException("No available period found")
                })
    }

    private fun splitPeriod(existingPeriod: Period, newPeriod: Period) {
        if (newPeriod.startDate?.after(existingPeriod.startDate) == true) {
            val availablePeriod = Period(
                null, existingPeriod.apartment, existingPeriod.startDate, newPeriod.startDate, PeriodStatus.AVAILABLE
            )
            PeriodStatus.availableStatuses()
            periodRepository.save(availablePeriod)
        }

        if (newPeriod.endDate?.before(existingPeriod.endDate) == true) {
            val availablePeriod = Period(
                null, existingPeriod.apartment, newPeriod.endDate, existingPeriod.endDate, PeriodStatus.AVAILABLE
            )
            periodRepository.save(availablePeriod)
        }

        existingPeriod.startDate = newPeriod.startDate
        existingPeriod.endDate = newPeriod.endDate
        existingPeriod.status = PeriodStatus.UNDER_CONSIDERATION
        periodRepository.save(existingPeriod)
    }
}