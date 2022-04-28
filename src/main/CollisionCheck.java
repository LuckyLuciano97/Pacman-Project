package main;

import javax.swing.text.html.parser.Entity;

import sprites.Sprites;

public class CollisionCheck {

    Pacman pm;

    public CollisionCheck(Pacman pm){
        this.pm = pm;
    }

    public void checkTile(Sprites sprite){

        int spriteLeftMapX = sprite.mapX + (int)sprite.solidArea.x;
        int spriteRightMapX = sprite.mapX + (int)sprite.solidArea.x + (int)sprite.solidArea.width;
        int spriteTopMapY = sprite.mapY + (int)sprite.solidArea.x;
        int spriteBottomMapY = sprite.mapY + (int)sprite.solidArea.x + (int)sprite.solidArea.width;

        int spriteLeftCol = spriteLeftMapX/pm.tileSize;
        int spriteRightCol = spriteRightMapX/pm.tileSize;
        int spriteTopRow = spriteTopMapY/pm.tileSize;
        int spriteBottomRow = spriteBottomMapY/pm.tileSize;

        int tileNum1, tileNum2;

        switch(sprite.direction){
            case "up":
            spriteTopRow = (spriteTopMapY - sprite.speed)/pm.tileSize;
            tileNum1 = pm.tileM.mazeTileNum[spriteLeftCol][spriteTopRow];
            tileNum2 = pm.tileM.mazeTileNum[spriteRightCol][spriteTopRow];
            if(pm.tileM.tile[tileNum1].collision == true || pm.tileM.tile[tileNum2].collision == true) {
                sprite.collisionOn = true;
            }
            break;
            case "down":
            spriteBottomRow = (spriteBottomMapY + sprite.speed)/pm.tileSize;
            tileNum1 = pm.tileM.mazeTileNum[spriteLeftCol][spriteBottomRow];
            tileNum2 = pm.tileM.mazeTileNum[spriteRightCol][spriteBottomRow];
            if(pm.tileM.tile[tileNum1].collision == true || pm.tileM.tile[tileNum2].collision == true) {
                sprite.collisionOn = true;
            }
            break;
            case "left":
            spriteLeftCol = (spriteLeftMapX - sprite.speed)/pm.tileSize;
            tileNum1 = pm.tileM.mazeTileNum[spriteLeftCol][spriteTopRow];
            tileNum2 = pm.tileM.mazeTileNum[spriteLeftCol][spriteBottomRow];
            if(pm.tileM.tile[tileNum1].collision == true || pm.tileM.tile[tileNum2].collision == true) {
                sprite.collisionOn = true;
            }
            break;
            case "right":
            spriteRightCol = (spriteRightMapX + sprite.speed)/pm.tileSize;
            tileNum1 = pm.tileM.mazeTileNum[spriteRightCol][spriteTopRow];
            tileNum2 = pm.tileM.mazeTileNum[spriteRightCol][spriteBottomRow];
            if(pm.tileM.tile[tileNum1].collision == true || pm.tileM.tile[tileNum2].collision == true) {
                sprite.collisionOn = true;
            }
            break;
        }
    }
    // public int checkObject(Sprites sprite, boolean player){

    //     int index = 999;


    //     for(int i=0;i<pm.obj.length;i++){
    //         if(pm.obj[i] != null){

    //             sprite.solidArea.x = sprite.mapX + sprite.solidArea.x;

    //             spriteSolidAreaX = sprite.mapX + spriteSolidAreaX;
    //             spriteSolidAreaY = sprite.mapY + spriteSolidAreaY;

    //             int pmOBJx = (int) pm.obj[i].solidArea.getX();
    //             int pmOBJy = (int) pm.obj[i].solidArea.getY();


    //             pmOBJx = (int) (pm.obj[i].mapX + pm.obj[i].solidArea.getX());
    //             pmOBJy = (int) (pm.obj[i].mapX + pm.obj[i].solidArea.getY());

    //             switch(sprite.direction){
    //                 case "up":
    //                     spriteSolidAreaY -= sprite.speed;
    //                     if(sprite.solidArea.intersects((pm.obj[i].solidArea).getBoundsInParent())){
    //                         System.out.println("up collision");
    //                     }
    //                 break;
    //                 case "down":
    //                     spriteSolidAreaY += sprite.speed;
    //                     if(sprite.solidArea.intersects((pm.obj[i].solidArea).getBoundsInParent())){
    //                         System.out.println("down collision");
    //                     }
    //                 break;
    //                 case "left":
    //                     spriteSolidAreaX -= sprite.speed;
    //                     if(sprite.solidArea.intersects((pm.obj[i].solidArea).getBoundsInParent())){
    //                         System.out.println("left collision");
    //                     }
    //                 break;
    //                 case "right":
    //                     spriteSolidAreaX += sprite.speed;
    //                     if(sprite.solidArea.intersects((pm.obj[i].solidArea).getBoundsInParent())){
    //                         System.out.println("right collision");
    //                     }
    //                 break;
    //             }

    //         }
    //         int pmOBJx = (int) pm.obj[i].solidArea.getX();
    //         int pmOBJy = (int) pm.obj[i].solidArea.getY();

    //         spriteSolidAreaX = sprite.solidAreaDefaultX;
    //         spriteSolidAreaY = sprite.solidAreaDefaultY;
    //         pmOBJx = pm.obj[i].solidAreaDefaultX;
    //         pmOBJy = pm.obj[i].solidAreaDefaultY;

    //     }

    //     return index;
    // }
}
