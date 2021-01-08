package day1_6;

import java.util.Scanner;
/**
 *@ClassName: rabbitCount
 *@Description 有一只兔子，第三天开始每天生一只小兔子。且生出的兔子每三天也会生一只兔子，求第n天总共有多少只兔子
 *@Author PandaChan1
 *@Date 2021/1/8
 *@Time 14:08
 */


public class rabbitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int res = getCount(n);
            System.out.println(res);
        }
    }

    public  static int getCount(int n) {
        if (n < 3) return 1;

        return getCount(n - 1) + getCount(n - 2);
    }
}
