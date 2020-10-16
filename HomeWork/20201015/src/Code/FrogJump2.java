package Code;

import java.util.Scanner;

/**
 *@ClassName: FrogJump2
 *@Description 变态跳台阶，青蛙可以一次跳任意阶
 *@Author PandaChan1
 *@Date 2020/10/16
 *@Time 8:56
 */


public class FrogJump2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(jump(n));
        }
        System.out.println("普通跳台阶5");
        System.out.println(frogJump(5));
        sc.close();
    }

    private static int jump(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        /*if (n == 2) {
            return 2;
        }*/
        //变态跳台阶，一次可以跳任意阶
        //例如：jump(n) = jump( n-1 ) + jump(n - 2)+..+ jump(1) +1
        //为什么 +1 呢，因为台阶为n时，最多跳n阶，这一个也算在里面
        int res = 0;
        for (int i = 0;i < n ; i++) {
            res = res + jump(i);
        }
        return res + 1;
    }

    //普通跳台阶
    private static int frogJump(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (n == 2) {
            return 2;
        }
        return frogJump(n -1) + frogJump(n - 2);
    }
}
