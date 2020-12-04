package day12_3;

import java.util.Scanner;

public class countNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] tmp = new int[10];

        for(int i = 0; i < str.length();i++) {
            int n = str.charAt(i) - '0';
            tmp[n]++;
        }

        for(int i = 0; i < tmp.length;i++) {
            if (tmp[i] != 0) {
                System.out.println(i + ":" + tmp[i]);
            }
        }
    }
}
