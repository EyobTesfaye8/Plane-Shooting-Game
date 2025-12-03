package com.planeshootinggame;

import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyManager {
    private List<Enemy> enemies = new ArrayList<>();
    private Pane root;

    public EnemyManager(Pane root) { this.root = root; }

    public void spawnEnemy() {
        
    }

    public void update() {
       
    }

    public List<Enemy> getEnemies() { return enemies; }

    public void removeOffscreen() {
        
    }
}