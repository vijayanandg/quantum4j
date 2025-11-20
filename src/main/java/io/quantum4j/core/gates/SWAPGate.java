package io.quantum4j.core.gates;

import io.quantum4j.core.math.Complex;

/**
 * SWAP quantum gate.
 *
 * <p>
 * A two-qubit gate that exchanges the states of two qubits. The gate permutes basis states as:
 * |00⟩ → |00⟩, |01⟩ → |10⟩, |10⟩ → |01⟩, |11⟩ → |11⟩. The SWAP gate matrix is:
 * </p>
 *
 * <pre>
 * [1  0  0  0]
 * [0  0  1  0]
 * [0  1  0  0]
 * [0  0  0  1]
 * </pre>
 */
public final class SWAPGate extends TwoQubitGate {

    public SWAPGate() {
        super(new Complex[][] { { Complex.ONE, Complex.ZERO, Complex.ZERO, Complex.ZERO },
                { Complex.ZERO, Complex.ZERO, Complex.ONE, Complex.ZERO },
                { Complex.ZERO, Complex.ONE, Complex.ZERO, Complex.ZERO },
                { Complex.ZERO, Complex.ZERO, Complex.ZERO, Complex.ONE } });
    }

    @Override
    public String name() {
        return "swap";
    }
}
