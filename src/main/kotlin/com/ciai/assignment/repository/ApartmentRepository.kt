package com.ciai.assignment.repository

import com.ciai.assignment.data.Apartment
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ApartmentRepository : CrudRepository<Apartment, Long> {
}