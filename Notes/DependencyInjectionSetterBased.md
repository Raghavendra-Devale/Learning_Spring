# 📘 Spring Notes: Setter-Based Dependency Injection with SimCard Example

##  1. **What I Learned**

### 🔹 Dependency Injection (DI)

* Objects don’t create their own dependencies — they are **injected externally** (by Spring).
* This improves **loose coupling**, flexibility, and testability.

### 🔹 Interface-Based Design

* I used a `SimCard` interface with methods like `call()` and `browse()`.
* Implemented it with classes like `JioSimCard`, `AirtelSimCard`, etc.
* The `Mobile` class uses the `SimCard` interface — not a specific implementation.

### 🔹 Setter Injection

* Spring calls **setter methods** (like `setSimCard()` or `setNetworkName()`) to inject dependencies.
* The injection is configured in the `beans.xml` file.

### 🔹 XML Bean Configuration

* Used `<bean>` tags in `beans.xml` to define objects.
* Injected object dependencies using `<property>` with `ref` (for objects) and `value` (for primitive types).
* Example: injected a `SimCard` bean and a `networkName` string into the `Mobile` and `SimCard` classes.

### 🔹 Inversion of Control (IoC)

* The control of object creation is taken away from the class itself and handled by the Spring container.
* I could **switch between Jio, Airtel, and Vodafone** SIMs just by changing XML — no code changes needed.

---

##  How the Example Worked

1. Created a `SimCard` interface with `call()` and `browse()`.
2. Made multiple implementations: `JioSimCard`, `AirtelSimCard`, etc.
3. `Mobile` class had:

   * A `SimCard` property
   * A `setSimCard()` setter method
4. In `beans.xml`:

   * Defined a SIM bean (e.g., `jioSimCard`)
   * Injected it into the `Mobile` bean using `<property name="simCard" ref="jioSimCard"/>`
5. Ran the app — Spring injected the correct SIM, and `Mobile` used it without knowing the type.

---

##  What I Can Say in Interviews

> "I created a small Spring application using setter-based dependency injection. I had a `Mobile` class that depended on a `SimCard` interface. I injected implementations like `JioSimCard` and `AirtelSimCard` using XML configuration. This showed me how Spring creates and wires beans using inversion of control, and how changing behavior doesn’t require code changes — only XML updates."

---

