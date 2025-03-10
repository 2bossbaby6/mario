package org.example.finalp_v.game;

import org.example.finalp_v.ai.Genome2;

import java.util.ArrayList;
import java.util.List;

class Leaderboard {
    private List<Genome2> bestGenomes = new ArrayList<>();

    public void add(Genome2 genome) {
        bestGenomes.add(genome);
    }

    public List<Genome2> getTopGenomes() {
        return bestGenomes.subList(0, Math.min(10, bestGenomes.size()));
    }
}
