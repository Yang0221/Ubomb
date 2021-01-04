

package fr.ubx.poo.model.decor;


public class Monster extends Decor {
    @Override
    public String toString() {
        return "Monster";
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
        return false;
    }
    protected boolean isMonster(){
        return true;
    }
    protected boolean isPrincess(){
        return false;
    }

}
