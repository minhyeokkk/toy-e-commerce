package com.ecommerce.order.infra.rdb.repository.jpa

import com.ecommerce.order.infra.rdb.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface OrderJpaRepository : JpaRepository<OrderEntity, UUID> {
}