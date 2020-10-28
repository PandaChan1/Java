package Code.LibraryManager.Operation;

import Code.LibraryManager.Book.BookList;

public class Display implements Operation{
    @Override
    public void work(BookList bookList) {
    int current = bookList.getUsedSize();
        for (int i = 0; i < current; i++) {
            System.out.println(bookList.getBook(i).toString());
        }
    }
}
