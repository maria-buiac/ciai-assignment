package com.ciai.assignment.service

import com.ciai.assignment.data.enums.PeriodStatus
import com.ciai.assignment.data.Apartment
import com.ciai.assignment.data.Period
import com.ciai.assignment.presentation.dtos.PeriodDto
import com.ciai.assignment.repository.ApartmentRepository
import org.springframework.stereotype.Service

@Service
class ApartmentService(
    val apartmentRepository: ApartmentRepository
) {

    fun getApartments(): MutableIterable<Apartment> = apartmentRepository.findAll()

    fun addApartment(apartment: Apartment) = apartmentRepository.save(apartment)

    fun addPeriod(apartmentId: Long, periodDto: PeriodDto) {
        val apartment = apartmentRepository.findById(apartmentId)
        apartment.ifPresentOrElse( {
            val period = Period(null,null, periodDto.startDate, periodDto.endDate, PeriodStatus.AVAILABLE)
            period.apartment = it
            it.periods.add(period)
            apartmentRepository.save(it)
        }, {
            throw RuntimeException("Apartment not found")
        })
    }


}