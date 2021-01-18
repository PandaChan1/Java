package day1_18;

import java.util.Scanner;

public class reverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] strs = s.split("[ ]");
            int n = strs.length;
            for (int i = n - 1; i >= 0; i--) {
                if (i == 0) {
                    System.out.println(strs[i]);
                }else {
                    System.out.print(strs[i] + " ");
                }
            }
        }
    }
}
