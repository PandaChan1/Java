import java.util.Scanner;

public class isPrime {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count=0;
        System.out.println("输入一个数字:");
        int num = sc.nextInt();
        for (int i = 2;i < num/2;i++) {
            if (num % i == 0){
                count++;
            }
        }
        if (count == 0) {
            System.out.println(num+" 是素数");
        }else{
            System.out.println(num+" 不是素数");
        }
        sc.close();
    }
}
