package Review;

import java.util.Arrays;

public class ShellSort {
    public void shellSort(int[] array) {
        int gap = array.length / 2;
        while(gap > 0) {
            for (int i = gap; i < array.length - 1; i++) {
                int cur = array[i];
                int pre = i - gap;
                while(pre >= 0 && cur < array[pre]) {
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
