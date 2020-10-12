import java.util.Scanner;

public class guessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
