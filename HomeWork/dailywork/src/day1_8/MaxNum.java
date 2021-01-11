package day1_8;

import java.util.Scanner;

/**
 *@ClassName: MaxNum
 *@Description 小易的升级之路
 *@Author PandaChan1
 *@Date 2021/1/11
 *@Time 14:46
 */


public class MaxNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int yi = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int monster = sc.nextInt();
                if (monster <= yi) {
                    yi += monster;
                }else {
                    yi += helper(yi,monster);
                }
            }
            System.out.println(yi);
        }
    }

    //递归求最大公约数
    public static int helper(int i, int j) {
        if (j == 0) return i;
        return helper(j,i % j);
    }
}
