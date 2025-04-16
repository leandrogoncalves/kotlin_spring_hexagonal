package com.leandrogsilva.hexagonal.adapters.`in`.controller

import com.leandrogsilva.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.leandrogsilva.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.leandrogsilva.hexagonal.application.core.domain.Customer
import com.leandrogsilva.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.leandrogsilva.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.leandrogsilva.hexagonal.application.ports.`in`.InsertCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class ConsumerController(
    private val insertCustomerInputPort: InsertCustomerInputPort,
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) {
        with(customerRequest) {
            insertCustomerInputPort.insert(
                Customer(name = name, cpf = cpf),
                zipCode
            )
        }
        /*
        val customer = Customer(
            name = customerRequest.name,
            cpf = customerRequest.cpf
        )
        insertCustomerInputPort.insert(customer, customerRequest.zipCode)
        */
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) = CustomerResponse(
        findCustomerByIdInputPort.find(id) ?: throw ObjectNotFoundException("Customer not found")
    )
}