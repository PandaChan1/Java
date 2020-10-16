package Code;

import Data.MyArray;

import java.util.Arrays;

/**
 *@ClassName: BubbleSort
 *@Description 冒泡排序优化
 *@Author PandaChan1
 *@Date 2020/10/16
 *@Time 11:33
 */


public class BubbleSort {
    public static void main(String[] args) {
        int[] res = new int[MyArray.MY_ARRAY.length];
        for (int i = 0; i < MyArray.MY_ARRAY.length; i++) {
            res[i] = MyArray.MY_ARRAY[i];
        }
        bubble(res);
        System.out.println(Arrays.toString( res));
    }

    private static void bubble(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {   //趟数
            //int t = 0;
            boolean flg = true;
            for (int j = 0;j <array.length - 1 -i;j++) {
               if (array[j] > array[j + 1]) {
//                   t++;
                   int temp = array[j];
                   array[j] = array[j + 1];
                   array[j +1] =temp;
                   flg = false;
               }
              }
//            if (t == 0) {
//                    return;
//            }
            if (flg) {
                return;
            }
        }

    }
}
