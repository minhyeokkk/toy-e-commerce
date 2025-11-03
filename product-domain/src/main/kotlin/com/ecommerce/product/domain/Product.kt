package com.ecommerce.product.domain

import java.math.BigDecimal

class Product(
    val id: Long,
    var name: String,
    var price: BigDecimal,
    var quantity: Long,
    var description: String
) {
    fun decreaseStock(quantity: Long) {
        require(this.quantity >= quantity) { "Not enough stock for product id: $id" }
        this.quantity -= quantity;
    }

}