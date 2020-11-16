package Sort;

/**
 *@ClassName: MergeNor
 *@Description 归并非递归
 *@Author PandaChan1
 *@Date 2020/11/16
 *@Time 9:19
 */


public class MergeNor {
    public static int[] mergeNor(int[] array,int gap) {
        int len = array.length;
        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = s2 + gap - 1 < len ?s2 + gap - 1 : len - 1;
        int[] temp = new int[len];
        int k = 0;
        while (s2 < len) {
            while(s1 <= e1 && s2 <= e2) {  //两个都不为空
                if (array[s1] <= array[s2]) {
                    temp[k++] = array[s1++];
                }else {
                    temp[k++] = array[s2++];
                }
            }
            //有一个为空时，不为空的直接添加
            while(s1 <= e1) {
                temp[k++] = array[s1++];
            }
            while(s2 <= e2) {
                temp[k++] = array[s2++];
            }
            //第一组已经排完
            s1 = s2 + 1;
            e1 = s1 + gap - 1;
            s2 = e1 + 1;
            e2 = s1 + gap - 1 < len ? s2 + gap - 1 : len - 1;
        }

        while(s1 <= len - 1) {
            temp[k++] = array[s1++];
        }

       return temp;
    }

    public static int[] MergeSortNor(int[] array) {
        for (int i = 1; i < array.length; i*=2) {
            mergeNor(array,i);
        }
        return array;
    }
}
