

package fr.ubx.poo.model.decor;


public class Key extends Decor {
    @Override
    public String toString() {
        return "Key";
    }
    protected boolean isBox(){
        return false;
    }
    protected boolean isCoeur(){
        return false;
    }
    protected boolean isKey(){
        return true;
    }
    protected boolean isDoorNextClosed(){
        return false;
    }
    protected boolean isDoorNextOpened(){
        return false;
    }
    protected boolean isDoorPrevOpened(){
        return false;
    }
    protected boolean isMonster(){
        return false;
    }
    protected boolean isPrincess(){
        return false;
    }
    protected boolean isBomb(){
        return false;
    }

}
