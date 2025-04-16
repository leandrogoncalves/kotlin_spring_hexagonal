package com.leandrogsilva.hexagonal.adapters.out.repository

import com.leandrogsilva.hexagonal.adapters.out.repository.contracts.CustomerRepository
import com.leandrogsilva.hexagonal.application.core.domain.Customer
import com.leandrogsilva.hexagonal.application.ports.out.database.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
): FindCustomerByIdOutputPort {

    override fun find(id: String): Customer? =
        customerRepository.findById(id)
            .getOrNull()
            .let {
                it?.toCustomer()
            }
}