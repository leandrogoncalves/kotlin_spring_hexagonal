package com.leandrogsilva.hexagonal.adapters.out.client

import com.leandrogsilva.hexagonal.adapters.out.client.contracts.FindAddressByZipCodeClient
import com.leandrogsilva.hexagonal.application.core.domain.Address
import com.leandrogsilva.hexagonal.application.ports.out.client.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    protected val findAddressByZipCodeClient: FindAddressByZipCodeClient
): FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address =
        findAddressByZipCodeClient.find(zipCode).toAddress()
}