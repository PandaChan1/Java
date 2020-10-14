package Code;

import java.util.Scanner;
/**
 *@ClassName: sumOfNumber
 *@Description 整数每一位的和
 *@Author PandaChan1
 *@Date 2020/10/14
 *@Time 18:45
 */


public class sumOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int num = sc.nextInt();
        System.out.println(sumNumber(num));
    }

    private static int sumNumber(int num) {
        if (num / 10 == 0) {
            return num;
        }
        return (num % 10) + sumNumber(num / 10);
    }
}
