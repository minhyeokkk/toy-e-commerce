package com.ecommerce.order.infra.rdb.repository

import com.ecommerce.order.application.dto.OrderDto
import com.ecommerce.order.application.repository.OrderRepository
import com.ecommerce.order.domain.Order
import com.ecommerce.order.infra.rdb.entity.OrderEntity
import com.ecommerce.order.infra.rdb.entity.OrderProductEntity
import com.ecommerce.order.infra.rdb.repository.jpa.OrderJpaRepository
import com.ecommerce.order.infra.rdb.repository.jpa.OrderProductJpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class OrderRepositoryImpl(
    private val orderJpaRepository: OrderJpaRepository,
    private val orderProductJpaRepository: OrderProductJpaRepository
) : OrderRepository {
    override fun create(order: Order): OrderDto {
        val orderEntity = OrderEntity.of(order)
        orderJpaRepository.save(orderEntity)

        val orderProductEntities = OrderProductEntity.of(order)
        orderProductJpaRepository.saveAll(orderProductEntities)

        return orderEntity.toDto()
    }

    override fun get(id: UUID): OrderDto {
        val orderEntity = orderJpaRepository.findByIdWithProducts(id)
            ?: throw NoSuchElementException("Order with id $id not found")
        return orderEntity.toDto()
    }

}