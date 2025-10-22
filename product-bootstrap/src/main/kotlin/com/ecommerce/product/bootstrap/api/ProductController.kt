package com.ecommerce.product.bootstrap.api

import com.ecommerce.product.application.usecase.ProductUseCase
import com.ecommerce.product.bootstrap.request.ProductRequest
import com.ecommerce.product.bootstrap.response.ProductResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

    @PostMapping
    fun createProduct(@Valid @RequestBody productRequest: ProductRequest): ResponseEntity<ProductResponse> {
        val product = productUseCase.create(productRequest.toCommand())
        val productResponse = ProductResponse.of(product);
        return ResponseEntity.ok(productResponse);
    }
}