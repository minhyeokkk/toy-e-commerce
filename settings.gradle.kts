plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "toy-e-commerce"

include (
    "product-bootstrap",
    "product-domain",
    "product-application",
    "product-infra-rdb",
    "order-bootstrap",
    "order-domain",
    "order-application",
    "order-infra-rdb",
    "common"
)

