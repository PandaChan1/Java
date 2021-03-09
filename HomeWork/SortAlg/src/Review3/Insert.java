package Review3;

import java.util.Arrays;

public class Insert {
    public static void insert(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int cur = array[i + 1];
            int pre = i;
            while(pre >= 0 && array[pre] > cur) {
                array[pre + 1] = array[pre];
                pre--;
            }
            array[pre + 1] = cur;
        }

        System.out.println(Arrays.toString(array));
    }
}
