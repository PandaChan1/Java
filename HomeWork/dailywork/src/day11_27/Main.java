package day11_27;

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] tmp = new int[4];
        int count = 0;
        for(int i = 0; i < tmp.length;i++) {
            int n = sc.nextInt();
            count += n;
            tmp[i] = n;
        }
        int A = tmp[0] + tmp[2];
        int B = tmp[1] + tmp[3];
        int C = 0;

        if(A % 2 == 0 && B % 2 == 0 && A >= 0 && B >= 0) {
            C = count - A/2 - B/2;
            System.out.println(A / 2 +" "+ B / 2 + " "+C);
        }else {
            System.out.println("No");
        }
    }
}