package ren.k88.pattern.structural;

/**
 * 装饰者模式
 * 动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性地替代方案
 * Created by jasonzhu on 2017/3/12.
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        /**
         * 买礼物，包装纸每一层都要钱，包装礼物的装饰物也要钱 最后计算总价格
         */
        Goods book = new Gift("一本书");
        //包一层包装纸
        Goods o = new Paper(book);
        //有一层包装纸
        Goods t = new Paper(o);
        //加一个贺卡
        Goods th = new GreetingCard(t);
        th.getName();
        System.out.println(String.format("礼物是：%s 价格是：%s元",th.getName(),th.cost()));
    }
}

/**
 * 物品
 */
interface Goods {
    String getName();
    Double cost();
}

/**
 * 装饰品
 */
interface Decorator extends Goods {

}

/**
 * 礼物
 */
class Gift implements Goods {
    String name;

    public Gift(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double cost() {
        return 10.0;
    }
}

/**
 * 包装纸
 */
class Paper implements Decorator {
    private Goods goods;

    public Paper(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String getName() {
        return "一张包装纸 + " + goods.getName();
    }

    @Override
    public Double cost() {
        return 1.1 + goods.cost();
    }
}

/**
 * 贺卡
 */
class GreetingCard implements Decorator {
    private Goods goods;

    public GreetingCard(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String getName() {
        return "一张贺卡 + " + goods.getName();
    }

    @Override
    public Double cost() {
        return 4.5 + goods.cost();
    }
}