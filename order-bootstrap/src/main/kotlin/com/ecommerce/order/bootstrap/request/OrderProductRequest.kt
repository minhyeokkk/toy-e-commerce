package com.ecommerce.order.bootstrap.request

data class OrderProductRequest(
    val productId: Long,
    val quantity: Long
)
