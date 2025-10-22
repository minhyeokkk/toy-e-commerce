package com.ecommerce.product.infra.rdb.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ComponentScan(basePackages = ["com.ecommerce.product.infra.rdb"])
@EnableJpaRepositories(basePackages = ["com.ecommerce.product.infra.rdb.repository.jpa"])
@EntityScan(basePackages = ["com.ecommerce.product.infra.rdb.entity"])
@EnableJpaAuditing
class RdbConfig {

}