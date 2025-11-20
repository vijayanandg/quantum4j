package io.quantum4j.core.backend;

/**
 * Configuration for quantum circuit execution.
 * <p>
 * Specifies execution parameters such as the number of measurement shots (repeated circuit runs) to collect statistics
 * on measurement outcomes.
 * </p>
 */
public final class RunOptions {
    private final int shots;

    private RunOptions(int shots) {
        if (shots <= 0)
            throw new IllegalArgumentException("shots must be > 0");
        this.shots = shots;
    }

    /**
     * Create RunOptions with the specified number of shots.
     *
     * @param shots
     *            number of times to measure the circuit (must be &gt; 0)
     *
     * @return RunOptions configured with the given shot count
     *
     * @throws IllegalArgumentException
     *             if shots &lt;= 0
     */
    public static RunOptions shots(int shots) {
        return new RunOptions(shots);
    }

    /**
     * Get the number of shots for this execution.
     *
     * @return the shot count
     */
    public int getShots() {
        return shots;
    }
}
