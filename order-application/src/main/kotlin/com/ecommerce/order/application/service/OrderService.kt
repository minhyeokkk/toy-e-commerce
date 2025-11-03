package com.ecommerce.order.application.service

import com.ecommerce.order.application.client.ProductClient
import com.ecommerce.order.application.command.OrderCommand
import com.ecommerce.order.application.dto.OrderDto
import com.ecommerce.order.application.repository.OrderRepository
import com.ecommerce.order.application.usecase.OrderUsecase
import com.ecommerce.order.domain.Order
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class OrderService(
    private val orderRepository: OrderRepository,
    private val productClient: ProductClient
) : OrderUsecase {

    @Transactional
    override fun create(orderCommands: List<OrderCommand>): OrderDto {
        val productIds = orderCommands.map { it.productId }
        val products = productClient.getProducts(productIds)

        val quantityByProductId = orderCommands.associateBy(
            keySelector = { it.productId },
            valueTransform = { it.quantity }
        )

        products.forEach { product ->
            val orderQuantity = quantityByProductId[product.productId] ?: 0L
            require(product.quantity >= orderQuantity) { "Insufficient stock for product id: ${product.productId}" }
        }
        productClient.decreaseStock(orderCommands)

        val order = Order(
            orderProducts = products.map { product ->
                Order.OrderProduct(
                    productId = product.productId,
                    quantity = quantityByProductId[product.productId] ?: 0L,
                    price = product.price
                )
            }
        )

        return orderRepository.create(order)
    }

    override fun get(uuid: UUID): OrderDto {
        return orderRepository.get(uuid)
    }
}