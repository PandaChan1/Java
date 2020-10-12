import java.util.Scanner;

public class maxDiviser {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.println("输入第一个数");
        int a = sc.nextInt();
        System.out.println("输入第二个数");
        int b = sc.nextInt();
        sc.close();
        int max,min;
        if (a > b){
            max = a;
            min = b;
        }else {
            max = b;
            min = a;
        }
        int temp = min;
        while(max % min != 0) {
            temp = max % min;
            max = min;
            min =temp;
        }
        System.out.println(temp);
    }
}
