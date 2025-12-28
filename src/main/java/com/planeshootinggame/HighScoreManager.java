package com.planeshootinggame;

import java.io.*;
// import java.util.*;

public class HighScoreManager {

    private static final String FILE_NAME = "highscore.txt";

    // Default scores (used if file doesn't exist)
    private static int[] scores = {0, 0, 0};

    // Load scores from file
    public static void loadScores() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            saveScores(); 
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < scores.length; i++) {
                String line = reader.readLine();
                if (line != null) {
                    scores[i] = Integer.parseInt(line);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Failed to load high scores");
        }
    }

    // Save scores to file
    public static void saveScores() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (int score : scores) {
                writer.println(score);
            }
        } catch (IOException e) {
            System.out.println("Failed to save high scores");
        }
    }

    // Get scores
    public static int[] getScores() {
        return scores;
    }

    // Update scores (call after a game ends)
    public static void submitScore(int newScore) {
        for (int i = 0; i < scores.length; i++) {
            if (newScore > scores[i]) {
                for (int j = scores.length - 1; j > i; j--) {
                    scores[j] = scores[j - 1];
                }
                scores[i] = newScore;
                break;
            }
        }
        saveScores();
    }
}
