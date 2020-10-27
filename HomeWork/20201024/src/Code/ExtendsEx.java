package Code;
/**
 *@ClassName: ExtendsEx
 *@Description 继承例子
 *@Author PandaChan1
 *@Date 2020/10/24
 *@Time 18:43
 */

class Animal{
    protected String name;
    public Animal(String name ) {
        this.name = name;
    }
    public void eat(){
        System.out.println("吃东西");
    }
}
class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(this.name+"cat::eat()");
    }
}
class Bird extends Animal{
    public Bird(String name) {
        super(name);
    }
    @Override
    public void eat() {
        System.out.println("bird::eat()");
    }
    public void fly(){
        System.out.println(this.name+"fly()");
    }
}

public class ExtendsEx {
    public static Animal whatAnimal(Cat cat) {
        return cat;
    }
    public static void whatsAnimal(Animal animal) {
        animal.eat();
    }
    public static void main(String[] args) {
//        Cat cat = new Cat("咪咪");
//        whatAnimal(cat).eat();
//
//        cat.eat();
//        Bird bird =new Bird("小鸟");
//        bird.eat();
//        bird.fly();
        Animal animal = new Cat("咪咪");
        whatsAnimal(animal);
    }
}
