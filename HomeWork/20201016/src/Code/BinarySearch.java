package Code;

import Data.SortedArray;

/**
 *@ClassName: BinarySearch
 *@Description 二分查找,二分查找要求数组有序
 *@Author PandaChan1
 *@Date 2020/10/16
 *@Time 10:09
 */


public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(SortedArray.SORTED_ARRAY,555));
    }


    private static int binarySearch(int[] array,int target) {
        int left = 0;
        int right = SortedArray.SORTED_ARRAY.length - 1;
        //终止条件，当 left > right 时停止
        while(left <= right) {
            int mid = (left + right) / 2;
            if (target == array[mid]) {
                return mid;
            }else if (target > array[mid]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1; //没有找到
    }

}
