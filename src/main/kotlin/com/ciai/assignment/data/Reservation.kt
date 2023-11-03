package com.ciai.assignment.data

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.Date

@Entity
data class Reservation (
    @Id
    @GeneratedValue
    val reservationId: Long,

    @ManyToOne
    val period: Period,

    @ManyToOne
    val client: User
)