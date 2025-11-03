package com.ecommerce.product.application.dto

import java.math.BigDecimal

data class ProductDto(
    val id: Long,
    val name: String,
    val price: BigDecimal,
    val quantity: Long,
    val description: String
)