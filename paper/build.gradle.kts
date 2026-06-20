dependencies {
    compileOnly("io.papermc.paper:paper-api:26.1.2.build.+")

    implementation("com.google.inject:guice:7.0.0")

    implementation("com.github.xKrisSx.aaapi:core:1.0.1")
    implementation("com.github.xKrisSx.aaapi:guice:1.0.1")

    implementation(project(":common"))
}