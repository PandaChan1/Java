package Review2;

import java.util.Arrays;

public class Quick {
    public void quickSort(int[] array,int left,int right) {
        if (left < right) {
            int pov = pattern(array,left,right);
            quickSort(array,left,pov -1);
            quickSort(array,pov + 1,right);
        }
    }

    private int pattern(int[] array, int left, int right) {
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

    public void print(int[] arr,int left,int right) {
        quickSort(arr,left,right);
        System.out.println(Arrays.toString(arr));
    }
}
