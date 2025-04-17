package com.leandrogsilva.hexagonal.application.ports.`in`

import com.leandrogsilva.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update(customer: Customer, zipCode: String)

}