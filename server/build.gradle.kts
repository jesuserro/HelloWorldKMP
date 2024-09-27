plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlinSerialization)
    application
}

group = "com.github.jesuserro.helloworldkmp"
version = "1.0.0"
application {
    mainClass.set("com.github.jesuserro.helloworldkmp.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
//    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.server.content.negotiation)
//    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}