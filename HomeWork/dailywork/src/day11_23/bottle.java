package day11_23;

import java.util.Scanner;

/**
 *@ClassName: bottle
 *@Description 汽水瓶子换汽水
 *@Author PandaChan1
 *@Date 2020/11/25
 *@Time 17:06
 */


public class bottle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bottles = sc.nextInt();
        System.out.println(maxBottle(bottles));
    }

    public static int maxBottle(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return  1;
        }
        return maxBottle(n / 3 + n % 3) + n / 3;
    }

}
