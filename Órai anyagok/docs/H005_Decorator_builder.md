# Decorator Pattern

## Overview
The **Decorator Pattern** is a structural design pattern that allows you to dynamically add new behavior to an object without modifying its existing code. It wraps the original object in one or more decorator classes that enhance or alter its functionality.

This pattern is especially useful when subclassing would lead to an explosion of classes or when you want to combine behaviors flexibly at runtime.

---

## Problem
Imagine you have a basic component (e.g., a `Coffee` class), and you want to add features like milk, sugar, or whipped cream.

You could:
- Create subclasses for every combination (`MilkCoffee`, `SugarCoffee`, `MilkSugarCoffee`, etc.)
- But this quickly becomes unmanageable as combinations grow.

---

## Solution
The Decorator Pattern suggests:
- Keeping the original component unchanged
- Creating wrapper classes (decorators) that implement the same interface
- Adding behavior before or after delegating to the wrapped object

---

## Structure

- **Component**: Defines the interface for objects
- **Concrete Component**: The base object being decorated
- **Decorator**: Abstract class that wraps a component
- **Concrete Decorators**: Add specific behaviors

---

## Decorator vs Template Method

The **Decorator Pattern** and the **Template Method Pattern** may seem similar at first because both allow you to extend behavior without modifying existing code. However, they solve different problems and operate in fundamentally different ways.

---

### Similarities

- **Promote code reuse**: Both patterns help avoid duplication
- **Follow the Open/Closed Principle**: Extend behavior without changing existing classes
- **Encapsulate variation**: They separate what changes from what stays the same

---

### Key Differences

| Aspect | Decorator Pattern | Template Method Pattern |
|--------|------------------|--------------------------|
| **Type** | Structural | Behavioral |
| **Mechanism** | Composition (wrapping objects) | Inheritance (subclassing) |
| **When behavior is defined** | Runtime | Compile-time |
| **Flexibility** | High (can combine multiple decorators) | Limited (fixed inheritance hierarchy) |
| **Control flow** | Delegated dynamically through wrappers | Defined by the base class algorithm |
| **Modification style** | Add responsibilities | Override steps of an algorithm |

---

### How They Differ Conceptually

- **Decorator Pattern**:
  - Adds new functionality *around* an object
  - You can stack multiple decorators dynamically
  - Focuses on enhancing behavior without altering structure

- **Template Method Pattern**:
  - Defines the skeleton of an algorithm in a base class
  - Subclasses override specific steps
  - Focuses on controlling the structure of an algorithm

---



## Example (Java)

### Component
```java
interface Coffee {
    String getDescription();
    double cost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }

    public double cost() {
        return 5.0;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public double cost() {
        return coffee.cost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    public double cost() {
        return coffee.cost() + 1.5;
    }
}
```
