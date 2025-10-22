plugins {
    kotlin("plugin.jpa") version "2.0.0"
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

dependencies {

    implementation(project(":product-application"))
    implementation(project(":product-domain"))

    implementation("org.springframework:spring-context")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.5.5")
    runtimeOnly("com.h2database:h2:2.3.232")
}