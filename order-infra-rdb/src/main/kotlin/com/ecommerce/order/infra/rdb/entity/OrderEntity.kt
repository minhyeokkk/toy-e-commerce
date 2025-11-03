package com.ecommerce.order.infra.rdb.entity

import com.ecommerce.order.application.dto.OrderDto
import com.ecommerce.order.domain.Order
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
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    var orderProducts: List<OrderProductEntity> = mutableListOf()
) {
    fun toDto(): OrderDto {
        return OrderDto(
            orderId = this.id,
            totalPrice = this.totalPrice,
            totalQuantity = this.orderProducts.sumOf { it.quantity },
            orderProducts = this.orderProducts.map { it.toDto() }
        )
    }

    companion object {
        fun of(order: Order): OrderEntity {
            return OrderEntity(
                id = order.id,
                totalPrice = order.orderProducts.sumOf { it.price * BigDecimal(it.quantity) },
                orderProducts = order.orderProducts.map { op ->
                    OrderProductEntity(
                        orderId = order.id,
                        productId = op.productId,
                        quantity = op.quantity
                    )
                }
            )

        }
    }
}