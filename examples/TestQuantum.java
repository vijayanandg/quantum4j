package io.quantum4j.core.examples;

import io.quantum4j.core.backend.*;
import io.quantum4j.core.circuit.QuantumCircuit;
import io.quantum4j.qasm.QasmExporter;

public class TestQuantum {
    public static void main(String[] args) {
        // 2 qubits, implicit classical bits for now
        QuantumCircuit qc = QuantumCircuit.create(3).x(0).x(1).ccx(0, 1, 2).measureAll();
        String qasm = QasmExporter.toQasm(qc);
        System.out.println(qasm);

        // .x(1); // just to show composing gates; we'll do real bell below

        // Real Bell circuit: H on qubit 0, then CX(0,1) – we haven’t implemented CX yet.
        // For now this example just tests H and X individually.

        Backend backend = new StateVectorBackend();
        Result result = backend.run(qc, RunOptions.shots(1000));

        System.out.println("Counts: " + result.getCounts());
    }
}
