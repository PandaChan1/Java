package Sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array,mid,array.length);
        return Merge(mergeSort(left),mergeSort(right));
    }

    private static int[] Merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    for(int index = 0,i = 0,j = 0;index < result.length;index++) {
if (i >= left.length) { //左边走完，直接将右边追加到result
result[index] = right[j++];
}else if (j >= right.length) {  //右边走完，直接将左边追加到result
result[index] =left[i++];
}else if (left[i] > right[j]) {  //左右都没走完时，比较大小，将小的放进result（升序）
result[index] = right[j++];
}else {
result[index] = left[i++];
}

    }
    return result;
    }
}
