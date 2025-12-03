package com.planeshootinggame;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GameEngine extends App{
    private Pane root;
    private AnimationTimer timer;
    private Player player;
    private BulletManager bullets;
    private EnemyManager enemies;
    private PowerupManager powerups;
    private boolean left, right, up, down;
    private Text scoreText;
    private int score = 0;
    private boolean gameOver = false;

    public GameEngine(Pane root) {
        this.root = root;
        bullets = new BulletManager(root);
        enemies = new EnemyManager(root);
        powerups = new PowerupManager(root);
        scoreText = new Text(10, 20, "Score: 0");
        root.getChildren().add(scoreText);
    }

    public void startGame() {
       
    }

    private void update() {

    }

    private void checkCollisions() {
        // bullets vs enemies
        // enemies vs player
        // player vs powerups
    }

    private void render() {

    }
}