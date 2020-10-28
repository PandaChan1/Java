package Code.LibraryManager.Operation;

import Code.LibraryManager.Book.BookList;

public class Find implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入你要找的书名:");
        String name = this.sc.next();
        int current = bookList.getUsedSize();
        for (int i = 0; i < current; i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                System.out.println("找到"  + "《" + name +  "》");
                System.out.println(bookList.getBook(i));
                return;
            }
        }
        System.out.println("图书馆中没有该书!");
    }
}
