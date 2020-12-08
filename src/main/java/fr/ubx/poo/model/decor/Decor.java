/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.model.decor;

import fr.ubx.poo.model.Entity;

/***
 * A decor is an element that does not know its own position in the grid.
 */
public abstract class Decor extends Entity {  
    
    protected abstract boolean isObstacle();
    
    public boolean take() {
		return isObstacle();
	}

    

}