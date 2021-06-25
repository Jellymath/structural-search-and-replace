plugins {
    java
    kotlin("jvm") version "1.5.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.mockito:mockito-core:3.11.2")
    testImplementation("org.mockito:mockito-junit-jupiter:3.11.2")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.5.20")
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}