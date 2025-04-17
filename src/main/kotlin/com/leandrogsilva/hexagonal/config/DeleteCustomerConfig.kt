package com.leandrogsilva.hexagonal.config

import com.leandrogsilva.hexagonal.adapters.out.repository.DeleteCustomerByIdAdapter
import com.leandrogsilva.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase
import com.leandrogsilva.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.leandrogsilva.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerConfig {

    @Bean
    fun deleteCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        deleteCustomerByIdAdapter: DeleteCustomerByIdAdapter
    ): DeleteCustomerByIdInputPort {
        return DeleteCustomerByIdUseCase(
            findCustomerByIdUseCase,
            deleteCustomerByIdAdapter
        )
    }
}