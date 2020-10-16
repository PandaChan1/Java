package Code;

import Data.SortedArray;

/**
 *@ClassName: ArrayIsSorted
 *@Description 判断数组是否有序
 *@Author PandaChan1
 *@Date 2020/10/16
 *@Time 10:41
 */


public class ArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(isSorted(SortedArray.SORTED_ARRAY));
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
