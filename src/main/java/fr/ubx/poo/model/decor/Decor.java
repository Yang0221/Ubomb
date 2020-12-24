/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.model.decor;

import fr.ubx.poo.model.Entity;

/***
 * A decor is an element that does not know its own position in the grid.
 */
public abstract class Decor extends Entity {  
    
  protected abstract boolean isBox();
  protected abstract boolean isCoeur();
  protected abstract boolean isKey();
  protected abstract boolean isDoorClosed();
  protected abstract boolean isMonster();
  protected abstract boolean isPrincess();
  public boolean y_box() {
		return isBox();
  }
  public boolean y_coeur(){
    return isCoeur();
  }
  public boolean y_doorc(){
    return isDoorClosed();
  }
  public boolean y_key(){
    return isKey();
  }
  public boolean y_monster(){
    return isMonster();
  }
  public boolean y_princess(){
    return isPrincess();
  }
}