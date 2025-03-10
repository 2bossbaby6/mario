package org.example.finalp_v.ai;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


class NEATVisualizer {
    public static void drawNetwork(GraphicsContext gc, Genome2 genome, int x, int y) {
        gc.setFill(Color.BLACK);
        for (Neuron2 n : genome.nodes) {
            gc.fillOval(x + n.id * 20, y, 10, 10);
        }
        gc.setStroke(Color.RED);
        for (Connection c : genome.connections) {
            if (c.enabled) {
                gc.strokeLine(x + c.fromNode * 20, y, x + c.toNode * 20, y + 20);
            }
        }
    }
}
