package com.leandrogsilva.hexagonal.application.ports.out.database

import com.leandrogsilva.hexagonal.application.core.domain.Customer

interface FindCustomerByIdOutputPort {

    fun find(id: String): Customer?

}