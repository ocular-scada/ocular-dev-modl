plugins {
    `java-library`
    kotlin("jvm")
}

java {
    toolchain {
        languageVersion.set(org.gradle.jvm.toolchain.JavaLanguageVersion.of(17))
    }
}

dependencies {
    // add common scoped dependencies here
    compileOnly("com.inductiveautomation.ignitionsdk:ignition-common:${rootProject.extra["sdk_version"]}")
    implementation(kotlin("stdlib-jdk8"))
}
