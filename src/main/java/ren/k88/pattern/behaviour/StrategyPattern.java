package ren.k88.pattern.behaviour;

/**
 * 策略模式
 * 定义了算法簇，分别封装起来，让它们之间可以互相替换，此模式让算法的变化独立于使用算法的客户
 * Created by jasonzhu on 2017/3/11.
 */
public class StrategyPattern {
    public static void main(String[] args) {
        /**
         * 有一个士兵，他有很多把武器，执行任务时只可以使用一把武器，但可以随时换武器
         */
        Soldier soldier = new Soldier();
        soldier.kill();
        soldier.changeWeapon(new Knife());
        soldier.kill();
        soldier.changeWeapon(new Brick());
        soldier.kill();
    }
}

/**
 * 士兵
 */
class Soldier {
    private Weapon weapon = new Gun();

    public void changeWeapon(Weapon weapon) {
        this.weapon = weapon;
        System.out.println("我换武器啦");
    }

    public void kill() {
        weapon.kill();
    }
}

/**
 * 武器
 */
interface Weapon {
    void kill();
}

/**
 * 枪
 */
class Gun implements Weapon {

    @Override
    public void kill() {
        System.out.println("biu biu biu~~ 打手枪来呀～～");
    }
}

/**
 * 刀
 */
class Knife implements Weapon {

    @Override
    public void kill() {
        System.out.println("来呀小贼！砍死你～～");
    }
}

/**
 * 板砖
 */
class Brick implements Weapon {

    @Override
    public void kill() {
        System.out.println("我他喵的拍死你～～");
    }
}