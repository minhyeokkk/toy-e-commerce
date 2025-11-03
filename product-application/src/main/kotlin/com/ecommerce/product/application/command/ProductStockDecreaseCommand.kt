package com.ecommerce.product.application.command

data class ProductStockDecreaseCommand (
    val productId : Long,
    val quantity : Long
){

}
