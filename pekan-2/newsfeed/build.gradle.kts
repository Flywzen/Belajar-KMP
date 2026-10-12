plugins {
    alias(libs.plugins.kotlinJvm)
    application
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlin.testJunit)
}

application {
    // Main.kt berada di default package -> kelas MainKt
    mainClass.set("MainKt")
}

tasks.test {
    useJUnit()
}
