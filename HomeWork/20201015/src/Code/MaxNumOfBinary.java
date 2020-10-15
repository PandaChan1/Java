package Code;

import java.util.Scanner;

/**
 *@ClassName: MaxNumOfBinary
 *@Description 输入一个整数，求其二进制表示中，连续出现多少个1
 *@Author PandaChan1
 *@Date 2020/10/15
 *@Time 21:40
 */


public class MaxNumOfBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(longest(num));
    }

    private static int longest(int num) {
        if (num == 0) {
            return 0;
        }
        int res = 0;
        int count = 0;
        while(num != 0) {
            if ((num & 1) == 1) {
                count++;
            }else {
                count = 0;
            }
            num  = num >>> 1;
            res = Math.max(res,count);
        }
        return res;
    }



}
