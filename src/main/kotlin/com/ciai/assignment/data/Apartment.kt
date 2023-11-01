package com.ciai.assignment.data

import jakarta.persistence.*

@Entity
data class Apartment(
    @Id
    @GeneratedValue
    val apartmentId: Long?,

    @ManyToOne
    var owner: User,
    var name: String?,
    var description: String?,
    var location: String?,
    var amenities: String?,
    var pictures: String?,
    var pricePerNight: Int?,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    val periods: MutableList<Period> = ArrayList()

) {

}