package com.ecommerce.product.application.repository

import com.ecommerce.product.application.command.ProductCreateCommand
import com.ecommerce.product.domain.Product

interface ProductRepository {
    fun findAll(): List<Product>
    fun create(productCreateCommand: ProductCreateCommand): Product
    fun findById(id: Long): Product
    fun findByIdIn(ids: List<Long>): List<Product>
    fun update(product: Product): Product
}