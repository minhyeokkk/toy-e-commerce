
dependencies {
	implementation(project(":order-application"))
    implementation(project(":order-domain"))
	implementation(project(":order-infra-rdb"))
	implementation(project(":common"))

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")

}