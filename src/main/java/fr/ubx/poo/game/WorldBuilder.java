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

public class WorldBuilder {
    private final Map<Position, Decor> grid = new Hashtable<>();

    private WorldBuilder() {//只有这一行是原本的代码
    }

    public static WorldEntity[][] creatEntities(){
        WorldEntity[][] raw={};
        try{
        	String path = WorldBuilder.class.getResource("/leve1.txt").getFile();
            FileInputStream file=new FileInputStream(path);
            ObjectInputStream in =new ObjectInputStream(file);
        
        Object a=in.readObject();
        int j=0,i=0;
        while((int) a!=-1){
            if((int) a ==10){ // ‘\n’=10 en intger
                j++;
                i=0;
            }
            char c=(char) a;
            WorldEntity h= creat(c);
            raw[i][j]=h;
            i++;
            a=in.readObject();
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
    catch(ClassNotFoundException e){
        e.printStackTrace();
    }
    return raw;
    }

///////////////////////////////////////////////////
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
                return new DoorClosed();
            case Monster:
                return new Monster();
            default:
                return null;
        }
   }
}