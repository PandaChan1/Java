package Review;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1,12,3,56,68,99,102,4,2,3,24};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array);

        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(array);

        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(array);

        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(array);

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array,0,array.length - 1);

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array);

        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.mergeSort(array)));
    }
}
