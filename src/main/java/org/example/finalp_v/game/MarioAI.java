package org.example.finalp_v.game;

import org.example.finalp_v.ai.Genome2;
import org.example.finalp_v.ai.NeuralNetwork;
import org.example.finalp_v.utils.Mario;

class MarioAI {
    Mario mario;
    NeuralNetwork brain;

    public MarioAI(Mario mario, Genome2 genome) {
        this.mario = mario;
        this.brain = new NeuralNetwork(genome);
    }

    public void update() {
        double[] inputs = {mario.x, mario.y};
        double[] outputs = brain.evaluate(inputs);

        if (outputs[0] > 0.5) mario.moveRight();
        if (outputs[1] > 0.5) mario.jump();
    }
}
