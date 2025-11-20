package io.quantum4j.core.gates;

import io.quantum4j.core.math.Complex;

/**
 * Rotation around the Z-axis (Rz(θ)) quantum gate.
 *
 * <p>
 * Performs a parameterized rotation of θ radians around the Z-axis of the Bloch sphere.
 * The gate matrix is:
 * </p>
 *
 * <pre>
 * [e^(-i*θ/2)      0     ]
 * [    0      e^(i*θ/2) ]
 * </pre>
 */
public final class RZGate extends SingleQubitGate {

    private final double theta;

    public RZGate(double theta) {
        super(createMatrix(theta));
        this.theta = theta;
    }

    public double getTheta() {
        return theta;
    }

    @Override
    public String name() {
        return "rz";
    }

    private static Complex[][] createMatrix(double theta) {
        double half = theta / 2;
        Complex eNeg = new Complex(Math.cos(-half), Math.sin(-half));
        Complex ePos = new Complex(Math.cos(half), Math.sin(half));

        return new Complex[][] { { eNeg, Complex.ZERO }, { Complex.ZERO, ePos } };
    }
}
