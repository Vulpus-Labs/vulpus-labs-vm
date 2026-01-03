package com.vulpuslabs.modules.piezo;

public enum MixMode {
    OR() {
        @Override
        public double mixVoices(boolean[] beeperStates, int interleaveSelector) {
            boolean beeperState = false;
            for (int i=0; i<4; i++) {
                beeperState = beeperState || beeperStates[i];
            }
            return beeperState ? 5.0 : 0.0;
        }
    },
    XOR() {
        @Override
        public double mixVoices(boolean[] beeperStates, int interleaveSelector) {
            boolean beeperState = false;
            for (int i=0; i<4; i++) {
                beeperState = beeperState ^ beeperStates[i];
            }
            return beeperState ? 5.0 : 0.0;
        }
    },
    INTERLEAVE() {
        @Override
        public double mixVoices(boolean[] beeperStates, int interleaveSelector) {
            return beeperStates[interleaveSelector] ? 5.0 : 0.0;
        }
    },
    QUAD() {
        @Override
        public double mixVoices(boolean[] beeperStates, int interleaveSelector) {
            double sum = 0.0;
            for (int i=0; i<4; i++) {
                sum += beeperStates[i] ? 1.25 : 0.0;
            }
            return sum;
        }
    };

    public abstract double mixVoices(boolean[] beeperStates, int interleaveSelector);
}
