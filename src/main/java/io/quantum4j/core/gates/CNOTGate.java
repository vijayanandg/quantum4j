package io.quantum4j.core.gates;

import io.quantum4j.core.math.Complex;

/**
 * CNOT (Controlled-NOT) quantum gate.
 *
 * <p>
 * A fundamental two-qubit gate where the target qubit is flipped (X gate) if the control qubit
 * is |1⟩. It is the quantum equivalent of the classical XOR operation. The gate matrix implements:
 * |00⟩ → |00⟩, |10⟩ → |11⟩, |01⟩ → |01⟩, |11⟩ → |10⟩.
 * </p>
 */
public final class CNOTGate extends TwoQubitGate {

    public CNOTGate() {
        super(new Complex[][] {
                // Basis ordering used by TwoQubitGate:
                // |00>, |10>, |01>, |11>
                //
                // CNOT (control -> target):
                // |00> -> |00>
                // |10> -> |11>
                // |01> -> |01>
                // |11> -> |10>

                { Complex.ONE, Complex.ZERO, Complex.ZERO, Complex.ZERO }, // |00> stays |00>
                { Complex.ZERO, Complex.ZERO, Complex.ZERO, Complex.ONE }, // |10> -> |11>
                { Complex.ZERO, Complex.ZERO, Complex.ONE, Complex.ZERO }, // |01> stays |01>
                { Complex.ZERO, Complex.ONE, Complex.ZERO, Complex.ZERO } // |11> -> |10>
        });
    }

    @Override
    public String name() {
        return "cx";
    }
}
