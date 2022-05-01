// package object;

// import java.io.FileInputStream;
// import java.io.IOException;

// import javax.imageio.ImageIO;

// import main.Pacman;

// public class Object_life extends SuperObject{

//     Pacman pm;

//     public Object_life(Pacman pm){
        
//         this.pm = pm;

//         name = "life";
//         try {
//             image = ImageIO.read(new FileInputStream("src/res/objects/life_0.png"));
//             image2 = ImageIO.read(new FileInputStream("src/res/objects/life_1.png"));
//         } catch (IOException ioe) {
//             ioe.printStackTrace();
//         }
//         collision =true;
//     }
// }