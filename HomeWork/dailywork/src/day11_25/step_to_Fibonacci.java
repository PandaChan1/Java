package day11_25;

import java.util.Scanner;

public class step_to_Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();

        int f1 = 0;
        int f2 = 1;
        int f3 = 0;
        while(key > f3) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        System.out.println(Math.min(key - f1,f2 - key));
    }

}
