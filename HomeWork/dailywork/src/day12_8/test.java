package day12_8;

public class test {
    public static void main(String[] args) {
        String str1 = "hello" + "world";
        String str2 = new String(str1);

        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);

    }
}
