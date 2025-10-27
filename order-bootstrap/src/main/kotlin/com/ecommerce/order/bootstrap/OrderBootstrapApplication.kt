package com.ecommerce.order.bootstrap

import com.ecommerce.order.application.config.OrderAppConfig
import com.ecommerce.order.infra.rdb.config.RdbConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(
	value = [
		OrderAppConfig::class,
		RdbConfig::class
	]
)
class OrderBootstrapApplication


fun main(args: Array<String>) {
    runApplication<OrderBootstrapApplication>(*args)
}
