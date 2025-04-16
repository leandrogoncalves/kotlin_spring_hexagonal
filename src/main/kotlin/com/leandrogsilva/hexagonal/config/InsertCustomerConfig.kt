package com.leandrogsilva.hexagonal.config

import com.leandrogsilva.hexagonal.adapters.out.client.FindAddressByZipCodeAdapter
import com.leandrogsilva.hexagonal.adapters.out.repository.InsertCustomerAdapter
import com.leandrogsilva.hexagonal.application.core.usecase.InsertCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter
    ) = InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter)
}