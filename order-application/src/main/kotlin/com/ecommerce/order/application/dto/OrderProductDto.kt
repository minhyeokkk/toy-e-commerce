package com.ecommerce.order.application.dto

import java.math.BigDecimal

data class OrderProductDto(
    val productId: Long,
    var name: String,
    var price: BigDecimal,
    val quantity: Long
) {
    constructor(productId: Long, quantity: Long) : this(
        productId = productId,
        name = "",
        price = BigDecimal.ZERO,
        quantity = quantity
    )

}
