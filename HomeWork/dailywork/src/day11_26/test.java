package day11_26;

import java.util.Scanner;

/**
 * 神奇的口袋 https://www.nowcoder.com/questionTerminal/9aaea0b82623466a8b29a9f1a00b5d35
 */
public class test {
        static int[] cap = new int[30];
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            for(int i = 1; i <= n ;i++) {
                cap[i] = sc.nextInt();
            }
            System.out.println(find(n,40));
        }

        public static int find(int n,int target) {
            if(target == 0) {
                return 1;
            }

            if(n <= 0) {
                return 0;
            }
            return find(n - 1,target - cap[n]) + find(n - 1,target);
        }
}
