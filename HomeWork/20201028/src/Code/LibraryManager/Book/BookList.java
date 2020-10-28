package Code.LibraryManager.Book;

public class BookList {
    private Book[] elem = new Book[10];  //顺序表
    private int usedSize;

    public BookList() {
        this.elem[0] = new Book("三国演义","罗贯中",25.6,"小说");
        this.elem[1] = new Book("西游记","吴承恩",33.0,"小说");
        this.elem[2] = new Book("Java","Oracl",51,"教育");
        this.usedSize = 3;
    }


    public int getUsedSize() {  //获取书架大小
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public Book getBook( int pos) {
        return this.elem[pos];
    }
    public void setBook(int pos,Book book) {
        this.elem[pos] = book;
        this.usedSize++;
    }

}
