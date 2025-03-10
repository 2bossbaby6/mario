package org.example.finalp_v.ai;

class Evolution {
    public static void mutate(Genome2 genome) {
        for (Connection c : genome.connections) {
            c.weight += (Math.random() * 0.2) - 0.1; // Small weight changes
        }
    }
}
