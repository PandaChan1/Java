package Code;

import java.util.Arrays;

/**
 *@ClassName: ArrayOddEve
 *@Description 数组奇数放后面
 *@Author PandaChan1
 *@Date 2020/10/18
 *@Time 18:55
 */

public class ArrayOddEve {
    public static void main(String[] args) {
        int[] array = new int[]{12,2,3,65,14,25,33,5,8,64,3};
        swapOdd(array);
        System.out.println(Arrays.toString(array));
    }

    private static void swapOdd(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            if (array[left] % 2 == 0) {
                left++;
            }
            if (array[right] % 2 != 0) {
                right--;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }
}
