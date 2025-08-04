
dependencies {
	implementation(project(":product-application"))
    implementation(project(":product-domain"))
	implementation(project(":product-infra-rdb"))
	implementation(project(":common"))

	implementation("org.springframework.boot:spring-boot-starter-web")
}
