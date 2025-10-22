package com.ecommerce.product.bootstrap.request

import com.ecommerce.product.application.command.ProductCreateCommand
import jakarta.validation.constraints.NotNull

data class ProductRequest(
    @field:NotNull
    val name: String,
    @field:NotNull
    val price: Long,
    @field:NotNull
    val quantity: Long,
    @field:NotNull
    val description: String
) {
    fun toCommand(): ProductCreateCommand {

        return ProductCreateCommand(
            name = this.name,
            price = this.price,
            quantity = this.quantity,
            description = this.description
        )
    }
}
