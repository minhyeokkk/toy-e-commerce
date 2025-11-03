package com.ecommerce.order.application.client

import com.ecommerce.order.application.command.OrderCommand
import com.ecommerce.order.application.dto.OrderProductDto

interface ProductClient {
    fun getProducts(productIds: List<Long>): List<OrderProductDto>
    fun decreaseStock(productStocks: List<OrderCommand>) : Boolean
}
