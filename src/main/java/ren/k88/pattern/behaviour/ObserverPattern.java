package ren.k88.pattern.behaviour;

import java.util.LinkedList;
import java.util.List;

/**
 * 观察者模式
 * 定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖着都会受到通知并自动更新
 * Created by jasonzhu on 2017/3/11.
 */
public class ObserverPattern {
    public static void main(String[] args) {
        /**
         * 有一个堡垒，当敌人快到达堡垒时，前锋要向前杀敌，后勤部队要向后撤退
         */
        Fort fort = new Fort();
        //前锋
        Observer v = new Vanguard();
        //后勤
        Observer l = new Logistics();
        fort.registerObserver(v);
        fort.registerObserver(l);
        //敌人来啦 通知观察者
        fort.notifyObservers();
        //前锋死了 取消观察者身份
        fort.removeObserver(v);
        //敌人又来了
        fort.notifyObservers();
    }
}

/**
 * 堡垒
 */
class Fort implements Subject{
    List<Observer> observers = new LinkedList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("敌人来了，我可告诉你们了哈！");
        for (Observer observer : observers) {
            observer.doSomething();
        }
    }
}

/**
 * 前锋
 */
class Vanguard implements Observer{

    @Override
    public void doSomething() {
        System.out.println("小鬼子来啦，冲啊！！杀呀～～");
    }
}

/**
 * 后勤
 */
class Logistics implements Observer{

    @Override
    public void doSomething() {
        System.out.println("鬼子来啦，撒丫子 撤他娘滴！～～");
    }
}
interface Subject{
    /**
     * 注册观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有观察者
     */
    void notifyObservers();
}

/**
 * 观察者
 */
interface Observer{
    void doSomething();
}

