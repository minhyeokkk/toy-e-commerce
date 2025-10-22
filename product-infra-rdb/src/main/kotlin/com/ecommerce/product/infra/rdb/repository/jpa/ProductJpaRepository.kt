package com.ecommerce.product.infra.rdb.repository.jpa

import com.ecommerce.product.infra.rdb.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductJpaRepository : JpaRepository<ProductEntity, Long> {

}