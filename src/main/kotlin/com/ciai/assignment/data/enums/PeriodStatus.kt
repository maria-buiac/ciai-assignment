package com.ciai.assignment.data.enums

enum class PeriodStatus {
    AVAILABLE,
    UNDER_CONSIDERATION,
    BOOKED,
    OCCUPIED,
    AWAITING_REVIEW,
    CLOSED;

    companion object {
        fun availableStatuses(): List<PeriodStatus> = listOf(AVAILABLE, UNDER_CONSIDERATION)
//        val OCCUPIED_STATUSES: List<PeriodStatus> = listOf(BOOKED, OCCUPIED, AWAITING_REVIEW, CLOSED)

    }
}