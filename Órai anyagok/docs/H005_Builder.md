# Builder Pattern

## Overview
The **Builder Pattern** is a creational design pattern that lets you construct complex objects step by step. It allows you to produce different representations of an object using the same construction process.

This pattern is especially useful when an object has many optional parameters or when its creation involves multiple steps.

---

## Problem
Consider a class with many fields, some required and some optional:

```java
class User {
    String name;
    int age;
    String email;
    String address;
    String phone;
}

Creating objects can become messy:
```java
User user = new User("John", 25, "john@email.com", "Some Street", "123456");
```

### Problems:

- Hard to read and maintain
- Easy to mix up parameters
- Difficult to handle optional fields

## Solution

The Builder Pattern suggests:

- Creating a separate Builder class
- Constructing the object step by step
- Returning the final object with a build() method

This makes object creation:

- More readable
- More flexible
- Less error-prone
