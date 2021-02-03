package day2_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Sum {
    private static List<List<Integer>> res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            res = new ArrayList<>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            Stack<Integer> stack = new Stack<>();
            dfs(1,m,n,stack);

            for (int i = 0; i < res.size(); i++) {
                List<Integer> tmp = res.get(i);
                for (int j = 0; j < tmp.size(); j++) {
                    System.out.print(tmp.get(j));
                    if (j != tmp.size() - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    private static void dfs(int index, int target, int n, Stack<Integer> stack) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(stack);
            res.add(temp);
            return;
        }

        for (int i = index; i <= n; i++) {
            target -= i;
            stack.add(i);
            dfs(i + 1,target,n,stack);
            stack.pop();
            target += i;
        }
    }

}
