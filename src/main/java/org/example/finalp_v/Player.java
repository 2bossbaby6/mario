package org.example.finalp_v;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Player class handles the player character's movements and collisions.
 */
public class Player {
    private int x, y;
    private int dx, dy;
    private Image playerImage;
    private boolean onGround;
    private boolean alive;
    private GamePanel gamePanel;

    public Player(int x, int y, GamePanel gamePanel) {
        this.x = x;
        this.y = y;
        this.onGround = false;
        this.alive = true;
        this.gamePanel = gamePanel;
        loadImage();
    }

    private void loadImage() {
        // Load the player image from the resources folder
        ImageIcon icon = new ImageIcon("C:\\Users\\Matan\\IdeaProjects\\finalp_v\\src\\main\\java\\org\\example\\finalp_v\\media\\select-icon.png");
        playerImage = icon.getImage();
    }

    public void draw(Graphics g, int cameraX) {
        // Draw the player image at the current position adjusted by the camera position
        if (alive) {
            g.drawImage(playerImage, x - cameraX, y, null);
        }
    }

    public void update(Platform[] platforms, Floor floor, List<Enemy> enemies, Set<Integer> keysPressed) {
        if (!alive) return;

        // Update the player's movement based on key presses
        if (keysPressed.contains(KeyEvent.VK_LEFT)) {
            dx = -2;
        } else if (keysPressed.contains(KeyEvent.VK_RIGHT)) {
            dx = 2;
        } else {
            dx = 0;
        }

        if (keysPressed.contains(KeyEvent.VK_UP) && onGround) {
            dy = -10; // Jump
            onGround = false;
        }

        // Update the player position based on the current velocity
        x += dx;
        y += dy;

        // Apply gravity if the player is not on the ground
        if (!onGround) {
            dy += 1;
        }

        // Check for collisions with platforms, floor, and enemies
        checkCollision(platforms, floor, enemies);

        // Keep the player within the screen bounds
        if (x < 100) {
            x = 100;
        }
    }

    private void checkCollision(Platform[] platforms, Floor floor, List<Enemy> enemies) {
        onGround = false;
        for (Platform platform : platforms) {
            if (getBounds().intersects(platform.getBounds()) && dy >= 0) {
                // Adjust the player's position to be on top of the platform
                y = platform.getY() - getHeight();
                dy = 0;
                onGround = true;
            }
        }
        if (dy >= 0) {
            int floorY = floor.getY();
            if (y + getHeight() > floorY) {
                y = floorY - getHeight();
                dy = 0;
                onGround = true;
            }
        }
        Iterator<Enemy> iterator = enemies.iterator();
        while (iterator.hasNext()) {
            Enemy enemy = iterator.next();
            if (getBounds().intersects(enemy.getBounds())) {
                if (dy > 0) {
                    // Kill the enemy if the player is falling
                    iterator.remove();
                    dy = -10; // Bounce up after killing the enemy
                } else {
                    // Die if the player hits the enemy from the sides or bottom
                    alive = false;
                    gamePanel.gameOver();
                }
            }
        }
    }

    public java.awt.Rectangle getBounds() {
        // Get the bounding box for the player
        return new java.awt.Rectangle(x, y, playerImage.getWidth(null), playerImage.getHeight(null));
    }

    public int getHeight() {
        return playerImage.getHeight(null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}