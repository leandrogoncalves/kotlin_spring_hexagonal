package com.leandrogsilva.hexagonal.adapters.out.repository.entity

import com.leandrogsilva.hexagonal.application.core.domain.Customer
import org.springframework.data.mongodb.core.mapping.MongoId
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "customers")
data class CustomerEntity(
    @MongoId val id: String?,
    val name: String,
    val address: AddressEntity,
    val cpf: String,
    val isValidCpf: Boolean = false
) {
    constructor(customer: Customer): this(
        id = customer.id,
        name = customer.name,
        address = AddressEntity(customer.address!!),
        cpf = customer.cpf,
        isValidCpf = customer.isValidCpf
    )

    fun toCustomer() = Customer(
        id = id,
        name = name,
        address = address.toAddress(),
        cpf = cpf,
        isValidCpf = isValidCpf
    )
}