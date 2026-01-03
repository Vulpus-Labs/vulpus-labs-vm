package com.vulpuslabs.modules.piezo;

/**
 * Linear Feedback Shift Register (LFSR) for pseudo-random noise generation.
 * Uses a 16-bit Galois LFSR with polynomial x^16 + x^14 + x^13 + x^11 + 1.
 * This creates a maximal-length sequence of 65,535 states before repeating.
 */
public class LFSR {

    private static final int POLYNOMIAL = 0xB400;  // Taps at bits 15, 13, 12, 10

    private int register;
    private boolean output;

    public LFSR() {
        this(0x1234);  // Default seed
    }

    public LFSR(int seed) {
        this.register = seed & 0xFFFF;
        this.output = (register & 1) == 1;
    }

    /**
     * Clock the LFSR forward one step, generating the next pseudo-random bit.
     */
    public void clock() {
        int lsb = register & 1;
        register >>= 1;
        if (lsb == 1) {
            register ^= POLYNOMIAL;
        }
    }

    /**
     * Get the current output bit.
     * @return true for 1, false for 0
     */
    public boolean getBoolean() {
        return (register & 1) == 1;
    }

    public byte getNextByte() {
        clock();
        return (byte) (register & 0xFF);
    }

    /**
     * Reset the LFSR to a specific seed value.
     * @param seed the seed value (will be masked to 16 bits)
     */
    public void reset(int seed) {
        this.register = seed & 0xFFFF;
        this.output = (register & 1) == 1;
    }
}
