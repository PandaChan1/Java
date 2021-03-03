package Review2;

import java.util.Arrays;

public class Insert {
    public void insertSort(int[] array) {
        int cur = 0;
        int pre = 0;
        for (int i = 0; i < array.length - 1; i++) {
            cur = array[i + 1];
            pre = i;
            while(pre >= 0 && array[pre] > cur) {
                array[pre + 1] = array[pre];
                pre--;
            }
            array[pre + 1] = cur;
        }
        System.out.println(Arrays.toString(array));
    }
}
