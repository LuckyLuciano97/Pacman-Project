package main;

import object.Object_Dot;
import object.Object_Potion;
import object.SuperObject;

public class AssetManager {

    Pacman pm;

    public AssetManager(Pacman pm){
        this.pm = pm;
    }
    
    public void setObject() {
        pm.obj[0] = new Object_Dot();
        pm.obj[0].mapX = 1 * pm.tileSize;
        pm.obj[0].mapY = 7 * pm.tileSize;

        pm.obj[1] = new Object_Dot();
        pm.obj[1].mapX = 1 * pm.tileSize;
        pm.obj[1].mapY = 8 * pm.tileSize;

        pm.obj[2] = new Object_Potion();
        pm.obj[2].mapX = 1 * pm.tileSize;
        pm.obj[2].mapY = 9 * pm.tileSize;



    }
}
