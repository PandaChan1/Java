package day12_29;
/**
 *@ClassName: nums
 *@Description leetcode330-按照要求补齐数组   贪心算法
 *@Author PandaChan1
 *@Date 2020/12/29
 *@Time 20:48
 */


public class nums {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }
}
