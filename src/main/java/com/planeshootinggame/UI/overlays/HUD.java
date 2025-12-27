package com.planeshootinggame.UI.overlays;

import javafx.scene.control.Label;

public class HUD {

    public static Label scoreLabel;
    public static Label healthLabel;
    // public static Label pauseLabel;

    private static int score = 0;
    private static int health = 100;
    private static boolean paused = false;

    public static void addScore(int amount) {
        score += amount;
        scoreLabel.setText("Score: " + score);
    }

    public static void damage(int amount) {
        health -= amount;
        if (health < 0) health = 0;
        healthLabel.setText("Lives: " + health);
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
