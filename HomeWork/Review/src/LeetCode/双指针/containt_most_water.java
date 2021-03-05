package LeetCode.双指针;

/**
 *@ClassName: containt_most_water
 *@Description 盛最多水的容器
 *@Author PandaChan1
 *@Date 2021/3/5
 *@Time 16:18
 */

//双指针法，原理：缩减空间法
    //https://leetcode-cn.com/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
public class containt_most_water {
    public static void main(String[] args) {
        solution(new int[]{1,8,6,2,5,4,8,3,7});
    }

    public static void solution(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;

        while(i < j) {
            int area = (j - i) * Math.min(height[i],height[j]);
            res = Math.max(res,area);

            if (height[i] < height[j]) {
                i++;
            }else {
                j--;
            }
        }
        System.out.println(res);
    }
}
