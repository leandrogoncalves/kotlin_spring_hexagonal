package com.leandrogsilva.hexagonal.config

import com.leandrogsilva.hexagonal.adapters.out.repository.FindCustomerByIdAdapter
import com.leandrogsilva.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig(
   private val findCustomerByIdAdapter: FindCustomerByIdAdapter
) {

    @Bean
    fun findCustomerById(findCustomerByIdAdapter: FindCustomerByIdAdapter) =
        FindCustomerByIdUseCase(findCustomerByIdAdapter)
}