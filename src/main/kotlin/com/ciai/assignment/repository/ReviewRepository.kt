package com.ciai.assignment.repository

import com.ciai.assignment.data.Review
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : CrudRepository<Review, Long>{
    fun findAllByApartmentApartmentId(apartmentId: Long)
}