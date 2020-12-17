package day12_17;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *@ClassName: subSetsQuestion
 *@Description 力扣78 子集问题
 *@Author PandaChan1
 *@Date 2020/12/17
 *@Time 15:55
 */


public class subSetsQuestion {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        subSetsQuestion s = new subSetsQuestion();
        System.out.println(s.subsets(new int[]{1,2,3}));
    }
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return ans;

        Stack<Integer> stack = new Stack<>();
        dfs(0,nums,stack);

        return ans;
    }

    private void dfs(int cur, int[] nums, Stack<Integer> stack) {

        List<Integer> temp = new ArrayList<>();
        temp.addAll(stack);
        ans.add(temp);

        for (int i = cur; i <= nums.length - 1; i++) {

            stack.push(nums[i]);

            dfs(i + 1,nums,stack);

            stack.pop();

        }
    }
}
