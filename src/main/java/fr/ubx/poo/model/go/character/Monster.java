package fr.ubx.poo.model.go.character;

import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.decor.*;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.model.go.GameObject;

public class Monster extends GameObject implements Movable {
    private Direction direction;


    public Direction getDirection() {
        return direction;
    }

    public Monster(Game game, Position position) {
        super(game, position);
        this.direction = Direction.random();
    }

    @Override
    public boolean canMove(Direction direction){
        return true;
    }

    public void doMove(Direction direction) {
        direction = direction.random();
        Position nextPos = direction.nextPosition(getPosition());
        if(nextPos.inside(game.getWorld().dimension)) {
            Decor decor = game.getWorld().get(nextPos);
            if (decor == null) {//si la case nextPos est vide
                setPosition(nextPos);
            }
        }
    }


    public void update(long now) {
        if (canMove(direction)) {
            doMove(direction);
        }
    }


}
