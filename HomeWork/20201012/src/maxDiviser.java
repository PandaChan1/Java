import java.util.Scanner;

/**
 * 求两个数的最大公约数
 */
public class maxDiviser {
    //辗转相除法求最大公约数
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.println("输入第一个数");
        int a = sc.nextInt();
        System.out.println("输入第二个数");
        int b = sc.nextInt();
        sc.close();
     /*   int max,min;
        if (a > b){
            max = a;
            min = b;
        }else {
            max = b;
            min = a;
        } */
        //不需要交换判断大小
        // 当a<b时，余数为a，之后方法内部交换数据就会自动交换
        int temp ;
        while(a % b != 0) {
            temp = a % b;
            a = b;
            b =temp;
        }
        System.out.println(b);
    }
}
