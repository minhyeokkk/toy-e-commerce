package com.ecommerce.order.application.usecase

import com.ecommerce.order.application.command.OrderCommand
import com.ecommerce.order.application.dto.OrderDto
import java.util.UUID

interface OrderUsecase {
    fun create(orderCommands: List<OrderCommand>): OrderDto
    fun get(uuid: UUID): OrderDto
}