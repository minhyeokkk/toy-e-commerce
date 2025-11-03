package com.ecommerce.product.bootstrap.api

import com.ecommerce.product.application.usecase.ProductUseCase
import com.ecommerce.product.bootstrap.request.BulkProductStockDecreaseRequest
import com.ecommerce.product.bootstrap.request.ProductRequest
import com.ecommerce.product.bootstrap.response.ProductResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/products")
class ProductController(private val productUseCase: ProductUseCase) {
    @GetMapping
    fun getProducts(): ResponseEntity<List<ProductResponse>> {
        productUseCase.getAll().stream()
            .map { productDto -> ProductResponse.of(productDto) }
            .toList()
            .also { productsResponse -> return ResponseEntity.ok(productsResponse) }
    }

    @GetMapping(params = ["ids"])
    fun getProducts(@RequestParam ids: List<Long>): ResponseEntity<List<ProductResponse>> {
        productUseCase.get(ids).stream()
            .map { productDto -> ProductResponse.of(productDto) }
            .toList()
            .also { productsResponse -> return ResponseEntity.ok(productsResponse) }
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: Long): ResponseEntity<ProductResponse> {
        productUseCase.get(id)
            .let { productDto -> ProductResponse.of(productDto) }
            .also { productResponse -> return ResponseEntity.ok(productResponse) }
    }

    @PostMapping
    fun createProduct(@Valid @RequestBody productRequest: ProductRequest): ResponseEntity<ProductResponse> {
        val product = productUseCase.create(productRequest.toCommand())
        val productResponse = ProductResponse.of(product);
        return ResponseEntity.ok(productResponse);
    }

    @PatchMapping("/stocks/decrease")
    fun updateProductStock(
        @RequestBody updateProductStockRequest: BulkProductStockDecreaseRequest
    ): ResponseEntity<List<ProductResponse>> {
        val products = productUseCase.decreaseStock(updateProductStockRequest.toCommand())
        products.map { productDto -> ProductResponse.of(productDto) }
            .toList()
            .also { productsResponses -> return ResponseEntity.ok(productsResponses) }
    }
}