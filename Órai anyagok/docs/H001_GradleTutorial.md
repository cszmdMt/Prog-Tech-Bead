# Gradle

**Gradle** is a fast, dependable, and flexible **open-source build automation tool**.  
It is widely used for building, testing, and deploying software, especially in the JVM ecosystem.

Gradle uses:
- **Groovy DSL** or **Kotlin DSL**
- Incremental builds and build caching for high performance
- A plugin-based architecture

## Supported Platforms & Languages

Gradle supports projects written in:
- Java
- Kotlin
- Kotlin Multiplatform
- Groovy
- Scala
- Android
- JavaScript
- C / C++

---

## Installing Gradle

### Prerequisite: Java Development Kit (JDK)

Gradle requires **JDK 17 or newer**.

### Check Java version
```bash
java -version
```

If not installed, install it:

```bash
sudo apt update
sudo apt install openjdk-25-jdk
```

### Install gradle

Guide is [here](https://docs.gradle.org/current/userguide/installation.html)

## Project Inicialization

We inicialize a project with gradle using:

```bash
gradle init --type <type-of-project> --dsl kotlin
```

This generates:
- build.gradle.kts (Build Configuration file)
- settings.gradle.kts (Project Configuration file)
- gradlew (Gradle Wrapper) (A script to run Gradle in a consistent way)
- Project directory structure 

### **Domain-Specific Language** (DSL)

It is a **programming or scripting language designed for a specific problem domain**, rather than general-purpose programming.
Used to describe builds

## Bulding the project

After writing the source code we build it with the help of gradle wrapper

```bash
./gradlew build
```

- Compiles the source code
- Runs tests
- Produces build artifacts in the `build/` directory

## Run the software

Run it: 
```bash
./gradlew run
```

### Useful Gradle Commands

```bash
./gradlew tasks        # List available tasks
./gradlew clean        # Remove build directory
./gradlew test         # Run tests
./gradlew build        # Full build lifecycle
```
