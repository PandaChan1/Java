package Code;

import java.util.Scanner;
/**
 *@ClassName: PrintNumber
 *@Description 正序打印整数的每一位
 *@Author PandaChan1
 *@Date 2020/10/14
 *@Time 11:03
 */


public class PrintNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        printNumber(num);
    }
    private static void  printNum(int num) {
        if (num / 10 == 0) {
            System.out.print(num + " ");
        }else {
            printNum(num / 10);
            System.out.print(num % 10 + " ");
        }
    }

    private static void printNumber(int num) {
        if (num > 9) {
            printNumber(num / 10);
            System.out.print(num % 10 + " ");
        }else {
            System.out.print(num + " ");
        }

    }
}
