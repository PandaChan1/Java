package Code.LibraryManager.Operation;

import Code.LibraryManager.Book.BookList;

public class Borrow implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入你要借的书:");
        String name = this.sc.next();
        int current = bookList.getUsedSize();
        for (int i = 0; i < current; i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                bookList.getBook(i).setBooked(true);
                System.out.println("借阅成功!");
                return;
            }
        }
        System.out.println("没有该书,借阅失败!");
    }
}
