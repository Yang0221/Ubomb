package fr.ubx.poo.model.decor;


public class DoorNextOpened extends Decor {
    @Override
    public String toString() {
        return "DoorNextOpened";
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
        return true;
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

