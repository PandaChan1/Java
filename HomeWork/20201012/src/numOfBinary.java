import java.util.Scanner;

/**
 * 求一个整数二进制表示种1的个数
 */
public class numOfBinary {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.println("输入一个整数");
        int num = sc.nextInt();
        sc.close();
        int a = num / 2;
        int b = num % 2;
        int count =0;
        while(a!=0){
            if (b == 1){
                count++;
            }
            a = a / 2;
            b = a % 2;
        }
        System.out.print(count);
    }
}
