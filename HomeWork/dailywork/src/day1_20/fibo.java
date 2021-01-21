package day1_20;

import java.util.Scanner;

/**
 *@ClassName: fibo
 *@Description 一共n阶台阶，每次只能跳1、2、3阶，求总共多少种跳法
 *@Author PandaChan1
 *@Date 2021/1/21
 *@Time 14:23
 */

//动态规划
public class fibo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp;
        while(sc.hasNext()) {
            int n = sc.nextInt();
            dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            if (n < 4) {
                System.out.println(dp[n]);
                break;
            }
            for (int i = 4; i <= n; i++) {
                dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3]) % 1000000007;
            }
            System.out.println(dp[n]);
            break;
        }
    }
}
