package org.example.finalp_v;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * GamePanel class handles the game loop and rendering.
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Image backgroundImage;
    private Image gameOverImage;
    private Player player;
    private Timer timer;
    private Platform[] platforms;
    private Floor floor;
    private List<Enemy> enemies;
    private int cameraX;
    private int backgroundWidth;
    private int backgroundHeight;
    private boolean isGameOver;
    private Set<Integer> keysPressed;

    public GamePanel() {
        // Set the panel to be focusable and add key listener
        this.setFocusable(true);
        this.addKeyListener(this);

        // Load the images
        loadImage();

        // Create the player object
        player = new Player(400, 100, this); // Start player in the center of the screen

        // Create platforms for the level
        platforms = createPlatforms();

        // Create the floor for the level
        floor = new Floor(0, 500, 800, 100);

        // Create enemies for the level
        enemies = createEnemies();

        // Initialize and start the timer for the game loop
        timer = new Timer(16, this); // Approximately 60 frames per second
        timer.start();

        // Initialize the set to keep track of keys pressed
        keysPressed = new HashSet<>();
    }

    private void loadImage() {
        // Load the background image from the resources folder
        ImageIcon bgIcon = new ImageIcon("C:\\Users\\Matan\\IdeaProjects\\finalp_v\\src\\main\\java\\org\\example\\finalp_v\\media\\background.png");
        backgroundImage = bgIcon.getImage();
        // Set the background size
        backgroundWidth = backgroundImage.getWidth(null);
        backgroundHeight = backgroundImage.getHeight(null);

        // Load the game over image from the resources folder
        ImageIcon goIcon = new ImageIcon("C:\\Users\\Matan\\IdeaProjects\\finalp_v\\src\\main\\java\\org\\example\\finalp_v\\media\\game-over.png");
        gameOverImage = goIcon.getImage();
    }

    private Platform[] createPlatforms() {
        // Add platforms for the level
        return new Platform[]{
                new Platform(50, 400, 200, 10),
                new Platform(300, 300, 200, 10),
                new Platform(550, 200, 200, 10),
                new Platform(800, 400, 200, 10),
                new Platform(1050, 300, 200, 10),
                new Platform(1300, 200, 200, 10),
                new Platform(1550, 400, 200, 10),
                new Platform(1800, 300, 200, 10)
        };
    }

    private List<Enemy> createEnemies() {
        // Add enemies for the level
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(600, 450, "C:\\Users\\Matan\\IdeaProjects\\finalp_v\\src\\main\\java\\org\\example\\finalp_v\\media\\heart-icon.png"));
        enemies.add(new Enemy(900, 350, "C:\\Users\\Matan\\IdeaProjects\\finalp_v\\src\\main\\java\\org\\example\\finalp_v\\media\\heart-icon.png"));
        enemies.add(new Enemy(1200, 450, "C:\\Users\\Matan\\IdeaProjects\\finalp_v\\src\\main\\java\\org\\example\\finalp_v\\media\\heart-icon.png"));
        enemies.add(new Enemy(1500, 350, "C:\\Users\\Matan\\IdeaProjects\\finalp_v\\src\\main\\java\\org\\example\\finalp_v\\media\\heart-icon.png"));
        enemies.add(new Enemy(1800, 450, "C:\\Users\\Matan\\IdeaProjects\\finalp_v\\src\\main\\java\\org\\example\\finalp_v\\media\\heart-icon.png"));
        return enemies;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        g.drawImage(backgroundImage, -cameraX % backgroundWidth, 0, backgroundWidth, backgroundHeight, null);
        if (cameraX % backgroundWidth > 0) {
            g.drawImage(backgroundImage, -cameraX % backgroundWidth + backgroundWidth, 0, backgroundWidth, backgroundHeight, null);
        }

        // Draw the player
        player.draw(g, cameraX);

        // Draw all platforms
        for (Platform platform : platforms) {
            platform.draw(g, cameraX);
        }

        // Draw the infinite floor
        floor.draw(g, cameraX);

        // Draw all enemies
        for (Enemy enemy : enemies) {
            enemy.draw(g, cameraX);
        }

        // Draw the game over screen if the player is dead
        if (isGameOver) {
            g.drawImage(gameOverImage, 200, 150, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            // Update the player and repaint the panel
            player.update(platforms, floor, enemies, keysPressed);
            for (Enemy enemy : enemies) {
                enemy.update();
            }
            updateCamera();
        }
        repaint();
    }

    private void updateCamera() {
        // Center the camera on the player
        cameraX = player.getX() - 400; // 400 is half the screen width
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Add the key to the set of pressed keys
        keysPressed.add(e.getKeyCode());
        // Check if the Enter key is pressed to restart the game
        if (isGameOver && e.getKeyCode() == KeyEvent.VK_ENTER) {
            restartGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Remove the key from the set of pressed keys
        keysPressed.remove(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    public void gameOver() {
        isGameOver = true;
        player.setAlive(false);
    }

    public void restartGame() {
        isGameOver = false;
        player = new Player(400, 100, this); // Reset the player
        platforms = createPlatforms(); // Reset the platforms
        floor = new Floor(0, 500, 800, 100); // Reset the floor
        enemies = createEnemies(); // Reset the enemies
    }

    public Player getPlayer() {
        return player;
    }

    public Platform[] getPlatforms() {
        return platforms;
    }

    public Floor getFloor() {
        return floor;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}