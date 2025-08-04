package com.ecommerce.product.infra.rdb

import com.ecommerce.product.application.out.ProductRepository
import com.ecommerce.product.domain.Product
import org.springframework.stereotype.Repository


@Repository
class ProductRepositoryImpl : ProductRepository {

    override fun findAll(): List<Product> {
        // Implementation to fetch all products from the database
        return emptyList() // Placeholder for actual implementation
    }
}