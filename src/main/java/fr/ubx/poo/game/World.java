package fr.ubx.poo.game;

import fr.ubx.poo.model.decor.Decor;

import java.util.Collection;
import java.util.Map;
import java.util.function.BiConsumer;

public class World {
    private final Map<Position, Decor> grid;
    private final WorldEntity[][] raw;
    public final Dimension dimension;
    private boolean changed=true;  //si un decor change sa position , on recharge le world
    private int rangeValue=1;
    private int nbBomb=1;
    public  World(String path) {
        this.raw = WorldBuilder.creatEntities(path); //on crée raw 
        dimension = new Dimension(raw.length, raw[0].length);
        grid = WorldBuilder.build(raw, dimension);
    }

    //////CHANGED////////
    public boolean hasChanged(){
        return changed;
    }
    public void setchanged(boolean a){
        this.changed=a;
    }
    //////RANGEVALUE//////
    public int getRange() {
    	return this.rangeValue;
    }
    public void addRange() {
    	this.rangeValue++;
    }
    public void removeRange() {
    	this.rangeValue--;
    }
    //////NBBOMB//////
    public int getNbBomb() {
    	return this.nbBomb;
    }
    public void addNbBomb() {
    	this.nbBomb++;
    }
    public void removeNbBomb() {
    	this.nbBomb--;
    }
    public Position findPlayer() throws PositionNotFoundException {
        for (int x = 0; x < dimension.width; x++) {
            for (int y = 0; y < dimension.height; y++) {
                if (raw[y][x] == WorldEntity.Player) {
                    return new Position(x, y);
                }
            }
        }
        throw new PositionNotFoundException("Player");
    }

    public Position findMonster() throws PositionNotFoundException {
        for (int x = 0; x < dimension.width; x++) {
            for (int y = 0; y < dimension.height; y++) {
                if (raw[y][x] == WorldEntity.Monster) {
                    return new Position(x, y);
                }
            }
        }
        throw new PositionNotFoundException("Monster");
    }

    public Decor get(Position position) {
        return grid.get(position);
    }

    public void set(Position position, Decor decor) {
        grid.put(position, decor);
    }

    public void clear(Position position) {
        grid.remove(position);
    }

    public void forEach(BiConsumer<Position, Decor> fn) {
        grid.forEach(fn);
    }

    public Collection<Decor> values() {
        return grid.values();
    }

    public boolean isInside(Position position) {
        return true; // to update
    }

    public boolean isEmpty(Position position) {
        return grid.get(position) == null;
    }
}
