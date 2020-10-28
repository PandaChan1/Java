package Code.LibraryManager.Operation;

import Code.LibraryManager.Book.Book;
import Code.LibraryManager.Book.BookList;

public class Del implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("输入你要删除的书名:");
        String name = this.sc.next();
        int current = bookList.getUsedSize();
        for (int i = 0; i < current; i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                for (int j = i; j < current; j++) {
                    bookList.setBook(j,bookList.getBook(j + 1));
                }
                System.out.println("删除成功!");
                bookList.setUsedSize(current - 1);
                return;
            }
        }
        System.out.println("没有该书，删除失败!");
    }
}
