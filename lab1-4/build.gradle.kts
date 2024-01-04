plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // https://mvnrepository.com/artifact/javax.validation/validation-api
    implementation("javax.validation:validation-api:2.0.1.Final")

   // https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator
    implementation("org.hibernate.validator:hibernate-validator:6.2.0.Final")


    // https://mvnrepository.com/artifact/org.glassfish/javax.el
    implementation("org.glassfish:javax.el:3.0.0")

    // https://mvnrepository.com/artifact/javax.el/javax.el-api
    implementation("javax.el:javax.el-api:2.2.4")

    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.16.0-rc1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.16.0-rc1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.3")

}

tasks.test {
    useJUnitPlatform()
}

