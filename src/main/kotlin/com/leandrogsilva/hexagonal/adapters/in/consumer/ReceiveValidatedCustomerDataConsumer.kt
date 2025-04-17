package com.leandrogsilva.hexagonal.adapters.`in`.consumer

import com.leandrogsilva.hexagonal.adapters.`in`.consumer.message.CustomerMessage
import com.leandrogsilva.hexagonal.application.core.domain.Customer
import com.leandrogsilva.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCustomerDataConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort
) {

    @KafkaListener(topics = ["tpk-cpf-validated"], groupId = "leaandrogsilva")
    fun receive(customerMessage: CustomerMessage) {
        with(customerMessage) {
            updateCustomerInputPort.update(
                toCustomer(),
                zipCode
            )
        }

    }
}