package ren.k88.pattern.behaviour;

/**
 * 命令模式
 * 将"请求"封闭称对象，以便使用不同的请求，队列活着日志来参数化其他对象。命令模式也支持可撤销的操作
 *
 * 1. 当一个应用程序调用者与多个目标对象之间存在调用关系，并且目标对象的操作都是类似的时候
 * 2. 当一个目标对象内部的方法调用太复杂，或者内部的方法需要协调才能完成对象的某个特点操作时
 * 3. 有时候调用者调用对象后，需要回掉一些方法
 *
 * Invoker ： 调用者对象
 * Receiver ： 接收调用者请求执行操作的目标对象
 * command ：用于解耦目标对象与调用者之间的抽象命令对象 一个实现类只执行一个命令
 * CommandOn ： 执行开机命令的类
 * CommandOff ： 执行关机命令的类
 * Created by jasonzhu on 2017/3/14.
 */
public class CommandPattern {
    public static void main(String[] args) {
        /**
         * 调用机器的开关
         */
        //真正的命令执行者
        Receiver receiver = new Receiver();
        //封装为命令对象 开机
        Command commandOn = new CommandOn(receiver);
        //封装为命令对象 关机
        Command commandOff = new CommandOff(receiver);
        //调用对象 相当于遥控器
        Invoker invoker =  new Invoker(commandOn,commandOff);
        invoker.runOn();
        invoker.runOff();
    }
}

/**
 * 命令 单个方法
 */
interface Command {
    void execute();
}

/**
 * 命令接受者
 */
class Receiver {
    public void turnOn(){
        System.out.println("真正执行命令操作的代码 on");
    }
    public void turnOff(){
        System.out.println("真正执行命令操作的代码 off");
    }
}

/**
 * 执行命令开机
 */
class CommandOn implements Command{
    private Receiver receiver;

    /**
     * 设置命令接受者
     */
   public CommandOn(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOn();
    }
}

/**
 * 执行命令关机
 */
class CommandOff implements Command{
    private Receiver receiver;

    /**
     * 设置命令接受者
     */
    public CommandOff(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnOff();
    }
}

/**
 * 调用者
 */
class Invoker {
    private Command commandOn;
    private Command commandOff;
    public Invoker(Command commandOn,Command commandOff){
        this.commandOn = commandOn;
        this.commandOff = commandOff;
    }
    public void runOn(){
        commandOn.execute();
    }
    public void runOff(){
        commandOff.execute();
    }
}
