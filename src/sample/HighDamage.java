package sample;

import javafx.scene.image.Image;

public class HighDamage extends Tower {
    public HighDamage(int x_pos, int y_pos){
        super(new Image("file:images\\highDamage.png"), 15, 200, 1);
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }
}
