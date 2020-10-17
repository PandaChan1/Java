package Code;

import java.util.Arrays;

public class SwapArray {
    public static void main(String[] args) {
        int[] array1 = new int[]{12,3,6,45,8,25,21,33,34};
        int[] array2 = new int[]{4,25,33,69,154,27,58,56,36};
        swap(array1,array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    private static void swap(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            int temp = array1[i];
            array1[i] = array2[i];
            array2[i] = temp;
        }
    }
}
