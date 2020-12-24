package fr.ubx.poo.model.decor;

public class Heart extends Decor {
    
    
    @Override
    public String toString() {
        return "Heart";
    }
    protected boolean isBox(){
        return false;
    }
    protected boolean isCoeur(){
        return true;
    }
    protected boolean isKey(){
        return false;
    }
    protected boolean isDoorClosed(){
        return false;
    }

    
}