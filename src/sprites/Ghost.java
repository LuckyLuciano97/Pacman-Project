package sprites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.Pacman;

public class Ghost extends Sprites{

    public Ghost(Pacman pm){
        super(pm);

        direction = "down";
        speed = 2;

        getNPCImage();
    }
    
    public void getNPCImage() {
        try {
            up = ImageIO.read(new FileInputStream("src/res/npc/blue-ghost-1.png"));
            up2 = ImageIO.read(new FileInputStream("src/res/npc/blue-ghost-2.png"));
            down = ImageIO.read(new FileInputStream("src/res/npc/blue-ghost-1.png"));
            down2 = ImageIO.read(new FileInputStream("src/res/npc/blue-ghost-2.png"));
            left = ImageIO.read(new FileInputStream("src/res/npc/blue-ghost-1.png"));
            left2 = ImageIO.read(new FileInputStream("src/res/npc/blue-ghost-2.png"));
            right = ImageIO.read(new FileInputStream("src/res/npc/blue-ghost-1.png"));
            right2 = ImageIO.read(new FileInputStream("src/res/npc/blue-ghost-2.png"));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    @Override
    public void setAction(){

        actionLimitCounter++;

        if(actionLimitCounter == 60){
            Random random = new Random();
            int i = random.nextInt(100)+1; //picks a num from 1 to 100
    
            if(i <= 25){
                direction = "up";
                if(collisionOn = true){
                    direction = "down";
                }
            }
            if(i > 25 && i <= 50){
                direction = "down";
                if(collisionOn = true){
                    direction = "up";
                }
            }
            if(i > 50 && i <= 75){
                direction = "left";
                if(collisionOn = true){
                    direction = "right";
                }
            }
            if(i > 75 && i <= 100){
                direction = "right";
                if(collisionOn = true){
                    direction = "left";
                }
            }

            actionLimitCounter = 0;
        }

    }
}
