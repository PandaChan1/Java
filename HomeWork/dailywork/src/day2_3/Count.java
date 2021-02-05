package day2_3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                if(stack.empty() || stack.peek()!=arr[i]) {
                    stack.push(arr[i]);
                }else if(stack.peek() == arr[i]) {
                    stack.pop();
                }
            }
            int o = stack.pop();
            System.out.println(stack.pop() + " " + o);
        }
    }
}
