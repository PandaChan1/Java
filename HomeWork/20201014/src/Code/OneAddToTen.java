package Code;

import java.util.Scanner;

public class OneAddToTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int num = sc.nextInt();
        System.out.println(sumRes(num));
    }

    private static int  sumRes(int num) {
        if (num == 1) {
            return num;
        }else {
            return num + sumRes(num - 1);
        }
    }

}
