package Review3;

import java.util.Arrays;

public class Merge {
    public static  int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array,mid,array.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    public static int[] merge(int[] left,int[] right) {
    int[] res = new int[left.length + right.length];

        for (int index = 0,i = 0, j = 0; index < res.length; index++) {
            if (i >= left.length) {  //左边走完
                res[index] = right[j++];
            }else if (j >= right.length) {
                res[index] = left[i++];
            }else if (left[i] > right[j]) {
                res[index] = right[j++];
            }else {
                res[index] = left[i++];
            }
        }
        return res;
    }
}
