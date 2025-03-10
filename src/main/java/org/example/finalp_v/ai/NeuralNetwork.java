package org.example.finalp_v.ai;

import java.util.Map;
import java.util.HashMap;

public class NeuralNetwork {
    Genome2 genome;

    public NeuralNetwork(Genome2 genome) {
        this.genome = genome;
    }

    public double[] evaluate(double[] inputs) {
        Map<Integer, Double> neuronValues = new HashMap<>();
        for (Neuron2 n : genome.nodes) {
            if (n.isInput) neuronValues.put(n.id, inputs[n.id]);
            else neuronValues.put(n.id, 0.0);
        }

        for (Connection c : genome.connections) {
            if (c.enabled) {
                neuronValues.put(c.toNode, neuronValues.get(c.toNode) + neuronValues.get(c.fromNode) * c.weight);
            }
        }

        for (Neuron2 n : genome.nodes) {
            if (n.isOutput) {
                neuronValues.put(n.id, ActivationFunction.sigmoid(neuronValues.get(n.id)));
            }
        }

        return neuronValues.values().stream().mapToDouble(Double::doubleValue).toArray();
    }
}
