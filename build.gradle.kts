plugins {
    id("java")
}

group = "com.github.idankoblik"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://nexus.voigon.dev/repository/beta-releases/")
}

dependencies {
    implementation("net.dv8tion:JDA:${project.findProperty("jda.version").toString()}")
    compileOnly("org.projectlombok:lombok:${project.findProperty("lombok.version").toString()}")
    implementation("com.google.guava:guava:${project.findProperty("guava.version").toString()}")
    implementation("io.github.cdimascio:dotenv-java:3.0.0")
    implementation("com.github.idankoblik:hertz:1.2.7")
}