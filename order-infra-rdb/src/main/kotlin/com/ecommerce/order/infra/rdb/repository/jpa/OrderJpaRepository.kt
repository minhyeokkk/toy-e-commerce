package com.ecommerce.order.infra.rdb.repository.jpa

import com.ecommerce.order.infra.rdb.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface OrderJpaRepository : JpaRepository<OrderEntity, UUID> {
    @Query("SELECT o FROM OrderEntity o JOIN FETCH o.orderProducts WHERE o.id = :id")
    fun findByIdWithProducts(id: UUID): OrderEntity?
}