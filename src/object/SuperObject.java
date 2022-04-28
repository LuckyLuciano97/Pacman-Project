package object;

import java.awt.*;
import java.awt.image.BufferedImage;

import javafx.scene.shape.Rectangle;
import main.Pacman;

public class SuperObject {
    public BufferedImage image;
    public boolean collision = false;
    public int mapX, mapY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public void draw(Graphics2D g2, Pacman pm){

        g2.drawImage(image, mapX, mapY, pm.tileSize, pm.tileSize, null);

    }
}
