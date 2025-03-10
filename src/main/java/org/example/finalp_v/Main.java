package org.example.finalp_v;

import javax.swing.JFrame;

/**
 * Main class to start the Mario game.
 */
public class Main {
    public static void main(String[] args) {
        // Create a new JFrame window for the game
        JFrame frame = new JFrame("Mario Game");

        // Create the game panel and add it to the frame
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        // Set default close operation, size, visibility, and resizability of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setResizable(false);

        // Start the map update and print loop
        new MapUpdater(gamePanel).start();
    }
}