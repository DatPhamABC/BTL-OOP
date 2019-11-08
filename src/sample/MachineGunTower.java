package sample;

public class MachineGunTower extends  Tower {
    public MachineGunTower(int x, int y, Bullet bullet) {
        super(new image("file:images\\MGTower.png"), x, y, bullet);
    }
}
