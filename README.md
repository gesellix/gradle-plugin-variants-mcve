# gradle-plugin-variants-mcve
Trying to reproduce https://discuss.gradle.org/t/declare-compatible-gradle-version-s-in-plugin-bundle-and-on-the-plugin-portal/39626

```shell
# should output "Hello from plugin 'de.gesellix.gradle.plugin.variants.greeting' (gradle7 variant)"
./gradlew :consumer:greeting
```
