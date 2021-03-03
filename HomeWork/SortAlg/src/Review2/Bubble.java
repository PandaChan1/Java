package Review2;

import java.util.Arrays;

public class Bubble {
    public void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            boolean flg = true;
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flg = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (flg) {break;}
        }
        System.out.println(Arrays.toString(array));
    }
}
