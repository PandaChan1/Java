package Code.MoreInterface;

/**
 *@ClassName: TestDemo
 *@Description 实现多个接口
 *@Author PandaChan1
 *@Date 2020/10/26
 *@Time 10:20
 */

/**
 * 意义：
 * 1、实现多继承
 * 2、可扩展性非常强
 * 接口是对某一种功能或者行为的抽象
 * 注意：
 * 1、类和接口之间的关系
 * 抽象类是否可以实现接口  可以，但没有意义（抽象类中可以定义普通方法，因此可以）
 * 2、接口和接口之间的关系
 * 接口可以extends接口，即接口的扩展 ,接口也可以extends多个接口
 */
class Animal {
    protected  String name;
    public Animal(String s){
        this.name = s;
    }
}
interface Runing {
    void run();
}
interface  Swimming {
    void swim();
}
interface  Flying {
    void fly();
}
//实现接口
class fish extends Animal implements Swimming {
    public fish (String name){
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(this.name + "fish swimming");
    }
}


class frog extends  Animal implements  Swimming,Runing {
    public frog (String name ) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(this.name + "frog swimming");
    }

    @Override
    public void run() {
        System.out.println(this.name + "frog runing");
    }
}


class duck extends Animal implements Swimming,Runing,Flying{
    public duck(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name + "duck runing");
    }

    @Override
    public void swim() {
        System.out.println(this.name + "duck swimming");
    }

    @Override
    public void fly() {
        System.out.println(this.name + "duck flying");
    }
}

public class TestDemo {
    public static void swim(Swimming swimming) {
        swimming.swim();
    }
    public static void run(Runing runing) {
        runing.run();
    }
    public static void main(String[] args) {
       frog frog= new frog("frog");
       swim(frog);
       run(frog);
    }
}
