package MyGenericList.MyGenericLinkedList;

public class GenericSingleTest {
    public static void main(String[] args) {
        GenericSingleList<Integer> singleList = new GenericSingleList<>();
        singleList.addLast(7);
        singleList.addLast(6);
        singleList.addLast(0);
        singleList.addLast(6);
        singleList.addLast(54);
        singleList.addLast(84);
        singleList.addFirst(78);
        singleList.addIndex(0,999);
        singleList.display();
        singleList.addIndex(8,111);
        singleList.display();
        singleList.removeAll(6);
        singleList.display();
        System.out.println(singleList.contains(84));
        System.out.println(singleList.size());
        singleList.clear();
        singleList.display();
    }
}
