package ren.k88.pattern.structural;

/**
 * 外观模式
 * 提供一个统一的接口，用来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用
 * Created by jasonzhu on 2017/3/15.
 */
public class FacadePattern {
    public static void main(String[] args) {
        /**
         * 开机 关机
         */
        TV tv = new TV(new RealDo());
        tv.turnOn();
        tv.turnOff();
    }
}

/**
 * 外观接口
 */
interface ITV {
    void turnOn();
    void turnOff();
}

class TV implements ITV{
    RealDo realDo;
    TV(RealDo realDo){
        this.realDo = realDo;
    }
    @Override
    public void turnOn() {
        realDo.doOn1();
        realDo.doOn2();
        realDo.doOn3();
        realDo.doOn4();
    }

    @Override
    public void turnOff() {
        realDo.doOff1();
        realDo.doOff2();
        realDo.doOff3();
    }
}
class RealDo{
    public void doOn1(){
        System.out.println("开机第一步");
    }
    public void doOn2(){
        System.out.println("开机第二步");
    }
    public void doOn3(){
        System.out.println("开机第三步");
    }
    public void doOn4(){
        System.out.println("开机第四步");
    }
    public void doOff1(){
        System.out.println("关机第一步");
    }
    public void doOff2(){
        System.out.println("关机第二步");
    }
    public void doOff3(){
        System.out.println("关机第三步");
    }
}
