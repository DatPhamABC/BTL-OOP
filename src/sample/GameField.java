package sample;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
import java.io.*;


public class GameField {
    protected GameEntity[][] gameEntities = new GameEntity[Config.heigth_amountimage][Config.width_amountimage];
    protected static String[][] arrmap = new String[Config.heigth_amountimage][Config.width_amountimage];
    //constuctor

    public GameField(GameEntity[][] gameEntities) {
        this.gameEntities = gameEntities;
    }

    public GameField() {
    }

    public GameField(GameEntity[][] gameEntities, String[][] arrmap) {
        this.gameEntities = gameEntities;
        this.arrmap = arrmap;
    }

    //method
    public void loadAndRenderMapfromfile (String namefile, Stage stage, int x, int y)  throws IOException
    {
        BufferedReader buffread = new BufferedReader (new FileReader(namefile));
        for(int i=0;i<Config.heigth_amountimage;i++)
        {
            //read from file
            arrmap[i] = buffread.readLine().split(" ");
            for(int j=0;j<Config.width_amountimage;j++)
            {
                //load image map
                gameEntities[i][j] = new GameEntity(new image("file:images\\"+arrmap[i][j]+".png"));

                //render map
                gameEntities[i][j].image.show(stage,x,y);
                x+=Config.sizeimageMap;
            }

            y+=Config.sizeimageMap;
            x=0;
        }
    }

}
