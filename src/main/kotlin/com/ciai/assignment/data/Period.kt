package com.ciai.assignment.data

import com.ciai.assignment.ApartmentStatus
import jakarta.persistence.*
import java.util.Date

@Entity
data class Period(
    @Id
    @GeneratedValue
    val periodId: Long?,

    @ManyToOne
    var apartment: Apartment?,
    val startDate: Date?,
    val endDate: Date?,

    @Enumerated(EnumType.STRING)
    val status: ApartmentStatus?
) {
}