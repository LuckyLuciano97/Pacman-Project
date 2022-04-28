package tile;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.*;

import javax.imageio.ImageIO;

import main.Pacman;

public class TileManager {
    
    Pacman pm;
    public Tile[] tile;
    public int mazeTileNum[] [];

    public TileManager(Pacman pm){

        this.pm = pm;

        tile = new Tile[12];
        mazeTileNum = new int[pm.maxScreenCol][pm.maxScreenRow];

        getTileImage();
        loadMaze("src/res/map/maze1.txt");
    }

    public void getTileImage(){

    try {

        tile[0] = new Tile();
        tile[0].image = ImageIO.read(new FileInputStream("src/res/tiles/blue_tile.png"));

        tile[1] = new Tile();
        tile[1].image = ImageIO.read(new FileInputStream("src/res/tiles/tile_horizontal.png"));
        tile[1].collision = true;

        tile[2] = new Tile();
        tile[2].image = ImageIO.read(new FileInputStream("src/res/tiles/tile_vertical.png"));
        tile[2].collision = true;
        
        tile[3] = new Tile();
        tile[3].image = ImageIO.read(new FileInputStream("src/res/tiles/tile_top_end.png"));
        tile[3].collision = true;

        tile[4] = new Tile();
        tile[4].image = ImageIO.read(new FileInputStream("src/res/tiles/tile_right_end.png"));
        tile[4].collision = true;

        tile[5] = new Tile();
        tile[5].image = ImageIO.read(new FileInputStream("src/res/tiles/tile_bottom_end.png"));
        tile[5].collision = true;

        tile[6] = new Tile();
        tile[6].image = ImageIO.read(new FileInputStream("src/res/tiles/tile_left_end.png"));
        tile[6].collision = true;

        tile[7] = new Tile();
        tile[7].image = ImageIO.read(new FileInputStream("src/res/tiles/tilecorners_top_left.png"));
        tile[7].collision = true;

        tile[8] = new Tile();
        tile[8].image = ImageIO.read(new FileInputStream("src/res/tiles/tilecorners_top_right.png"));
        tile[8].collision = true;

        tile[9] = new Tile();
        tile[9].image = ImageIO.read(new FileInputStream("src/res/tiles/tilecorners_bottom_right.png"));
        tile[9].collision = true;

        tile[10] = new Tile();
        tile[10].image = ImageIO.read(new FileInputStream("src/res/tiles/tilecorners_bottom_left.png"));
        tile[10].collision = true;

        tile[11] = new Tile();
        tile[11].image = ImageIO.read(new FileInputStream("src/res/tiles/tilecorners_cross.png"));
        tile[11].collision = true;

    } catch (IOException ioe) {
        ioe.printStackTrace();
    }

}

public void loadMaze(String filePath){
    try {
        InputStream is = new FileInputStream(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        int col = 0;
        int row = 0;

        while(col < pm.maxScreenCol && row < pm.maxScreenRow){
            String line = br.readLine();
            while(col < pm.maxScreenCol){
                String numbers[] = line.split(" ");

                int num = Integer.parseInt(numbers[col]);

                mazeTileNum[col][row] = num;
                col++;
            }
            if(col==pm.maxScreenCol){
                col = 0;
                row++;
            }
        }
        br.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void draw(Graphics2D g2){

int col = 0;
int row = 0;
int x = 0;
int y = 0;

while(col < pm.maxScreenCol && row < pm.maxScreenRow){

        int tileNum = mazeTileNum[col][row];

        g2.drawImage(tile[tileNum].image, x, y, pm.tileSize, pm.tileSize, null);
        col++;
        x += pm.tileSize;

        if(col == pm.maxScreenCol){
            col = 0;
            x = 0;
            row++;
            y += pm.tileSize;
        }
}

}
}
