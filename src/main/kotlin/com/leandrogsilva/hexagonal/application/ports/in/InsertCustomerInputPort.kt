package com.leandrogsilva.hexagonal.application.ports.`in`

import com.leandrogsilva.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert(customer: Customer, zipCode: String)

}