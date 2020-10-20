package Code;

public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
//        mySingleList.addFirst(1);
//        mySingleList.addFirst(2);
//        mySingleList.addFirst(3);
//        mySingleList.addFirst(4);
//        mySingleList.display();
        mySingleList.addLast(5);
        mySingleList.addLast(6);
        mySingleList.addLast(2);
        mySingleList.addLast(6);
        mySingleList.display();
        System.out.println(mySingleList.contains(6)); //true
        System.out.println(mySingleList.contains(16)); //false
        mySingleList.display();
//        mySingleList.clear();
//        mySingleList.display();
        mySingleList.addIndex(0,99);
        mySingleList.display();
//        mySingleList.addIndex(12,98);
        mySingleList.addIndex(5,55);
        mySingleList.display();
        mySingleList.remove(999);
        mySingleList.display();
        mySingleList.removeAllKey(6);
        mySingleList.display();
    }
}
