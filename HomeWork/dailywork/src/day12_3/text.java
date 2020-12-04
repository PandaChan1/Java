package day12_3;

public class text {
    public static boolean isAdmin(String str) {
        return str.toLowerCase().equals("admin") ;
    }

    public static void main(String[] args) {
        System.out.println(isAdmin("Admin"));

    }

}
