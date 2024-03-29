package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Tower Defense");
        GameField gameField = new GameField();
        gameField.loadMapfromfile("input.txt");
        gameField.loadImageMap();
        gameField.rendermap(primaryStage,0,0);
        GameStage gameStage = new GameStage(13);
        gameStage.loadArrayEnemy("arrEnemy.txt");



        Bullet bullet2 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
        Tower tower = new Tower(null,bullet2);

//        Circle path = new Circle(72*4.5, 72*4.5, 72*6);
//        path.setFill(null);
//        path.setStroke(Color.RED);
//        Config.group.getChildren().add(path);
//        primaryStage.setScene(Config.scene);
//
//        Circle path1 = new Circle(72*4.5, 72*4.5, 72*4);
//        path1.setFill(null);
//        path1.setStroke(Color.BLUE);
//        Config.group.getChildren().add(path1);
//        Config.pane.getChildren().add(Config.group);
//        primaryStage.setScene(Config.scene);
//        primaryStage.show();


        Tower.towerSpawnOnMap(primaryStage, bullet2);

        Stack<Enemy> newStack =gameStage.getStackEnemy();
        Stack<Enemy> newStack1 =gameStage.getStackEnemy();
//        Stack<String> stringStack1 = new Stack<>();
//        stringStack1.push("right");
//        NormalEnemy normalEnemy = new NormalEnemy();
//        normalEnemy.Run(primaryStage,gameStage.x,gameStage.y,stringStack1);

//        image image2 = new image("file:images\\SpinerTower.png");
//        image2.show(primaryStage,72-15,72+30);
//        image image = new image("file:images\\MGTower.png");
//        image.show(primaryStage,72*3-15,72*3);
//        image image1 = new image("file:images\\NormalTower.png");
//        image1.show(primaryStage,72*4,72*1);
        Timeline timeline = new
                Timeline(new KeyFrame(Duration.millis(2000),
                (evt)->{
                   // Stack<String> stringStack = new Stack<>();
                    //stringStack.push("right");
                   //     if(newStack.isEmpty() == false) newStack.pop().Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                    Stack<String> stringStack1 = new Stack<>();
                    stringStack1.push("right");
                    NormalEnemy normalEnemy = new NormalEnemy();
                    normalEnemy.Run(primaryStage,gameStage.x,gameStage.y,stringStack1);
                    //if(Tower.getCount() >=2) System.out.println(Tower.arrayList.get(1).isDanger());
                    if(Tower.getCount() >=5) tower.shoot(primaryStage,Tower.arrayList.get(4));
//                    if(tower.canShoot(72*4.5,72*4.5,72*4,normalEnemy.getimage().getImageView().getX()+12.5,normalEnemy.getimage().getImageView().getY()+12.5))
//                    {
//                        tower.setEnemyTarget(false);
//                    }
//                    image2.show(primaryStage,72-15,72+30);
//                    image.show(primaryStage,72*3-15,72*3);
//                    image1.show(primaryStage,72*4,72*1);


                }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        Timeline timeline1 = new
                Timeline(new KeyFrame(Duration.millis(2000),
                (evt)->{
                        /*Stack<String> stringStack = new Stack<>();
                        stringStack.push("right");
                                if(newStack.isEmpty() == false){
                                    tower.shoot(primaryStage,newStack.get(12));
                                    newStack.pop().Run(primaryStage,gameStage.x,gameStage.y,stringStack);
                                }*/

//                        image2.show(primaryStage,72-15,72+30);
//                        image.show(primaryStage,72*3-15,72*3);
//                        image1.show(primaryStage,72*4,72*1);

                }
        ));
        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.play();
    }
    public static void main(String[] args) {
        launch(args);

    }
}
