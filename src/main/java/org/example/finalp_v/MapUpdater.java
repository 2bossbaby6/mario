package org.example.finalp_v;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * MapUpdater class handles updating and printing the game map.
 */
public class MapUpdater {
    private GamePanel gamePanel;
    private int[][] map;
    private int mapWidth;
    private int mapHeight;
    private Timer timer;

    public MapUpdater(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.mapWidth = 2000; // Set this to match your game world's width
        this.mapHeight = 600; // Set this to match your game world's height
        this.map = new int[mapHeight][mapWidth];
        this.timer = new Timer();
    }

    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateMap();
                printMap();
            }
        }, 0, 1000); // Update and print the map every second
    }

    private void updateMap() {
        // Clear the map
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                map[y][x] = 0;
            }
        }

        // Set the player position
        Player player = gamePanel.getPlayer();
        map[player.getY()][player.getX()] = 4;

        // Set the platforms positions
        for (Platform platform : gamePanel.getPlatforms()) {
            for (int x = platform.getX(); x < platform.getX() + platform.getWidth(); x++) {
                map[platform.getY()][x] = 1;
            }
        }

        // Set the floor positions
        Floor floor = gamePanel.getFloor();
        for (int x = floor.getX(); x < floor.getX() + floor.getWidth(); x++) {
            map[floor.getY()][x] = 2;
        }

        // Set the enemies positions
        for (Enemy enemy : gamePanel.getEnemies()) {
            map[enemy.getY()][enemy.getX()] = 3;
        }
    }

    private void printMap() {
        // Print the map to the console
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                System.out.print(map[y][x]);
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }
}