package Sort;

/**
 *@ClassName: HeapSort
 *@Description 堆排序
 *@Author PandaChan1
 *@Date 2020/11/12
 *@Time 11:01
 */


public class HeapSort {
    public static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            adjustDwon(array,i,array.length);
        }
    }

    private static void adjustDwon(int[] array, int parent, int len) {
        int child = parent * 2 + 1;
        while (child < len) {  //有左孩子
            if (child + 1 < len && array[child] < array[child + 1]) { //有右孩子,且右孩子大于左孩子
                child++;
            }
//child下标就是最大值
            if (array[child] > array[parent]) {
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;

                parent = child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }
    }
    public static int[] heapSort(int[] array) {
        createHeap(array);
        int end = array.length - 1;
        while(end > 0) {
            int temp = array[0];
            array[0] = array[end];
            array[end] = temp;
            adjustDwon(array,0,end);
            end--;
        }
    return  array;
    }
}
