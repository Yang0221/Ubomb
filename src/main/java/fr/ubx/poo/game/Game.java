package fr.ubx.poo.game;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import fr.ubx.poo.model.go.character.Monster;
import fr.ubx.poo.model.go.character.Player;

public class Game {

    private final World world;
    private final Player player;
    private final List<Monster> monsters = new ArrayList<>();
    private final String worldPath;
    public int initPlayerLives;
    public int initKeys;


    public Game(String worldPath) {
        //world= new WorldStatic();
        this.worldPath = worldPath;
        world = new World(this.worldPath) ;
        loadConfig(this.worldPath);
        Position positionPlayer = null;
        Position positionMonster = null;
        try {
            positionPlayer = world.findPlayer();
            player = new Player(this, positionPlayer);
            Position [] tab= world.findMonster();
            for (int i = 0; i < tab.length; i++) {
                if (tab[i]!=null)
                monsters.add(new Monster(this,tab[i]));
            }
            System.out.println("+");
        } catch (PositionNotFoundException e) {
            System.err.println("Position not found : " + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }

    public int getInitPlayerLives() {
        return initPlayerLives;
    }

    public int getInitKeys(){
        return initKeys;
    }
    private void loadConfig(String path) {
        try (InputStream input = new FileInputStream(new File(path, "config.properties"))) {
            Properties prop = new Properties();
            // load the configuration file
            prop.load(input);
            initPlayerLives = Integer.parseInt(prop.getProperty("lives", "3"));
            initKeys=Integer.parseInt(prop.getProperty("keys", "0"));
        } catch (IOException ex) {
            System.err.println("Error loading configuration");
        }
    }

    public World getWorld() {
        return this.world;
    }

    public Player getPlayer() {
        return this.player;
    }

    public List<Monster> getMonsters(){
        return this.monsters;
    }


}
