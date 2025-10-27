package com.ecommerce.product.infra.rdb.repository

import com.ecommerce.product.application.command.ProductCreateCommand
import com.ecommerce.product.application.repository.ProductRepository
import com.ecommerce.product.domain.Product
import com.ecommerce.product.infra.rdb.entity.ProductEntity
import com.ecommerce.product.infra.rdb.repository.jpa.ProductJpaRepository
import org.springframework.stereotype.Repository


@Repository
class ProductRepositoryImpl(
    private val productJpaRepository: ProductJpaRepository
) : ProductRepository {

    override fun findAll(): List<Product> {

        return productJpaRepository.findAll().map { entity ->
            Product(
                id = entity.id!!,
                name = entity.name,
                description = entity.description,
                quantity = entity.quantity,
                price = entity.price
            )
        }
    }

    override fun findById(id: Long): Product {

        val entity = productJpaRepository.findById(id).orElseThrow {
            IllegalArgumentException("Product not found with id: $id")
        }

        return Product(
            id = entity.id!!,
            name = entity.name,
            description = entity.description,
            quantity = entity.quantity,
            price = entity.price
        )

    }

    override fun create(productCreateCommand: ProductCreateCommand): Product {
        val entity = productJpaRepository.save(
            ProductEntity(
                name = productCreateCommand.name,
                description = productCreateCommand.description,
                quantity = productCreateCommand.quantity,
                price = productCreateCommand.price
            )
        )

        return Product(
            id = entity.id!!,
            name = entity.name,
            description = entity.description,
            quantity = entity.quantity,
            price = entity.price
        )
    }


}