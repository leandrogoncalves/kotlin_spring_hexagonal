package com.leandrogsilva.hexagonal.adapters.out.client.contracts

import com.leandrogsilva.hexagonal.adapters.out.client.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "FindAddressByZipCodeClient",
    url = "\${leandrogsilva.client.address.url}"
)
interface FindAddressByZipCodeClient {

    @GetMapping("/{zipcode}")
    fun find(@PathVariable zipcode: String): AddressResponse
}