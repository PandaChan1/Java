import Data.passwd;

import java.util.Scanner;

/**
 * 模拟密码登录，三次错误就直接退出
 * 密码正确输出提示并退出
 */
public class simulatePassword {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int count=3;
        while(true){
            System.out.println("请输入密码");
            String str=sc.next();
            if (!str.equals(passwd.PASSWORD)){
                count--;
                System.out.println("密码错误");
            }
            if (count > 0 && str.equals(passwd.PASSWORD)){
                System.out.println("密码正确");
                break;
            }
            if (count == 0){
                break;
            }
        }
    }
}
