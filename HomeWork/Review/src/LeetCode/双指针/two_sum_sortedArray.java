package LeetCode.双指针;

import java.util.Arrays;

/**
 *@ClassName: two_sum_sortedArray
 *@Description 两数之和  数组有序
 *@Author PandaChan1
 *@Date 2021/3/5
 *@Time 16:23
 */

//双指针O(n)
    //和盛满水的容器一题类似，都是O(n)解法，用到了缩减空间法
public class two_sum_sortedArray {
    public static void main(String[] args) {
        solution(new int[]{2,7,11,15},9);

    }

    public static void solution(int[] array,int target) {
        int i = 0;
        int j = array.length - 1;
        int[] res = new int[2];

        while(i < j) {
            int sum = array[i] + array[j];  //先求和
            if (sum > target) {  //因为有序，如果sum太大，右边下标减小
                j--;
            }else if (sum < target) {  //如果sum太小，左边下标增大
                i++;
            }else {
                break;  //跳出  得出结果
            }
        }


        //i,j就是数组中元素的下标
        res[0] = i ;
        res[1] = j ;
        System.out.println(Arrays.toString(res));
    }
}
