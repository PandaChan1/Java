package extendsPack;

import Code.Animals;

/**
 *@ClassName: frog
 *@Description protected例子
 *@Author PandaChan1
 *@Date 2020/10/26
 *@Time 21:25
 */


class frog extends Animals {

    public frog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(this.name + " frog::eat()");
    }

    public void jump() {
        System.out.println(this.name + " frog::jump()");
    }

    public void swim() {
        System.out.println(this.name + " frog::swim()");
    }
}

public class ProtectedTestDemo {
    public static void main(String[] args) {
        frog frog = new frog("呱呱");
        frog.eat();
        frog.jump();
        frog.swim();
    }
}
