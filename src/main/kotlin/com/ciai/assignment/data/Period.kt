package com.ciai.assignment.data

import com.ciai.assignment.data.enums.PeriodStatus
import jakarta.persistence.*
import java.util.Date

@Entity
data class Period(
    @Id
    @GeneratedValue
    val periodId: Long?,

    @ManyToOne
    var apartment: Apartment?,
    var startDate: Date?,
    var endDate: Date?,

    @Enumerated(EnumType.STRING)
    var status: PeriodStatus?
) {

}