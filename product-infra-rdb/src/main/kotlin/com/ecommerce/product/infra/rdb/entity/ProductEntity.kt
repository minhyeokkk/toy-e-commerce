package com.ecommerce.product.infra.rdb.entity

import com.ecommerce.product.domain.Product
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "PRODUCT")
class ProductEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    var price: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false)
    var quantity: Long = 0,
    @Column(nullable = false)
    var description: String
) {
    fun update(product: Product) {
        name = product.name
        price = product.price
        quantity = product.quantity
        description = product.description
    }
}