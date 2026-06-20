plugins {
    id("java")
}

allprojects {
    group = "dev.p2tch.arpeggio.ghosts"
    version = "1.0.0"
}

repositories {
    mavenCentral()
}

subprojects {
    repositories {
        mavenCentral()
        maven {
            name = "papermc"
            url = uri("https://repo.papermc.io/repository/maven-public/")
        }
        maven("https://jitpack.io")
    }

    apply {
        plugin("java")
    }

    dependencies {}

    java {
        sourceCompatibility = JavaVersion.VERSION_25
        targetCompatibility = JavaVersion.VERSION_25
    }
}
