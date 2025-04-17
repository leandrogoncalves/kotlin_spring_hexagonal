package com.leandrogsilva.hexagonal.adapters.out.repository

import com.leandrogsilva.hexagonal.adapters.out.repository.contracts.CustomerRepository
import com.leandrogsilva.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.leandrogsilva.hexagonal.application.core.domain.Customer
import com.leandrogsilva.hexagonal.application.ports.out.database.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository
): UpdateCustomerOutputPort {
    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}