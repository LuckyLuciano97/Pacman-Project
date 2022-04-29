package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    Pacman pm;

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public KeyHandler(Pacman pm) {
        this.pm = pm;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (pm.gameState == pm.titleState) {
            if (pm.sc.titleScreenState == 0) {

                if (code == KeyEvent.VK_UP) {
                    pm.sc.commandNum--;
                    if (pm.sc.commandNum < 0) {
                        pm.sc.commandNum++;
                    }
                }
                if (code == KeyEvent.VK_DOWN) {
                    pm.sc.commandNum++;
                    if (pm.sc.commandNum > 2) {
                        pm.sc.commandNum--;
                    }
                }
                if (code == KeyEvent.VK_ENTER) {
                    if (pm.sc.commandNum == 0) {
                        pm.sc.titleScreenState = 1;
                    }
                    if (pm.sc.commandNum == 1) {
                        // multiplayer
                    }
                    if (pm.sc.commandNum == 2) {
                        System.exit(0);
                    }
                }

            }
            if (pm.sc.titleScreenState == 1) {
                if (code == KeyEvent.VK_SPACE) {
                    pm.sc.commandNum--;
                    if (pm.sc.commandNum == -1) {
                        pm.gameState = pm.playState;
                    }
                    }
            }
        }

        if (code == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if (code == KeyEvent.VK_P) {
            if (pm.gameState == pm.playState) {
                pm.gameState = pm.pauseState;
            } else if (pm.gameState == pm.pauseState) {
                pm.gameState = pm.playState;

            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

}
