package com.ciai.assignment.presentation.dtos

import java.util.Date

data class PeriodDto(
    val startDate: Date,
    val endDate: Date,
    val userId: Long
) {
}