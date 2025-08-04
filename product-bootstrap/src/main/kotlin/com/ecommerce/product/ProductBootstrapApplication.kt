package com.ecommerce.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductBootstrapApplication

fun main(args: Array<String>) {
	runApplication<ProductBootstrapApplication>(*args)
}
