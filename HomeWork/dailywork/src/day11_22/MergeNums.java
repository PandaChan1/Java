package day11_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@ClassName: MergeNums
 *@Description leetcode 56合并区间  452 最少的箭引爆气球
 * 56 https://leetcode-cn.com/problems/merge-intervals/
 * 452 https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *@Author PandaChan1
 *@Date 2020/11/23
 *@Time 16:46
 */


public class MergeNums {
    //最少的箭引爆气球
    public static int min_ballons(int[][] arrays) {
        Arrays.sort(arrays,(o1,o2)->Integer.compare(o1[0],o2[0]));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            int left = arrays[i][0];
            int right = arrays[i][1];

            if (list.size() == 0 || list.get(list.size() - 1)[1] < left) {
                list.add(new int[]{left,right});
            }else {
                list.get(list.size() - 1)[1] = Math.min(list.get(list.size() - 1)[1],right);
            }
        }
        return list.size();
    }




    //合并所有重叠的区间
    public static int[][] mergeNums(int[][] nums) {
        Arrays.sort(nums,(o1,o2)->o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i][0];
            int right = nums[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < left){
                list.add(new int[] {left,right});
            }else {
                list.get(list.size() - 1)[1] = Math.max(right,list.get(list.size() - 1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
