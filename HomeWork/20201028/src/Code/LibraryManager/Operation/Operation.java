package Code.LibraryManager.Operation;

import Code.LibraryManager.Book.BookList;

import java.util.Scanner;

public interface Operation {
    Scanner sc = new Scanner(System.in);
    void work(BookList bookList);
}
