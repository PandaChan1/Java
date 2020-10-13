package Code;

import java.util.Random;
import java.util.Scanner;

/**
 * 猜数字游戏
 * 随机生成数字
 */
public class guessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Random random = new Random();
//        int rand = random.nextInt(100)+1;
        //如果不+1，随机数范围为[0,100),左闭右开
        // [0,99) --> +1  [1,100]
        int randomNum = (int)(Math.random()*(100-1)+1);
        while(true) {
            System.out.println("请猜一个数字");
            int num = sc.nextInt();

            if (randomNum > num) {
                System.out.println("小了");
            } else if (randomNum < num) {
                System.out.println("大了");
            }else if (randomNum == num ) {
                System.out.println("恭喜你猜对了");
                break;
            }
        }
        sc.close();
    }
}
