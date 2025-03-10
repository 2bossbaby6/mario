package org.example.finalp_v;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Floor class represents the floor in the game.
 */
public class Floor {
    private int x, y, width, height;

    public Floor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g, int cameraX) {
        // Draw the floor as a green rectangle adjusted by the camera position
        g.setColor(new Color(0, 255, 0, 128)); // Green color with 50% transparency
        for (int i = -cameraX; i < 800 + width; i += width) {
            g.fillRect(i, y, width, height);
        }
    }

    public Rectangle getBounds() {
        // Get the bounding box for the floor
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