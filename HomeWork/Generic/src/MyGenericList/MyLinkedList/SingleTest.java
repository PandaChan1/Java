package MyGenericList.MyLinkedList;

public class SingleTest {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addLast(3);
        singleList.addLast(6);
        singleList.addLast(12);
        singleList.addLast(10);
        singleList.addLast(0);
        singleList.addLast(65);
        singleList.addFirst(99);
        singleList.addIndex(0,111);
        singleList.display();
        singleList.addIndex(8,3);
        singleList.display();
        singleList.removeAll(3);
        singleList.display();
        System.out.println(singleList.contains(120));
        System.out.println(singleList.size());
        singleList.clear();
        singleList.display();
    }
}
