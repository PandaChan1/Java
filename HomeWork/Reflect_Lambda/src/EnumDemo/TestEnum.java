package EnumDemo;

/**
 *@ClassName: TestEnum
 *@Description 自己写的枚举类，默认继承自enum
 *@Author PandaChan1
 *@Date 2020/11/21
 *@Time 10:37
 */

/**
 * 1、自己写的枚举类，会默认继承Enum
 * 问题：Enum类为是那么没有values方法
 * 2、枚举类方法默认是private的
 * 通过反射获取枚举类的类对象需要传入四个参数，因为我们写的枚举类默认继承自Enum
 * 而观察Enum的源码，发现Enum只提供了一个两个参数的构造方法。
 * 而子类的构造方法在实现时，会自动先构造父类（ super关键字 ）。Enum父类需要两个参数，因此需要多传入两个参数
 *
 */

public enum TestEnum {
    RED,BLACK,GREEN,WHITE;
    public static void main(String[] args) {

    }
}
