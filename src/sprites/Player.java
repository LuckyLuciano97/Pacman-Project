package sprites;

import main.Pacman;
import main.KeyHandler;
import java.awt.*;
import java.awt.Rectangle;

import java.io.FileInputStream;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

// import javafx.scene.shape.Rectangle;

public class Player extends Sprites {

    KeyHandler keyH;

    public int score;

    public Player(Pacman pm, KeyHandler keyH) {

        super(pm);
        this.keyH = keyH;

        solidArea = new Rectangle();
        solidArea.x = 16;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 16;
        solidArea.height = 16;


        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues() {
        mapX = 40;
        mapY = 40;
        speed = 2;
        direction = "down";

    }

    public void getPlayerImage() {
        try {
            up = ImageIO.read(new FileInputStream("src/res/player/pacman-up.png"));
            up2 = ImageIO.read(new FileInputStream("src/res/player/pacman-upC.png"));
            down = ImageIO.read(new FileInputStream("src/res/player/pacman-down.png"));
            down2 = ImageIO.read(new FileInputStream("src/res/player/pacman-downC.png"));
            left = ImageIO.read(new FileInputStream("src/res/player/pacman-left.png"));
            left2 = ImageIO.read(new FileInputStream("src/res/player/pacman-leftC.png"));
            right = ImageIO.read(new FileInputStream("src/res/player/pacman-right.png"));
            right2 = ImageIO.read(new FileInputStream("src/res/player/pacman-rightC.png"));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            direction = "up";

        } else if (keyH.downPressed == true) {
            direction = "down";

        } else if (keyH.leftPressed == true) {
            direction = "left";

        } else if (keyH.rightPressed == true) {
            direction = "right";
        }

        // CHECKING FOR COLLISION
        collisionOn = false;
        pm.collisionCheck.checkTile(this);

        //Check for object collision
         int objectIndex = pm.collisionCheck.checkObject(this, true);
         collectObject(objectIndex);

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

public void collectObject(int i){
 if(i != 999){

    // pm.obj[i] = null; 

    String objectName = pm.obj[i].name;

    switch(objectName){
        case "dot":
        score++;
        pm.obj[i] = null; 
        System.out.println("Score: "+score);
        if(score == 2){
            pm.sc.levelCompleted = true;
        }
        break;
        case "potion":
        //turns npcs blue and edible
        pm.obj[i] = null; 
        break;
    }

 }
}

    public void draw(Graphics2D g2) {

        // g2.setColor(Color.white);
        // g2.fillRect(x, y, pm.tileSize, pm.tileSize);

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
