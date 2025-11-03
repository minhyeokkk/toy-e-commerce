package com.ecommerce.order.application.command

data class OrderCommand(
    val productId: Long,
    val quantity: Long
)
