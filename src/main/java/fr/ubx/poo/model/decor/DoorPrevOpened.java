package fr.ubx.poo.model.decor;


public class DoorPrevOpened extends Decor {
    @Override
    public String toString() {
        return "DoorPrevOpened";
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
    protected boolean isDoorNextClosed(){
        return false;
    }
    protected boolean isDoorNextOpened(){
        return false;
    }
    protected boolean isDoorPrevOpened(){
        return true;
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

