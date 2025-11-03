package com.ecommerce.order.application.dto

import java.math.BigDecimal
import java.util.UUID

data class OrderDto(
    val orderId: UUID,
    val totalPrice: BigDecimal,
    val totalQuantity: Long,
    val orderProducts: List<OrderProductDto>
)
