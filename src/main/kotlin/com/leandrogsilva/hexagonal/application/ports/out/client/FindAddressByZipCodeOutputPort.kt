package com.leandrogsilva.hexagonal.application.ports.out.client

import com.leandrogsilva.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address

}