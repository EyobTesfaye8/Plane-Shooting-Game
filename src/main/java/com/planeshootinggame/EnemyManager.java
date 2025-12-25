package com.planeshootinggame;

import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.planeshootinggame.EnemyTypes.BigEnemy;
import com.planeshootinggame.EnemyTypes.DancingEnemy;
import com.planeshootinggame.EnemyTypes.FastEnemy;
import com.planeshootinggame.EnemyTypes.NormalEnemy;
import com.planeshootinggame.EnemyTypes.ShootingEnemy;
public class EnemyManager {
    private List<Enemy> enemies = new ArrayList<>();
    private Pane root;
    private Random r = new Random();
    public EnemyManager(Pane root){ 
        this.root = root;   
    }

    public void spawnEnemy() {
        double randomNUM = r.nextDouble()*1000;
        Enemy enemy;
        if(randomNUM > 600){
            enemy = new NormalEnemy(r.nextInt(App.sWidth-100), -300);
        }
        else if (randomNUM > 300){
            enemy = new FastEnemy(r.nextInt(App.sWidth-100), -300);
        }
        else if (randomNUM > 200){
            enemy = new BigEnemy(r.nextInt(App.sWidth-100), -300);
        }
        else if (randomNUM > 150){
            enemy = new ShootingEnemy(r.nextInt(App.sWidth-100), -300);
        }
        else{
            enemy = new DancingEnemy(r.nextInt(App.sWidth-100), -300);
        }
        root.getChildren().add(enemy.sprite);
        enemies.add(enemy);
    }

    public void update() {
        for (Enemy e : enemies) {
            e.update();
            e.changeImage();
            // e.attack();
        }
        // removeOffscreen();
    }

    public Pane getRoot(){return this.root;}

    public List<Enemy> getEnemies(){return enemies;}

    public void removeOffscreen(){
        for (Iterator<Enemy> it = enemies.iterator(); it.hasNext();){
            Enemy e = it.next();
            if(e.y+e.height > App.sHeight+500){
                it.remove();
                root.getChildren().remove(e.getSprite());
            }
        }
    }
}