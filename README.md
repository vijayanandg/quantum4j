# Quantum4J: A Modern Java Quantum Computing SDK  
**Lightweight • Extensible • Qiskit-Inspired • JVM-Native**

![Build](https://github.com/vijayanandg/quantum4j/actions/workflows/maven.yml/badge.svg)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Stars](https://img.shields.io/github/stars/vijayanandg/quantum4j.svg?style=flat)

---

Quantum4J is a pure-Java quantum computing framework designed to bring quantum programming to the JVM ecosystem.  
It provides a clean, intuitive API similar to Qiskit, a fast state-vector simulator, a QASM exporter,  
and a growing set of standard quantum gates.

Quantum4J is built for:

- Java developers learning quantum computing  
- Researchers who prefer Java tooling  
- JVM-based enterprise applications exploring QC use-cases  
- Developers wanting an open, extensible Java quantum SDK  

Quantum4J is **100% open-source**, **dependency-free**, and runs circuits up to ~**25 qubits** (memory-bound).

---

# ✨ Features

## ✔ Full Standard Gate Set
- **Single-qubit:** X, Y, Z, H, S, T  
- **Rotation gates:** RX(θ), RY(θ), RZ(θ)  
- **Controlled gates:** CX, CZ, CH  
- **Two-qubit:** SWAP, iSWAP  
- **Three-qubit:** CCX (Toffoli)

## ✔ State-Vector Simulator
- Efficient N-qubit statevector engine  
- Supports 1-, 2-, and 3-qubit unitaries  
- Custom `Complex` class (fast, immutable)  
- Accurate quantum state collapse  

## ✔ Measurements
- `measure(q, c)`  
- `measureAll()`  
- Classical register mapping  
- Deterministic + sampled measurement modes  

## ✔ OpenQASM Exporter
Export any circuit to **OpenQASM 2.0**:

```java
String qasm = QasmExporter.toQasm(circuit);
```

## ✔ Extensible Architecture
Implementing a new gate is as simple as:

```java
class MyGate extends SingleQubitGate {
    ...
}
```

## ✔ Full Example + JUnit Test Suite
Includes examples for:

- Bell state  
- GHZ state  
- Toffoli circuit  
- Rotations  
- SWAP / iSWAP  
- More coming soon  

---

# 📦 Installation

## Maven (coming soon to Central)
```xml
<dependency>
    <groupId>io.quantum4j</groupId>
    <artifactId>quantum4j</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Gradle
```gradle
implementation 'io.quantum4j:quantum4j:1.0.0'
```

## From source (current method)
```bash
git clone https://github.com/vijayanandg/quantum4j.git
```

---

# 🚀 Quick Start Example

### Create a Bell State

```java
import io.quantum4j.core.circuit.QuantumCircuit;
import io.quantum4j.core.backend.*;

public class BellState {
    public static void main(String[] args) {
        QuantumCircuit qc = QuantumCircuit.create(2)
                .h(0)
                .cx(0, 1)
                .measureAll();

        Result r = new StateVectorBackend().run(qc, RunOptions.shots(1000));
        System.out.println(r.getCounts());
    }
}
```

**Sample Output**
```
{00=502, 11=498}
```

---

# 🔺 Toffoli (CCX) Example

```java
QuantumCircuit qc = QuantumCircuit.create(3)
    .x(0)
    .x(1)
    .ccx(0, 1, 2)
    .measureAll();

Result r = backend.run(qc, RunOptions.shots(1000));
System.out.println(r.getCounts());
```

Expected:
```
{111=1000}
```

---

# 📤 Export to QASM

```java
QuantumCircuit qc = QuantumCircuit.create(2)
    .h(0)
    .cx(0, 1)
    .measureAll();

String qasm = QasmExporter.toQasm(qc);
System.out.println(qasm);
```

Output:

```
OPENQASM 2.0;
include "qelib1.inc";
qreg q[2];
creg c[2];

h q[0];
cx q[0], q[1];
measure q[0] -> c[0];
measure q[1] -> c[1];
```

---

# 🧱 Architecture Overview

| Module     | Description                                       |
|------------|---------------------------------------------------|
| circuit/   | Circuit objects, instructions, fluent builder     |
| gates/     | Gate definitions (1, 2, 3 qubit)                  |
| math/      | Complex arithmetic + state-vector implementation  |
| backend/   | Execution backend (statevector simulator)         |
| qasm/      | QASM exporter                                     |
| examples/  | Ready-to-run examples                             |
| tests/     | JUnit 5 test suite                                |

---

# 🧪 Test Suite

Quantum4J includes a comprehensive JUnit 5 suite:

### Gate correctness
- X, Y, Z  
- H, S, T  
- RX, RY, RZ  
- CX, CZ  
- SWAP, iSWAP  
- CCX  

### Other tests
- Measurement behavior  
- State collapse  
- Classical register correctness  
- QASM output  

Run tests:
```bash
mvn test
```

---

# ⚡ Performance (Statevector Size)

| Qubits | Amplitudes | Approx. Memory |
|--------|-------------|----------------|
| 10     | 1,024       | ~16 KB         |
| 15     | 32,768      | ~0.5 MB        |
| 20     | 1,048,576   | ~16 MB         |
| 25     | 33,554,432  | ~500 MB        |

**25 qubits is the realistic max for Java RAM on typical machines.**

---

# 🗺️ Future Roadmap

### **v1.1**
- UGate / U3Gate  
- Controlled RX/RY/RZ  
- Grover’s algorithm  
- Deutsch–Jozsa  
- Bernstein–Vazirani  
- Expanded QASM coverage  

### **v1.2**
- Density-matrix backend  
- Noise models  
- Basic transpiler  

### **v1.3**
- Hardware provider interface (IBM / IonQ / Rigetti)  
- Cloud execution adapters  

---

# 🧑‍💻 Contributing

We welcome:

- Pull requests  
- Issue reports  
- New gate implementations  
- Example circuits  
- Academic extensions  

Please use the **Google/IntelliJ Java style guide**.

---

# 📄 License

Quantum4J is licensed under the Apache License, Version 2.0.

You may use, copy, modify, and distribute this software in source or binary form
as long as you comply with the LICENSE and NOTICE files.

Commercial usage is allowed. Patent protection is granted under Section 3 of the
Apache License, Version 2.0.

See the full license in the `LICENSE` file.

---

# 🏢 Maintainer

**Vijay Anand Geddada**  
Creator – Quantum4J, mainMethod  
20+ years enterprise engineering leadership  
Cloud-native • Microservices • Java • Spring • AI • Quantum

---

# ⭐ If you find Quantum4J useful…
Please star the repo — it helps others discover it!

**https://github.com/vijayanandg/quantum4j**
