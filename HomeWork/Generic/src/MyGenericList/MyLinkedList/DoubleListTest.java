package MyGenericList.MyLinkedList;

public class DoubleListTest {
    public static void main(String[] args) {
      DoubleHeadList doubleHeadList = new DoubleHeadList();
      doubleHeadList.addFirst(11);
      doubleHeadList.addLast(20);
      doubleHeadList.addLast(0);
      doubleHeadList.addLast(99);
      doubleHeadList.addLast(99);
      doubleHeadList.addLast(74);
      doubleHeadList.addIndex(0,99);
      doubleHeadList.addIndex(7,111);
      doubleHeadList.display();
        System.out.println(doubleHeadList.contains(0));
        System.out.println(doubleHeadList.contains(456));
        System.out.println(doubleHeadList.isEmpty());
        System.out.println(doubleHeadList.size());
        System.out.println(doubleHeadList.get(7));
        doubleHeadList.removeAll(111);
        doubleHeadList.display();
    }
}
