# Java Overview

## Java Standard Library (JSL)

The **Java Standard Library** contains a large collection of built-in classes and interfaces that provide core functionality for Java programs.

- Includes packages such as:
  - `java.lang` (automatically imported, e.g. `Object`, `String`, `Math`)
  - `java.util` (collections, utilities)
  - `java.io` / `java.nio` (input/output)
  - `java.net` (networking)
  - `java.time` (date and time API)

---
  
## Java Virtual Machine (JVM)

The **Java Virtual Machine** is responsible for executing Java bytecode.

### Responsibilities
- Loads `.class` files (bytecode) into memory
- Executes bytecode using an interpreter and/or Just-In-Time (JIT) compiler
- Provides **platform independence** (“write once, run anywhere”)
- Manages:
  - Memory allocation and deallocation
  - Garbage collection
  - Multithreading and thread scheduling
  - Security checks and runtime optimizations

> The JVM is platform-specific, but Java bytecode is platform-independent.

---

## Java Runtime Environment (JRE)

The **Java Runtime Environment** provides everything needed to **run** a Java application (but not to develop one).

### Contains
- Java Virtual Machine (JVM)
- Java Standard Library (JSL)
- Supporting runtime files and libraries

### Purpose
- Allows users to execute Java programs
- Does **not** include development or compilation tools

## Java Development Kit (JDK)

The **Java Development Kit** provides everything needed to **develop, compile, debug, and run** Java applications.

### Contains
- Java Runtime Environment (JRE)
- Development tools
- Header files and documentation (depending on distribution)

---

### Development tools

1. **`javac`** – Compiles `.java` source files into `.class` bytecode  
2. **`java`** – Launches the JVM and runs Java applications  
3. **Java Standard Library source code** – Reference implementation of core APIs  
4. **Debugger (`jdb`)** – Helps inspect and debug running programs  
5. **Monitoring & profiling tools**
   - `jconsole`
   - `jvisualvm`
   - Flight Recorder / Mission Control (in some distributions)

---

# Example: Running a Simple Java Program

## Step 0: Install Java (On Linux):

```bash
sudo apt install openjdk-25
```

## 1. Create a Java Source File

Create a file named `HelloWorld.java`:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

## 2. Compile the Program

Compile the java file

```bash
javac HelloWorld.java
```

It generates HelloWorld.class

## 3. Run the Program

execute it with JVM:

```bash
hava HelloWorld
```
