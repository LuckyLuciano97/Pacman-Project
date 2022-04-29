package main;

import javax.swing.text.html.parser.Entity;
import java.awt.Rectangle;

import sprites.Sprites;

public class CollisionCheck {

    Pacman pm;

    public CollisionCheck(Pacman pm) {
        this.pm = pm;
    }

    public void checkTile(Sprites sprite) {

        int spriteLeftMapX = sprite.mapX + sprite.solidArea.x;
        int spriteRightMapX = sprite.mapX + sprite.solidArea.x + sprite.solidArea.width;
        int spriteTopMapY = sprite.mapY + sprite.solidArea.x;
        int spriteBottomMapY = sprite.mapY + sprite.solidArea.x + sprite.solidArea.width;

        int spriteLeftCol = spriteLeftMapX / pm.tileSize;
        int spriteRightCol = spriteRightMapX / pm.tileSize;
        int spriteTopRow = spriteTopMapY / pm.tileSize;
        int spriteBottomRow = spriteBottomMapY / pm.tileSize;

        int tileNum1, tileNum2;

        switch (sprite.direction) {
            case "up":
                spriteTopRow = (spriteTopMapY - sprite.speed) / pm.tileSize;
                tileNum1 = pm.tileM.mazeTileNum[spriteLeftCol][spriteTopRow];
                tileNum2 = pm.tileM.mazeTileNum[spriteRightCol][spriteTopRow];
                if (pm.tileM.tile[tileNum1].collision == true || pm.tileM.tile[tileNum2].collision == true) {
                    sprite.collisionOn = true;
                }
                break;
            case "down":
                spriteBottomRow = (spriteBottomMapY + sprite.speed) / pm.tileSize;
                tileNum1 = pm.tileM.mazeTileNum[spriteLeftCol][spriteBottomRow];
                tileNum2 = pm.tileM.mazeTileNum[spriteRightCol][spriteBottomRow];
                if (pm.tileM.tile[tileNum1].collision == true || pm.tileM.tile[tileNum2].collision == true) {
                    sprite.collisionOn = true;
                }
                break;
            case "left":
                spriteLeftCol = (spriteLeftMapX - sprite.speed) / pm.tileSize;
                tileNum1 = pm.tileM.mazeTileNum[spriteLeftCol][spriteTopRow];
                tileNum2 = pm.tileM.mazeTileNum[spriteLeftCol][spriteBottomRow];
                if (pm.tileM.tile[tileNum1].collision == true || pm.tileM.tile[tileNum2].collision == true) {
                    sprite.collisionOn = true;
                }
                break;
            case "right":
                spriteRightCol = (spriteRightMapX + sprite.speed) / pm.tileSize;
                tileNum1 = pm.tileM.mazeTileNum[spriteRightCol][spriteTopRow];
                tileNum2 = pm.tileM.mazeTileNum[spriteRightCol][spriteBottomRow];
                if (pm.tileM.tile[tileNum1].collision == true || pm.tileM.tile[tileNum2].collision == true) {
                    sprite.collisionOn = true;
                }
                break;
        }
    }

