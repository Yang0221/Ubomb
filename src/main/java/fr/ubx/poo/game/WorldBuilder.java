package fr.ubx.poo.game;

import fr.ubx.poo.model.Entity;
import fr.ubx.poo.model.decor.*;

import java.util.Hashtable;
import java.util.Map;
import java.io.*;
import java.util.ArrayList;
import fr.ubx.poo.game.WorldEntity;
import static fr.ubx.poo.game.WorldEntity.*;
import javafx.application.Application;
import fr.ubx.poo.game.Game;

public class WorldBuilder  {
    private final Map<Position, Decor> grid = new Hashtable<>();

    //private WorldBuilder() {}

    //////creatEntities permet de creer un raw à paritir du diffrent fichiers
    public static WorldEntity[][] creatEntities(String path){
        WorldEntity[][] raw={
            {Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty},
            {Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty},
            {Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty},
            {Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty},
            {Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty},
            {Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty},
            {Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty, Empty},
            
        };
        try{
            File filename = new File(path,"level2.txt"); // à changer pour passer au niveau suivant
    
		    InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader in = new BufferedReader(reader); 

		    String line = in.readLine(); //on lit le fichier une ligne par ligne

            int len=line.length();  // len est la longeur du world
            int i=-1,j=-1;  
            char c;
		    while (line!=null) {
                j++;
                i=0;
                while(i<len){
                    c=line.charAt(i);  
                    raw[j][i]=WorldEntity.fromCode(c).get();
                    // on change le type char ver WorldEntity un caractère par caractère
                    i++;  
                }
                line = in.readLine();
            }
            in.close();
        }
        catch(FileNotFoundException e ){
            e.printStackTrace();
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return raw;
    }



    public static Map<Position, Decor> build(WorldEntity[][] raw, Dimension dimension) {
        WorldBuilder builder = new WorldBuilder();
        for (int x = 0; x < dimension.width; x++) {
            for (int y = 0; y < dimension.height; y++) {
                Position pos = new Position(x, y);
                Decor decor = processEntity(raw[y][x]);
                if (decor != null)
                    builder.grid.put(pos, decor);
            }
        }
        return builder.grid;
    }
    
   private static Decor processEntity(WorldEntity entity) {
        switch (entity) {
            case Stone:
                return new Stone();
            case Tree:
                return new Tree();
            case Princess:
                return new Princess();
            case Box:
                return new Box();
            case Heart:
                return new Heart();
            case Key:
                return new Key();
            case DoorNextClosed:
                return new DoorNextClosed();
            case DoorNextOpened:
                return new DoorNextOpened();  
            case DoorPrevOpened:
                return new DoorPrevOpened();
            case BombNumberInc:
            	return new BombNumberInc();
            case BombNumberDec:
            	return new BombNumberDec();
            case BombRangeInc:
            	return new BombRangeInc();
            case BombRangeDec:
            	return new BombRangeDec();
            case Bomb:
                return new Bomb();
            
            default:
                return null;
        }
   }
}