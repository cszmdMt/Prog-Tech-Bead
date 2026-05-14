# Singleton Design Pattern (Lazy and Eager)

## 1. Singleton Pattern

### Basic Information
The **Singleton Pattern** is a creational design pattern that ensures a class has **only one instance** and provides a **global point of access** to that instance.

Instead of allowing objects to be created with `new`, the class controls its own instantiation.

Key characteristics:
- Only **one instance** of the class exists
- The instance is **globally accessible**
- The constructor is **private** to prevent direct instantiation

---

### When to Use
Use the Singleton pattern when:

- Exactly **one instance** of a class is required.
- A **global shared resource** must be controlled.
- You want **centralized access** to a resource.

Example use cases:
- Logging systems
- Configuration managers
- Database connection managers
- Thread pools
- Caching systems

---

### How to Use

1. Make the constructor **private**.
2. Create a **static instance variable** inside the class.
3. Provide a **public static method** to access the instance.
4. Ensure that no other instances can be created.

There are two common implementations:
- **Eager (Greedy) Initialization**
- **Lazy Initialization**

---

## 2. Eager (Greedy) Initialization

### Basic Information
In **Eager Initialization**, the Singleton instance is created **when the class is loaded**.

This approach is simple and **thread-safe** because the instance is created during class loading by the JVM.

However, the instance is created **even if it is never used**, which may waste memory or resources.

---

## 3. Lazy Initialization

### Basic Information
In **Lazy Initialization**, the Singleton instance is created **when the class is first invoked**.

This approach is **not** thread-safe.

However, the instance is **only** created when it is used, saving memory.

### When to Use
Use eager initialization when:

- The Singleton instance is **lightweight**.
- The instance will **always be used**.
- You want **simple thread-safe implementation**.

Use lazy initialization wheN:

- The Singleton instance is **heavyweight**.
- The instance maybe **won't be used**.
- Thead Safety **is not** a concern.

---

### How it Works

1. The instance is created as a **static final variable**.
2. The constructor is **private**.
3. A **public static getter** returns the instance.

Example (Java):

```java
class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {
        // private constructor prevents instantiation
    }

    public static Singleton getInstance() {
        return instance;
    }
}
