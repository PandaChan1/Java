package Code;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,2);
        myArrayList.add(1,4);
        myArrayList.add(2,2);
        myArrayList.add(3,3);
        myArrayList.add(4,2);
        myArrayList.add(3,2);

        myArrayList.display();
//        System.out.println(myArrayList.contains(2));
//        System.out.println(myArrayList.search(2));
//        System.out.println("删除");
//        myArrayList.remove(999);
//        myArrayList.display();
//        myArrayList.removeAll(2);
//        myArrayList.display();
    }
}
