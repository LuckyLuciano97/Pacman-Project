package main;
import javax.swing.JPanel;

import object.SuperObject;
import sprites.Player;
import tile.TileManager;
import java.awt.Graphics;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;

/**
 * PackmanGEOStarter with JavaFX and Thread
 */

public class Pacman extends JPanel implements Runnable {
   public final int startingTileSize = 16;
   public final int scale = 3;

   public final int tileSize = startingTileSize * scale;
   public final int playerSize = startingTileSize * scale;
   public final int maxScreenCol = 16;
   public final int maxScreenRow = 12;
   public final int screenWidth = tileSize * maxScreenCol;
   public final int screenHeight = tileSize * maxScreenRow;

   //FPS
   int FPS = 60;

   TileManager tileM = new TileManager(this);
   KeyHandler keyH = new KeyHandler();
   Thread gameThread;
   public CollisionCheck collisionCheck = new CollisionCheck(this);
   public AssetManager assetManager = new AssetManager(this);
   public Player player = new Player(this,keyH);
   public SuperObject obj[] = new SuperObject[10];

   public Pacman() {
      this.setPreferredSize(new Dimension(screenWidth, screenHeight));
      this.setBackground(Color.black);
      this.setDoubleBuffered(true);
      this.addKeyListener(keyH);
      this.setFocusable(true);
   }

   public void setAssets(){

      assetManager.setObject();
   }

   public void startGameThread() {
      gameThread = new Thread(this);
      gameThread.start();
   }

   @Override
   public void run() {


      double drawInterval = 1000000000/FPS;
      double nextDrawTime = System.nanoTime() + drawInterval;

      while (gameThread != null) {

         // UPDATE INFO
         update();
         // DRAW SCREEN NEW SCREEN
         repaint();

         try {
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime/1000000;

            if(remainingTime < 0){
               remainingTime = 0;
            }

            Thread.sleep((long) remainingTime);

            nextDrawTime += drawInterval;

         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      } 
   }

   public void update() {

player.update();

   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
     
      //Tiles
      tileM.draw(g2);
      //Object
      for(int i=0;i < obj.length; i++){
         if(obj[i] != null){
            obj[i].draw(g2, this);
         }
      }
      //Player
      player.draw(g2);

      g2.dispose();

   }
}
