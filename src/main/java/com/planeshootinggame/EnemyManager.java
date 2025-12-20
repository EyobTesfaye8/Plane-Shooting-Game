package com.planeshootinggame;

import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
public class EnemyManager {
    private List<Enemy> enemies = new ArrayList<>();
    private Pane root;
    private Random r = new Random();
    public EnemyManager(Pane root){ 
        this.root = root;   
    }

    public void spawnEnemy() {
        Enemy enemy = new Enemy(r.nextInt(App.sWidth-100), -100);
        root.getChildren().add(enemy.sprite);
        enemies.add(enemy);
    }

    public void update() {
        for (Enemy e : enemies) e.update();
        // removeOffscreen();
    }

    public Pane getRoot(){return this.root;}

    public List<Enemy> getEnemies() { return enemies; }

    public void removeOffscreen() {
        for (Iterator<Enemy> it = enemies.iterator(); it.hasNext();){
            Enemy e = it.next();
            if(e.y+e.height > App.sheight+100){
                it.remove();
                root.getChildren().remove(e.getSprite());
            }
        }
    }
}