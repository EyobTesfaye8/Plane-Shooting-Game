package com.planeshootinggame.UI.overlays;

import javafx.scene.control.Label;

public class HUD {

    public static Label scoreLabel;
    public static Label healthLabel;

    private static int score = 0;
    private static int lives = 3;
    private static boolean paused = false;

    public static void addScore(int amount) {
        // score += amount;
        scoreLabel.setText("Score: " + amount);
    }

    public static void damage() {
        lives-=1;
        healthLabel.setText("Lives: " + lives);
    } 
    public static void heal() {
        lives+=1;
        healthLabel.setText("Lives: " + lives);
    }

    public static void togglePause() {
        paused = !paused;
    }
    public static void pause() {
        paused = true;
    }
    public static void resume() {
        paused = false;
    }

    public static boolean isPaused() {
        return paused;
    }
}
