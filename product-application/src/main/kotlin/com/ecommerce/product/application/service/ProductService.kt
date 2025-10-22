package com.ecommerce.product.application.service

import com.ecommerce.product.application.command.ProductCreateCommand
import com.ecommerce.product.application.dto.ProductDto
import com.ecommerce.product.application.usecase.ProductUseCase
import com.ecommerce.product.application.repository.ProductRepository
import org.springframework.stereotype.Service


@Service
class ProductService(private val productRepository: ProductRepository) : ProductUseCase {

    override fun getAll(): List<ProductDto> {
        // Implementation to fetch all products from the repository
        return productRepository.findAll().map { p ->
            ProductDto(
                id = p.id,
                name = p.name,
                description = p.description,
                quantity = p.quantity,
                price = p.price
            )
        }
    }

    override fun create(productCreateCommand: ProductCreateCommand): ProductDto {
        val product = productRepository.create(productCreateCommand)

        return ProductDto(
            id = product.id,
            name = product.name,
            description = product.description,
            quantity = product.quantity,
            price = product.price
        )
    }
}