package Review2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1,12,3,56,68,99,102,4,2,3,24};
        Bubble bubble = new Bubble();
        bubble.bubbleSort(array);

        Select select = new Select();
        select.selectSort(array);

        Insert insert = new Insert();
        insert.insertSort(array);

        Shell shell = new Shell();
        shell.shellSort(array);

        Quick quick = new Quick();
        quick.print(array,0,array.length - 1);

        Heap heap = new Heap();
        heap.heapSort(array);

        Merge merge = new Merge();
        System.out.println(Arrays.toString(merge.mergeSort(array)));
    }
}
