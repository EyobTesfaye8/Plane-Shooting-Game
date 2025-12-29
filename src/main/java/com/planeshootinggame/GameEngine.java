package com.planeshootinggame;

import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;

import com.planeshootinggame.EnemyTypes.*;
import com.planeshootinggame.PowerupTypes.*;
import com.planeshootinggame.UI.overlays.*;
import com.planeshootinggame.UI.screens.*;
import com.planeshootinggame.BulletTypes.*;

public class GameEngine extends App{
    private Pane root;
    private AnimationTimer timer;
    private Player player;
    private BulletManager playerBullets;
    private BulletManager enemyBullets;
    private EnemyManager enemies;
    private PowerupManager powerups;
    private int score = 0;
    private boolean timerRunning = false;
    private boolean left, right, up, down;
    private boolean gameOver, gamePaused;
    private long enemySpawnInterval =       2000000000L,    lastEnemySpawn = 0;
    private long playerImmunityInterval =   3000000000L,    lastImmunity = 0;
    private long playerShootInterval =      1500000000L,     lastShot = 0;
    private GameOver gameOverScene;

    public GameEngine(Pane root) {
        this.root = root;
        playerBullets = new BulletManager(root);
        enemyBullets = new BulletManager(root);
        enemies = new EnemyManager(root);
        powerups = new PowerupManager(root);
        pauseMenu = new GamePause();
        createHUD();
        initTimer();
    }


    public void init_player(){
        player = new Player(sWidth/2, 1100, root);
    }

