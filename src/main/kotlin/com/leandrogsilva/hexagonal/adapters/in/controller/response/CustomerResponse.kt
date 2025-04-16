package com.leandrogsilva.hexagonal.adapters.`in`.controller.response

import com.leandrogsilva.hexagonal.application.core.domain.Customer

data class CustomerResponse(
    val id: String,
    val name: String,
    val cpf: String,
    val address: AddressResponse,
    val isValidCpf: Boolean
) {
    constructor(customer: Customer): this(
        id = customer.id!!,
        name = customer.name,
        cpf = customer.cpf,
        address = AddressResponse(customer.address!!),
        isValidCpf = customer.isValidCpf
    )
}
