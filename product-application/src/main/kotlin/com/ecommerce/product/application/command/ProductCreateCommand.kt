package com.ecommerce.product.application.command

data class ProductCreateCommand(
    val name: String,
    val price: Long,
    val quantity: Long,
    val description: String
)
