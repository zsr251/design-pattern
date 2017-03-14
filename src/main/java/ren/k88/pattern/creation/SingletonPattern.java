package ren.k88.pattern.creation;

/**
 * 单例模式
 * 确保一个类只有一个实例，并提供全局访问点
 * Created by jasonzhu on 2017/3/15.
 */
public class SingletonPattern {
    public static void main(String[] args) {
        /**
         * 有一个蓄水池，不论实例化多少次都是同一个蓄水池
         */
        Pool p1 = Pool.newInstance();
        p1.getAddress();
        Pool p2 = Pool.newInstance();
        p2.getAddress();
        if (p1 == p2) {
            System.out.println("同一个池子");
        } else {
            System.out.println("不同的池子");
        }
    }
}

class Pool {
    private String address;

    private Pool() {
        this.address = "第一大街的池子";
    }

    /**
     * 内部静态类 延迟加载
     */
    private static class Inner {
        public static Pool pool = new Pool();
    }

    public static Pool newInstance() {
        return Inner.pool;
    }

    public void getAddress() {
        System.out.println(address);
    }
}
