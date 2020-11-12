package Sort;


import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[] array = new int[] {9,1,2,5,7,4,8,6,3,5};
        System.out.println(Arrays.toString(InsertSort.insertSort(array)));
        System.out.println(Arrays.toString(ShellSort.shellSort(array)));
        System.out.println(Arrays.toString(ShellSort.shell(array)));
        System.out.println(Arrays.toString(SelectSort.selectSort(array)));
        System.out.println(Arrays.toString(HeapSort.heapSort(array)));
        System.out.println(Arrays.toString(QuickSort.quickSort(array,0,array.length - 1)));
    }
}
