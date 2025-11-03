package com.ecommerce.product.application.command

import java.math.BigDecimal

data class ProductCreateCommand(
    val name: String,
    val price: BigDecimal,
    val quantity: Long,
    val description: String
)
