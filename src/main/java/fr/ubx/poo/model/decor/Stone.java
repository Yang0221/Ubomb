/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.model.decor;

public class Stone extends Decor {
    @Override
    public String toString() {
        return "Stone";
    }
    protected boolean isBox(){
        return false;
    }
    protected boolean isCoeur(){
        return false;
    }
    protected boolean isKey(){
        return false;
    }
    protected boolean isDoorClosed(){
        return false;
    }
    protected boolean isMonster(){
        return false;
    }
    protected boolean isPrincess(){
        return false;
    }

}
