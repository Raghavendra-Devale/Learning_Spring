#  Spring Core – Constructor Injection (XML Configuration)

This lesson explains how to perform **constructor-based dependency injection** using **Spring XML configuration**.
We use a simple example: A `Laptop` that needs a `Processor` (either Intel or AMD).

---

## 📦 Project Structure

```
com.example.SpringIntro
├── App.java
├── Laptop.java
├── Processor.java
├── IntelProcessor.java
├── AMDProcessor.java
└── beans.xml
```

---

## 🧱 Components

### 1. `Processor` (Interface)

```java
public interface Processor {
    void boot();
}
```

---

### 2. `IntelProcessor` (Implements Processor)

```java
public class IntelProcessor implements Processor {
    public void boot() {
        System.out.println("Intel processor is booting up...");
    }
}
```

---

### 3. `AMDProcessor` (Implements Processor)

```java
public class AMDProcessor implements Processor {
    public void boot() {
        System.out.println("AMD processor is running...!");
    }
}
```

---

### 4. `Laptop` (Depends on Processor via Constructor)

```java
public class Laptop {
    private Processor processor;

    public Laptop(Processor processor) {
        this.processor = processor;
    }

    public void start() {
        processor.boot();
    }
}
```

---

## 🛠 Spring Configuration – `beans.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Processor Bean (Choose one) -->
    <bean id="intelProcessor" class="com.example.SpringIntro.IntelProcessor"/>
    <!-- <bean id="amdProcessor" class="com.example.SpringIntro.AMDProcessor"/> -->

    <!-- Laptop Bean with constructor injection -->
    <bean id="laptop" class="com.example.SpringIntro.Laptop">
        <constructor-arg ref="intelProcessor"/>
        <!-- change to amdProcessor if needed -->
    </bean>

</beans>
```

---

## 🚀 `App.java` (Main Class)

```java
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/example/SpringIntro/beans.xml");

        Laptop laptop = (Laptop) context.getBean("laptop");
        laptop.start();
    }
}
```

---

##  Output

When you run `App.java`:

```
Intel processor is booting up...
```

or

```
AMD processor is running...!
```

(depending on the bean injected)

---

## 📌 Key Concepts

| Concept                   | Description                                                    |
| ------------------------- | -------------------------------------------------------------- |
| **Dependency Injection**  | Giving required objects (dependencies) to a class from outside |
| **Constructor Injection** | Dependencies are passed using constructor                      |
| **Loose Coupling**        | Objects don’t create their own dependencies                    |
| **XML Configuration**     | Uses `beans.xml` to define and wire beans                      |
| **Spring Container**      | Reads the XML and builds objects with dependencies injected    |

---

## 🧠 Why Constructor Injection?

* Makes dependencies **required** (ensures class won't work without them)
* Easy to test and switch components (e.g., Intel ↔ AMD)
* Promotes **clean, maintainable code**

---
