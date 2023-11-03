package com.ciai.assignment.service

import com.ciai.assignment.data.Review
import com.ciai.assignment.repository.ApartmentRepository
import com.ciai.assignment.repository.ReviewRepository
import org.springframework.stereotype.Service

@Service
class ReviewService(
    val apartmentRepository: ApartmentRepository,
    val reviewRepository: ReviewRepository
) {
    fun getReviews(apartmentId: Long) = reviewRepository.findAllByApartmentApartmentId(apartmentId)

    fun addReview(apartmentId: Long, review: Review) {
        val apartment = apartmentRepository.findById(apartmentId)
        apartment.ifPresentOrElse( {
            review.apartment = it
            reviewRepository.save(review)
        }, {
            throw RuntimeException("Apartment not found")
        })
    }


}