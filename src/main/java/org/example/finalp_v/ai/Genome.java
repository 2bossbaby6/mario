/*
package org.example.finalp_v.ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Genome {
    List<Gene> genes;
    double fitness;
    double adjustedFitness;
    Map<Integer, Neuron2> network;
    int maxneuron;
    int globalRank;
    Map<String, Double> mutationRates;

    public Genome() {
        genes = new ArrayList<>();
        fitness = 0;
        adjustedFitness = 0;
        network = new HashMap<>();
        maxneuron = 0;
        globalRank = 0;
        mutationRates = new HashMap<>();
        initializeMutationRates();
    }

    private void initializeMutationRates() {
        mutationRates.put("connections", MarIO.MUTATE_CONNECTIONS_CHANCE);
        mutationRates.put("link", MarIO.LINK_MUTATION_CHANCE);
        mutationRates.put("bias", MarIO.BIAS_MUTATION_CHANCE);
        mutationRates.put("node", MarIO.NODE_MUTATION_CHANCE);
        mutationRates.put("enable", MarIO.ENABLE_MUTATION_CHANCE);
        mutationRates.put("disable", MarIO.DISABLE_MUTATION_CHANCE);
        mutationRates.put("step", MarIO.STEP_SIZE);
    }
}
*/