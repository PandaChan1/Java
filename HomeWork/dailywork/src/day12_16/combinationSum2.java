package day12_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *@ClassName: combinationSum2
 *@Description
 * 组合总和  给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 *@Author PandaChan1
 *@Date 2020/12/16
 *@Time 17:23
 */


/**
 * 思路与39题一致，39题可以重复使用，而本题不能重复使用
 * 在39题基础上加上标记位置，即index
 */
public class combinationSum2 {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
    combinationSum2 c = new combinationSum2();
        System.out.println(c.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  //排序

        if (candidates[0] == target) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(candidates[0]);
            ans.add(tmp);
            return ans;
        }else if (candidates[0] > target) {
            return ans;
        }

        Stack<Integer> stack = new Stack<>();
        dfs(target,candidates,0,stack);  //传入起始位置
        return ans;
    }

    public void dfs(int target,int[] array,int index,Stack<Integer> stack) {

        if (target == 0) {  //找到一个解
            List<Integer> temp = new ArrayList<>();
            temp.addAll(stack);
            ans.add(temp);
            return;
        }

        for (int i = index; i < array.length; i++) {

          if (check(index,i,array)) {
              continue;
          }

            if (!stack.isEmpty()) {
                if (array[i] < stack.peek()) {  //剪枝
                    continue;
                }
            }

            if (array[i] > target) {  //剪枝
                return;
            }

            target -= array[i];
            stack.push(array[i]);
            dfs(target,array,i+1,stack);
            stack.pop();
            target += array[i];

        }
    }

    private boolean check(int index, int i, int[] array) {

        for (int j = index; j < i; j++) {
            if (array[j] == array[i]) {
                return true;
            }
        }
        return false;
    }

}
