package Code;

import Data.MyArray;

import java.util.Arrays;

public class SwapArray {
    public static void main(String[] args) {
        int[] res = new int[MyArray.MY_ARRAY.length];
        for (int i = 0; i < MyArray.MY_ARRAY.length; i++) {
            res[i] = MyArray.MY_ARRAY[i];
        }
        swapArray(res);
        System.out.println(Arrays.toString(res));
    }

    private static void swapArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int left = 0;
        int rignt = array.length -1;
        while(left < rignt) {
            int temp = array[left];
            array[left] = array[rignt];
            array[rignt] = temp;
            left++;
            rignt--;
        }
    }
}
