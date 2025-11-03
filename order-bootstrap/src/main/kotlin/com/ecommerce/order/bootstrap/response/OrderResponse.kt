package com.ecommerce.order.bootstrap.response

import com.ecommerce.order.application.dto.OrderDto
import java.math.BigDecimal
import java.util.*

data class OrderResponse(
    val id: UUID,
    val totalPrice: BigDecimal,
    val totalQuantity: Long,
    val orderProducts: List<OrderProductResponse> = emptyList()
) {
    companion object {
        fun of(orderDto: OrderDto): OrderResponse {
            return OrderResponse(
                id = orderDto.orderId,
                totalPrice = orderDto.totalPrice,
                totalQuantity = orderDto.totalQuantity,
                orderProducts = orderDto.orderProducts.map {
                    OrderProductResponse(
                        productId = it.productId,
                        quantity = it.quantity
                    )
                }
            )
        }
    }
}
