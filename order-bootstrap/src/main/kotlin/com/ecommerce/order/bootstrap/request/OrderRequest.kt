package com.ecommerce.order.bootstrap.request

import com.ecommerce.order.application.command.OrderCommand

data class OrderRequest(
    val orders: List<OrderProductRequest>
) {
    fun toCommand() : List<OrderCommand>{
        return orders.map {
            OrderCommand(
                productId = it.productId,
                quantity = it.quantity
            )
        }
    }
}
