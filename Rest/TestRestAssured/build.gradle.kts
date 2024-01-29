plugins {
    id("java")
}

group = "co.com.rest.assured"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.rest-assured:rest-assured:5.4.0")
    testImplementation("org.testng:testng:7.7.1")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("junit:junit:4.13.1")
}

tasks.test {
    useJUnitPlatform()
}