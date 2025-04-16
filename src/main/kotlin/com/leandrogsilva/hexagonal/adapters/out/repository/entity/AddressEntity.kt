package com.leandrogsilva.hexagonal.adapters.out.repository.entity

import com.leandrogsilva.hexagonal.application.core.domain.Address

data class AddressEntity(
    val street: String,
    val city: String,
    val state: String
) {
    constructor(address: Address): this(
        street = address.street,
        city = address.city,
        state = address.state
    )

    fun toAddress() = Address(street,city,state)
}
