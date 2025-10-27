package com.ecommerce.order.infra.rdb.repository.jpa

import com.ecommerce.order.infra.rdb.entity.OrderProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderProductJpaRepository : JpaRepository<OrderProductEntity, Long> {
}