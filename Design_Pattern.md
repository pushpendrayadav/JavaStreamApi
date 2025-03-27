

---

### Introduction
- **What are Design Patterns?**: Solutions to common programming problems that recur across languages and platforms. Not complex—just need to know when and how to use them.
- **Origin**: In 1994, the "Gang of Four" (GoF) wrote *Design Patterns: Elements of Reusable Object-Oriented Software*, cataloging 23 patterns in three buckets:
  1. **Creational**: Object creation flexibility.
  2. **Structural**: How objects relate to each other (like Lego blueprints).
  3. **Behavioral**: Communication and responsibility distribution between objects.
- **Focus**: Covering 7 of the 23 patterns, not all.

---

### Creational Patterns
#### 1. Singleton Pattern
- **Purpose**: Ensures a single instance of an object exists, globally accessible (e.g., a central logger for an app).
- **Example**: One logger for all errors vs. multiple conflicting loggers.
- **Code**: `Logger.getInstance()` vs. `new Logger()` everywhere.
- **When to Use**: Need a single, guaranteed instance (e.g., database connection pool, logger).
- **Pros**: Single instance, global access.
- **Cons**: Hard to test (mocking issues), needs special handling in multi-threaded environments, essentially a "glorified global variable."
- **Analogy**: A hammer—great for nails, not everything.

#### 2. Builder Pattern
- **Purpose**: Simplifies creating objects with many optional parameters, step-by-step.
- **Example**: Building an HTTP request with headers, query params, etc., chaining methods (`requestBuilder.withHeader().withTimeout().build()`).
- **When to Use**: Constructors with too many parameters or step-by-step object construction (like cooking a recipe).
- **Pros**: Readable code, easy to extend (add new options), maintainable.
- **Cons**: More upfront code.
- **Analogy**: Cooking—don’t throw all ingredients in at once, follow steps.

#### 3. Factory Pattern
- **Purpose**: Centralizes object creation, hiding complexity (e.g., creating different user types: admin, moderator, regular).
- **Example**: `UserFactory.createUser("admin", id, name)` vs. `new Admin()` or `new Moderator()` with conditional logic everywhere.
- **When to Use**: Repeated `new` keyword usage or complex creation logic.
- **Pros**: Cleaner, maintainable code; centralized logic (e.g., add logging in one place).
- **Cons**: Adds abstraction layer, tightly coupled to factory class.
- **Analogy**: A car factory—cars come out, but you don’t see the messy internals.

---

### Structural Patterns
#### 4. Facade Pattern
- **Purpose**: Simplifies interaction with complex subsystems by providing a unified interface.
- **Example**: Clicking "Buy Now" online—handles payment, inventory, shipping behind the scenes vs. manually calling each subsystem.
- **When to Use**: Messy, complex subsystems need simplification.
- **Pros**: Hides complexity, clean interface (like encapsulation).
- **Cons**: Risk of becoming a "god object" (knowing/doing too much).
- **Analogy**: Online shopping button—simple front, complex back-end.

#### 5. Adapter Pattern
- **Purpose**: Makes incompatible interfaces work together (e.g., converting third-party API data to your app’s format).
- **Example**: Weather API in Celsius/km to Fahrenheit/miles—wrap it in an adapter vs. converting manually everywhere.
- **When to Use**: Integrating third-party libraries/APIs with mismatched interfaces.
- **Pros**: Keeps conversion logic centralized, avoids code duplication.
- **Cons**: Tedious to create adapters for everything.
- **Analogy**: USB-to-HDMI adapter—bridges two systems seamlessly.

---

### Behavioral Patterns
#### 6. Strategy Pattern
- **Purpose**: Defines interchangeable algorithms for a task, swapping them without changing core code.
- **Example**: Getting to work—drive, bike, bus strategies vs. if-else nightmare for each transport type.
- **Code**: `Commuter.setStrategy(carStrategy).goToWork()` vs. sprawling if-else logic.
- **When to Use**: Multiple ways to do the same thing (follows open-closed principle).
- **Pros**: Clean, extensible (add new strategies easily), programs to an interface.
- **Cons**: More classes to manage.
- **Analogy**: Choosing how to commute—same goal, different strategies.

#### 7. Observer Pattern
- **Purpose**: Allows objects to subscribe to events and get notified when they occur.
- **Example**: YouTube notifications—subscribers get pinged when a video uploads vs. manually looping through all users.
- **Code**: `VideoChannel.subscribe(user).upload(video)` notifies all subscribers automatically.
- **When to Use**: Event-driven scenarios (e.g., system errors, state changes).
- **Pros**: Automatic updates, performant (no manual polling).
- **Cons**: Risk of "event callback hell" if overused (event triggers event triggers event).
- **Analogy**: YouTube bell—click it, get notified.

---

### Key Takeaways
- **Why Use Them?**: They’re proven solutions to recurring problems, improving code quality and maintainability.
- **When to Use**: Recognize the problem (e.g., complex creation → Builder, event handling → Observer) and apply the right tool.
- **Practice**: Study and use them to internalize their application.

---
