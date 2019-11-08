package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Time;
import java.util.Stack;

public class Tower {
    protected Image image1;
    protected int damage;
    protected int x_pos;
    protected int y_pos;
    protected int range;
    protected int speed;

    public Tower(){}
    public Tower(Image image1, int damage, int range, int speed){
        this.image1 = image1;
        this.damage = damage;
        this.range = range;
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Image getImage1() {
        return image1;
    }
    public void setImage1(Image image1) {
        this.image1 = image1;
    }

    public void shoot(Stage stage, Enemy enemy){
        if (rangeCheck(enemy)){
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(speed*100),
                    e -> {
                        enemy.health.blood -= damage;
                        System.out.println(enemy.health.blood);
                    }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }

    private boolean rangeCheck(Enemy enemy){
        int delta_pos = (int)Math.sqrt((enemy.x + (enemy.width/2) - x_pos)*(enemy.x + (enemy.width/2) - x_pos) +
                (enemy.y + (enemy.height/2) - y_pos)*(enemy.y + (enemy.height/2) - y_pos));
        if (delta_pos <= range){
            return true;
        }
        return false;
    }

    public void towerBuild (Stage stage){
            if (GameField.arrmap[(Config.y_pos / Config.sizeimageMap)][(Config.x_pos / Config.sizeimageMap)].equals("2")) {
                ImageView imageView = new ImageView(image1);
                imageView.setFitHeight(Config.sizeimageMap);
                imageView.setFitWidth(Config.sizeimageMap);
                imageView.setX(Config.x_pos);
                imageView.setY(Config.y_pos);
                imageView.setPreserveRatio(true);
                Circle circle = new Circle(x_pos + Config.sizeimageMap/2, y_pos+ Config.sizeimageMap/2,
                        200, Color.color(0.192, 0.192, 0.192, 0.1));
                Config.pane.getChildren().addAll(imageView, circle);
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(3),
                                event -> { Config.pane.getChildren().remove(circle); }));
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
            }
    }
}
