plugins {
    id("java-library")
    id("maven-publish")
}

group = "com.vulpuslabs"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.vulpuslabs.vulpes"
            artifactId = "vulpes-interface"
            version = "1.0"

            from(components["java"])
        }
    }
}