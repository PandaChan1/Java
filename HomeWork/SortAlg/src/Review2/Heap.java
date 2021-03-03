package Review2;

import java.util.Arrays;

public class Heap {
    public void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDown(array,i,array.length);
        }
    }
    public void adjustDown(int[] array,int parent,int len) {
        int child = parent * 2 + 1;
        while(child < len) {
            if (child + 1 < len && array[child + 1] > array[child]) {
                child++;
            }

            if (array[parent] < array[child]) {
                int tenp = array[parent];
                array[parent] = array[child];
                array[child] = tenp;

                parent = child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }
    }

    public void heapSort(int[] array) {
        createHeap(array);

        int len = array.length - 1;

        while(len > 0) {
            if (array[len] < array[0]) {
                int temp = array[0];
                array[0] = array[len];
                array[len] = temp;

                adjustDown(array,0,len);
                len--;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
