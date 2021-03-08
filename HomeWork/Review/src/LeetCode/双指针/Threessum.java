package LeetCode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@ClassName: Threessum
 *@Description 三树之和为0
 *@Author PandaChan1
 *@Date 2021/3/7
 *@Time 18:29
 */

//本题也可以用回溯，列举所有可能，将sum为0的加入答案中
    //但使用双指针+排序比回溯更简单
    //因为回溯需要剪枝，去除掉重复项
public class Threessum {
    public static void main(String[] args) {
        solution(new int[]{-1,0,1,2,-1,-4});
    }

    public static  void solution(int[] array) {
        int len= array.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {   //固定一个数
            if (array[i] > 0) break;  //如果array[i] > 0 直接break
            if (i > 0 && array[i] == array[i - 1]) continue;  //排除重复项
            int left = i + 1;
            int right = len - 1;
            while(left < right) {  //另外两个数
                int sum  =  array[i] + array[left] + array[right];  //计算和
                if (sum == 0) {
                    ans.add(Arrays.asList(array[i],array[left],array[right]));  //添加到结果集
                    while(left < right && array[left] == array[left + 1]) left++;  //去掉重复项
                    while(left < right && array[right] == array[right - 1]) right--;
                    left++;
                    right--;
                }else if (sum > 0) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        System.out.println(ans.toString());
    }
}
