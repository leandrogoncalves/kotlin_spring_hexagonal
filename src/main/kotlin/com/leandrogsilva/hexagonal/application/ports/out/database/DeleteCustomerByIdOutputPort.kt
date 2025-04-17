package com.leandrogsilva.hexagonal.application.ports.out.database

interface DeleteCustomerByIdOutputPort {
    fun delete(id: String)
}