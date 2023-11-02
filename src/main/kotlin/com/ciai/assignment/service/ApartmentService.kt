package com.ciai.assignment.service

import com.ciai.assignment.ApartmentStatus
import com.ciai.assignment.data.Apartment
import com.ciai.assignment.data.Period
import com.ciai.assignment.data.Review
import com.ciai.assignment.presentation.dtos.PeriodDto
import com.ciai.assignment.presentation.search.SearchCriteria
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
            val period = Period(null,null, periodDto.startDate, periodDto.endDate, ApartmentStatus.AVAILABLE)
            period.apartment = it
            it.periods.add(period)
            apartmentRepository.save(it)
        }, {
            throw RuntimeException("Apartment not found")
        })
    }

    fun getPeriodsForApartment(apartmentId: Long): List<Period> {
        val apartment = apartmentRepository.findById(apartmentId)
        return apartment.map { it.periods }.orElse(mutableListOf<Period>())

    }

    fun addPeriodToApartment(apartmentId: Long, periodDto: PeriodDto, ownerId: Long) {
        val apartment = apartmentRepository.findById(apartmentId)

        if (apartment.isEmpty) {
            throw RuntimeException("Apartment not found.")
        }

        val owner = apartment.get().owner

        if (owner.userId != ownerId) {
            throw RuntimeException("You do not have permission to add a period to this apartment.")
        }

        val period = Period(
                null,
                null,
                periodDto.startDate,
                periodDto.endDate,
                ApartmentStatus.AVAILABLE
        )

        val apartmentToUpdate = apartment.get()
        period.apartment = apartmentToUpdate
        apartmentToUpdate.periods.add(period)
        apartmentRepository.save(apartmentToUpdate)
    }


    fun searchApartments(criteria: SearchCriteria): List<Apartment> {

        val allApartments = getApartments()
        val filteredApartments = allApartments.filter { apartment ->
            criteria.location?.let { it.equals(apartment.location, ignoreCase = true) } ?: true
                    && criteria.pricePerNight?.let { it == apartment.pricePerNight } ?: true
        }

        return filteredApartments
    }


}


