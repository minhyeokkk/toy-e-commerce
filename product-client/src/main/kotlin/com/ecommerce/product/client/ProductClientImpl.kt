package com.ecommerce.product.client

import com.ecommerce.order.application.client.ProductClient
import com.ecommerce.order.application.command.OrderCommand
import com.ecommerce.order.application.dto.OrderProductDto
import com.ecommerce.product.bootstrap.request.BulkProductStockDecreaseRequest
import com.ecommerce.product.client.feign.ProductFeignClient
import org.springframework.stereotype.Component


@Component
class ProductClientImpl(
    private val productFeignClient: ProductFeignClient
) : ProductClient {
    override fun getProducts(productIds: List<Long>): List<OrderProductDto> {
        val products = productFeignClient.getProducts(productIds)

        products.body?.map { productResponse ->
            OrderProductDto(
                productId = productResponse.id,
                name = productResponse.name,
                price = productResponse.price,
                quantity = productResponse.quantity
            )
        }.also { return it?: emptyList() }
    }

    override fun decreaseStock(productStocks: List<OrderCommand>): Boolean {
        val responses = productFeignClient.updateProductStock(
            BulkProductStockDecreaseRequest(
                productStockRequests = productStocks.map { orderCommand ->
                    BulkProductStockDecreaseRequest.ProductStockDecreaseRequest(
                        productId = orderCommand.productId,
                        quantity = orderCommand.quantity
                    )
                }
            )
        )

        return responses.statusCode.is2xxSuccessful
    }

}