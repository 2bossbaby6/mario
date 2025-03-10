/*
package org.example.finalp_v.ai;

import java.util.*;

public class NEAT {
    public List<Genome2> population = new ArrayList<>();
    List<Species> species = new ArrayList<>();
    int generation = 0;

    public NEAT(int size) {
        for (int i = 0; i < size; i++) {
            population.add(new Genome2());
        }
    }

    public void evolve() {
        for (Genome2 g : population) g.calculateFitness();
        speciate();
        reproduce();
        generation++;
    }

    private void speciate() {
        species.clear();
        for (Genome2 g : population) {
            boolean found = false;
            for (Species s : species) {
                if (s.representative.calculateFitness() - g.calculateFitness() < 5) {
                    s.addMember(g);
                    found = true;
                    break;
                }
            }
            if (!found) {
                Species newSpecies = new Species();
                newSpecies.representative = g;
                newSpecies.addMember(g);
                species.add(newSpecies);
            }
        }
    }

    private void reproduce() {
        List<Genome2> newGeneration = new ArrayList<>();
        for (Species s : species) {
            for (Genome2 g : s.members) {
                Genome2 offspring = new Genome2();
                offspring.mutate();
                newGeneration.add(offspring);
            }
        }
        population = newGeneration;
    }
}

*/