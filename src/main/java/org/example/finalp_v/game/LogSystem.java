package org.example.finalp_v.game;

import java.io.FileWriter;
import java.io.IOException;

class LogSystem {
    public static void log(String message) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
