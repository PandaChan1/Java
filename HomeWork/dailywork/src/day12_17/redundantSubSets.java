package day12_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class redundantSubSets {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
    redundantSubSets r = new redundantSubSets();
        System.out.println(r.subsetsWithDup(new int[]{1,2,2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
    if (nums.length == 0) return ans;

        Stack<Integer> stack = new Stack<>();

        Arrays.sort(nums);
        dfs(0,nums,stack);
        return ans;
    }

    private void dfs(int cur, int[] nums, Stack<Integer> stack) {

        List<Integer> temp = new ArrayList<>();
        temp.addAll(stack);
        ans.add(temp);


        for (int i = cur; i < nums.length; i++) {
            if (check(cur,i,nums)) {
                continue;
            }

            stack.push(nums[i]);

            dfs(i + 1,nums,stack);

            stack.pop();

        }

    }

    private boolean check(int cur, int i, int[] nums) {
        for (int j = cur; j < i; j++) {
            if (nums[i] == nums[j]) {
                return true;
            }
        }
        return false;
    }
}
