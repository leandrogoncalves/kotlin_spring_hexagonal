package com.leandrogsilva.hexagonal.application.core.usecase

import com.leandrogsilva.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.leandrogsilva.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.leandrogsilva.hexagonal.application.ports.out.database.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val deleteCustomerOutputPort: DeleteCustomerByIdOutputPort
): DeleteCustomerByIdInputPort {
    override fun delete(id: String) {
        //Find Customer or fail
        findCustomerByIdInputPort.find(id)
        deleteCustomerOutputPort.delete(id)
    }
}