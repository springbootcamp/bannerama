plugins {
    `kotlin-dsl`
}

apply {
    from("../gradle/repositories.gradle.kts")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

dependencies {
    implementation("io.freefair.gradle:lombok-plugin:4.1.6")
}
