package Code;

import java.util.Scanner;

/**
 *@ClassName: Code.numOfBinary
 *@Description 求一个整数二进制中1的个数
 *@Author PandaChan1
 *@Date 2020/10/13
 *@Time 11:46
 */


public class numOfBinary {
    //方法三，n & (n-1) 就会减少一个1
    public static void main3(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入一个数");
        int num = scanner.nextInt();
        scanner.close();
        int count = 0;
        while(num != 0){
            count++;
            num = num &(num -1);
        }
        System.out.println(count);
    }


    //方法二，方法一循环32次
    //例如 7有三个1，然而方法一循环了32次，多余了29次
    //多余的29次 都是0在和1进行 & 运算
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("请输入一个数");
        int n = scanner.nextInt();
        scanner.close();
        int count = 0;
        while(n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
                n = n >>> 1;
                // 右移 >> 和 无符号右移 >>>
                //当输入-1时，负数二进制存储是补码 负数的补码是（不含符号位取反）取反加1
                //-1 的补码是32个1， 进行& 运算时，右移补符号位1，会死循环
                //为了避免死循环，使用 >>> 无符号右移 即右移之后 补0
        }
        System.out.println(count);
    }


    //方法一，右移32次
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数");
        int num = scanner.nextInt();
        scanner.close();
        int count=0;
        //用运算符&，正数&1 ！= 0 则 count++
        //然后用 >> 右移运算符右移一位，继续&1
        //int的大小为4字节，即32位，因此需要右移32次
        for (int i = 0; i < 32; i++) {
            if ((num & 1) != 0) {
                count++;
                num = num >> 1;
            }
        }
        System.out.println(count);
    }


    public static void main1(String[] args){
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
