import java.util.Scanner;

public class yearsOld {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年龄");
        int num = sc.nextInt();
        sc.close();
        if (num <= 18) {
            System.out.println("少年");
        }else if (num >18 && num < 29) {
            System.out.println("青年");
        }else if (num > 28 && num < 56) {
            System.out.println("中年");
        }else {
            System.out.println("老年");
        }
    }
}
