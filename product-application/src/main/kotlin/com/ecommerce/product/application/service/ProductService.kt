package com.ecommerce.product.application.service

import com.ecommerce.product.application.dto.ProductDto
import com.ecommerce.product.application.`in`.ProductUseCase
import com.ecommerce.product.application.out.ProductRepository
import org.springframework.stereotype.Service


@Service
class ProductService(private val productRepository: ProductRepository) : ProductUseCase {

    override fun getAllProducts(): List<ProductDto> {
        // Implementation to fetch all products from the repository
        return productRepository.findAll().map { _ ->
            ProductDto()
        }
    }
}