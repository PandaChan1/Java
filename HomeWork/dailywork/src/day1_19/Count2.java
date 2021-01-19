package day1_19;

import java.util.Scanner;

/**
 *@ClassName: Count2
 *@Description 计算0 - n之间2出现的个数
 *@Author PandaChan1
 *@Date 2021/1/19
 *@Time 15:31
 */


public class Count2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            helper(n);
        }
    }

    private static void helper(int n) {
            int count = 0;
            for (int i = 1; i <= n; i *= 10) {
                int a = n / i,b = n % i;
                //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
                //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
                count += (a + 7) / 10 * i + ((a % 10 == 2) ? b + 1 : 0);
            }
        System.out.println(count);
        }

    }
