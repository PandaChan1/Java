package Code.LibraryManager.Operation;

import Code.LibraryManager.Book.Book;
import Code.LibraryManager.Book.BookList;

public class Add implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入书名:");
        String name = this.sc.next();
        System.out.println("请输入作者:");
        String author = this.sc.next();
        System.out.println("请输入价格:");
        Double price = this.sc.nextDouble();
        System.out.println("请输入类型:");
        String type = this.sc.next();
        Book book = new Book(name,author,price,type);
        bookList.setBook(bookList.getUsedSize(),book);
    }
}
