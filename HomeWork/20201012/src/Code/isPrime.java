package Code;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

/**
 * 判读一个数是否为素数
 */

public class isPrime {
    //优化
    //方法三、从 2 -- sqrt（n） 之间存在一个数可以整除n，则不是素数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int n = scanner.nextInt();
        scanner.close();
        int i = 2;
        if(n == 0) {
            System.out.println(n+" 不是素数");
            return;
        }
        for (; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println(n+" 不是素数");
                break;
            }
        }
        if (i >= Math.sqrt(n)) {
            System.out.println(n+" 是素数");
        }
    }
    //优化
    // 方法二，从 2 -- n/2 之间存在一个属可以整除n，则不是素数
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个数字");
        int n = sc.nextInt();
        int i = 2;
        if(n == 0) {
            System.out.println(n+" 不是素数");
            return;
        }
        for (;i < n/2 ; i++) {
            if (n % i == 0) {
                System.out.println(n+" 不是素数");
                break;
            }
        }
        if (i >= n/2) {
            System.out.println(n+" 是素数");
        }
    }
    //方法一，从2 -- (n-1)之间存在一个数可以整除n，则不是素数
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(n+" 不是素数");
            return;
        }
        int i = 2;
        for (; i < n ; i++) {
            if (n % i == 0){
                System.out.println(n+" 不是素数");
                break;
            }
        }
        //2种情况跳出循环
        //1、循环执行完毕-》是素数   2、break退出-》不是素数
        if(i >= n) {
            System.out.println(i+"是素数");
        }
    }


    public static void main1(String[] args){
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
