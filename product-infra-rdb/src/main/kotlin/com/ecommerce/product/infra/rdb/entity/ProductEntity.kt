package com.ecommerce.product.infra.rdb.entity

import jakarta.persistence.*

@Entity
@Table(name = "PRODUCT")
class ProductEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    var price: Long = 0,
    @Column(nullable = false)
    var quantity: Long = 0,
    @Column(nullable = false)
    var description: String
)