package ren.k88.pattern.behaviour;

/**
 * 模板方法模式
 * 在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以在不改变算法结构的情况下，重新定义算法的某些步骤
 * Created by jasonzhu on 2017/3/15.
 */
public class TemplatePattern {
    public static void main(String[] args) {
        /**
         * 简单模板方法
         */
        RealDo realDo = new RealDo();
        realDo.doThis();
    }
}

/**
 * 模板方法
 */
abstract class AbstractDo{
    final void doThis(){
        step1();
        step2();
        step3();
        step4();
    }
    abstract void step1();
    abstract void step2();
    abstract void step3();
    abstract void step4();
}
class RealDo extends AbstractDo{

    @Override
    void step1() {
        System.out.println("步骤1");
    }

    @Override
    void step2() {
        System.out.println("步骤2");
    }

    @Override
    void step3() {
        System.out.println("步骤3");
    }

    @Override
    void step4() {
        System.out.println("步骤4");
    }
}
