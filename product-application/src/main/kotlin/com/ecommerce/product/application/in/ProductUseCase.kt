package com.ecommerce.product.application.`in`

import com.ecommerce.product.application.dto.ProductDto

interface ProductUseCase {
    fun getAllProducts(): List<ProductDto>
}