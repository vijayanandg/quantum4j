package io.quantum4j.core.gates;

import io.quantum4j.core.math.Complex;

/**
 * Controlled Hadamard (CH) quantum gate.
 *
 * <p>
 * A two-qubit gate where the target qubit undergoes a Hadamard transformation if the control
 * qubit is |1⟩. The gate matrix in the computational basis {|00⟩, |01⟩, |10⟩, |11⟩} is:
 * </p>
 *
 * <pre>
 * [1  0  0   0  ]
 * [0  1  0   0  ]
 * [0  0  H[0][0] H[0][1]]
 * [0  0  H[1][0] H[1][1]]
 * </pre>
 *
 * <p>
 * where H is the Hadamard matrix.
 * </p>
 */
public final class CHGate extends TwoQubitGate {

    public CHGate() {
        super(new Complex[][] { { Complex.ONE, Complex.ZERO, Complex.ZERO, Complex.ZERO },
                { Complex.ZERO, Complex.ONE, Complex.ZERO, Complex.ZERO },
                { Complex.ZERO, Complex.ZERO, GateMatrices.H[0][0], GateMatrices.H[0][1] },
                { Complex.ZERO, Complex.ZERO, GateMatrices.H[1][0], GateMatrices.H[1][1] } });
    }

    @Override
    public String name() {
        return "ch";
    }
}
