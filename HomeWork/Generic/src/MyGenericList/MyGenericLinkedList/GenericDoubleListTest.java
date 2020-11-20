package MyGenericList.MyGenericLinkedList;

public class GenericDoubleListTest {
    public static void main(String[] args) {
      GenericDoubleHeadList<String> doubleHeadList = new GenericDoubleHeadList<>();
      doubleHeadList.addFirst("Hello");
      doubleHeadList.addLast("world");
      doubleHeadList.addLast("i");
      doubleHeadList.addLast("love");
      doubleHeadList.addLast("world");
      doubleHeadList.addLast("and");
      doubleHeadList.addIndex(0,"code");
      doubleHeadList.addIndex(7,"and you ?");
      doubleHeadList.display();
        System.out.println(doubleHeadList.contains("i"));
        System.out.println(doubleHeadList.contains("love you"));
        System.out.println(doubleHeadList.isEmpty());
        System.out.println(doubleHeadList.size());
        System.out.println(doubleHeadList.get(7));
        doubleHeadList.removeAll("world");
        doubleHeadList.display();
    }
}
