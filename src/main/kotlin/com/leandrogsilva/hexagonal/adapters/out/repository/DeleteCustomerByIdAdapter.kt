package com.leandrogsilva.hexagonal.adapters.out.repository

import com.leandrogsilva.hexagonal.adapters.out.repository.contracts.CustomerRepository
import com.leandrogsilva.hexagonal.application.ports.out.database.DeleteCustomerByIdOutputPort
import org.springframework.stereotype.Component

@Component
class DeleteCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
): DeleteCustomerByIdOutputPort {
    override fun delete(id: String) {
        customerRepository.deleteById(id)
    }
}