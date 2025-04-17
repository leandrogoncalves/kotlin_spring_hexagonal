package com.leandrogsilva.hexagonal.adapters.out.messaging

import com.leandrogsilva.hexagonal.application.ports.out.messaging.SendCpfForValidationOutputPort
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class SendCpfForValidationAdapter(
    private val kafkaTemplate: KafkaTemplate<String, String>
): SendCpfForValidationOutputPort {
    override fun send(cpf: String) {
        kafkaTemplate.send("tpk-cpf-validation", cpf)
    }
}