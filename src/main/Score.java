package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Score {

    Pacman pm;
    Graphics2D g2;
    Font arial_25, arial_40B;
    public boolean levelCompleted = false;

    public Score(Pacman pm){
     
        this.pm = pm;
        arial_25 = new Font("Arial", Font.PLAIN, 25);
        arial_40B = new Font("Arial", Font.BOLD, 40);

    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        if(levelCompleted == true){

            String text;
            int textLength;
            int x;
            int y;

            g2.setFont(arial_40B);
            g2.setColor(Color.BLACK);
            text = "You have completed the level";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = pm.screenWidth/2 - textLength/2;
            y = pm.screenHeight/2 - (pm.tileSize*3);
            g2.drawString(text, x, y);

        
            
            text = "Congratulations";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = pm.screenWidth/2 - textLength/2;
            y = pm.screenHeight/2 + (pm.tileSize*2);
            g2.drawString(text, x, y);

            pm.gameThread = null;
            

        } else{

            g2.setFont(arial_25);
            g2.setColor(Color.black);
            g2.drawString("Score: "+ pm.player.score, 30, 30);

            if(pm.gameState == pm.playState){

            }if(pm.gameState == pm.pauseState){
                drawPaused();
            }
        }

    }

    public void drawPaused(){
        String text = "Paused game";
        int x = getXforCenter(text);
        int y = pm.screenHeight/2;
        g2.drawString(text, x, y);
    }

    public int getXforCenter(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = pm.screenWidth/2 - length/2;
        return x;

    }
    
}

