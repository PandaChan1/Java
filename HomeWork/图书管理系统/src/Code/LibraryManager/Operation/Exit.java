package Code.LibraryManager.Operation;

import Code.LibraryManager.Book.BookList;

public class Exit implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("系统退出!");
        System.exit(0);
    }
}
