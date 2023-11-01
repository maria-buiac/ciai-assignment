package com.ciai.assignment.presentation

import com.ciai.assignment.data.Review
import com.ciai.assignment.service.ReviewService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/apartments/{apartmentId}/reviews")
class ReviewController(
    val reviewService: ReviewService
) {

    @GetMapping
    fun getReviews(@PathVariable apartmentId: Long) = reviewService.getReviews(apartmentId)

    @PostMapping
    fun addReview(@PathVariable apartmentId: Long, @RequestBody review: Review) = reviewService.addReview(apartmentId, review)

}