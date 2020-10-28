package Code.LibraryManager.User;

import Code.LibraryManager.Operation.*;

public class Admin extends User {
    public Admin(String name) {
        super(name);
    }

    @Override
    public int menu() {
//        System.out.println("hello "+ this.getName() + " 欢迎你来到图书管理系统!");
        System.out.println("==========================");
        System.out.println("1->查找图书");
        System.out.println("2->新增图书");
        System.out.println("3->删除图书");
        System.out.println("4->显示所有图书");
        System.out.println("0->退出出系统");
        System.out.println("==========================");
        return this.scan.nextInt();
    }

    @Override
    public Operation doOperation(int choice) {
        this.operations = new Operation[] {
                new Exit(),
                new Find(),
                new Add(),
                new Del(),
                new Display(),

        };
        return this.operations[choice];
    }
}