    public void initTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (gameOver) {
                    stopGame();
                    reset();
                    showGameOver();
                    HighScoreManager.submitScore(score);
                    score = 0;
                    return;
                }
                if (gamePaused) {
                    left = right = up = down = false;
                }
                update(now);
            }
        };
    }

    int getScore(){return score;}
    
    public void turnOffGame(){gameOver = true;}
    public void turnONGame(){gameOver = false;}
    public Scene getGameOverScene(Stage stage){return gameOverScene.getScene(stage, score);}
    public Pane getRoot(){return this.root;}

    public void reset(){
        left = right = up = down = false;
        for (Iterator<Enemy> it = enemies.getEnemies().iterator();it.hasNext();) {
            Enemy e = it.next();
            root.getChildren().remove(e.getSprite());
        }
        for (Iterator<Bullet> it = playerBullets.getBullets().iterator();it.hasNext();) {
            Bullet b = it.next();
            root.getChildren().remove(b.getSprite());
        }
        for (Iterator<Bullet> it = enemyBullets.getBullets().iterator();it.hasNext();) {
            Bullet b = it.next();
            root.getChildren().remove(b.getSprite());
        }
        for (Iterator<Powerup> it = powerups.getPowerups().iterator();it.hasNext();) {
            Powerup p = it.next();
            root.getChildren().remove(p.getSprite());
        }
        enemies.getEnemies().clear();
        playerBullets.getBullets().clear();
        enemyBullets.getBullets().clear();
        powerups.getPowerups().clear();
        root.getChildren().remove(player.getPlayer());
    }
    
    public void startGame() {
        gameOver = false;
        gamePaused = false;
        if (!timerRunning) {
            timer.start();
            timerRunning = true;
        }
    }

    public void stopGame() {
        if (timerRunning) {
            timer.stop();
            timerRunning = false;
        }
    }
    

    public void setInput(){
        App.gameScene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT -> left = true;
                case RIGHT -> right = true;
                case UP -> up = true;
                case DOWN -> down = true;
            }
        });
        App.gameScene.setOnKeyReleased(e -> {
            switch (e.getCode()) {
                case LEFT -> left = false;
                case RIGHT -> right = false;
                case UP -> up = false;
                case DOWN -> down = false;
                case ESCAPE -> {
                    HUD.togglePause();
                    pauseMenu.show();
                }
            }
        });
    }
    
    private void update(long now) {
        setInput();
        checkCollisions();
        gamePaused = HUD.isPaused();
        player.move(left, right, up, down);
        if(!gamePaused){
            pauseMenu.hide();
            if(!player.canBeIntersected()){
                if(now - lastImmunity >= playerImmunityInterval){
                    player.canBeIntersectedToggle();
                    lastImmunity = now;
                }
            }

            if(now - lastEnemySpawn >= enemySpawnInterval){
                enemies.spawnEnemy();
                lastEnemySpawn = now;
            }
        
            if(now - lastShot >= playerShootInterval){
                if (player.isMegaBullet()){
                    playerBullets.addBullet(new MegaBullet(player.x+player.width/2, player.y));
                }
                else{
                    playerBullets.addBullet(new NormalBullet(player.x+player.width/2, player.y));
                }
                lastShot = now;
            }
            enemies.update(now);
            player.update();
            player.update(now);
            playerBullets.update();
            enemyBullets.update();
            powerups.update();
        }
        
        for(Iterator<Enemy> it = enemies.getEnemies().iterator(); it.hasNext();){
            Enemy e = it.next();
            if(e.isDamaged()){
                CompletableFuture.runAsync(()->{
                    try{
                        Thread.sleep(60);
                        e.resetDamageStatus();
                    }catch(InterruptedException ex){
                        System.out.println("Error while sleeping");
                    }
                });
            }
            // System.out.println(player.getLives());
            if(e.canShoot()){
                Bullet b;
                if(e.getClass() == BigEnemy.class){
                    b = new EnemyBullet(e.x+e.width/2-65, e.y+40, e.dy+3);
                    enemyBullets.addBullet(b);
                }
                else if(e.getClass() == ShootingEnemy.class){
                    b = new EnemyBullet(e.x+e.width/2-60, e.y+40, e.dy+3);
                    enemyBullets.addBullet(b);
                }
                e.canShoot = false;
                e.shootTimer();
            }
        }
        
        // System.out.println(player.getLives());
        removeOffscreen();
    }

    private void checkCollisions() {
        // player vs enemy
        for(Iterator<Enemy> it = enemies.getEnemies().iterator();it.hasNext();){
            Enemy e = it.next();
            if(player.intersects(e) && player.canBeIntersected()){
                it.remove();
                root.getChildren().remove(e.getSprite());
                player.damage();
                HUD.damage();
                player.canBeIntersectedToggle();
                if(player.getLives() <= 0){
                    gameOver = true;
                }
            }
        }
        //bullet vs enemies
        for(Iterator<Bullet> itB = playerBullets.getBullets().iterator();itB.hasNext();){
            Bullet b = itB.next();
            for(Iterator<Enemy> itE = enemies.getEnemies().iterator();itE.hasNext();){
                Enemy e = itE.next();
                if(e.intersects(b)){
                    e.damage(b.bulletPower());
                    if(e.health <= 0){
                        if(e.getClass() == NormalEnemy.class)       score+=10;
                                
                        else if(e.getClass() == FastEnemy.class)    score+=30;
                                
                        else if(e.getClass() == BigEnemy.class)     score+=50;

                        else if(e.getClass() == DancingEnemy.class) score+=40;

                        else score+=30;
                        
                        powerups.spawnPowerup(e.x, e.y);
                        itE.remove();
                        root.getChildren().remove(e.getSprite());
                        HUD.addScore(score);
                    }
                    itB.remove();
                    root.getChildren().remove(b.getSprite());
                }
            }
        }
        // player vs enemy bullets
        for(Iterator<Bullet> itB = enemyBullets.getBullets().iterator();itB.hasNext();){
            Bullet b = itB.next();
            if(player.intersects(b) && player.canBeIntersected()){
                itB.remove();
                root.getChildren().remove(b.getSprite());
                player.damage();
                HUD.damage();
                player.canBeIntersectedToggle();
                if(player.getLives() <= 0){
                    root.getChildren().remove(player.sprite);
                    gameOver = true;
                }
            }
        }
        // player vs powerups
        for(Iterator<Powerup> it = powerups.getPowerups().iterator(); it.hasNext();){
            Powerup p = it.next();
            if (player.intersects(p)){
                it.remove();
                root.getChildren().remove(p.getSprite());
                p.apply(player);
                if(p.getClass() == ExtraLife.class) facts.showFact(FactType.LOGISTICS_FACT);
                else if(p.getClass() == Shield.class) facts.showFact(FactType.SHIELD_FACT);
                else if(p.getClass() == Speedup.class) facts.showFact(FactType.HORSES_FACT);
                else facts.showFact(FactType.WEAPONS_USED_FACT);
            }
        }

    }
        
    public void removeOffscreen(){
        enemies.removeOffscreen();
        playerBullets.removeOffscreen();
        enemyBullets.removeOffscreen();
        powerups.removeOffscreen();
    }
    
    public void createHUD() {
        Label scoreLabel = new Label("Score: 0");
        scoreLabel.setStyle("-fx-font-size: 28px; -fx-text-fill: white;");
        scoreLabel.setTranslateX(20);
        scoreLabel.setTranslateY(20);

        Label healthLabel = new Label("Lives: 3");
        healthLabel.setStyle("-fx-font-size: 28px; -fx-text-fill: red;");
        healthLabel.setTranslateX(20);
        healthLabel.setTranslateY(60);

        ImageView pauseButton = new ImageView(assets.pauseButtonIMG);
        pauseButton.setFitWidth(50);
        pauseButton.setFitHeight(50);

        pauseButton.setTranslateX(App.sWidth - 70);
        pauseButton.setTranslateY(20);

        pauseButton.setOnMouseEntered(e -> pauseButton.setOpacity(0.7));
        pauseButton.setOnMouseExited(e -> pauseButton.setOpacity(1));

        pauseButton.setOnMouseClicked(e -> {
            HUD.togglePause();
            if(!AssetLoader.mute) App.assets.click.play();
            if (HUD.isPaused()) {
                pauseMenu.show();
            }
        });

        hudLayer.getChildren().addAll(pauseMenu, scoreLabel, healthLabel, pauseButton);

        HUD.scoreLabel = scoreLabel;
        HUD.healthLabel = healthLabel;
    }
}