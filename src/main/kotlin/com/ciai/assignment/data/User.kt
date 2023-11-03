package com.ciai.assignment.data

import com.ciai.assignment.data.enums.UserRole
import jakarta.persistence.*

@Entity
data class User (
    @Id
    @GeneratedValue
    val userId: Long,
    val name: String?,
    val username: String?,
    val password: String?,
    val email: String?,
    val phoneNumber: String?,
    val picture: String?,

    @Enumerated(EnumType.STRING)
    val userRole: UserRole?
)