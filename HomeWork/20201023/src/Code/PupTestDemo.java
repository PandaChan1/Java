package Code;

public class PupTestDemo {
    public static void main(String[] args) {
        PupLinkedList pupLinkedList = new PupLinkedList();
        pupLinkedList.addFirst(1);
        pupLinkedList.addFirst(2);
        pupLinkedList.addFirst(3);
        pupLinkedList.addFirst(4);
        pupLinkedList.display();
        pupLinkedList.addLast(2);
        pupLinkedList.display();
//        System.out.println(pupLinkedList.size());
//        System.out.println(pupLinkedList.contains(4));
        pupLinkedList.addIndex(3,99);
        pupLinkedList.display();
//        pupLinkedList.remove(99);

        pupLinkedList.removeAll(2);
        pupLinkedList.display();

    }

}
