dependencies {

	implementation(project(":order-application"))
	implementation(project(":product-bootstrap"))

	implementation("org.springframework:spring-context")
	implementation("org.springframework:spring-web")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("io.github.openfeign:feign-httpclient:12.1")
}
