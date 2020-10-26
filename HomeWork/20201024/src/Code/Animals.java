package Code;

public class Animals {
     protected String name;
     private final int age = 0;
    public Animals(String name){
        this.name = name;
    }
    public void eat() {
        System.out.println("吃东西");
    }
}
//class Man{
//    protected int a = 0;
//}
//public class Animals{
//    public static void main(String[] args) {
//       final Man man = new Man();
//        System.out.println(++man.a);
//    }
//}