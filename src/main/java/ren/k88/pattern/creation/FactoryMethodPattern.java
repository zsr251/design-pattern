package ren.k88.pattern.creation;

/**
 * 工厂模式
 * 定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。工厂方法让类吧实例化推迟到子类
 * Created by jasonzhu on 2017/3/12.
 */
public class FactoryMethodPattern {
    public static void main(String[] args) {
        /**
         * 有个枪工厂，可以根据类型生成不同的枪
         */
        Creator gunFactory = new GunFactory();
        Product p1 = gunFactory.createProduct("pistol");
        System.out.println(p1.getName());
        Product p2 = gunFactory.createProduct("laser");
        System.out.println(p2.getName());
        Product p3 = gunFactory.createProduct("wood");
        System.out.println(p3.getName());
    }
}

/**
 * 工厂
 */
interface Creator {
    Product createProduct(String type);
}

/**
 * 产品
 */
interface Product {
    String getName();
}

/**
 * 枪工厂
 */
class GunFactory implements Creator {
    @Override
    public Product createProduct(String type) {
        if ("pistol".equals(type)) {
            return new Pistol();
        } else if ("laser".equals(type)) {
            return new LaserGun();
        } else if ("wood".equals(type)) {
            return new WoodGun();
        }
        return null;
    }
}

class Pistol implements Product {

    @Override
    public String getName() {
        return "手枪";
    }
}

class LaserGun implements Product {

    @Override
    public String getName() {
        return "激光枪";
    }
}

class WoodGun implements Product {

    @Override
    public String getName() {
        return "木头枪";
    }
}