    public int checkObject(Sprites sprite, boolean player) {

        int index = 999;

        for (int i = 0; i < pm.obj.length; i++) {
            if (pm.obj[i] != null) {

                sprite.solidArea.x = sprite.mapX + sprite.solidArea.x;
                sprite.solidArea.y = sprite.mapY + sprite.solidArea.y;

                pm.obj[i].solidArea.x = pm.obj[i].mapX + pm.obj[i].solidArea.x;
                pm.obj[i].solidArea.y = pm.obj[i].mapY + pm.obj[i].solidArea.y;

                switch (sprite.direction) {
                    case "up":
                        sprite.solidArea.y -= sprite.speed;
                        if (sprite.solidArea.intersects(pm.obj[i].solidArea)) {
                            if (pm.obj[i].collision == true) {
                                sprite.collisionOn = true;

                            }
                            if (player = true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        sprite.solidArea.y += sprite.speed;
                        if (sprite.solidArea.intersects(pm.obj[i].solidArea)) {
                            if (pm.obj[i].collision == true) {
                                sprite.collisionOn = true;

                            }
                            if (player = true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        sprite.solidArea.x -= sprite.speed;
                        if (sprite.solidArea.intersects(pm.obj[i].solidArea)) {
                            if (pm.obj[i].collision == true) {
                                sprite.collisionOn = true;

                            }
                            if (player = true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        sprite.solidArea.x += sprite.speed;
                        if (sprite.solidArea.intersects(pm.obj[i].solidArea)) {
                            if (pm.obj[i].collision == true) {
                                sprite.collisionOn = true;

                            }
                            if (player = true) {
                                index = i;
                            }
                            break;
                        }
                }
                sprite.solidArea.x = sprite.solidAreaDefaultX;
                sprite.solidArea.y = sprite.solidAreaDefaultY;
                pm.obj[i].solidArea.x = pm.obj[i].solidAreaDefaultX;
                pm.obj[i].solidArea.y = pm.obj[i].solidAreaDefaultY;
            }
        }

        return index;
    }
    public int checkSprite(Sprites sprite, Sprites[] target){
        int index = 999;

        for (int i = 0; i < target.length; i++) {
            if (target[i] != null) {

                sprite.solidArea.x = sprite.mapX + sprite.solidArea.x;
                sprite.solidArea.y = sprite.mapY + sprite.solidArea.y;

                target[i].solidArea.x = target[i].mapX + target[i].solidArea.x;
                target[i].solidArea.y = target[i].mapY + target[i].solidArea.y;

                switch (sprite.direction) {
                    case "up":
                        sprite.solidArea.y -= sprite.speed;
                        if (sprite.solidArea.intersects(target[i].solidArea)) {
                                sprite.collisionOn = true;
                                index = i;
                            }
                        break;
                    case "down":
                        sprite.solidArea.y += sprite.speed;
                        if (sprite.solidArea.intersects(target[i].solidArea)) {
                                sprite.collisionOn = true;
                                index = i;
                            }
                        break;
                    case "left":
                        sprite.solidArea.x -= sprite.speed;
                        if (sprite.solidArea.intersects(target[i].solidArea)) {
                                sprite.collisionOn = true;
                                index = i;
                            }
                        break;
                    case "right":
                        sprite.solidArea.x += sprite.speed;
                        if (sprite.solidArea.intersects(target[i].solidArea)) {                   
                                sprite.collisionOn = true;
                                index = i;
                            
                            break;
                        }
                }
                sprite.solidArea.x = sprite.solidAreaDefaultX;
                sprite.solidArea.y = sprite.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }

        return index;
    }
    public void checkPlayer(Sprites sprite){
                sprite.solidArea.x = sprite.mapX + sprite.solidArea.x;
                sprite.solidArea.y = sprite.mapY + sprite.solidArea.y;

                pm.player.solidArea.x = pm.player.mapX + pm.player.solidArea.x;
                pm.player.solidArea.y = pm.player.mapY + pm.player.solidArea.y;

                switch (sprite.direction) {
                    case "up":
                        sprite.solidArea.y -= sprite.speed;
                        if (sprite.solidArea.intersects(pm.player.solidArea)) {
                                sprite.collisionOn = true;
                            }
                        break;
                    case "down":
                        sprite.solidArea.y += sprite.speed;
                        if (sprite.solidArea.intersects(pm.player.solidArea)) {
                                sprite.collisionOn = true;
                            }
                        break;
                    case "left":
                        sprite.solidArea.x -= sprite.speed;
                        if (sprite.solidArea.intersects(pm.player.solidArea)) {
                                sprite.collisionOn = true;
                            }
                        break;
                    case "right":
                        sprite.solidArea.x += sprite.speed;
                        if (sprite.solidArea.intersects(pm.player.solidArea)) {                   
                                sprite.collisionOn = true;
                            break;
                        }
                }
                sprite.solidArea.x = sprite.solidAreaDefaultX;
                sprite.solidArea.y = sprite.solidAreaDefaultY;
                pm.player.solidArea.x = pm.player.solidAreaDefaultX;
                pm.player.solidArea.y = pm.player.solidAreaDefaultY;
    }
}
