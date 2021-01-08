package day1_6;

import java.util.Scanner;

public class rabbitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int res = getCount(n);
            System.out.println(res);
        }
    }

    public  static int getCount(int n) {
        if (n < 3) return 1;

        return getCount(n - 1) + getCount(n - 2);
    }
}
