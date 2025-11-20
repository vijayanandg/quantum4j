package io.quantum4j.core.gates;

import io.quantum4j.core.math.Complex;

/**
 * iSWAP (imaginary SWAP) quantum gate.
 *
 * <p>
 * A two-qubit gate that swaps the states of two qubits and applies an imaginary phase (i) to
 * the |01⟩ and |10⟩ basis states. The iSWAP gate is useful for implementing quantum interactions
 * and is commonly used in superconducting qubit architectures.
 * </p>
 */
public final class ISWAPGate extends TwoQubitGate {

    private static Complex C(double r) {
        return new Complex(r, 0);
    }

    private static Complex CI(double r) {
        return new Complex(0, r); // imaginary amplitude
    }

    public ISWAPGate() {
        super(new Complex[][] {

                // |00>, |01>, |10>, |11>
                { C(1), C(0), C(0), C(0) }, { C(0), C(0), CI(1), C(0) }, { C(0), CI(1), C(0), C(0) },
                { C(0), C(0), C(0), C(1) } });
    }

    @Override
    public String name() {
        return "iswap";
    }
}
