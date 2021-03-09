package Review3;

import java.util.Arrays;

public class Shell {
    public static void shell(int[] array) {
        int gap = array.length / 2;
        while(gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int cur = array[ i];
                int pre = i - gap;
                while(pre >= 0 && array[pre] > cur) {
                    array[pre + gap] = array[pre];
                    pre -= gap;
                }
                array[pre + gap] = cur;
            }
            gap /= 2;
        }
        System.out.println(Arrays.toString(array));
    }
}
