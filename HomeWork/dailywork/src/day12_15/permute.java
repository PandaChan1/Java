package day12_15;

import java.util.ArrayList;
import java.util.List;

/**
 *@ClassName: permute
 *@Description 全排列问题回溯法
 *@Author PandaChan1
 *@Date 2020/12/15
 *@Time 16:43
 */


public class permute {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        permute p = new permute();
        System.out.println(p.permuteList(new int[]{1, 2, 3}));
    }
    public List<List<Integer>> permuteList(int[] nums) {
        if(nums.length == 0) return ans;
        dfs(0,nums);
        return ans;
    }

    public void dfs(int n,int[] array)  {
        if(n == array.length) {   //找到一个解
            List<Integer> tmp = new ArrayList<>();
            for (int i :
                    array) {
                tmp.add(i);
            }
        ans.add(tmp);
            return;
        }

        for(int i = n; i < array.length;i++) {
            swap(n,i,array);

            dfs(n + 1, array);

            swap(n,i,array);
        }

    }

    private void swap(int n, int i, int[] array) {
        int temp = array[n];
        array[n] = array[i];
        array[i] = temp;
    }
}
