package com.ecommerce.order.bootstrap.api

import com.ecommerce.order.application.usecase.OrderUsecase
import com.ecommerce.order.bootstrap.request.OrderRequest
import com.ecommerce.order.bootstrap.response.OrderResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("v1/orders")
class OrderController (
    private val orderUsecase: OrderUsecase
) {

    @PostMapping
    fun createOrder(@RequestBody orderRequest : OrderRequest) : ResponseEntity<OrderResponse> {
        val command = orderRequest.toCommand()
        val order = orderUsecase.create(command)

        return ResponseEntity.ok(OrderResponse.of(order))
    }

    @GetMapping("/{id}")
    fun getOrder(@PathVariable id : UUID): ResponseEntity<OrderResponse> {
        orderUsecase.get(id).let {
            val orderResponse = OrderResponse.of(it)
            return ResponseEntity.ok(orderResponse)
        }
    }
}