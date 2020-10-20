package Code;

public class HomeWorkTest {
    public static void main(String[] args) {
        HomeWorkList homeWorkList = new HomeWorkList();
        homeWorkList.addFirst(3);
        homeWorkList.addFirst(6);
        homeWorkList.addFirst(3);
        homeWorkList.addLsat(12);
        System.out.println(homeWorkList.contains(6));
        System.out.println(homeWorkList.contains(99));
        System.out.println(homeWorkList.size());

//        homeWorkList.remove(3);

        homeWorkList.removeAllKey(3);
        homeWorkList.display();
    }
}
