package com.ciai.assignment.presentation

import com.ciai.assignment.data.Reservation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/apartments/{apartmentId}/reservations")
class ReservationController {

    @GetMapping
    fun getReservations(@PathVariable apartmentId: Long) = null

    @PostMapping
    fun addReservation(@PathVariable apartmentId: Long, @RequestBody reservation: Reservation) = null



}