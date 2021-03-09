package Review3;

import java.util.Arrays;

public class Bubble {
    public static void bubble(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            boolean flg = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j  + 1]) {
                    flg = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                if (flg) break;
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
