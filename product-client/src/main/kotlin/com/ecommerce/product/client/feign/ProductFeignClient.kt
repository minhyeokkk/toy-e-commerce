package com.ecommerce.product.client.feign

import com.ecommerce.product.bootstrap.request.BulkProductStockDecreaseRequest
import com.ecommerce.product.bootstrap.response.ProductResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "product", url = "\${feign.client.product-service.url}/v1/products")
interface ProductFeignClient {
    @GetMapping
    fun getProducts(@RequestParam ids: List<Long>): ResponseEntity<List<ProductResponse>>

    @PatchMapping("/stocks/decrease")
    fun updateProductStock(@RequestBody updateProductStockRequest: BulkProductStockDecreaseRequest): ResponseEntity<List<ProductResponse>>
}