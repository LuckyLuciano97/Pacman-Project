package sprites;
import java.awt.image.BufferedImage;

import javafx.scene.shape.Rectangle;

public class Sprites {

    public int mapX, mapY;
    public int speed;
    public BufferedImage up, down, right, left, up2, down2, right2, left2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;  
    public java.awt.Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    
}
