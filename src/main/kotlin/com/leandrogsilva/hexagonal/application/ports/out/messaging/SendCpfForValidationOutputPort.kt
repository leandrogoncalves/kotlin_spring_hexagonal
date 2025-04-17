package com.leandrogsilva.hexagonal.application.ports.out.messaging

interface SendCpfForValidationOutputPort {
    fun send(cpf: String)
}