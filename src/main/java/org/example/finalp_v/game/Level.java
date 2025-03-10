package org.example.finalp_v.game;

public class Level {
    private int[][] tiles;
    private int width, height;
    private int obstaclesCleared = 0;

    public static final int EMPTY = 0;
    public static final int GROUND = 1;
    public static final int PIPE = 2;
    public static final int ENEMY = 3;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new int[width][height];
        generateLevel();
    }

    private void generateLevel() {
        for (int x = 0; x < width; x++) {
            tiles[x][height - 1] = GROUND; // Ground at the bottom
        }
        tiles[5][height - 2] = PIPE;
        tiles[10][height - 2] = ENEMY;
    }

    // Called when Mario successfully passes an obstacle
    public void obstacleCleared() {
        obstaclesCleared++;
    }

    // Returns the number of obstacles Mario has cleared
    public int getObstaclesCleared() {
        return obstaclesCleared;
    }
    // Get the tile type at (x, y)
    public int getTile(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) return GROUND; // Out of bounds = solid
        return tiles[x][y];
    }
}


