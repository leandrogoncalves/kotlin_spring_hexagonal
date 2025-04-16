package com.leandrogsilva.hexagonal.application.core.usecase

import com.leandrogsilva.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.leandrogsilva.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.leandrogsilva.hexagonal.application.ports.out.database.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
): FindCustomerByIdInputPort {

    override fun find(id: String) = findCustomerByIdOutputPort.find(id)
        ?: throw ObjectNotFoundException("Customer not found")
}