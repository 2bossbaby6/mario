package org.example.finalp_v.ai;

import java.util.*;

public class Genome2 {
    List<Neuron2> nodes = new ArrayList<>();
    List<Connection> connections = new ArrayList<>();
    int fitness;

    public void mutate() {
        if (Math.random() < 0.8) mutateWeights();
        if (Math.random() < 0.1) addNode();
        if (Math.random() < 0.1) addConnection();
    }

    private void mutateWeights() {
        for (Connection c : connections) {
            if (Math.random() < 0.9) c.weight += Math.random() * 0.2 - 0.1;
            else c.weight = Math.random() * 2 - 1;
        }
    }

    private void addNode() {
        if (connections.isEmpty()) return;
        Connection c = connections.get((int) (Math.random() * connections.size()));
        c.enabled = false;
        int newId = nodes.size();
        Neuron2 newNode = new Neuron2(newId, false, false);
        nodes.add(newNode);
        connections.add(new Connection(c.fromNode, newId, 1.0, c.innovationNumber + 1));
        connections.add(new Connection(newId, c.toNode, c.weight, c.innovationNumber + 2));
    }

    private void addConnection() {
        int a = (int) (Math.random() * nodes.size());
        int b = (int) (Math.random() * nodes.size());
        connections.add(new Connection(a, b, Math.random() * 2 - 1, connections.size() + 1));
    }

    public double calculateFitness() {
        return fitness; // Fitness function will be implemented in Mario simulation
    }
}

