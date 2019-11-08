package sample;

import javafx.scene.image.Image;

public class NormalTower extends Tower {
    public NormalTower(int x_pos, int y_pos){
        super(new Image("file:images\\tower1.png"), 5, 200, 2);
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }
}
