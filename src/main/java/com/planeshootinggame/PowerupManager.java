package com.planeshootinggame;

import javafx.scene.layout.Pane;
import java.util.ArrayList;
// import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PowerupManager {
    private List<Powerup> powerups = new ArrayList<>();
    private Pane root;
    private Random rnd = new Random();
    
    public PowerupManager(Pane root) { this.root = root; }

    public void spawnPowerupcod(double x, double y) {
       
    }

    public void update() {
        for (Powerup p : powerups) p.update();
    }

    public void removeSprite(Powerup p) { 

    }

    public Pane getRoot(){return this.root;}

    public void removeOffscreen(double height) {
        
    }
}