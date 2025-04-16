package com.leandrogsilva.hexagonal.adapters.out.repository

import com.leandrogsilva.hexagonal.adapters.out.repository.contracts.CustomerRepository
import com.leandrogsilva.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.leandrogsilva.hexagonal.application.core.domain.Customer
import com.leandrogsilva.hexagonal.application.ports.out.database.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
): InsertCustomerOutputPort {

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }

}