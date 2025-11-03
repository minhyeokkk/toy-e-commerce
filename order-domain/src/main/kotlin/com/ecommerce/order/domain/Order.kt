package com.ecommerce.order.domain

import java.math.BigDecimal
import java.util.ArrayList
import java.util.UUID

class Order(
    val id: UUID = UUID.randomUUID(),
    val orderProducts: List<OrderProduct> = ArrayList()
) {
    class OrderProduct(
        val productId: Long,
        val quantity: Long,
        val price: BigDecimal
    ) {

    }
}