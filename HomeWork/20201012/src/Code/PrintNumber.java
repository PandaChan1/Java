package Code;

import java.util.Scanner;

/**
 *@ClassName: PrintNumber
 *@Description 输出一个整数的每一位
 *@Author PandaChan1
 *@Date 2020/10/13
 *@Time 19:12
 */


public class PrintNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        int temp;
        while(num != 0) {
            temp = num % 10;
            System.out.print(temp+" ");
            num = num / 10;
        }
    }
}
