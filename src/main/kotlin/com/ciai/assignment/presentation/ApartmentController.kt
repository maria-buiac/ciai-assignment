package com.ciai.assignment.presentation

import com.ciai.assignment.data.Apartment
import com.ciai.assignment.data.Period
import com.ciai.assignment.data.Review
import com.ciai.assignment.presentation.dtos.PeriodDto
import com.ciai.assignment.presentation.search.SearchCriteria
import com.ciai.assignment.service.ApartmentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/apartments")
class ApartmentController(
    val apartmentService: ApartmentService
) {

    @GetMapping
    fun getApartments(): MutableIterable<Apartment> = apartmentService.getApartments()

    @PostMapping
    fun addApartment(@RequestBody apartment: Apartment) = apartmentService.addApartment(apartment)

    @PostMapping("/{apartmentId}/periods")
    fun addPeriod(@PathVariable apartmentId: Long, @RequestBody period: PeriodDto) {
        apartmentService.addPeriod(apartmentId, period)
    }

    @GetMapping("/{apartmentId}/periods")
    fun getPeriodsForApartment(@PathVariable apartmentId: Long): List<Period> {
        return apartmentService.getPeriodsForApartment(apartmentId)
    }

    @PostMapping("/apartment/{apartmentId}/periods")
    fun addPeriodToApartment(
            @PathVariable apartmentId: Long,
            @RequestBody periodDto: PeriodDto,
            @RequestParam ownerId: Long
    ) {
        apartmentService.addPeriodToApartment(apartmentId, periodDto, ownerId)
    }




    @PostMapping("/search")
    fun searchApartments(@RequestBody searchCriteria: SearchCriteria): List<Apartment> {
        return apartmentService.searchApartments(searchCriteria)
    }

}