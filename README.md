Quantum4J: A Modern Java Quantum Computing SDK
Lightweight • Extensible • Qiskit-Inspired • JVM-Native

![Build](https://github.com/vijayanandg/Quantum4J/actions/workflows/maven.yml/badge.svg)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![Java](https://img.shields.io/badge/Java-17%2B-blue)


Quantum4J is a pure-Java quantum computing framework designed to bring quantum programming to the JVM ecosystem.
It provides a clean, intuitive API similar to Qiskit, a fast state-vector simulator, a QASM exporter, and a growing set of standard quantum gates.

Quantum4J is built for:
    Java developers learning quantum computing
    Researchers who prefer Java tooling
    JVM-based enterprise applications exploring QC use-cases
    Developers who want an open, extensible Java quantum SDK
    Quantum4J is 100% open source, dependency-free, and fast enough for circuits up to ~25 qubits.

✨ Features
✔ Full Standard Gate Set
    X, Y, Z
    H, S, T
    RX, RY, RZ (rotation gates)
    Controlled gates: CX, CZ, CH
    Two-qubit gates: SWAP, iSWAP
    Three-qubit gate: CCX (Toffoli)

✔ State-Vector Simulator
    Efficient state-vector backend
    Supports up to ~25 qubits (depending on memory)
    Complex number support with custom Complex class
    Safe application of 1-, 2-, and 3-qubit unitaries

✔ Measurements
    measure(q, c)
    measureAll()
    Classical register support
    Quantum state collapse logic

✔ QASM Exporter
    Export circuits to OpenQASM 2.0 for execution on external quantum providers:
    String qasm = QasmExporter.toQasm(circuit);

✔ Extensible Architecture
    Adding a new gate requires only:
    class MyGate extends SingleQubitGate { … }

✔ Examples + JUnit Test Suite
    Bell state
    GHZ state
    Toffoli example
    Rotations
    SWAP / iSWAP
    Full JUnit 5 test suite
    Grover search (coming soon)

Installation
Maven (coming soon)
<dependency>
    <groupId>io.quantum4j</groupId>
    <artifactId>quantum4j</artifactId>
    <version>1.0.0</version>
</dependency>

Gradle
implementation 'io.quantum4j:quantum4j:1.0.0'


Until then, clone the repo:

git clone https://github.com/vijayanandg/quantum4j.git

Quick Start Example

Create a Bell state:
    import io.quantum4j.core.circuit.QuantumCircuit;
    import io.quantum4j.core.backend.*;

    public class BellState {
        public static void main(String[] args) {
            QuantumCircuit qc = QuantumCircuit.create(2)
                    .h(0)
                    .cx(0,1)
                    .measureAll();

            Result r = new StateVectorBackend().run(qc, RunOptions.shots(1000));
            System.out.println(r.getCounts());
        }
    }


Output:
{00=502, 11=498}

Example: Toffoli (CCX) Gate
    QuantumCircuit qc = QuantumCircuit.create(3)
        .x(0)
        .x(1)
        .ccx(0,1,2)
        .measureAll();

    Result r = backend.run(qc, RunOptions.shots(1000));
    System.out.println(r.getCounts());


Expected:
    {111=1000}

Export to QASM
    QuantumCircuit qc = QuantumCircuit.create(2)
        .h(0)
        .cx(0,1)
        .measureAll();

    String qasm = QasmExporter.toQasm(qc);
    System.out.println(qasm);


Output:
    OPENQASM 2.0;
    include "qelib1.inc";
    qreg q[2];
    creg c[2];

    h q[0];
    cx q[0], q[1];
    measure q[0] -> c[0];
    measure q[1] -> c[1];

Architecture Overview
Core Modules
Module	            Purpose
circuit/	        Circuit objects, instructions, fluent builder
gates/	            Gate definitions (1, 2, 3 qubit)
math/	            Complex number and state-vector logic
backend/	        Execution engine (state-vector simulator)
qasm/	            QASM exporter
examples/	        Ready-to-run examples
tests/	            JUnit test suite

🧪 Test Suite
Quantum4J includes a full JUnit 5 suite, covering:

✔ Gate correctness
    X, Y, Z
    H, S, T
    RX, RY, RZ
    CX, CZ
    SWAP, ISWAP
    CCX

✔ Measurement behavior
✔ State collapse
✔ Register mapping
✔ QASM output validation

Run tests:
    mvn test

Performance

Quantum4J is optimized for medium-scale circuits:

Qubits	State size	        Memory required
10	    1024 amplitudes	        ~16 KB
15	    32,768 amplitudes	    ~0.5 MB
20	    1,048,576 amplitudes	~16 MB
25	    33,554,432 amplitudes	~500 MB

25 qubits is typically the practical limit due to RAM.

🌍 Future Roadmap
Version 1.1
    UGate / U3Gate
    Controlled versions of RX/RY/RZ
    Grover algorithm example
    Deutsch-Jozsa & Bernstein-Vazirani
    Improved QASM coverage

Version 1.2
    Density-matrix backend
    Noise models
    Basic transpiler

Version 1.3
    Hardware provider interface (IBM / IonQ / Rigetti connectors)
    Cloud execution adapters

🧑‍💻 Contributing

We welcome:
    Pull requests
    Issue reports
    New gate implementations
    Example circuits
    Academic extensions
    Please format code using the default IntelliJ/Google Java style guide.

📄 License
Quantum4J is released under the MIT License — free for commercial and academic use.

🏢 Maintainer
Vijay Anand Geddada
Founder, Quantum4J, mainMethod
20+ years of enterprise engineering leadership
Cloud-native, microservices, Java, Spring, AI, quantum computing

⭐ If you find this useful…
Please star the repo — it helps others discover Quantum4J.