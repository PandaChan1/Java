package day12_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *@ClassName: combinationSum
 *@Description
 * 组合总和  给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 *@Author PandaChan1
 *@Date 2020/12/16
 *@Time 15:55
 */


public class combinationSum {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        combinationSum c = new combinationSum();
        System.out.println(c.combinationSum(new int[]{2, 3, 5}, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates[0] > target){
            return ans;
        }else if (candidates[0] == target) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(candidates[0]);
            ans.add(tmp);
            return ans;
        }

        Stack<Integer> stack = new Stack<>();
        dfs(target,candidates,stack);
        return ans;
    }

    public void dfs(int target,int[] array,Stack<Integer> stack) {
        if (0 == target) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(stack);
            ans.add(temp);
            return;
        }


        //回溯判断
        if (0 < target) {  //继续递归

            for (int i = 0; i < array.length; i++) {

                if (!stack.isEmpty()) {      //剪枝，剪掉第一次剪枝后重复的项
                    // 如target=8， 233 332 323，由于数组排过序，因此如果读取的数小于栈顶元素直接跳过本次
                    //当栈为23时，就不会选择232，而会选择223；同理当栈为3时，不会选择2即不会出现323的结果
                    if (array[i] < stack.peek()) {
                        continue;
                    }
                }


                if (array[i] > target ) {  //排过序，因此只要大于目标即可剪枝，但还有重复
                    return;
                }


                target -= array[i];
                stack.push(array[i]);
                dfs(target,array,stack);
                stack.pop();
                target += array[i];

            }

        }

    }
}

