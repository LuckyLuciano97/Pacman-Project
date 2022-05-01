package main;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.restart();
        
    }

    public void restart(){
        JFrame window = new JFrame();
        window.setResizable(false);
        window.setTitle("Pacman");

        Pacman pacman = new Pacman();
        window.add(pacman);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        pacman.setAssets();
        pacman.startGameThread();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}
