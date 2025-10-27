package com.ecommerce.order.infra.rdb.entity

import jakarta.persistence.*

@Entity
@Table(name = "ORDERS_PRODUCT")
class OrderProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false)
    var orderId: String,
    @Column(nullable = false)
    var productId: Long,
    @Column(nullable = false)
    var quantity: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", insertable = false, updatable = false)
    var order: OrderEntity? = null
) {
}