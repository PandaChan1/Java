package Review;

import jdk.nashorn.internal.objects.NativeUint8ClampedArray;

public class QuickSort {
    public void quickSort(int[] array,int left,int right) {
        if (right < left) {
            int pov = parttern(array,left,right);
            quickSort(array,left,pov - 1);
            quickSort(array,pov + 1,right);
        }
    }

    private int parttern(int[] array, int left, int right) {
        int key = array[left];
        while(left < right) {
            if (left < right && array[right] >= key) {right--;}
            array[left] = array[right];
            if (left < right && array[left] <= key) {left++;}
            array[right] = array[left];
        }
        array[left] = key;
        return left;
    }
}
