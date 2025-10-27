package com.ecommerce.product.application.usecase

import com.ecommerce.product.application.command.ProductCreateCommand
import com.ecommerce.product.application.dto.ProductDto

interface ProductUseCase {
    fun getAll(): List<ProductDto>
    fun get(id: Long): ProductDto
    fun create(productCreateCommand: ProductCreateCommand): ProductDto
}