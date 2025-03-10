package org.example.finalp_v.ai;

public class Neuron2 {
    int id;
    double value;
    double bias;
    boolean isInput, isOutput;

    public Neuron2(int id, boolean isInput, boolean isOutput) {
        this.id = id;
        this.isInput = isInput;
        this.isOutput = isOutput;
        this.bias = Math.random() * 2 - 1; // Random bias between -1 and 1
    }
}

