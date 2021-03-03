package Review;

import java.util.Arrays;

public class BubbleSort {
    public void bubbleSort(int[] array) {
        int len = array.length;

        for (int i = 0; i < len - 1; i++) {  //n-1趟
            //标记，记录该趟是否发生交换
            boolean flg = true;
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    //发生交换则置为false
                    flg = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            //没有发生交换，说明已经有序，直接break，开始下一趟
            if (flg){break;}
        }

        System.out.println(Arrays.toString(array));
    }
}
