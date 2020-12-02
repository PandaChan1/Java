package day12_1;

public class reverseNum {
    public static void main(String[] args) {
        reverseNum(23106000);
    }

    public static void reverseNum(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder(s).reverse();
        System.out.println(sb.toString());
    }
}
