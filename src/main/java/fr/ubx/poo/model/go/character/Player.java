/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.model.go.character;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.go.GameObject;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.World;

import fr.ubx.poo.model.decor.Decor;
import fr.ubx.poo.model.decor.Box;
import fr.ubx.poo.model.decor.Tree;
import fr.ubx.poo.model.decor.Stone;
import fr.ubx.poo.model.decor.Heart;

public class Player extends GameObject implements Movable {

	private final boolean alive = true;
    Direction direction;
    private boolean moveRequested = false;
    private int lives = 3;
    private boolean winner;

    public Player(Game game, Position position) {
        super(game, position);
        this.direction = Direction.S;
        this.lives = game.getInitPlayerLives();
    }

    public int getLives() {
        return lives;
    }

    public Direction getDirection() {
        return direction;
    }
    
    public void addLives(){
        this.lives += 1 ;
    }

    public void removeLives(){
        this.lives -= 1 ;
    } 


    public void requestMove(Direction direction) {
        if (direction != this.direction) {
            this.direction = direction;
        }
        moveRequested = true;
    }

    @Override
    public boolean canMove(Direction direction) {
        Position nextPos = direction.nextPosition(getPosition());
        Position boxPos= direction.nextPosition(nextPos);
        if(nextPos.inside(game.getWorld().dimension)){
            Decor decor=game.getWorld().get(nextPos);
            Decor boxNext=game.getWorld().get(boxPos);
            if(decor == null )//si la case nextPos est vide
                return true;
            else if(decor.y_coeur()){ //si nextPos est coeur  
                addLives();  //ajout un live
                game.getWorld().clear(nextPos);  //supprime coeur
                game.getWorld().setchanged(true);  //recharge  world
                return true;
            }
            else if(decor.y_box() && boxPos.inside(game.getWorld().dimension) && boxNext==null){
                //si nextPos est box  et  la case d'après nextPos  est vide et inside de world 
                    game.getWorld().clear(nextPos);
                    game.getWorld().set(boxPos,new Box());
                    game.getWorld().setchanged(true);
                    return true;
            }
            else
                return false;
        }
       return false;
    }

    public void doMove(Direction direction) {
  
        Position nextPos = direction.nextPosition(getPosition());
        setPosition(nextPos);
    }

    public void update(long now) {
        if (moveRequested) {
            if (canMove(direction)) {
                doMove(direction);
            }
        }
        moveRequested = false;
    }

    public boolean isWinner() {
        return winner;
    }

    public boolean isAlive() {
        return alive;
    }

}
