package Code;

import java.util.Random;
import java.util.Scanner;

/**
 *@ClassName: Swap
 *@Description 交换两个变量的值，改变实参的值
 *@Author PandaChan1
 *@Date 2020/10/18
 *@Time 18:56
 */


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
