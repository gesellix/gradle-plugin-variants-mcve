buildscript {
  repositories {
    mavenLocal()
  }

  dependencies {
    classpath("gradle-plugin-variants-mcve:plugin:local")
  }
}

apply(plugin = "de.gesellix.gradle.plugin.variants.greeting")
