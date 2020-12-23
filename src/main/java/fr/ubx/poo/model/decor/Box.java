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
    
}