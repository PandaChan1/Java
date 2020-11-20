package MyGenericList.MyGenericArrayList;

public class GenericArrayListTest {
    public static void main(String[] args) {
        GenericArrayList<String> genericArrayList = new GenericArrayList<>();
        genericArrayList.add("hello");
        genericArrayList.add("world");
        genericArrayList.add("i");
        genericArrayList.add("love");
        genericArrayList.add("world");
        genericArrayList.add(0,"panda");
        genericArrayList.display();
        System.out.println(genericArrayList.isEmpty());
        System.out.println(genericArrayList.isFull());
        System.out.println(genericArrayList.contains("panda"));
        System.out.println(genericArrayList.get(0));
        genericArrayList.remove("panda");
        genericArrayList.display();
        genericArrayList.removeAll("world");
        genericArrayList.display();
    }
}
