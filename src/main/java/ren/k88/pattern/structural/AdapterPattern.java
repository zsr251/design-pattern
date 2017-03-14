package ren.k88.pattern.structural;

/**
 * 适配器模式
 * 将一个类的接口，转换成客户期望的另一个接口。适配器让原本接口不兼容的类可以合作无间
 *
 * 类适配器：使用实现目标接口，继承源角色的方法实现
 * 对象适配器：使用实现目标接口，委派源角色执行方法
 *
 * 装饰者模式 ： 不改变接口，但加入责任
 * 适配器模式 ： 将一个接口转成另一个接口
 * 外观模式  ： 让接口更简单
 * Created by jasonzhu on 2017/3/14.
 */
public class AdapterPattern {
    public static void main(String[] args) {
        /**
         * 实现适配器的两种方式
         */
        //类适配器
        IA a1 = new A1();
        a1.test1();
        a1.test3();

        //对象适配器
        IA a2 = new A2(new B());
        a1.test1();
        a1.test3();
    }
}

/**
 * 目标接口
 */
interface IA{
    void test1();
    void test3();
}

/**
 * 被适配者
 */
class B {
    public void test2(){
        System.out.println("我想要的test2");
    }
}

/**
 * 类适配器
 */
class A1 extends B implements IA{
    @Override
    public void test1() {
        test2();
    }

    @Override
    public void test3() {
        System.out.println("我是新增的方法");
    }
}

/**
 * 对象适配器
 */
class A2 implements IA{
    private B b;
    public A2(B b){
        this.b = b;
    }
    @Override
    public void test1() {
        b.test2();
    }
    @Override
    public void test3() {
        System.out.println("我是新增的方法");
    }

}

