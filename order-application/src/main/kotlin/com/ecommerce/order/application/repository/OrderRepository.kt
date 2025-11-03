package com.ecommerce.order.application.repository

import com.ecommerce.order.application.dto.OrderDto
import com.ecommerce.order.domain.Order
import java.util.*

interface OrderRepository {
    fun create(order: Order): OrderDto
    fun get(id: UUID): OrderDto

}