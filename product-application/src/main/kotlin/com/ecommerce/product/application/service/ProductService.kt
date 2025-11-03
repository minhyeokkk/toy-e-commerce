package com.ecommerce.product.application.service

import com.ecommerce.product.application.command.ProductCreateCommand
import com.ecommerce.product.application.command.ProductStockDecreaseCommand
import com.ecommerce.product.application.dto.ProductDto
import com.ecommerce.product.application.usecase.ProductUseCase
import com.ecommerce.product.application.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.ArrayList


@Service
@Transactional(readOnly = true)
class ProductService(private val productRepository: ProductRepository) : ProductUseCase {

    override fun getAll(): List<ProductDto> {
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

    override fun get(ids: List<Long>): List<ProductDto> {
        return productRepository.findByIdIn(ids).map { p ->
            ProductDto(
                id = p.id,
                name = p.name,
                description = p.description,
                quantity = p.quantity,
                price = p.price
            )
        }
    }

    override fun get(id: Long): ProductDto {
        return productRepository.findById(id).let { p ->
            ProductDto(
                id = p.id,
                name = p.name,
                description = p.description,
                quantity = p.quantity,
                price = p.price
            )
        }

    }

    @Transactional
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

    @Transactional
    override fun decreaseStock(productStockDecreaseCommands: List<ProductStockDecreaseCommand>): List<ProductDto> {
        val productDtos = ArrayList<ProductDto>()
        val productById = productRepository.findByIdIn(productStockDecreaseCommands.map { it.productId }).associateBy(
            keySelector = { it.id },
            valueTransform = { it }
        )

        productStockDecreaseCommands.forEach { command ->
            val product = productById[command.productId]
                ?: throw IllegalArgumentException("Product not found for id: ${command.productId}")
            require(product.quantity >= command.quantity) { "Insufficient stock for product id: ${command.productId}" }

            product.decreaseStock(command.quantity)
            productRepository.update(product)

            ProductDto(
                id = product.id,
                name = product.name,
                description = product.description,
                quantity = product.quantity,
                price = product.price
            ).let { dto ->
                productDtos.add(dto)
            }
        }

        return productDtos
    }
}