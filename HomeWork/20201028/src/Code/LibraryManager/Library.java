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
            return new Admin(name);
        } else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("111");
        str.append("dada");
        BookList bookList = new BookList();
        User user = logIn();
        System.out.println("hello " + user.getName() + " 欢迎你来到图书管理系统!");
        while (true) {
            int choice = user.menu();
            Operation operation = user.doOperation(choice);
            operation.work(bookList);
        }
    }
}
