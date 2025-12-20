package com.planeshootinggame;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import java.util.Iterator;

import com.planeshootinggame.EnemyTypes.BigEnemy;
import com.planeshootinggame.EnemyTypes.DancingEnemy;
import com.planeshootinggame.EnemyTypes.FastEnemy;
import com.planeshootinggame.EnemyTypes.NormalEnemy;

public class GameEngine extends App{
    private Pane root;
    private AnimationTimer timer;
    private Player player;
    private BulletManager bullets;
    private EnemyManager enemies;
    private PowerupManager powerups;
    private Text scoreText;
    private int score = 0;
    private boolean left, right, up, down;
    private boolean canBeIntersected = true;
    private boolean gameOver = false, gamePaused = false;
    private long enemySpawnInterval =       1000000000L,    lastEnemySpawn = 0;
    private long playerImmunityInterval =   3000000000L,    lastImmunity = 0;
    private long playerShootInterval =      200000000L,     lastShot = 0;

    public GameEngine(Pane root) {
        this.root = root;
        bullets = new BulletManager(root);
        enemies = new EnemyManager(root);
        powerups = new PowerupManager(root);
        scoreText = new Text(100, 200, "Score: "+score);
        scoreText.setFont(Font.font("arial", FontWeight.BOLD, 30));
        root.getChildren().add(scoreText);
    }

    void init_player(){
        player = new Player(sWidth/2, 900, root);
    }

    public void startGame() {
        init_player();
       timer = new AnimationTimer() {
        @Override
        public void handle(long now){
            if (gameOver) {
                timer.stop(); 
                // reset enemies
                for (Iterator<Enemy> it = enemies.getEnemies().iterator();it.hasNext();) {
                    Enemy e = it.next();
                    root.getChildren().remove(e.getSprite());
                }
                enemies.getEnemies().clear();
                //reset bullets
                for (Iterator<Bullet> it = bullets.getBullets().iterator();it.hasNext();) {
                    Bullet b = it.next();
                    root.getChildren().remove(b.getSprite());
                }
                bullets.getBullets().clear();
                //reset powerups

                StackPane menu = new StackPane();
                Button btnOK = new Button("start over");
                btnOK.setPrefSize(300, 50);
                menu.getChildren().add(btnOK);
                btnOK.setFont(Font.font("arial", FontWeight.BOLD, 30));
                App.scene.setRoot(menu);
                btnOK.setOnMouseClicked(e -> {System.out.println("hello");});
                btnOK.setOnAction(e -> {
                    gameOver = false;
                    score = 0;
                    App.scene.setRoot(root);
                    init_player();
                    timer.start();
                });
                return;
            }
            update(now);
        }
       };
       timer.start();
    }

    public void setInput(){
        App.scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT -> left = true;
                case RIGHT -> right = true;
                case UP -> up = true;
                case DOWN -> down = true;
            }
        });
        App.scene.setOnKeyReleased(e -> {
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
        player.update(left, right, up, down);
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
        Enemy e = enemies.getEnemies().get(0);
        System.out.println(((DancingEnemy)e).nextDestination);
        if(now - lastShot >= playerShootInterval){
            Bullet b = new Bullet(player.x+player.width/2, player.y);
            bullets.addBullet(b);
            lastShot = now;
        }
        enemies.update();
        player.update();
        bullets.update();
        powerups.update();

        checkCollisions();
        removeOffscreen();
    }

    public Pane getRoot(){return this.root;}

    private void checkCollisions() {
        // player vs enemy
        for(Iterator<Enemy> it = enemies.getEnemies().iterator();it.hasNext();){
            Enemy e = it.next();
            if(player.intersects(e) && canBeIntersected){
                it.remove();
                root.getChildren().remove(e.getSprite());
                player.lives--;
                canBeIntersected = false;
                if(player.lives <= 0){
                    root.getChildren().remove(player.sprite);
                    gameOver = true;
                }
            }
        }
        //bullet vs enemies
        for(Iterator<Enemy> itE = enemies.getEnemies().iterator();itE.hasNext();){
            Enemy e = itE.next();
            for(Iterator<Bullet> itB = bullets.getBullets().iterator();itB.hasNext();){
                Bullet b = itB.next();
                if(e.intersects(b)){
                    if(e.getClass() == NormalEnemy.class){
                        if(e.health <= 0){
                            score+=10;
                            itE.remove();
                            root.getChildren().remove(e.getSprite());
                        }
                        else{
                            e.damage();
                        }
                    }
                    else if(e.getClass() == FastEnemy.class){
                        if(e.health <= 0){
                            score+=30;
                            itE.remove();
                            root.getChildren().remove(e.getSprite());
                        }
                        else{
                            e.damage();
                        }
                    }
                    else if(e.getClass() == BigEnemy.class){
                        if(e.health <= 0){
                            score+=50;
                            itE.remove();
                            root.getChildren().remove(e.getSprite());
                        }
                        else{
                            e.damage();
                        }
                    }
                    else{
                        if(e.health <= 0){
                            score+=30;
                            itE.remove();
                            root.getChildren().remove(e.getSprite());
                        }
                        else{
                            e.damage();
                        }
                    }

                    scoreText.setText("Score: "+score);
                    itB.remove();
                    root.getChildren().remove(b.getSprite());
                }
            }
        }
        // player vs powerups
    }

    public void removeOffscreen(){
        // player.removeOffscreen();
        enemies.removeOffscreen();
        bullets.removeOffscreen();
        // powerups.removeOffscreen(sheight);
    }

    private void render() {

    }
}