package com.planeshootinggame;

import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;

import com.planeshootinggame.EnemyTypes.*;
import com.planeshootinggame.UI.screens.GameOver;
// import com.planeshootinggame.UI.MainMenu;
import com.planeshootinggame.BulletTypes.*;

public class GameEngine extends App{
    private Pane root;
    private AnimationTimer timer;
    private Player player;
    private BulletManager playerBullets;
    private BulletManager enemyBullets;
    private EnemyManager enemies;
    private PowerupManager powerups;
    private Text scoreText;
    private int score = 0;
    private boolean left, right, up, down;
    private boolean canBeIntersected = true;
    private boolean isEnemyDamaged = false;
    private boolean gameOver = true, gamePaused = false;
    private long enemySpawnInterval =       1000000000L,    lastEnemySpawn = 0;
    private long enemyShootInterval =       1000000000L,    lastEnemyShoot = 0;
    private long playerImmunityInterval =   3000000000L,    lastImmunity = 0;
    private long playerShootInterval =      150000000L,     lastShot = 0;
    private GameOver gameOverScene;
    public GameEngine(Pane root) {
        this.root = root;
        playerBullets = new BulletManager(root);
        enemyBullets = new BulletManager(root);
        enemies = new EnemyManager(root);
        powerups = new PowerupManager(root);
        scoreText = new Text(100, 200, "Score: "+score);
        scoreText.setFont(Font.font("arial", FontWeight.BOLD, 30));
        root.getChildren().add(scoreText);
    }

    void init_player(){
        player = new Player(sWidth/2, 1100, root);
        // scoreText.setText("Score: "+score);
    }

    public void changeGameOverStatus(){
        gameOver =! gameOver;
    }

    public void startGame(Stage stage) {
        init_player();
       timer = new AnimationTimer() {
            @Override
            public void handle(long now){
                if (gameOver) {
                    timer.stop(); 
                    // reset movement
                    left = right = up = down = false;
                    // reset enemies
                    for (Iterator<Enemy> it = enemies.getEnemies().iterator();it.hasNext();) {
                        Enemy e = it.next();
                        root.getChildren().remove(e.getSprite());
                    }
                    enemies.getEnemies().clear();
                    //reset playerBullets
                    for (Iterator<Bullet> it = playerBullets.getBullets().iterator();it.hasNext();) {
                        Bullet b = it.next();
                        root.getChildren().remove(b.getSprite());
                    }
                    playerBullets.getBullets().clear();
                    //reset enemyBullets
                    for (Iterator<Bullet> it = enemyBullets.getBullets().iterator();it.hasNext();) {
                        Bullet b = it.next();
                        root.getChildren().remove(b.getSprite());
                    }
                    //reset powerups
                    for (Iterator<Powerup> it = powerups.getPowerups().iterator();it.hasNext();) {
                        Powerup p = it.next();
                        root.getChildren().remove(p.getSprite());
                    }

                    
                    gameOverScene = new GameOver();
                    stage.setScene(getGameOverScene(stage));
                    return;
                }
                update(now);
            }
        };
    timer.start();
    }

    public Scene getGameOverScene(Stage stage){
        return gameOverScene.getScene(stage, score);
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
            }
        });
    }

    private void update(long now) {
        setInput();
        player.move(left, right, up, down);

        if(!canBeIntersected){
            if(now - lastImmunity >= playerImmunityInterval){
                canBeIntersected = true;
                lastImmunity = now;
            }
        }

        if(now - lastEnemySpawn >= enemySpawnInterval){
            enemies.spawnEnemy();
            lastEnemySpawn = now;
        }
    
        if(now - lastShot >= playerShootInterval){
            if(player.isManyBullets() && player.isMegaBullet()){
                playerBullets.addBullet(new MegaBullet(player.x+player.width/2, player.y));
                playerBullets.addBullet(new MegaBullet(player.x+player.width/2-60, player.y));
                playerBullets.addBullet(new MegaBullet(player.x+player.width/2+60, player.y));
            }
            else if(player.isManyBullets()){
                playerBullets.addBullet(new NormalBullet(player.x+player.width/2, player.y));
                playerBullets.addBullet(new NormalBullet(player.x+player.width/2-40, player.y));
                playerBullets.addBullet(new NormalBullet(player.x+player.width/2+40, player.y));
                playerBullets.addBullet(new NormalBullet(player.x+player.width/2-80, player.y));
                playerBullets.addBullet(new NormalBullet(player.x+player.width/2+80, player.y));
            }
            else if (player.isMegaBullet()){
                playerBullets.addBullet(new MegaBullet(player.x+player.width/2, player.y));
            }
            else{
                playerBullets.addBullet(new NormalBullet(player.x+player.width/2, player.y));
            }
            lastShot = now;
        }
        
        enemies.update();
        player.update();
        playerBullets.update();
        enemyBullets.update();
        powerups.update();
        
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
                    b = new EnemyBullet(e.x+e.width/2-30, e.y, e.dy+10);
                    enemyBullets.addBullet(b);
                }
                else if(e.getClass() == ShootingEnemy.class){
                    b = new EnemyBullet(e.x+e.width/2-30, e.y, e.dy+10);
                    enemyBullets.addBullet(b);
                }
                e.canShoot = false;
                e.shootTimer();
            }
        }
        
        System.out.println(player.getLives());
        checkCollisions();
        removeOffscreen();
    }

    private void checkCollisions() {
        // player vs enemy
        for(Iterator<Enemy> it = enemies.getEnemies().iterator();it.hasNext();){
            Enemy e = it.next();
            if(player.intersects(e) && canBeIntersected){
                it.remove();
                root.getChildren().remove(e.getSprite());
                player.damage();
                canBeIntersected = false;
                if(player.getLives() <= 0){
                    root.getChildren().remove(player.sprite);
                    score = 0;
                    scoreText.setText("Score: "+score);
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
                    }
                    itB.remove();
                    root.getChildren().remove(b.getSprite());
                }
                scoreText.setText("Score: "+score);
            }
        }
        // player vs enemy bullets
        for(Iterator<Bullet> itB = enemyBullets.getBullets().iterator();itB.hasNext();){
            Bullet b = itB.next();
            if(player.intersects(b) && canBeIntersected){
                itB.remove();
                root.getChildren().remove(b.getSprite());
                player.damage();
                canBeIntersected = false;
                if(player.getLives() <= 0){
                    root.getChildren().remove(player.sprite);
                    score = 0;
                    scoreText.setText("Score: "+score);
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
            }
        }

    }
        
    public void removeOffscreen(){
        // player.removeOffscreen();
        enemies.removeOffscreen();
        playerBullets.removeOffscreen();
        enemyBullets.removeOffscreen();
        // powerups.removeOffscreen(sheight);
    }

    public Pane getRoot(){return this.root;}
    
    private void render() {
        
    }
}