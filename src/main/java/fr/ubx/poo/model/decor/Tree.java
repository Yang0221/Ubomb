/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.model.decor;


public class Tree extends Decor {
    @Override
    public String toString() {
        return "Tree";
    }
	protected boolean isObstacle() {
		return true;
	}
}
