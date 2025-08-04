package com.ecommerce.product.application.out

import com.ecommerce.product.domain.Product

interface ProductRepository {
    fun findAll(): List<Product>

}