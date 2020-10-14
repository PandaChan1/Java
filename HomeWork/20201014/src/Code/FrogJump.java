package Code;

import java.util.Scanner;

/**
 *@ClassName: FrogJump
 *@Description 青蛙跳台阶问题，输入台阶数n，青蛙每次可以跳一阶或两阶，求总共有多少种跳法。
 *@Author PandaChan1
 *@Date 2020/10/14
 *@Time 19:25
 */


public class FrogJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入台阶的阶数");
        int n = sc.nextInt();
        if (n == 0) {
            return;
        }
        System.out.println(jump(n));
    }

    private static int jump(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }else {
            //思路：当n==1时，即上一步跳完后剩余台阶为1，只能跳一步，return 1
            // 当n==0时，即上一步跳完之后剩余台阶为0，同样 return 1
            return jump(n -1 ) + jump(n - 2);
        }
    }
}
