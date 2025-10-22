package com.ecommerce.product.bootstrap.response

import com.ecommerce.product.application.dto.ProductDto
import com.ecommerce.product.domain.Product

data class ProductResponse(
    val id: Long,
    val name: String,
    val price: Long,
    val quantity: Long,
    val description: String
) {
    companion object {
        fun of(product: ProductDto) : ProductResponse {
            return ProductResponse(
                id = product.id,
                name = product.name,
                price = product.price,
                quantity = product.quantity,
                description = product.description
            )

        }
    }
}
