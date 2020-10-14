package Code;

import java.util.Scanner;

public class MaxNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个整数");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a +"与" + b + "的最大值是" +maxTwoNum(a,b));
        System.out.println("请输入三个整数");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        System.out.println(x +"与" + y +","+ z + "的最大值是" +maxThreeNum(x,y,z));
        sc.close();
    }

    private static int maxTwoNum(int a, int b) {
//        if (a > b) {
//            return a;
//        }else {
//            return b;
//        }

        return   a > b ?  a : b ;
    }
    private static int maxThreeNum(int a, int b,int c) {
//       if (maxTwoNum(a,b) > c) {
//           return maxTwoNum(a,b);
//       }else {
//           return c;
//       }
       return maxTwoNum(a,b) > c ? maxTwoNum(a,b) : c;
    }
}
