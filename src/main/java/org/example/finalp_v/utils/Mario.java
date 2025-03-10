package org.example.finalp_v.utils;

public class Mario {
    public int x;
    public int y;
    int velocityX;
    int velocityY;
    boolean isJumping;

    public Mario() {
        this.x = 50;
        this.y = 300;
    }

    public void moveLeft() { velocityX = -2; }
    public void moveRight() { velocityX = 2; }
    public void jump() { if (!isJumping) { velocityY = -5; isJumping = true; } }

    public void update() {
        x += velocityX;
        y += velocityY;
        velocityY += 1; // Gravity
        if (y > 300) { y = 300; isJumping = false; }
    }
}
