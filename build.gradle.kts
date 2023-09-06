plugins {
    java
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
}

group = "com.dmandryianau"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_19
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

    val testContainerVersion = "1.19.0"
    testImplementation("org.testcontainers:junit-jupiter:${testContainerVersion}")
    testImplementation("org.testcontainers:postgresql:${testContainerVersion}")

    val jsonWebToken = "0.11.5"
    implementation("io.jsonwebtoken:jjwt-api:${jsonWebToken}")
    implementation("io.jsonwebtoken:jjwt-impl:${jsonWebToken}")
    implementation("io.jsonwebtoken:jjwt-jackson:${jsonWebToken}")

    val prometheusVersion = "1.11.3"
    implementation("io.micrometer:micrometer-registry-prometheus:${prometheusVersion}")

    val flywayVersion = "9.22.0"
    implementation("org.flywaydb:flyway-core:${flywayVersion}")
    val postgresVersion = "42.6.0"
    implementation("org.postgresql:postgresql:${postgresVersion}")

    val lombokVersion = "1.18.28"
    compileOnly("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")

    val mapstructVersion = "1.5.5.Final"
    implementation("org.mapstruct:mapstruct:${mapstructVersion}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")

    val openApiVersion = "2.2.0"
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:${openApiVersion}")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
