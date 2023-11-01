package com.ciai.assignment.presentation

import com.ciai.assignment.data.Apartment
import com.ciai.assignment.data.Period
import com.ciai.assignment.data.Review
import com.ciai.assignment.presentation.dtos.PeriodDto
import com.ciai.assignment.service.ApartmentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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


}