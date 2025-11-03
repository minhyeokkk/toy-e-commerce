package com.ecommerce.product.client.config

import feign.Client
import feign.httpclient.ApacheHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignClientConfig {

    @Bean
    fun client(): Client {
        return ApacheHttpClient()
    }
}