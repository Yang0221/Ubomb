

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
    protected boolean isDoorClosed(){
        return false;
    }

}
