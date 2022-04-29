package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;

import java.awt.Graphics2D;

public class Score {

    Pacman pm;
    Graphics2D g2;
    Font arial_25, arial_40B;
    public boolean levelCompleted = false;
    public int commandNum = 0;
    public int titleScreenState = 0; // 0: first screen, 1: secondscreen

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

            if(pm.gameState == pm.titleState){
                drawTitle();
            }
            if(pm.gameState == pm.playState){

            }
            if(pm.gameState == pm.pauseState){
                drawPaused();
            }
        }

    }
    public void drawTitle(){
        if(titleScreenState == 0){
            g2.setColor(new Color(0, 0, 0));
            g2.fillRect(0, 0, pm.screenWidth, pm.screenHeight);
    
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
            String text = "Pac-Man Game";
            int x = getXforCenter(text);
            int y = pm.tileSize *3;
    
            g2.setColor(Color.YELLOW);
            g2.drawString(text, x, y);
    
            //pacman image
            x = pm.screenWidth/2 - (pm.tileSize*4)/2;
            y += pm.tileSize;
            g2.drawImage(pm.player.right, x, y, pm.playerSize*4, pm.playerSize*4, null);
    
            //Menu
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,42F));
    
            text = "SINGLE PLAYER";
            x = getXforCenter(text);
            y = pm.tileSize *9;
            g2.drawString(text, x, y);
            if(commandNum == 0){
                g2.drawString(">", x-pm.tileSize, y);
            }
    
            text = "MULTI PLAYER";
            x = getXforCenter(text);
            y += pm.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawString(">", x-pm.tileSize, y);
            }
    
            text = "EXIT GAME";
            x = getXforCenter(text);
            y += pm.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawString(">", x-pm.tileSize, y);
            }
    
        } else if(titleScreenState == 1){
            g2.setColor(Color.BLACK);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

            String text = "Instructions for playing";
            int x = getXforCenter(text);
            int y = pm.tileSize *3;
            g2.setColor(Color.YELLOW);
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(28F));

            text = "Collect all the dots to win the game";
            x = getXforCenter(text);
            y += pm.tileSize*2;
            g2.drawString(text, x, y);

            text = "You have three tries to collect all of them";
            x = getXforCenter(text);
            y += pm.tileSize;
            g2.drawString(text, x, y);

            text = "Avoid the ghosts that are roaming around";
            x = getXforCenter(text);
            y += pm.tileSize;
            g2.drawString(text, x, y);

            text = "Collect the special potion to defeat the ghosts";
            x = getXforCenter(text);
            y += pm.tileSize;
            g2.drawString(text, x, y);

            text = "PRESS THE SPACE BUTTON TO START THE GAME";
            x = getXforCenter(text);
            y += pm.tileSize*2;
            g2.drawString(text, x, y);
            
            
            
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

