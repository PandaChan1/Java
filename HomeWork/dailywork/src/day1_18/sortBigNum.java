package day1_18;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 *@ClassName: sortBigNum
 *@Description 大整数排序 使用java的BigInteger类型
 *@Author PandaChan1
 *@Date 2021/1/18
 *@Time 16:00
 */


public class sortBigNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            BigInteger[] big = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                big[i] = sc.nextBigInteger();
            }
            //用字符串读取三个整数
            Arrays.sort(big);
            for (BigInteger b :
                    big) {
                System.out.println(b);
            }
        }
    }

}
