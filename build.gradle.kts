plugins {
    id("java")
    id("application")
}

group = "com.unvise"
version = "1.0-SNAPSHOT"
val mainClazz = "com.unvise.oop.Main"

repositories {
    mavenCentral()
}

application {
    mainClass.set(mainClazz)
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    testLogging {
        events.add(org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED)
        events.add(org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED)
        events.add(org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED)
        events.add(org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_OUT)
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.SHORT
        showExceptions = true
        showCauses = true
        showStackTraces = true
    }
}

tasks.withType<Jar> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes["Main-Class"] = mainClazz
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    val sourcesMain = sourceSets.main.get()
    from(sourcesMain.output)
}