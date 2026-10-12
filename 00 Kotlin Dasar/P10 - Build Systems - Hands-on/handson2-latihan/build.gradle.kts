version = "1.0.0"

tasks.register("printProjectInfo") {
    group = "kotlin dasar"
    description = "Mencetak nama project, versi project, dan versi Gradle"
    doLast {
        println("Nama project: ${project.name}")
        println("Versi project: ${project.version}")
        println("Versi Gradle: ${gradle.gradleVersion}")
    }
}
