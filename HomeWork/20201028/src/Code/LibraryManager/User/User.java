package Code.LibraryManager.User;

import Code.LibraryManager.Operation.Operation;

import java.util.Scanner;

public abstract class User {
    private String name;
    Scanner scan = new Scanner(System.in);
    Operation[] operations;  //存放方法的对象

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    public Operation doOperation(int choice) {
        return this.operations[choice];
    }

    public String getName() {
        return name;
    }
}
