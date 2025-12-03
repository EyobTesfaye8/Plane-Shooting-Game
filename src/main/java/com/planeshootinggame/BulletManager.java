package com.planeshootinggame;

import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BulletManager {
    private List<Bullet> bullets = new ArrayList<>();
    private Pane root;

    public BulletManager(Pane root) { this.root = root; }

    public void addBullet(Bullet b) {
        bullets.add(b);
    }

    public void update() {
        for (Bullet b : bullets) b.update();
    }

    public List<Bullet> getBullets() { return bullets; }

    public void removeOffscreen() {
        
    }
}