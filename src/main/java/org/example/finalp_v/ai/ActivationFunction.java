package org.example.finalp_v.ai;

class ActivationFunction {
    public static double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public static double tanh(double x) {
        return Math.tanh(x);
    }

    public static double relu(double x) {
        return Math.max(0, x);
    }
}
