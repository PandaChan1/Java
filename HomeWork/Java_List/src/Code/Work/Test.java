package Code.Work;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        System.out.println(myLinkedList.get(0));
        myLinkedList.display();
        System.out.println("================================");
        myLinkedList.addAtTail(10);
        myLinkedList.display();
        System.out.println("=============================");
        myLinkedList.addAtIndex(0,99);
        myLinkedList.display();
        System.out.println("================================");
        myLinkedList.deleteAtIndex(5);
        myLinkedList.display();

    }
}
