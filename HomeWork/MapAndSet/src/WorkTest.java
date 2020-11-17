import java.util.Arrays;

/**
 *@ClassName: WorkTest
 *@Description 部分排序 https://leetcode-cn.com/problems/sub-sort-lcci/
 *@Author PandaChan1
 *@Date 2020/11/17
 *@Time 17:58
 */


public class WorkTest {
    public static int[] subSort(int[] array) {
        if(array.length == 0) return new int[]{-1,-1};
        int[] sorted = new int[array.length];

        for(int i = 0;i < array.length;i++) {
            sorted[i] = array[i];
        }
        int[] res = quicksort(sorted,0,array.length - 1);
        int left = 0;
        int right = array.length - 1;
        int[] ans = new int[]{-1,-1};
        while(left < array.length && ans[0] == -1) {
            if(array[left] == res[left]) {
                left++;
            }else {
                ans[0] = left;
            }
        }

        while(right >= 0 && ans[1] == -1) {
            if(array[right] == res[right]) {
                right--;
            }else {
                ans[1] = right;
            }
        }

        return ans;

    }

    public static int[] quicksort(int[] array,int left,int right) {  //快排
        if(left < right) {
            int pov = partition(array,left,right);
            quicksort(array,left,pov - 1);
            quicksort(array,pov + 1,right);
        }
        return array;
    }

    public static int partition(int[] array,int left,int right) {   //找基准
        int temp = array[left];  //先以左边为基准
        while(left < right) {
            if(left < right && array[right] >= temp) {right--;}
            array[left] = array[right];
            if(left < right && array[left] <= temp) {left++;}
            array[right] = array[left];
        }
        array[left] = temp;
        return left;
    }

    //快排超时
    //题解法
    public static int[] newsubSort(int[] array) {
        int[] clone = array.clone();
        Arrays.sort(clone);
        int[] ans = new int[]{-1,-1};
        for(int i = 0;i < array.length;i++) {
            if(array[i] != clone[i]) {
                if(ans[0] == -1) {
                    ans[0] = i;
                }
                ans[1] = i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] array = {1,3,7,9,5};
        System.out.println(Arrays.toString(subSort(array)));
        System.out.println(Arrays.toString(newsubSort(array)));
    }
}
