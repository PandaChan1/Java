package Code;

import java.util.Scanner;

/**
 *@ClassName: NineNineList
 *@Description 9*9乘法表
 *@Author PandaChan1
 *@Date 2020/10/13
 *@Time 19:06
 */


public class NineNineList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int n = sc.nextInt();
        sc.close();
        for (int i = 1; i <= n; i++) {
            for (int j = 1;j <= i; j++) {
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println();
        }
    }
}
