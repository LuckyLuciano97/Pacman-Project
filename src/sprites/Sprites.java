package sprites;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.awt.*;

import main.Pacman;

import java.awt.Rectangle;
public class Sprites {

    Pacman pm;
    public int mapX, mapY;
    public int speed;
    public BufferedImage up, down, right, left, up2, down2, right2, left2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;  
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLimitCounter = 0;

    public Sprites(Pacman pm){
        this.pm = pm;

        solidArea = new Rectangle();
        solidArea.x = 16;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 16;
        solidArea.height = 16;
    }

    public void setAction() {

    }

    public void update() {

        setAction();

        collisionOn = false;
        pm.collisionCheck.checkTile(this);
        pm.collisionCheck.checkPlayer(this);   
             

            // IF NO COLLISION PLAYER CAN MOVE
            if (collisionOn == false) {

                switch (direction) {
                    case "up":
                        mapY -= speed;
                        break;
                    case "down":
                        mapY += speed;
                        break;
                    case "left":
                        mapX -= speed;
                        break;
                    case "right":
                        mapX += speed;
                        break;
                }
            }
    
            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, mapX, mapY, pm.playerSize, pm.playerSize, null);


    }    
}
