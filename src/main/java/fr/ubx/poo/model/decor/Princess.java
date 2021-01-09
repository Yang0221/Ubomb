package fr.ubx.poo.model.decor;

public class Princess extends Decor {

    @Override
    public String toString() {
        return "Princess";
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
        return false;
    }
    protected boolean isMonster(){
        return false;
    }
    protected boolean isPrincess(){
        return true;
    }
    protected boolean isBomb(){
        return false;
    }


}