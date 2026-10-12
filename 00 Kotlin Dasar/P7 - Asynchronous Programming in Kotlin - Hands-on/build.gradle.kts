plugins {
    kotlin("jvm") version "1.9.24" apply false
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

    dependencies {
        "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    }
}

subprojects {
    apply(plugin = "application")
    extensions.configure<org.gradle.api.plugins.JavaApplication> {
        mainClass.set("LatihanKt")
    }
}
