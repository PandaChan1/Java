package Code.LibraryManager;

import Code.LibraryManager.Book.BookList;
import Code.LibraryManager.Operation.Operation;
import Code.LibraryManager.User.Admin;
import Code.LibraryManager.User.NormalUser;
import Code.LibraryManager.User.User;

import java.util.Scanner;

public class Library {
    public static User logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名:");
        String name = scanner.next();
        System.out.println("请输入你的身份：1->管理员  0->普通用户");
        int id = scanner.nextInt();
        if (id == 1) {
            return new Admin(name);  //按照输入创建不同的对象
        } else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = logIn();  //接收对象
        System.out.println("hello " + user.getName() + " 欢迎你来到图书管理系统!");
        while (true) {
            int choice = user.menu();  //动态绑定
            Operation operation = user.doOperation(choice);
            operation.work(bookList);
        }
    }
}
