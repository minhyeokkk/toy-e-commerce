package com.ecommerce.order.bootstrap

import com.ecommerce.common.CommonConfig
import com.ecommerce.order.application.config.OrderAppConfig
import com.ecommerce.order.infra.rdb.config.RdbConfig
import com.ecommerce.product.client.config.ProductClientConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(
    value = [
        OrderAppConfig::class,
        RdbConfig::class,
        ProductClientConfig::class,
        CommonConfig::class
    ]
)
class OrderBootstrapApplication


fun main(args: Array<String>) {
    runApplication<OrderBootstrapApplication>(*args)
}
