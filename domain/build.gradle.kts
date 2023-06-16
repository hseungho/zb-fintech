plugins {
    kotlin("plugin.jpa")
}

version = "0.0.1"

allprojects {
    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.6")
        implementation("com.mysql:mysql-connector-j:8.0.32")
        implementation("org.springframework.boot:spring-boot-starter-data-redis")
    }
}