group = "com.hackerrank.monosoul"
version = "1.0"

plugins {
    java
}

apply {
    plugin("org.junit.platform.gradle.plugin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testCompile("org.junit.jupiter:junit-jupiter-params:5.1.0")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    testCompile("org.assertj:assertj-core:3.9.1")
    testCompile("org.projectlombok:lombok:1.16.20")
    testCompile("com.google.guava:guava:24.1-jre")
}

repositories {
    jcenter()
}

buildscript {
    repositories{
        jcenter()
    }

    dependencies{
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.1.0")
    }
}