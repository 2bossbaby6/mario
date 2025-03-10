package org.example.finalp_v.game;

import org.example.finalp_v.game.Level;
import org.example.finalp_v.utils.Mario;

class CollisionHandler {
    public static boolean isColliding(Mario mario, Level level) {
        return level.getTile(mario.x, mario.y) == 1;
    }
}

