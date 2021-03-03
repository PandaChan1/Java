package Review;

import java.util.Arrays;

public class HeapSort {
    public void adjustDown(int[] array,int parent,int len) {
        int child = parent*2 + 1;
        while(child < len) {  //有左孩子
            if (child + 1 < len && array[child + 1] > array[child]) {  //有右孩子，且右孩子大于左孩子
                child++;
            }
//child就是孩子中的最大值的下标
            if (array[child] > array[parent]) {
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;

                parent = child;
                child = parent*2 + 1;
            }else {
                break;
            }
        }
    }

    public void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(array,i,array.length);
        }
    }

    public void heapSort(int[] array) {
        createHeap(array);

        int len = array.length - 1;

        while(len > 0) {
                if (array[len] < array[0]) {
                    int temp = array[len];
                    array[len] = array[0];
                    array[0] = temp;

                    adjustDown(array,0,len);
                    len--;
                }
        }
        System.out.println(Arrays.toString(array));
    }
}
