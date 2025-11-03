package com.ecommerce.order.infra.rdb.entity

import com.ecommerce.order.application.dto.OrderProductDto
import com.ecommerce.order.domain.Order
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "ORDERS_PRODUCT")
class OrderProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false)
    var orderId: UUID,
    @Column(nullable = false)
    var productId: Long,
    @Column(nullable = false)
    var quantity: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", insertable = false, updatable = false)
    var order: OrderEntity? = null
) {
    fun toDto() : OrderProductDto {
        return OrderProductDto(
            productId = this.productId,
            quantity = this.quantity
        )

    }

    companion object {
        fun of(order: Order): List<OrderProductEntity> {
            return order.orderProducts.map { op ->
                OrderProductEntity(
                    orderId = order.id,
                    productId = op.productId,
                    quantity = op.quantity
                )
            }
        }
    }
}