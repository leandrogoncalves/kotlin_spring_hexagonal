package com.leandrogsilva.hexagonal.adapters.out.client.response

import com.leandrogsilva.hexagonal.application.core.domain.Address

data class AddressResponse(
    val street: String,
    val city: String,
    val state: String
) {
    fun toAddress() = Address(street,city,state)
}
