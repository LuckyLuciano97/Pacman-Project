package object;

import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Object_Dot extends SuperObject {
    
    public Object_Dot(){

        String name = "dot";

        try {
            image = ImageIO.read(new FileInputStream("src/res/objects/dot.png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
