package com.leandrogsilva.hexagonal.application.ports.`in`

interface DeleteCustomerByIdInputPort {
    fun delete(id: String)
}