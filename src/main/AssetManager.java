package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import object.Object_Dot;
import object.Object_Potion;
import object.SuperObject;
import sprites.Ghost;

public class AssetManager {

    Pacman pm;
    public int numOfDots;

    public AssetManager(Pacman pm) {
        this.pm = pm;
    }

    public void setObject(String filePath) {

        try {
            InputStream is = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            int z = 0;
            int l = 0;
            numOfDots = 0;

            while (col < pm.maxScreenCol && row < pm.maxScreenRow) {
                String line = br.readLine();
                while (col < pm.maxScreenCol) {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    if (num == 0) {
                        pm.obj[z] = new Object_Dot();
                        pm.obj[z].mapX = col * pm.tileSize;
                        pm.obj[z].mapY = row * pm.tileSize;
                        z++;
                        numOfDots++;
                        System.out.println(numOfDots);

                    }
                    if (num == 12) {
                        pm.obj[z] = new Object_Potion();
                        pm.obj[z].mapX = col * pm.tileSize;
                        pm.obj[z].mapY = row * pm.tileSize;
                        z++;
                    }
                    // System.out.println(num);
                    col++;
                }
                if (col == pm.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setNPC() {
        pm.npc[0] = new Ghost(pm);
        pm.npc[0].mapX = pm.tileSize * 1;
        pm.npc[0].mapY = pm.tileSize * 10;

        pm.npc[1] = new Ghost(pm);
        pm.npc[1].mapX = pm.tileSize * 6;
        pm.npc[1].mapY = pm.tileSize * 6;

        pm.npc[2] = new Ghost(pm);
        pm.npc[2].mapX = pm.tileSize * 6;
        pm.npc[2].mapY = pm.tileSize * 7;

        pm.npc[3] = new Ghost(pm);
        pm.npc[3].mapX = pm.tileSize * 9;
        pm.npc[3].mapY = pm.tileSize * 7;

    }
}
