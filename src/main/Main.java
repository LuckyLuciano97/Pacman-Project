package main;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
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
    }
}
