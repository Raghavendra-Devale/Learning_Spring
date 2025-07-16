# 🌿 Spring Core – Autowiring with XML Configuration

This lesson explains how to perform **automatic dependency injection** using the `autowire` attribute in Spring’s **XML configuration**.

We’ll use a simple example: a `Person` who depends on a `Vehicle` to drive.

---

## 📦 Project Structure

```
com.example.XMLAutowiring
├── App.java
├── Vehicle.java
├── Person.java
└── config.xml
```

---

## 🧱 Components

### 1. `Vehicle` (Dependency)

```java
public class Vehicle {
    public Vehicle() {
        System.out.println("vehicle constructor");
    }

    public void start() {
        System.out.println("vehicle started");
    }
}
```

---

### 2. `Person` (Depends on Vehicle)

#### Option A: Setter Injection

```java
public class Person {
    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void drive() {
        vehicle.start();
    }
}
```

#### Option B: Constructor Injection

```java
public class Person {
    private Vehicle vehicle;

    public Person(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void drive() {
        vehicle.start();
    }
}
```

---

## 💡 What is Autowiring?

**Autowiring** allows Spring to automatically inject dependencies by:

* **Type**
* **Name**
* **Constructor**

You configure this using the `autowire` attribute in your XML `<bean>` declaration.

---

## 🛠 XML Configuration – `config.xml`

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Vehicle Bean -->
    <bean id="vehicle" class="com.example.XMLAutowiring.Vehicle" />

    <!-- Person Bean (autowiring to be tested) -->
    <!-- Choose autowire mode here -->
</beans>
```

---

## 🔍 Types of Autowiring

### 1️⃣ `autowire="no"` (Manual Wiring – Default)

```xml
<bean id="person" class="com.example.XMLAutowiring.Person">
    <property name="vehicle" ref="vehicle" />
</bean>
```

📌 No automatic injection. You define every dependency manually.

---

### 2️⃣ `autowire="byName"`

```xml
<bean id="person" class="com.example.XMLAutowiring.Person" autowire="byName" />
```

🔧 Rules:

* Spring looks for a **setter method**.
* It checks if any bean ID **matches the property name** (e.g., `vehicle`).
* If found, it injects that bean.

✅ Requires: `setVehicle()` in `Person.java`
✅ Bean ID: `vehicle`

---

### 3️⃣ `autowire="byType"`

```xml
<bean id="person" class="com.example.XMLAutowiring.Person" autowire="byType" />
```

🔧 Rules:

* Spring finds a **setter method**.
* It checks for a bean whose class **matches the type** of the property (e.g., `Vehicle`).
* Must be **only one** bean of that type.

⚠️ If multiple beans of same type exist, you get `NoUniqueBeanDefinitionException`.

---

### 4️⃣ `autowire="constructor"`

```xml
<bean id="person" class="com.example.XMLAutowiring.Person" autowire="constructor" />
```

🔧 Rules:

* Spring looks for a constructor and matches its parameter types.
* Injects beans by type into constructor.

✅ `Person` must have: `public Person(Vehicle vehicle)`

---

### 5️⃣ `autowire="autodetect"` (Deprecated ❌)

* Spring chooses constructor if available, otherwise setter.
* Removed in latest Spring versions. Avoid using.

---

## 🚀 `App.java` (Main Class)

```java
ApplicationContext context = new ClassPathXmlApplicationContext("com/example/XMLAutowiring/config.xml");
Person p = context.getBean("person", Person.class);
p.drive();
```

---

## 🧪 Example Output

```
vehicle constructor
vehicle started
```

---

## 📌 Summary Table

| Mode          | How It Works                                             | Requires                        | Notes                           |
| ------------- | -------------------------------------------------------- | ------------------------------- | ------------------------------- |
| `no`          | Manual with `<property>`                                 | Setter method                   | Most control, most work         |
| `byName`      | Injects bean whose ID matches property name              | Setter method, matching bean ID | Sensitive to bean naming        |
| `byType`      | Injects bean by type                                     | Setter method, unique bean type | Fails if multiple beans of type |
| `constructor` | Injects into constructor by argument type                | Constructor                     | Best for mandatory dependencies |
| `autodetect`  | Automatically chooses constructor or setter (deprecated) | Constructor or setter           | ❌ Don’t use                     |

---

## 🧠 Why Use Autowiring?

* ✅ Less XML code
* ✅ Faster development
* ✅ Clean and automatic
* ❌ But harder to debug if not used carefully

---