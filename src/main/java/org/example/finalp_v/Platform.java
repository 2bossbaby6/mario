package org.example.finalp_v;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Platform class represents the platforms in the game.
 */
public class Platform {
    private int x, y, width, height;

    public Platform(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g, int cameraX) {
        // Draw the platform as a gray rectangle adjusted by the camera position
        g.setColor(Color.GRAY);
        g.fillRect(x - cameraX, y, width, height);
    }

    public Rectangle getBounds() {
        // Get the bounding box for the platform
        return new Rectangle(x, y, width, height);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}