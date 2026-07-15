plugins {
    id("java")
    id("org.springframework.boot") version "4.1.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

tasks.jar {
    enabled = false
}
application {
    mainClass.set("org.example.Main")
}

tasks.bootJar {
    enabled = true
    archiveClassifier.set("")
    archiveFileName.set("app.jar")
    mainClass.set("org.example.Main")
}

dependencies {
    //Spring
    implementation("org.springframework.boot:spring-boot-starter:4.1.0")
    implementation("org.springframework.boot:spring-boot-starter-web:4.1.0")

    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}