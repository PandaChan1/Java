package Code.LibraryManager.User;

import Code.LibraryManager.Operation.*;

import javax.print.attribute.standard.Fidelity;

public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
    }

    @Override
    public int menu() {
//        System.out.println("hello " + this.getName() + " 欢迎你来到图书管理系统!");
        System.out.println("==========================");
        System.out.println("1->查找图书");
        System.out.println("2->借阅图书");
        System.out.println("3->归还图书");
        System.out.println("0->退出出系统");
        System.out.println("==========================");
        return this.scan.nextInt();
    }

    @Override
    public Operation doOperation(int choice) {
        this.operations = new Operation[]{
                new Exit(),
                new Find(),
                new Borrow(),
                new Return(),

        };
       return this.operations[choice];
    }
}
