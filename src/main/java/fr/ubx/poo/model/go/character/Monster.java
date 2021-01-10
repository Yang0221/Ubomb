package fr.ubx.poo.model.go.character;

import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.decor.*;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.model.go.GameObject;
import javax.swing.Timer;

public class Monster extends GameObject implements Movable {
    private Direction direction;

    protected boolean isMonsterSprite(){
        return true;
    }


    public Direction getDirection() {
        return this.direction;
    }

    public Monster(Game game, Position position) {
        super(game, position);
        this.direction = Direction.S;
    }

    @Override
    public boolean canMove(Direction direction){
        Position nextPos = direction.nextPosition(getPosition());
        if(nextPos.inside(game.getWorld().dimension)) {
            Decor decor = game.getWorld().get(nextPos);
            if (decor == null) {//si la case nextPos est vide
               return true;
            }
        }
        return false;
    }

    /***
     * met à jour la position du monstre en fonction de si il peut bouger ou non
     * @param direction la direction du monstre qui doit être random
     */

    @Override
    public void doMove(Direction direction) {
        Position nextPos = direction.nextPosition(getPosition());
        if(game.getPlayer().getPosition() == nextPos){
            game.getPlayer().removeLive();

        }
        setPosition(nextPos);
    }


    public void update() {
        this.direction = Direction.random();
        if (canMove(this.direction)) {
            doMove(this.direction);
        }
    }


}
