package org.example.finalp_v.ai;

import org.example.finalp_v.game.Level;
import org.example.finalp_v.utils.Mario;

class FitnessFunction {
    public static double evaluate(Mario mario, Level level) {
        return mario.x - (level.getObstaclesCleared() * 10);
    }
}

