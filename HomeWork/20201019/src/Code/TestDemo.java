package Code;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(9);
        myArrayList.add(0,2);
        myArrayList.add(1,4);
        myArrayList.add(2,2);
        myArrayList.add(3,3);
        myArrayList.add(4,2);
        myArrayList.add(5,2);
        myArrayList.add(6,92);
        myArrayList.add(7,45);
        myArrayList.add(8,999);

        myArrayList.display();
        System.out.println(myArrayList.contains(2));
        System.out.println(myArrayList.search(2));
        System.out.println("删除");
//        myArrayList.remove(3);
//        myArrayList.display();
        myArrayList.removeAll(999);
        myArrayList.display();
    }
}
