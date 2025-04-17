package com.leandrogsilva.hexagonal.application.core.usecase

import com.leandrogsilva.hexagonal.application.core.domain.Customer
import com.leandrogsilva.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.leandrogsilva.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.leandrogsilva.hexagonal.application.ports.out.client.FindAddressByZipCodeOutputPort
import com.leandrogsilva.hexagonal.application.ports.out.database.UpdateCustomerOutputPort
import com.leandrogsilva.hexagonal.application.ports.out.messaging.SendCpfForValidationOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
): UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        if (customer.id == null) throw IllegalArgumentException("The id field can not be null")
        //Find Customer or fail
        val savedCpf = findCustomerByIdInputPort.find(customer.id)?.cpf

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            updateCustomerOutputPort.update(it)
            if (savedCpf != it.cpf) {
                sendCpfForValidationOutputPort.send(it.cpf)
            }
        }
    }
}