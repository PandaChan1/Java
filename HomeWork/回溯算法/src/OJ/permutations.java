package OJ;

import java.util.ArrayList;
import java.util.List;

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
        if(start == end) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < nums.length;i++) {
                temp.add(nums[i]);
            }
            res.add(temp);
            return;
        }

        for(int i = start; i <= end;i++) {
            swap(nums,start,i);
            dfs(nums,start + 1,end);
            swap(nums,start,i);
        }
    }

    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
