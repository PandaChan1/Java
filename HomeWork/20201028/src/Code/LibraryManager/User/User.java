package Code.LibraryManager.User;

import Code.LibraryManager.Operation.Operation;

import java.util.Scanner;

public abstract class User {
    private String name;
    Scanner scan = new Scanner(System.in);  //后面会多次使用scanner，直接在抽象类中声明为成员变量
    Operation[] operations;  //存放方法的对象

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();  //对每种user都存在一个menu

    public Operation doOperation(int choice) {
        return this.operations[choice];
    }  //获取operations[]中的操作对象，然后通过这个对象来执行work()方法

    public String getName() {
        return name;
    }
}
