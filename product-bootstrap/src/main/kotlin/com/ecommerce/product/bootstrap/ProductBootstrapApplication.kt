package com.ecommerce.product.bootstrap

import com.ecommerce.product.application.config.AppConfig
import com.ecommerce.product.infra.rdb.config.RdbConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(
	value = [
		AppConfig::class,
		RdbConfig::class
	]
)
class ProductBootstrapApplication

fun main(args: Array<String>) {
	runApplication<ProductBootstrapApplication>(*args)
}
