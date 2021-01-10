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

    public boolean existe(Position P[], Position val){
        for(int i = 0;i<P.length;i++){
            if(val.equals(P[i])){
                return true;
            }
        }
        return false;
    }

    /***
     * tab de taille arbitraire avec chaque valeur initialisé à null
     * on suppose ici qu'on aura pas de level avec plus de 9 monstre
     */
    Position [] tab= new Position[]{null,null,null,null,null,null,null,null,null};

    /***
     * rempli le tableau tab des positions des monstre dans la grille
     * @return un tableau de posotion où à chaque position se trouve un monstre
     */

    public Position[] findMonster() {
        int i = 0;
        for (int x = 0; x < dimension.width; x++) {
            for (int y = 0; y < dimension.height; y++) {
                if (raw[y][x] == WorldEntity.Monster) {
                    Position p = new Position(x,y);
                    if(existe(tab,p)==false){
                        tab[i] = p;
                        i++;
                    }
                }
            }
        }
        return tab;
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
