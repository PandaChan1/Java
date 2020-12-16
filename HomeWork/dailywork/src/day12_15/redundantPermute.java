package day12_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@ClassName: redundantPermute
 *@Description 回溯法剪枝，全排列重复问题
 *@Author PandaChan1
 *@Date 2020/12/15
 *@Time 16:44
 */


public class redundantPermute {
    public static void main(String[] args) {
        redundantPermute rp = new redundantPermute();
        System.out.println(rp.permuteUnique(new int[]{-1,2,0,-1,1,0,1}));
    }
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums.length == 0) return  ans;
        Arrays.sort(nums);  //先排序
    dfs(0,nums);  //从第一个元素开始
    return ans;
    }

    private void dfs(int i, int[] nums) {
        if (i == nums.length) {  //找到一个解
            List<Integer> tmp = new ArrayList<>();
            for (int n :
                    nums) {
                tmp.add(n);
            }
            ans.add(tmp);
            return;
        }


        for (int j = i; j < nums.length; j++) {
            //剪枝处理
            if (check(nums,i,j)){
                swap(j,i,nums);
                dfs(i + 1,nums);
                swap(j,i,nums);
            }

        }
    }

    //剪枝函数，每次递归都判断
    //从当前位置，到结束位置，有没有和结束位置相等的元素，如果有将该元素跳过
    private boolean check(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int j, int i, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
