# Introduction

This document is for a small introduction into principles during first class

# Principles

Principles are unwritten rules which tells us how we should desing our program and how we should program it.

## 1. The Code is always changing

When we build build a software, than during production its codebase will always develop. We add new classes, new features, bug fixes and we also refactor.
We should desing a program in mind that we will expand it in the future.

## 2. Separation of Concerns (SoC)

Since our code always changes we design it with SoC in mind.

- What can be separetad, should be separeted

If se separeta the parts of our code, then it will be easier to handle.

## 3. GOF1

GOF1: Program to an interface, not an implementation

### **Example:**

```java
import java.util.List;
import java.util.ArrayList;

// Bad Code:
public class MainBad {
    public static void main(String[] args) {
        // Directly using concrete class
        ArrayList<String> students = new ArrayList<>();
        students.add("Alice");
        students.add("Bob");

        for (String s : students) {
            System.out.println(s);
        }
    }
}

// Better code:
public class MainGood {
    public static void main(String[] args) {
        // Programming to interface List, not ArrayList
        List<String> students = new ArrayList<>();
        students.add("Alice");
        students.add("Bob");

        printStudents(students);
    }

    public static void printStudents(List<String> students) {
        for (String s : students) {
            System.out.println(s);
        }
    }
}
```

In the first case if we have to change the type of ```students``` we have to change it at multiple places.
In the second case we only have to replace it at one place.
If we use a function that is implemented in ```ArrayList``` but not in ```LinkedList``` that can produce errors and bugs. Thus we should only call function that are part of the interface.

## 4. GOF2

GOF2: Favour object composition over class inheritance.

With object composition we can replace inheritance and we can also change the object dinamically during runtime

## 5. Is-A & Has-A

- Is-A: Inheritance. Class B is a type of Class A.

Example: class Dog extends Animal → Dog is an Animal.

- Has-A: Composition. Class B contains an instance of Class A.

Example: class Car { Engine engine; } → Car has an Engine.
