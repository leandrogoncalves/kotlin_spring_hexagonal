package com.leandrogsilva.hexagonal.adapters.`in`.controller

import com.leandrogsilva.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.leandrogsilva.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.leandrogsilva.hexagonal.application.core.domain.Customer
import com.leandrogsilva.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.leandrogsilva.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.leandrogsilva.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.leandrogsilva.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.leandrogsilva.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class ConsumerController(
    private val insertCustomerInputPort: InsertCustomerInputPort,
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val updateCustomerInputPort: UpdateCustomerInputPort,
    private val deleteCustomerByIdInputPort: DeleteCustomerByIdInputPort
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
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String) = CustomerResponse(
        findCustomerByIdInputPort.find(id) ?: throw ObjectNotFoundException("Customer not found")
    )

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @Valid @RequestBody customerRequest: CustomerRequest) {
        with(customerRequest) {
            updateCustomerInputPort.update(
                Customer(id, name, cpf = cpf),
                zipCode
            )
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        deleteCustomerByIdInputPort.delete(id)
    }
}