package day1_10;

import java.util.ArrayList;
import java.util.List;
/**
 *@ClassName: RangeNums
 *@Description leetcode228 汇总区间
 *@Author PandaChan1
 *@Date 2021/1/10
 *@Time 19:03
 */



public class RangeNums {
 
        public List<String> summaryRanges(int[] nums) {
            List<String> ret = new ArrayList<String>();
            int i = 0;
            int n = nums.length;
            while (i < n) {
                int low = i;
                i++;
                while (i < n && nums[i] == nums[i - 1] + 1) {
                    i++;
                }
                int high = i - 1;
                StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
                if (low < high) {
                    temp.append("->");
                    temp.append(Integer.toString(nums[high]));
                }
                ret.add(temp.toString());
            }
            return ret;
        }
}
