package Code;

public class HomeWorkTest {
    public static void main(String[] args) {
        HomeWorkList homeWorkList = new HomeWorkList();
        homeWorkList.addFirst(3);
        homeWorkList.addFirst(6);
        homeWorkList.addFirst(3);

        homeWorkList.addLsat(12);
        homeWorkList.addLsat(55);
        homeWorkList.addLsat(7);
        homeWorkList.addLsat(9);
        homeWorkList.display();
        homeWorkList.addIndex(0,12);
        homeWorkList.addIndex(3,12);
        homeWorkList.addIndex(7,12);
        homeWorkList.display();
        System.out.println(homeWorkList.contains(6));
        System.out.println(homeWorkList.contains(99));
        System.out.println(homeWorkList.size());

//        homeWorkList.remove(3);

        homeWorkList.removeAllKey(3);
        homeWorkList.display();
    }
}
