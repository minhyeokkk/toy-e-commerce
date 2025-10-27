package com.ecommerce.order.infra.rdb.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "ORDERS")
class OrderEntity(
    @Id
    var id: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    var totalPrice: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false)
    var totalAmount: Long,
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    var orderProducts: List<OrderProductEntity> = emptyList()
) {
}