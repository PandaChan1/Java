package Sort;

public class QuickSort {
    public static int[] quickSort(int[] array,int left,int right) {
        if(left < right) {
            int pov = partition(array,left,right);
            quickSort(array,left,pov - 1);
            quickSort(array,pov + 1,right);
        }
        return array;
    }

    private static int partition(int[] array, int left, int right) {
        int temp = array[left];  //以左边为基准
        while(left < right) { // 不相遇
            while (left < right && array[right] >= temp)  {right--;}
            array[left] = array[right];

            while(left < right && array[left] <= temp) {left++;}
            array[right] = array[left];

        }
        array[left] = temp;
        return left;
    }
}
