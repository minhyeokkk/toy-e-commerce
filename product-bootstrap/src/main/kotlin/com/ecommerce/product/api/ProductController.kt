package com.ecommerce.product.api

import com.ecommerce.product.application.`in`.ProductUseCase
import com.ecommerce.product.response.ProductResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/products")
class ProductController(private val productUseCase: ProductUseCase) {


     @GetMapping
     fun getProducts(): ResponseEntity<List<ProductResponse>> {
         productUseCase.getAllProducts()
         return ResponseEntity.ok().build();
     }
}