import io.freefair.gradle.plugins.lombok.tasks.GenerateLombokConfig

plugins {
    id("java-library")
    id("io.freefair.lombok")
    id("java-test-fixtures")
}

version = "0.0.1-SNAPSHOT"

apply {
    from("${rootProject.rootDir}/gradle/repositories.gradle.kts")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:2.2.4.RELEASE")
}


tasks {
    withType<JavaCompile> {
        sourceCompatibility = Versions.java
        targetCompatibility = Versions.java
    }
    withType<io.freefair.gradle.plugins.lombok.tasks.GenerateLombokConfig> {
        enabled = false
    }

    withType<Test> {
        useJUnitPlatform()
    }
}
