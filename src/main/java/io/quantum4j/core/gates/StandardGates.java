package io.quantum4j.core.gates;

import io.quantum4j.core.math.Complex;

/**
 * Factory class providing standard single- and two-qubit gates.
 *
 * <p>
 * StandardGates contains inner classes for commonly used quantum gates:
 * </p>
 *
 * <ul>
 * <li><b>Pauli gates:</b> X (NOT), Y, Z</li>
 * <li><b>Hadamard:</b> H (superposition)</li>
 * <li><b>Rotations:</b> RX, RY, RZ</li>
 * <li><b>Two-qubit gates:</b> CNOT, CZ, SWAP, ISWAP</li>
 * <li><b>Three-qubit gates:</b> CCX (Toffoli)</li>
 * </ul>
 */
public final class StandardGates {

    private StandardGates() {
    }

    // ----------------------------------------------------------------------
    // Pauli Gates
    // ----------------------------------------------------------------------

    public static final class XGate extends SingleQubitGate {
        public XGate() {
            super(GateMatrices.X);
        }

        @Override
        public String name() {
            return "x";
        }
    }

    public static final class YGate extends SingleQubitGate {
        public YGate() {
            super(GateMatrices.Y);
        }

        @Override
        public String name() {
            return "y";
        }
    }

    public static final class ZGate extends SingleQubitGate {
        public ZGate() {
            super(GateMatrices.Z);
        }

        @Override
        public String name() {
            return "z";
        }
    }

    // ----------------------------------------------------------------------
    // Clifford Gates
    // ----------------------------------------------------------------------

    public static final class HGate extends SingleQubitGate {
        public HGate() {
            super(GateMatrices.H);
        }

        @Override
        public String name() {
            return "h";
        }
    }

    public static final class SGate extends SingleQubitGate {
        public SGate() {
            super(GateMatrices.S);
        }

        @Override
        public String name() {
            return "s";
        }
    }

    public static final class TGate extends SingleQubitGate {
        public TGate() {
            super(GateMatrices.T);
        }

        @Override
        public String name() {
            return "t";
        }
    }

    // ----------------------------------------------------------------------
    // Parameterized Rotation Gates
    // ----------------------------------------------------------------------

    public static final class RXGate extends SingleQubitGate {
        private final double theta;

        public RXGate(double theta) {
            super(GateMatrices.RX(theta));
            this.theta = theta;
        }

        public double getTheta() {
            return theta;
        }

        @Override
        public String name() {
            return "rx";
        }
    }

    public static final class RYGate extends SingleQubitGate {
        private final double theta;

        public RYGate(double theta) {
            super(GateMatrices.RY(theta));
            this.theta = theta;
        }

        public double getTheta() {
            return theta;
        }

        @Override
        public String name() {
            return "ry";
        }
    }

    public static final class RZGate extends SingleQubitGate {
        private final double theta;

        public RZGate(double theta) {
            super(GateMatrices.RZ(theta));
            this.theta = theta;
        }

        public double getTheta() {
            return theta;
        }

        @Override
        public String name() {
            return "rz";
        }
    }

    // ----------------------------------------------------------------------
    // 2-qubit gates
    // ----------------------------------------------------------------------

    public static final class CNOTGate extends TwoQubitGate {
        public CNOTGate() {
            super(GateMatrices.CNOT);
        }

        @Override
        public String name() {
            return "cx";
        }
    }

    public static final class CZGate extends TwoQubitGate {
        public CZGate() {
            super(GateMatrices.CZ);
        }

        @Override
        public String name() {
            return "cz";
        }
    }

    public static final class SWAPGate extends TwoQubitGate {
        public SWAPGate() {
            super(GateMatrices.SWAP);
        }

        @Override
        public String name() {
            return "swap";
        }
    }

    public static final class ISWAPGate extends TwoQubitGate {
        public ISWAPGate() {
            super(GateMatrices.ISWAP);
        }

        @Override
        public String name() {
            return "iswap";
        }
    }

    public static final class CHGate extends TwoQubitGate {
        public CHGate() {
            super(GateMatrices.CH);
        }

        @Override
        public String name() {
            return "ch";
        }
    }

    // ----------------------------------------------------------------------
    // 3-qubit gates
    // ----------------------------------------------------------------------

    public static final class CCXGate extends ThreeQubitGate {
        public CCXGate() {
            super(GateMatrices.CCX);
        }

        @Override
        public String name() {
            return "ccx";
        }
    }
}
