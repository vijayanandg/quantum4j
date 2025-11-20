package io.quantum4j.core.gates;

import io.quantum4j.core.math.Complex;

/**
 * Rotation around the Y-axis (Ry(θ)) quantum gate.
 *
 * <p>
 * Performs a parameterized rotation of θ radians around the Y-axis of the Bloch sphere.
 * The gate matrix is:
 * </p>
 *
 * <pre>
 * [cos(θ/2)  -sin(θ/2)]
 * [sin(θ/2)   cos(θ/2)]
 * </pre>
 */
public final class RYGate extends SingleQubitGate {

    private final double theta;

    public RYGate(double theta) {
        super(createMatrix(theta));
        this.theta = theta;
    }

    public double getTheta() {
        return theta;
    }

    @Override
    public String name() {
        return "ry";
    }

    private static Complex[][] createMatrix(double theta) {
        double ct = Math.cos(theta / 2);
        double st = Math.sin(theta / 2);

        return new Complex[][] { { new Complex(ct, 0), new Complex(-st, 0) },
                { new Complex(st, 0), new Complex(ct, 0) } };
    }
}
