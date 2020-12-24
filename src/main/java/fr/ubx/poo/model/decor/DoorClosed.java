

package fr.ubx.poo.model.decor;


public class DoorClosed extends Decor {
    @Override
    public String toString() {
        return "DoorClosed";
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
        return true;
    }

}
