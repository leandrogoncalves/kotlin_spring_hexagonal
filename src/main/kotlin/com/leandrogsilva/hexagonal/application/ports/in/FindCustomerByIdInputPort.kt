package com.leandrogsilva.hexagonal.application.ports.`in`

import com.leandrogsilva.hexagonal.application.core.domain.Customer

interface FindCustomerByIdInputPort {

    fun find(id: String): Customer?

}