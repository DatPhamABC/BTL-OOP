package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Stack;

public class Tower extends GameEntity {
    private Bullet bullet;
    private boolean enemyTarget=false;
    public static ArrayList<Enemy> arrayList = new ArrayList<>();
    private static  int count=0;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Tower.count = count;
    }

    public boolean isEnemyTarget() {
        return enemyTarget;
    }

    public void setEnemyTarget(boolean enemyTarget) {
        this.enemyTarget = enemyTarget;
    }

    public Tower(sample.image image, Bullet bullet) {
        super(image);
        this.bullet = bullet;

    }
    // getter && setter
    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public Tower(sample.image image, int x, int y, Bullet bullet) {
        super(image, x, y);
        this.bullet = bullet;
    }
    public void Target (Stack<Enemy> enemyStack, Tower tower) {

    }

    public static void addTarget (Enemy enemy)
    {
        if(enemy.getimage().getImageView() != null)
        {
            if(canShoot1(72*4.5,72*4.5,72*4,enemy.getimage().getImageView().getX()+12.5,enemy.getimage().getImageView().getY()+12.5))
            {
                if(enemy.isDanger() == false) {
                    arrayList.add(enemy);
                    count++;
                    enemy.setDanger(true);
                }
            }
            else {
                if(enemy.isDanger() == true) {
                    arrayList.remove(enemy);
                    count--;
                    enemy.setDanger(false);
                }
            }
        }
    }
    public static void built()
    {

    }

    public void shoot(Stage stage ,Enemy enemy)
    {
        //Enemy enemy = enemyTarget(GameStage.stackEnemy,this);
        Timeline timeline1 = new
                Timeline(new KeyFrame(Duration.millis(1000),
                (evt)->{
                    if(this.canShoot1(72*4.5,72*4.5,72*4,enemy.getimage().getImageView().getX()+12.5,enemy.getimage().getImageView().getY()+12.5))
                    {
                        //System.out.println(this.canShoot(72*4.5,72*4.5,72*4,enemy.getimage().getImageView().getX()+12.5,enemy.getimage().getImageView().getY()+12.5));
                        // build tower
                        Bullet bullet3 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
                        bullet3.shoot(stage,72-15,72+30,enemy.getimage().getImageView().getX()+12.5,enemy.getimage().getImageView().getY()+12.5);
                        Bullet bullet4 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
                        bullet4.shoot(stage,72*3-15,72*3,enemy.getimage().getImageView().getX()+12.5,enemy.getimage().getImageView().getY()+12.5);
                        Bullet bullet5 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
                        bullet5.shoot(stage,72*4,72*1,enemy.getimage().getImageView().getX()+12.5,enemy.getimage().getImageView().getY()+12.5);
                    }
                }
        ));
        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.play();
    }


    public static boolean canShoot1(double x ,double y , double range,double x_target,double y_target)
    {
        double  distance = Math.sqrt((x-x_target)*(x-x_target)+(y-y_target)*(y-y_target));
        return distance < range;
    }


    public void towerBuild (Stage stage){
        image.show(stage, this.x - (image.getImage().getWidth()-Config.sizeimageMap),
                this.y - (image.getImage().getHeight()-Config.sizeimageMap));

        Circle circle = new Circle(x + Config.sizeimageMap/2, y + Config.sizeimageMap/2,
                200, Color.color(0.192, 0.192, 0.192, 0.1));
        Config.pane.getChildren().add(circle);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2.5),
                        event -> { Config.pane.getChildren().remove(circle); }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}
