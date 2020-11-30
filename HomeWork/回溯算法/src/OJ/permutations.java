package OJ;

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName: permutations
 *@Description 回溯法解决全排列问题  https://leetcode-cn.com/problems/permutations/
 *@Author PandaChan1
 *@Date 2020/11/30
 *@Time 9:58
 */


public class permutations {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        permutations p = new permutations();
        System.out.println(p.permute(new int[]{1, 2, 3}));
    }
    public List<List<Integer>> permute(int[] nums) {

        dfs(nums,0,nums.length - 1);
        return res;
    }

    public void dfs(int[] nums,int start,int end) {
        if(start == end) {  //说明已经走到nums的末尾，找到一个结果
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < nums.length;i++) {
                temp.add(nums[i]);
            }
            res.add(temp);
            return;
        }

        //回溯
        for(int i = start; i <= end;i++) {
            swap(nums,start,i);    //每次交换元素，可以得到两个元素的全排列
            //求剩下元素的全排列,如果可以一直递归下去找到结果，那么就会添加结果到结果集中
            dfs(nums,start + 1,end);
            //不论有没有找到，上面递归跳出后，都会再次交换，将原本交换的两个元素恢复
            //即回溯，恢复现场
            swap(nums,start,i);
        }
    }

    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
