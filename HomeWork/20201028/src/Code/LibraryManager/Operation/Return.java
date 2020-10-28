package Code.LibraryManager.Operation;

import Code.LibraryManager.Book.BookList;

public class Return implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入要还书的名字:");
        String name = this.sc.next();
        int current = bookList.getUsedSize();
        for (int i = 0; i < current; i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                bookList.getBook(i).setBooked(false);
                return;
            }
        }
        System.out.println("该书不是图书馆的书!");
    }
}
