package com.ciai.assignment.data

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
data class Review (
    @Id
    @GeneratedValue
    val reviewId: Long?,
    val text: String?,
    val rating: Int?,

    @ManyToOne
    var apartment: Apartment?
)