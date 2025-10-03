# Distributor

## Overview
Distributor generates random gate signals following a binomial distribution by propagating a trigger along a tree of branching pathways, like a Galton board. At each branch/leaf, a gate signal is emitted if the trigger reaches it. Branch probabilities are controllable, with optional delay and jitter for both gate length and propagation timing.

## How It Works
When triggered, a signal propagates through a binary tree structure (5 rows: 0→1→2→3→4). At each branch, the trigger randomly follows either the "high" or "low" path based on controllable probability.

**Tree structure:**
- Row 0: Single root gate (always triggered)
- Row 1: 2 gates (1.1, 1.2)
- Row 2: 3 gates (2.1, 2.2, 2.3)
- Row 3: 4 gates (3.1, 3.2, 3.3, 3.4)
- Row 4: 5 gates (4.1, 4.2, 4.3, 4.4, 4.5)

With "fair" 50/50 probabilities, middle gates triggered more often (binomial distribution).

Gates can be delayed before propagation, with jitter applied to both gate length and delay time.

## Key Controls
- **TRIG IN**: Trigger input (positive voltage crossing)
- **Gate outputs**: One for each position in tree (0, 1.1, 1.2, 2.1-2.3, 3.1-3.4, 4.1-4.5)
- **Probability knobs**: Between each pair of gates, controls high/low path probability
- **GATE LEN**: Gate duration (up to 1s)
- **DELAY LEN**: Propagation delay between rows (up to 1s)
- **GATE JIT**: Random variation in gate length
- **DELAY JIT**: Random variation in delay time
- **Range switch**: Sets maximum gate/delay length

## Implementation Notes
- LEDs light up when gates fire, visualizing trigger path
- At DELAY LEN = 0, entire path fires instantaneously
- With delay > 0, trigger "travels" visibly across board
- Fair 50/50 probabilities create classic bell curve distribution on row 4
- Inspired by 1980s BBC Micro Galton Board program
- Useful for generative/probabilistic sequencing
