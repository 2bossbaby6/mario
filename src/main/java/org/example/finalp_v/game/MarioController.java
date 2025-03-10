package org.example.finalp_v.game;

import org.example.finalp_v.ai.Genome2;
import org.example.finalp_v.utils.Mario;

class MarioController {
    Mario mario;
    Genome2 genome;

    public MarioController(Mario mario, Genome2 genome) {
        this.mario = mario;
        this.genome = genome;
    }

    public void update() {
        double[] inputs = {mario.x, mario.y};
        double[] outputs = genome.calculateFitness() > 0.5 ? new double[]{1, 0} : new double[]{0, 1};

        if (outputs[0] > 0.5) mario.moveRight();
        if (outputs[1] > 0.5) mario.jump();
    }
}
