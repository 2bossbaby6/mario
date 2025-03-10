package org.example.finalp_v.utils;

class Enemy {
    int x, y, velocityX;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.velocityX = -1;
    }

    public void update() {
        x += velocityX;
    }
}
