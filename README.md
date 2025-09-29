# 📘 EI Study Repository



## 🗂 Repository Structure

### **Exercise-1** – Design Patterns
Covers key design patterns in Java:

**Behavioral Patterns**
- Command  
- Observer  

**Creational Patterns**
- Builder  
- Prototype  

**Structural Patterns**
- Flyweight  
- Composite  

---

### **Exercise-2: Satellite Command System**
Simulates a satellite command system where users can type commands to perform operations:

- Rotate the satellite in four directions  
- Activate / Deactivate panels  
- Collect numerical data  

#### **Design Patterns Used**

**1. Command Pattern**  
- Each request to the satellite is wrapped in a command object.  
- Uses a simple factory to map commands instead of if-else ladders, following the **Open/Closed Principle (OCP)**.

**2. State Pattern**  
- Manages `panelStatus` and `dataCollection` states.  
- Allows the system to behave differently based on its current state.

---

## ⚙️ Getting Started

### Prerequisites
- Java JDK 11 or above  
- IDE (IntelliJ IDEA, Eclipse, VS Code with Java extensions)  
- Git  

### Clone the Repository
```bash
git clone https://github.com/Hariprasathk13/ei-study.git
cd ei-study

```

### to run exercise-2
##### open in terminal:
```bash

cd exercise-2/SatelliteCommandSystem
javac -d build\classes -sourcepath src src\SatelliteCommandSystem.java
java -cp build\classes SatelliteCommandSystem
```
