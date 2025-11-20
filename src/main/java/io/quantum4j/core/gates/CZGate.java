package io.quantum4j.core.gates;

import io.quantum4j.core.math.Complex;

/**
 * Controlled-Z (CZ) quantum gate.
 *
 * <p>
 * A two-qubit gate that applies a phase flip (Z gate) to the target qubit if the control qubit
 * is |1⟩. Equivalently, it applies a -1 phase if both qubits are |1⟩. The gate matrix is diagonal:
 * </p>
 *
 * <pre>
 * [1  0  0   0 ]
 * [0  1  0   0 ]
 * [0  0  1   0 ]
 * [0  0  0  -1 ]
 * </pre>
 */
public final class CZGate extends TwoQubitGate {

    public CZGate() {
        super(new Complex[][] { { Complex.ONE, Complex.ZERO, Complex.ZERO, Complex.ZERO },
                { Complex.ZERO, Complex.ONE, Complex.ZERO, Complex.ZERO },
                { Complex.ZERO, Complex.ZERO, Complex.ONE, Complex.ZERO },
                { Complex.ZERO, Complex.ZERO, Complex.ZERO, new Complex(-1, 0) } });
    }

    @Override
    public String name() {
        return "cz";
    }
}
