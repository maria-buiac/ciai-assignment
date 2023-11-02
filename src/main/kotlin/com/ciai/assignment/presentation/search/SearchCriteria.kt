package com.ciai.assignment.presentation.search

data class SearchCriteria(
        val location: String?,
        val minPrice: Double?,
        val maxPrice: Double?,
        val minBedrooms: Int?,
        val maxBedrooms: Int?
)

