plugins {
    kotlin("jvm") version "2.4.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    repositories {
        maven("https://maven.aliyun.com/repository/public")
        mavenCentral()
    }
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}
tasks.withType<JavaExec> {
    jvmArgs = listOf(
        "-Dfile.encoding=UTF-8",
        "-Dsun.stdout.encoding=UTF-8",
        "-Dsun.stderr.encoding=UTF-8"
    )
}