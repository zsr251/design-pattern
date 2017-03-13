package ren.k88.pattern.creation;

/**
 * 抽象工厂模式
 * 提供一个接口，用于创建相关或依赖对象的家族，而不需要制定具体类
 * Created by jasonzhu on 2017/3/12.
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        /**
         * 有多家兵器工厂，每个兵器工厂可以生产枪和刀子
         */
        AbstractFactory af = new AFactory();
        Gun ag = af.createGun();
        Knife ak = af.createKnife();
        ag.getName();
        ak.getName();

        AbstractFactory bf = new BFactory();
        Gun bg = bf.createGun();
        Knife bk = bf.createKnife();
        bg.getName();
        bk.getName();

    }

}

/**
 * 抽象工厂
 */
interface AbstractFactory{
    /**
     * 生产枪
     */
    Gun createGun();

    /**
     * 生产刀
     */
    Knife createKnife();
}
interface Gun{
    void getName();
}
interface Knife{
    void getName();
}
class AGun implements Gun{

    @Override
    public void getName() {
        System.out.println("A款枪");
    }
}
class BGun implements Gun{

    @Override
    public void getName() {
        System.out.println("B款枪");
    }
}
class AKinfe implements Knife{

    @Override
    public void getName() {
        System.out.println("A款刀子");
    }
}
class BKinfe implements Knife{

    @Override
    public void getName() {
        System.out.println("B款刀子");
    }
}

/**
 * A工厂
 */
class AFactory implements AbstractFactory{

    @Override
    public Gun createGun() {
        return new AGun();
    }

    @Override
    public Knife createKnife() {
        return new AKinfe();
    }
}

/**
 * B工厂
 */
class BFactory implements AbstractFactory{

    @Override
    public Gun createGun() {
        return new BGun();
    }

    @Override
    public Knife createKnife() {
        return new BKinfe();
    }
}