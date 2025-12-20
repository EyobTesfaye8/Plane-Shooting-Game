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
        root.getChildren().add(b.getSprite());
    }

    public void update() {
        for (Bullet b : bullets) b.update();
    }

    public Pane getRoot(){return this.root;}

    public List<Bullet> getBullets() { return bullets; }

    public void removeOffscreen() {
        for(Iterator<Bullet> it = bullets.iterator(); it.hasNext();){
            Bullet b = it.next();
            if(b.outOfScreenV()){
                it.remove();
                root.getChildren().remove(b.getSprite());
            }
        }
    }
}