package object;

import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Object_Potion extends SuperObject{

    public Object_Potion(){

        this.name = "potion";

        try {
            image = ImageIO.read(new FileInputStream("src/res/objects/potion.png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        collision =true;
    }
}
