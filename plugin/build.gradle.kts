/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Gradle plugin project to get you started.
 * For more details take a look at the Writing Custom Plugins chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.0/userguide/custom_plugins.html
 */

plugins {
  // Apply the Java Gradle plugin development plugin to add support for developing Gradle plugins
  `java-gradle-plugin`
}

repositories {
  // Use Maven Central for resolving dependencies.
  mavenCentral()
}

dependencies {
  // Use JUnit test framework for unit tests
  testImplementation("junit:junit:4.13.1")
}

gradlePlugin {
  // Define the plugin
  val greeting by plugins.creating {
    id = "de.gesellix.gradle.plugin.variants.greeting"
    implementationClass = "de.gesellix.gradle.plugin.variants.GradlePluginVariantsMcvePlugin"
  }
}

// Add a source set for the functional test suite
val functionalTestSourceSet = sourceSets.create("functionalTest") {
}

gradlePlugin.testSourceSets(functionalTestSourceSet)
configurations["functionalTestImplementation"].extendsFrom(configurations["testImplementation"])

// Add a task to run the functional tests
val functionalTest by tasks.registering(Test::class) {
  testClassesDirs = functionalTestSourceSet.output.classesDirs
  classpath = functionalTestSourceSet.runtimeClasspath
}

tasks.check {
  // Run the functional tests as part of `check`
  dependsOn(functionalTest)
}
