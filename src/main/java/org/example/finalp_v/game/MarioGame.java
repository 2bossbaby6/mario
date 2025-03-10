/*
package org.example.finalp_v.game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import org.example.finalp_v.ai.NEAT;
import org.example.finalp_v.ai.Genome2;
import org.example.finalp_v.utils.Mario;



import java.util.*;

public class MarioGame extends Application {
    Mario mario = new Mario();
    NEAT neat = new NEAT(50);
    List<MarioAI> agents = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(800, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        for (Genome2 g : neat.population) {
            agents.add(new MarioAI(new Mario(), g));
        }

        new AnimationTimer() {
            public void handle(long now) {
                update();
                draw(gc);
            }
        }.start();

        primaryStage.setScene(new Scene(new javafx.scene.layout.Pane(canvas)));
        primaryStage.show();
    }

    private void update() {
        for (MarioAI ai : agents) {
            ai.update();
            ai.mario.update();
        }
    }

    private void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, 800, 400);
        gc.setFill(Color.BLUE);
        for (MarioAI ai : agents) {
            gc.fillRect(ai.mario.x, ai.mario.y, 20, 20);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


*/