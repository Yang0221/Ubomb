package fr.ubx.poo.model.decor;

import fr.ubx.poo.model.Entity;

/***
 * A decor is an element that does not know its own position in the grid.
 */
public abstract class Decor extends Entity {  
    
  protected abstract boolean isBox();
  protected abstract boolean isCoeur();
  protected abstract boolean isKey();
  protected abstract boolean isMonster();
  protected abstract boolean isPrincess();
  protected abstract boolean isDoorNextClosed();
  protected abstract boolean isDoorNextOpened();
  protected abstract boolean isDoorPrevOpened();
  protected abstract boolean isBombNumberInc();
  protected abstract boolean isBombNumberDec();
  protected abstract boolean isBombRangeInc();
  protected abstract boolean isBombRangeDec();
  protected abstract boolean isBomb();
 
  public boolean y_box() {
		return isBox();
  }
  public boolean y_coeur(){
    return isCoeur();
  }
  public boolean y_key(){
    return isKey();
  }
  public boolean y_monster(){
    return isMonster();
  }
  public boolean y_door_nextC(){
    return isDoorNextClosed();
  }
  public boolean y_door_nextO(){
    return isDoorNextOpened();
  }
  public boolean y_door_preC(){
    return isDoorPrevOpened();
  }
  public boolean y_princess(){
	    return isPrincess();
  }
  public boolean y_addbomb(){
	    return isBombNumberInc();
  }
  public boolean y_removebomb(){
	    return isBombNumberDec();
  }
  public boolean y_addrange(){
	    return isBombRangeInc();
  }
  public boolean y_removerange(){
	    return isBombRangeDec();
  }
  public boolean y_bomb(){
    return isBomb();
  }
}