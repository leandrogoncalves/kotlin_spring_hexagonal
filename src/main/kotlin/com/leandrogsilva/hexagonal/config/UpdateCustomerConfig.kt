package com.leandrogsilva.hexagonal.config

import com.leandrogsilva.hexagonal.adapters.out.client.FindAddressByZipCodeAdapter
import com.leandrogsilva.hexagonal.adapters.out.messaging.SendCpfForValidationAdapter
import com.leandrogsilva.hexagonal.adapters.out.repository.UpdateCustomerAdapter
import com.leandrogsilva.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.leandrogsilva.hexagonal.application.core.usecase.UpdateCustomerUseCase
import com.leandrogsilva.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter
    ) = UpdateCustomerUseCase(
            findCustomerByIdUseCase,
            findAddressByZipCodeAdapter,
            updateCustomerAdapter,
            sendCpfForValidationAdapter
        )
}