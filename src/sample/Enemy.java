package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Stack;

public class Enemy extends GameEntity {
    protected int speed;
    protected Health health;
    protected int armor;
    protected int bonus;
    protected boolean danger;
    protected int distant = 0;

    public boolean isDanger() {
        return danger;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
    }

    public Enemy() {
        speed =0;
        health=null;
        armor =0;
        bonus=0;
        danger =false;
    }

    public Enemy(sample.image image, int speed, Health health, int armor, int bonus) {
        super(image);
        this.speed = speed;
        this.health = health;
        this.armor = armor;
        this.bonus = bonus;
        this.danger=false;
    }
 // getter && setter
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    // method
    public void Run(Stage stage, final int x_now , final int y_now, Stack<String> direction)
    {
        image.show(stage,x_now,y_now);
        health.getImgBlood().show(stage,x_now,y_now);
       /* Timeline timeline1 = new
                Timeline(new KeyFrame(Duration.millis(1000),
                (evt)->{
                    Bullet bullet2 = new Bullet(new image("file:images\\bullet.png"),100,100,100);
                    bullet2.shoot(stage,72*5,72*3,this.getimage().getImageView().getX()+12.5,this.getimage().getImageView().getY()+12.5);
                }
        ));
        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.play();*/
        Timeline timeline = new
                Timeline(new KeyFrame(Duration.millis(20),
                (evt)->{
                         //Tower.addTarget(this);
                       try
                       {
                           String way = checkRoad((int)image.getImageView().getX(),(int)image.getImageView().getY(),direction);
                           if(way.equals("right"))
                           {

                               image.getImageView().setX(image.getImageView().getX()+1);
                               health.getImgBlood().getImageView().setX((health.getImgBlood().getImageView().getX()+1));
                               if(image.getImageView().getX() >= Config.width_scene) die();
                           }
                           if(way.equals("up"))
                           {
                               image.getImageView().setY(image.getImageView().getY()-1);
                               health.getImgBlood().getImageView().setY(health.getImgBlood().getImageView().getY()-1);
                               if(image.getImageView().getY()-11 < 0) die();
                           }
                           if(way.equals("down"))
                           {
                               image.getImageView().setY(image.getImageView().getY()+1);
                               health.getImgBlood().getImageView().setY(health.getImgBlood().getImageView().getY()+1);
                               if(image.getImageView().getY() >= Config.height_scene) die();
                           }
                           if(way.equals("left"))
                           {
                               image.getImageView().setX(image.getImageView().getX()-1);
                               health.getImgBlood().getImageView().setX(health.getImgBlood().getImageView().getX()-1);
                               if(image.getImageView().getX() <0) die();
                           }
                       }
                       catch (ArrayIndexOutOfBoundsException e)
                       {

                       }

                }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    public String checkRoad(int x,int y ,Stack<String> direction)
    {
        if(direction.peek().equals("right") || direction.peek().equals("down"))
        {
            int arr_x = (x-11)/Config.sizeimageMap;
            int arr_y = (y-11)/Config.sizeimageMap;
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==6) {
                if(direction.peek()!="right") direction.push("right");
                return "right";
            }
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==8) {
                if(direction.peek()!="up") direction.push("up");
                return "up";
            }
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==5) {
                if(direction.peek()!="down") direction.push("down");
                return "down";
            }
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==4)
            {
                if(direction.peek()!="left") direction.push("left");
                return "left";
            }
            return "finish";
        }
        if(direction.peek().equals("left") || direction.peek().equals("up"))
        {
            int arr_x = (x+60)/Config.sizeimageMap;
            int arr_y = (y+60)/Config.sizeimageMap;
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==6) {
                if(direction.peek()!="right") direction.push("right");
                return "right";
            }
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==8) {
                if(direction.peek()!="up") direction.push("up");
                return "up";
            }
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==5) {
                if(direction.peek()!="down") direction.push("down");
                return "down";
            }
            if( Integer.parseInt(GameField.arrmap[arr_y][arr_x])==4)
            {
                if(direction.peek()!="left") direction.push("left");
                return "left";
            }
            return "finish";
        }
        return "finish";
    }

    public void die()
    {
        this.getimage().remote();
        speed = 0;
        this.getHealth().getImgBlood().remote();
        armor =0;
        bonus=0;
    }


    public boolean equals(Enemy enemy) {
        if (this.x != enemy.x) return false;
        if (this.y != enemy.y) return false;
        if (!this.image.equals(enemy.image)) return false;
        return true;
    }
}
