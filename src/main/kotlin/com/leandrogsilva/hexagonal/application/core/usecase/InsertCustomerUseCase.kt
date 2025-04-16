package com.leandrogsilva.hexagonal.application.core.usecase

import com.leandrogsilva.hexagonal.application.core.domain.Customer
import com.leandrogsilva.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.leandrogsilva.hexagonal.application.ports.out.client.FindAddressByZipCodeOutputPort
import com.leandrogsilva.hexagonal.application.ports.out.database.InsertCustomerOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort
) : InsertCustomerInputPort {

    override fun insert(customer: Customer, zipCode: String) {
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertCustomerOutputPort.insert(it)
        }
    }
}