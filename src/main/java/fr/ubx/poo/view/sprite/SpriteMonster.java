package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.character.Monster;
import fr.ubx.poo.model.go.character.Player;
import fr.ubx.poo.view.image.ImageFactory;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;

public class SpriteMonster extends SpriteGameObject {
    /***
     * create a SpriteMonster
     * @param layer position du monstre (en avant plan avec le player)
     * @param monster monster de la classe Monster
     */
    public SpriteMonster(Pane layer, Monster monster){
        super(layer, null, monster);
        updateImage();
    }

    /***
     * update l'imaage en fonction de la position du joueur
     */

    @Override
    public void updateImage() {
        Monster monster = (Monster) go;
        setImage(ImageFactory.getInstance().getMonster(monster.getDirection()));
    }
}
