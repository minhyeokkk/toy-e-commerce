package com.ecommerce.product.bootstrap.request

import com.ecommerce.product.application.command.ProductStockDecreaseCommand

data class BulkProductStockDecreaseRequest(
    val productStockRequests : List<ProductStockDecreaseRequest>
) {
    fun toCommand(): List<ProductStockDecreaseCommand> {
        val stockDecreaseCommands = productStockRequests.map {
            ProductStockDecreaseCommand(
                productId = it.productId,
                quantity = it.quantity
            )
        }
        return stockDecreaseCommands
    }

    data class ProductStockDecreaseRequest (
        val productId : Long,
        val quantity : Long
    )

}
