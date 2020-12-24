package fr.ubx.poo.model.decor;

public class Box extends Decor {
    
    @Override
    public String toString() {
        return "Box";
    }
    public boolean isBox(){
        return true;
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