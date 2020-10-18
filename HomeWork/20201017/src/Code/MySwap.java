package Code;

import java.util.Random;
import java.util.Scanner;

class Swap{
    public static void swap() {
        int temp = MySwap.a;
        MySwap.a = MySwap.b;
        MySwap.b = temp;
    }
}
public class MySwap {
    static int a;
    static int b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        sc.close();
        Swap.swap();
        System.out.println(a + " " + b);
    }
}
