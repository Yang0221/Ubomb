package fr.ubx.poo.model.decor;


public class Bomb extends Decor {
    @Override
    public String toString() {
        return "Bomb";
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
        return false;
    }
    protected boolean isBombRangeInc(){
        return false;
    }
    protected boolean isBombRangeDec(){
        return false;
    }
    protected boolean isBombNumberInc(){
        return false;
    }
    protected boolean isBombNumberDec(){
        return false;
    }
    protected boolean isBomb(){
        return true;
    }

}
