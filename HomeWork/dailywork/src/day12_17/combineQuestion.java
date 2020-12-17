package day12_17;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *@ClassName: combine
 *@Description 力扣77 组合  回溯算法
 *@Author PandaChan1
 *@Date 2020/12/17
 *@Time 15:15
 */


public class combineQuestion {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        combineQuestion c = new combineQuestion();
        System.out.println(c.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0) return ans;
        if (k == 0) return ans;

        //回溯
        Stack<Integer> stack = new Stack<>();
        dfs(1,n,k,stack);
        return ans;
    }

    private void dfs(int cur,int n, int k,Stack<Integer> stack) {
        if (stack.size() == k) {  //加入ans
            List<Integer> temp = new ArrayList<>();
            temp.addAll(stack);
            ans.add(temp);
            return;
        }

        for (int i = cur; i <= n - (k - stack.size()) + 1; i++) {

            stack.push(i);

            dfs(i + 1,n,k,stack);

            stack.pop();
        }


    }
}
