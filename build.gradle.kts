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

  api("com.github.dtmo.jfiglet:jfiglet:1.0.0")

  // Use JUnit Jupiter API for testing.
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
  testImplementation("org.assertj:assertj-core:3.14.0")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")

  testFixturesImplementation("org.springframework.boot:spring-boot-starter:2.2.4.RELEASE")
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
