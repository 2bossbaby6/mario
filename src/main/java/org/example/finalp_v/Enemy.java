package org.example.finalp_v;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Enemy class represents the enemies in the game.
 */
public class Enemy {
    private int x, y;
    private int dx;
    private Image enemyImage;

    public Enemy(int x, int y, String imagePath) {
        this.x = x;
        this.y = y;
        this.dx = -1; // Move left by default
        loadImage(imagePath);
    }

    private void loadImage(String imagePath) {
        // Load the enemy image from the specified path
        ImageIcon icon = new ImageIcon(imagePath);
        enemyImage = icon.getImage();
    }

    public void draw(Graphics g, int cameraX) {
        // Draw the enemy image at the current position adjusted by the camera position
        g.drawImage(enemyImage, x - cameraX, y, null);
    }

    public void update() {
        // Update the enemy position based on the current velocity
        x += dx;
    }

    public java.awt.Rectangle getBounds() {
        // Get the bounding box for the enemy
        return new java.awt.Rectangle(x, y, enemyImage.getWidth(null), enemyImage.getHeight(null));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}